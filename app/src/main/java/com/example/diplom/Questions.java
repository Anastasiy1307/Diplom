package com.example.diplom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Questions extends AppCompatActivity {
    TextView nameTest;
    View v;
    Connection connection;

    RadioGroup radioGroup;

    private RadioButton not;
    private RadioButton skor_not;
    private RadioButton in_yes;
    int bal = 0;
    private TextView ball;
    private RadioButton scor_yes;
    private RadioButton yes;
    RadioButton radioButton;

    List<Maska_Questions> data;
    ListView listView;
    Adapter_questions pAdapter;
    String zapr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);
        v = findViewById(com.google.android.material.R.id.ghost_view);
        View w = View.inflate(Questions.this, R.layout.activity_maska_questions, null);

        radioGroup = w.findViewById(R.id.RG);

        not = (RadioButton) w.findViewById(R.id.answ1);
        skor_not = (RadioButton) w.findViewById(R.id.answ2);
        in_yes = (RadioButton) w.findViewById(R.id.answ3);
        scor_yes = (RadioButton) w.findViewById(R.id.answ4);
        yes = (RadioButton) w.findViewById(R.id.answ5);
        ball = (TextView) findViewById(R.id.ball1);
        nameTest = (TextView) findViewById(R.id.nameTest);
        final String getExtra = getIntent().getStringExtra("test");

        nameTest.setText(getExtra);
        GetTextFromSQL(v);

        not.setChecked(Update("not"));
        skor_not.setChecked(Update("skor_not"));
        in_yes.setChecked(Update("in_yes"));
        scor_yes.setChecked(Update("scor_yes"));
        yes.setChecked(Update("yes"));


        not.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean not_isChecked) {
                SaveIntoSharePrefs("not", not_isChecked);
              }
        });
        skor_not.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean skor_not_isChecked) {
                SaveIntoSharePrefs("skor_not", skor_not_isChecked);
            }
        });
        in_yes.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean in_yes_isChecked) {
                SaveIntoSharePrefs("in_yes", in_yes_isChecked);
            }
        });
        scor_yes.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean scor_yes_isChecked) {
                SaveIntoSharePrefs("scor_yes", scor_yes_isChecked);
            }
        });
        yes.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean yes_isChecked) {
                SaveIntoSharePrefs("yes", yes_isChecked);
            }
        });







    }



    private void SaveIntoSharePrefs(String key, boolean value) {

        SharedPreferences sp = getSharedPreferences("answer", MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean(key, value);
        editor.apply();
    }

    private boolean Update(String key) {
        SharedPreferences sp = getSharedPreferences("answer", MODE_PRIVATE);
        return sp.getBoolean(key, false);

    }


    public void End(View v) {
        Intent intent = new Intent(Questions.this, ResultTests.class);
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
        pAdapter = new Adapter_questions(Questions.this, data);
        try {
            ConnectionHelper connectionHelper = new ConnectionHelper();
            connection = connectionHelper.connectionClass();
            if (connection != null) {

                String query = "Select * From Questions_t1";
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