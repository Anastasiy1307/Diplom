package com.example.diplom;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class LogIn_student extends AppCompatActivity {

    EditText group;
    Button LogIn;

    Connection connection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in_student);
        group = (EditText) findViewById(R.id.Group);
        LogIn = (Button) findViewById(R.id.Login);
        LogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new LogIn_student.LogInStudent().execute("");
                Intent intent = new Intent(LogIn_student.this, Tests.class);

            }
        });
    }

    public class LogInStudent extends AsyncTask<String, String, String> {

        String z = null;
        Boolean isSuccess = false;

        @Override
        protected String doInBackground(String... strings) {
            ConnectionHelper connectionHelper = new ConnectionHelper();
            connection = connectionHelper.connectionClass();
            if (connection == null) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(LogIn_student.this, "Проверьте подключение к Интернету", Toast.LENGTH_LONG).show();
                    }
                });
                z = "On Internet Connection";
            }
            else {
                try {
                    String sql = "Select ID From Classes Where Name_group = '" + group.getText() + "'";
                    Statement statement = connection.createStatement();
                    ResultSet rs = statement.executeQuery(sql);


                    if (rs.next()) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(LogIn_student.this, "Вход выполнен успешно", Toast.LENGTH_LONG).show();
                            }
                        });
                        z = "Успешно";

                        Intent intent = new Intent(LogIn_student.this, Tests.class);
                        intent.putExtra("id_group", sql);
                        startActivity(intent);
                        finish();
                    } else {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(LogIn_student.this, "Группа не найдена", Toast.LENGTH_LONG).show();
                            }
                        });

                    }
                } catch (Exception e) {
                    isSuccess = false;
                    Log.e("SQL Error: ", e.getMessage());
                }
            }
            return z;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(String s) {

        }
    }
}


