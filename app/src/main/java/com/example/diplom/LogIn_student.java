package com.example.diplom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class LogIn_student extends AppCompatActivity {

    EditText group;
    Button LogIn;
    int rID;
    String k;

    Connection connection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in_student);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        Random random = new Random();
        int randomId = random.nextInt(2000);//генерация Id
        rID = randomId;
        k = Integer.toString(rID);

        group = (EditText) findViewById(R.id.Group);
        LogIn = (Button) findViewById(R.id.Login);
        LogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new LogIn_student.LogInStudent().execute("");
                try {
                    ResultS();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
        });
    }

    public class LogInStudent extends AsyncTask<String, String, String> {

        public String z = null;
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

                    String sql = "Select ID From Classes Where Name_group = '" + group.getText() + "'";//Проверка на соответствие данных с БД
                    Statement statement = connection.createStatement();
                    ResultSet rs = statement.executeQuery(sql);


                    if (rs.next()) {
                        runOnUiThread(new Runnable() {

                            @Override
                            public void run() {
                                Toast.makeText(LogIn_student.this, "Вход выполнен успешно", Toast.LENGTH_LONG).show();

                                Intent intent = new Intent(LogIn_student.this, Tests.class);
                                intent.putExtra("ID",k);
                                startActivity(intent);
                                finish();
                            }
                        });
                        z = "Успешно";


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
    public void ResultS() throws SQLException {
        ConnectionHelper connectionHelper = new ConnectionHelper();
        connection = connectionHelper.connectionClass();
        String z = null;




        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.LL.dd");//Формат даты, где y - год, L - месяц, d - день
        String date = sdf.format(new Date());
        String query="";
        if (connection != null) {
            query = "INSERT INTO Result (ID, ID_group,  Result, Date) Select " + rID + ", Classes.ID, NULL, '"+date+"' From Classes Where Name_group = '"+ group.getText()+ "'";//запись в таблицу "Результаты" Даты, Id группы и рандомного id

        }
        else
        {}
        z = "Успешно";
        Statement statement1 = connection.createStatement();
        ResultSet result = statement1.executeQuery(query);


    }
    public void Back(View v) {
        Intent intent = new Intent(LogIn_student.this, AVT.class);
        startActivity(intent);
        finish();
    }

}


