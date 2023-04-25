package com.example.diplom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Tests extends AppCompatActivity {
    private String test = "";
    View v;
    Connection connection;
    List<Maska_Tests> data;
    ListView listView;
    Adapter_Tests pAdapter;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tests);
        v = findViewById(com.google.android.material.R.id.ghost_view);
        GetTextFromSQL(v);
    }

    public void enterMobile() {
        pAdapter.notifyDataSetInvalidated();
        listView.setAdapter(pAdapter);
    }

    public void Help(View v) {
        Intent intent = new Intent(Tests.this, Help.class);
        startActivity(intent);
        finish();
    }

    public void Calm(View v) {
        Intent intent = new Intent(Tests.this, Calm.class);
        startActivity(intent);
        finish();
    }

    public void GetTextFromSQL(View v) {
        data = new ArrayList<Maska_Tests>();
        listView = findViewById(R.id.LTests);
        pAdapter = new Adapter_Tests(Tests.this, data);
        try {
            ConnectionHelper connectionHelper = new ConnectionHelper();
            connection = connectionHelper.connectionClass();
            if (connection != null) {

                String query = "Select * From Tests";
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query);

                while (resultSet.next()) {
                    Maska_Tests tempMask = new Maska_Tests(
                            resultSet.getInt("Id"),
                            resultSet.getString("Name_test"),
                            resultSet.getString("Short_descroption"),
                            resultSet.getString("Image"),
                            resultSet.getInt("number_of_questions")
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