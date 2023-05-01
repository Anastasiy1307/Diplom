package com.example.diplom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Question2 extends AppCompatActivity {

    TextView nameTest;
    View v;
    Connection connection;
    List<Maska_Questions> data;
    ListView listView;
    Adapter_questions pAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question2);
        v = findViewById(com.google.android.material.R.id.ghost_view);

        nameTest = (TextView) findViewById(R.id.nameTestt);
        final String getExtra = getIntent().getStringExtra("test");

        nameTest.setText(getExtra);

        GetTextFromSQL(v);
    }


    public void End(View v) {
        Intent intent = new Intent(Question2.this, ResultTests.class);
        startActivity(intent);
        finish();
    }
    public void enterMobile() {
        pAdapter.notifyDataSetInvalidated();
        listView.setAdapter(pAdapter);
    }

    public void GetTextFromSQL(View v) {
        data = new ArrayList<Maska_Questions>();
        listView = findViewById(R.id.Ql);
        pAdapter = new Adapter_questions(Question2.this, data);
        try {
            ConnectionHelper connectionHelper = new ConnectionHelper();
            connection = connectionHelper.connectionClass();
            if (connection != null) {

                String query = "Select * From Questions_t2";
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query);

                while (resultSet.next()) {
                    Maska_Questions tempMask = new Maska_Questions
                            (resultSet.getInt("ID"),
                                    resultSet.getString("Question")
                            );
                    data.add(tempMask);
                    pAdapter.notifyDataSetInvalidated();
                }
                connection.close();
            } else {
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        enterMobile();

    }
}