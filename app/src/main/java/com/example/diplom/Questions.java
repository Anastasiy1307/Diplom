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
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

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
    String ConnectionResult = "";
    String test = "";
    public final int[] i = {0};

    ProgressBar progress;
    Button not;
    Button snv;
    Button iv;
    Button sv;
    Button ver;
    TextView percent;
    int perc = 0;
    int percc;
    int progr = 0;
    int balll;
    int ball = 0;
    String ID;

    TextView bal;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);
        v = findViewById(com.google.android.material.R.id.ghost_view);
        nameTest = (TextView) findViewById(R.id.nameTest);
        final String getExtra = getIntent().getStringExtra("test");
        final String getExtra1= getIntent().getStringExtra("ID");
        test = getExtra;
        ID = getExtra1;
        nameTest.setText(getExtra);

        GetTextFromSql1(v);

            not = (Button) findViewById(R.id.not);
            not.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    balll = ball + 1;
                    ball = balll;


                    percc = perc+5;
                    perc = percc;
                    progr = progr + 1;
                    progress = (ProgressBar) findViewById(R.id.progresss);
                    progress.setProgress(progr);
                    percent = (TextView) findViewById(R.id.percent);
                    percent.setText(Integer.toString(perc) +"%");
                    GetTextFromSql1(v);

                }
            });
            snv = (Button) findViewById(R.id.snv);
            snv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    balll = ball + 2;
                    ball = balll;

                    percc = perc+5;
                    perc = percc;
                    progr = progr + 1;
                    progress = (ProgressBar) findViewById(R.id.progresss);
                    progress.setProgress(progr);
                    percent = (TextView) findViewById(R.id.percent);
                    percent.setText(Integer.toString(perc) +"%");
                    GetTextFromSql1(v);

                }
            });
            iv = (Button) findViewById(R.id.iv);
            iv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    balll = ball + 3;
                    ball = balll;

                    percc = perc+5;
                    perc = percc;
                    progr = progr + 1;
                    progress = (ProgressBar) findViewById(R.id.progresss);
                    progress.setProgress(progr);
                    percent = (TextView) findViewById(R.id.percent);
                    percent.setText(Integer.toString(perc) +"%");
                    GetTextFromSql1(v);

                }
            });
            sv = (Button) findViewById(R.id.sv);
            sv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    balll = ball + 4;
                    ball = balll;

                    percc = perc+5;
                    perc = percc;
                    progr = progr + 1;
                    progress = (ProgressBar) findViewById(R.id.progresss);
                    progress.setProgress(progr);
                    percent = (TextView) findViewById(R.id.percent);
                    percent.setText(Integer.toString(perc) +"%");
                    GetTextFromSql1(v);

                }
            });
            ver = (Button) findViewById(R.id.v);
            ver.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    balll = ball + 5;
                    ball = balll;

                    percc = perc+5;
                    perc = percc;
                    progr = progr + 1;
                    progress = (ProgressBar) findViewById(R.id.progresss);
                    progress.setProgress(progr);
                    percent = (TextView) findViewById(R.id.percent);
                    percent.setText(Integer.toString(perc) +"%");
                    GetTextFromSql1(v);

                }
            });



    }





    public void End(View v) {

        try {
            ConnectionHelper conectionHellper = new ConnectionHelper();
            connection = conectionHellper.connectionClass();
            if (ball < 20 )
            {
                Toast.makeText(this,"Тест еще не закончен", Toast.LENGTH_LONG).show();
                return;
            }
            if (connection != null) {

                String query = "Update Result set Result = '"+ball+"' Where ID = '"+ID+"' and Result is NULL ";
                Statement statement = connection.createStatement();
                statement.execute(query);
                Toast.makeText(this,"Успешно добавлено", Toast.LENGTH_LONG).show();
            } else {
                ConnectionResult = "Check Connection";
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }

        Intent intent = new Intent(Questions.this, ResultTests.class);
        intent.putExtra("ball",ball);
        intent.putExtra("test",test);

        startActivity(intent);
        finish();

    }

    public void GetTextFromSql1(View v) {
        TextView BaseId = findViewById(R.id.Question);

        try {
            ConnectionHelper conectionHellper = new ConnectionHelper();
            connection = conectionHellper.connectionClass();
            if (connection != null) {

                String query0 = "select count(ID) from Questions_t1 ";
                Statement statement0 = connection.createStatement();
                ResultSet resultSet0 = statement0.executeQuery(query0);
                int c = 0;
                while (resultSet0.next()) {
                    c = resultSet0.getInt(1);
                }

                int finalC = c;

                if (i[0] != finalC) {
                    i[0] = i[0] + 1;
                }else
                {
                    not.setEnabled(false);
                    snv.setEnabled(false);
                    iv.setEnabled(false);
                    sv.setEnabled(false);
                    ver.setEnabled(false);
                }


                String query = "Select * From Questions_t1 where ID = " + i[0] + "";
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query);
                while (resultSet.next()) {
                    BaseId.setText(resultSet.getString(2));
                }

            } else {
                ConnectionResult = "Check Connection";
            }
        } catch (Exception ex) {

        }

    }

}