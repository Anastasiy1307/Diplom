package com.example.diplom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

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
    String ConnectionResult = "";
    String test = "";
    public final int[] i = {0};

    Button not;
    Button snv;
    Button iv;
    Button sv;
    Button ver;
    ProgressBar progress;
    int balll;
    int ball = 0;
    int balll1;
    int ball1 = 0;
    int balll2;
    int ball2 = 0;
    int balll3;
    int ball3 = 0;
    int balll4;
    int ball4 = 0;

    TextView percent;
    double perc = 0.0;
    double percc;
    int progr = 0;

    String ID;

    TextView bal;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question2);
        v = findViewById(com.google.android.material.R.id.ghost_view);
        nameTest = (TextView) findViewById(R.id.nameTest);
        final String getExtra = getIntent().getStringExtra("test");
        final String getExtra1= getIntent().getStringExtra("ID");
        test = getExtra;
        ID = getExtra1;
        nameTest.setText(getExtra);
        GetTextFromSql1(v);




    }


    public void GetTextFromSql1(View v) {
        TextView BaseId = findViewById(R.id.Question);

        try {
            ConnectionHelper conectionHellper = new ConnectionHelper();
            connection = conectionHellper.connectionClass();
            if (connection != null) {

                String query0 = "select count(ID) from Questions_t2 ";
                Statement statement0 = connection.createStatement();
                ResultSet resultSet0 = statement0.executeQuery(query0);
                int c = 0;
                while (resultSet0.next()) {
                    c = resultSet0.getInt(1);
                }

                int finalC = c;

                if (i[0] != finalC) {
                    i[0] = i[0] + 1;
                    if (i[0] ==1 || i[0] == 6 || i[0] == 11){
                        not = (Button) findViewById(R.id.not);
                        not.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                balll = ball + 1;
                                ball = balll;
                                percc = perc + 6.67;
                                perc = percc;
                                progr = progr + 1;
                                progress = (ProgressBar) findViewById(R.id.progresss);
                                progress.setProgress(progr);
                                percent = (TextView) findViewById(R.id.percent);
                                percent.setText(Double.toString(perc) +"%");
                                GetTextFromSql1(v);

                            }
                        });
                        snv = (Button) findViewById(R.id.snv);
                        snv.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                balll = ball + 2;
                                ball = balll;
                                percc = perc + 6.67;
                                perc = percc;
                                progr = progr + 1;
                                progress = (ProgressBar) findViewById(R.id.progresss);
                                progress.setProgress(progr);
                                percent = (TextView) findViewById(R.id.percent);
                                percent.setText(Double.toString(perc) +"%");
                                GetTextFromSql1(v);

                            }
                        });
                        iv = (Button) findViewById(R.id.iv);
                        iv.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                balll = ball + 3;
                                ball = balll;
                                percc = perc + 6.67;
                                perc = percc;
                                progr = progr + 1;
                                progress = (ProgressBar) findViewById(R.id.progresss);
                                progress.setProgress(progr);
                                percent = (TextView) findViewById(R.id.percent);
                                percent.setText(Double.toString(perc) +"%");
                                GetTextFromSql1(v);

                            }
                        });
                        sv = (Button) findViewById(R.id.sv);
                        sv.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                balll = ball + 4;
                                ball = balll;
                                percc = perc + 6.67;
                                perc = percc;
                                progr = progr + 1;
                                progress = (ProgressBar) findViewById(R.id.progresss);
                                progress.setProgress(progr);
                                percent = (TextView) findViewById(R.id.percent);
                                percent.setText(Double.toString(perc) +"%");
                                GetTextFromSql1(v);

                            }
                        });
                        ver = (Button) findViewById(R.id.v);
                        ver.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                balll = ball + 5;
                                ball = balll;
                                percc = perc + 6.67;
                                perc = percc;
                                progr = progr + 1;
                                progress = (ProgressBar) findViewById(R.id.progresss);
                                progress.setProgress(progr);
                                percent = (TextView) findViewById(R.id.percent);
                                percent.setText(Double.toString(perc) +"%");
                                GetTextFromSql1(v);

                            }
                        });
                    }
                    else if (i[0] == 2 || i[0] == 7 || i[0] == 12){
                        not = (Button) findViewById(R.id.not);
                        not.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                balll1 = ball1 + 1;
                                ball1 = balll1;
                                percc = perc + 6.67;
                                perc = percc;
                                progr = progr + 1;
                                progress = (ProgressBar) findViewById(R.id.progresss);
                                progress.setProgress(progr);
                                percent = (TextView) findViewById(R.id.percent);
                                percent.setText(Double.toString(perc) +"%");
                                GetTextFromSql1(v);

                            }
                        });
                        snv = (Button) findViewById(R.id.snv);
                        snv.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                balll1 = ball1 + 2;
                                ball1 = balll1;
                                percc = perc + 6.67;
                                perc = percc;
                                progr = progr + 1;
                                progress = (ProgressBar) findViewById(R.id.progresss);
                                progress.setProgress(progr);
                                percent = (TextView) findViewById(R.id.percent);
                                percent.setText(Double.toString(perc) +"%");
                                GetTextFromSql1(v);

                            }
                        });
                        iv = (Button) findViewById(R.id.iv);
                        iv.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                balll1 = ball1 + 3;
                                ball1 = balll1;
                                percc = perc + 6.67;
                                perc = percc;
                                progr = progr + 1;
                                progress = (ProgressBar) findViewById(R.id.progresss);
                                progress.setProgress(progr);
                                percent = (TextView) findViewById(R.id.percent);
                                percent.setText(Double.toString(perc) +"%");
                                GetTextFromSql1(v);

                            }
                        });
                        sv = (Button) findViewById(R.id.sv);
                        sv.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                balll1 = ball1 + 4;
                                ball1 = balll1;
                                percc = perc + 6.67;
                                perc = percc;
                                progr = progr + 1;
                                progress = (ProgressBar) findViewById(R.id.progresss);
                                progress.setProgress(progr);
                                percent = (TextView) findViewById(R.id.percent);
                                percent.setText(Double.toString(perc) +"%");
                                GetTextFromSql1(v);

                            }
                        });
                        ver = (Button) findViewById(R.id.v);
                        ver.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                balll1 = ball1 + 5;
                                ball1 = balll1;
                                percc = perc + 6.67;
                                perc = percc;
                                progr = progr + 1;
                                progress = (ProgressBar) findViewById(R.id.progresss);
                                progress.setProgress(progr);
                                percent = (TextView) findViewById(R.id.percent);
                                percent.setText(Double.toString(perc) +"%");
                                GetTextFromSql1(v);

                            }
                        });

                    }

                    else if (i[0] == 3 || i[0] == 8 || i[0] == 13){
                        not = (Button) findViewById(R.id.not);
                        not.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                balll2 = ball2 + 1;
                                ball2 = balll2;
                                percc = perc + 6.67;
                                perc = percc;
                                progr = progr + 1;
                                progress = (ProgressBar) findViewById(R.id.progresss);
                                progress.setProgress(progr);
                                percent = (TextView) findViewById(R.id.percent);
                                percent.setText(Double.toString(perc) +"%");
                                GetTextFromSql1(v);

                            }
                        });
                        snv = (Button) findViewById(R.id.snv);
                        snv.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                balll2 = ball2 + 2;
                                ball2 = balll2;
                                percc = perc + 6.67;
                                perc = percc;
                                progr = progr + 1;
                                progress = (ProgressBar) findViewById(R.id.progresss);
                                progress.setProgress(progr);
                                percent = (TextView) findViewById(R.id.percent);
                                percent.setText(Double.toString(perc) +"%");
                                GetTextFromSql1(v);

                            }
                        });
                        iv = (Button) findViewById(R.id.iv);
                        iv.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                balll2 = ball2 + 3;
                                ball2 = balll2;
                                percc = perc + 6.67;
                                perc = percc;
                                progr = progr + 1;
                                progress = (ProgressBar) findViewById(R.id.progresss);
                                progress.setProgress(progr);
                                percent = (TextView) findViewById(R.id.percent);
                                percent.setText(Double.toString(perc) +"%");
                                GetTextFromSql1(v);

                            }
                        });
                        sv = (Button) findViewById(R.id.sv);
                        sv.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                balll2 = ball2 + 4;
                                ball2 = balll2;
                                percc = perc + 6.67;
                                perc = percc;
                                progr = progr + 1;
                                progress = (ProgressBar) findViewById(R.id.progresss);
                                progress.setProgress(progr);
                                percent = (TextView) findViewById(R.id.percent);
                                percent.setText(Double.toString(perc) +"%");
                                GetTextFromSql1(v);

                            }
                        });
                        ver = (Button) findViewById(R.id.v);
                        ver.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                balll2 = ball2 + 5;
                                ball2 = balll2;
                                percc = perc + 6.67;
                                perc = percc;
                                progr = progr + 1;
                                progress = (ProgressBar) findViewById(R.id.progresss);
                                progress.setProgress(progr);
                                percent = (TextView) findViewById(R.id.percent);
                                percent.setText(Double.toString(perc) +"%");
                                GetTextFromSql1(v);

                            }
                        });

                    }

                    else if (i[0] == 4 || i[0] == 9 || i[0] == 14){
                        not = (Button) findViewById(R.id.not);
                        not.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                balll3 = ball3 + 1;
                                ball3 = balll3;
                                percc = perc + 6.67;
                                perc = percc;
                                progr = progr + 1;
                                progress = (ProgressBar) findViewById(R.id.progresss);
                                progress.setProgress(progr);
                                percent = (TextView) findViewById(R.id.percent);
                                percent.setText(Double.toString(perc) +"%");
                                GetTextFromSql1(v);

                            }
                        });
                        snv = (Button) findViewById(R.id.snv);
                        snv.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                balll3 = ball3 + 2;
                                ball3 = balll3;
                                percc = perc + 6.67;
                                perc = percc;
                                progr = progr + 1;
                                progress = (ProgressBar) findViewById(R.id.progresss);
                                progress.setProgress(progr);
                                percent = (TextView) findViewById(R.id.percent);
                                percent.setText(Double.toString(perc) +"%");
                                GetTextFromSql1(v);

                            }
                        });
                        iv = (Button) findViewById(R.id.iv);
                        iv.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                balll3 = ball3 + 3;
                                ball3 = balll3;
                                percc = perc + 6.67;
                                perc = percc;
                                progr = progr + 1;
                                progress = (ProgressBar) findViewById(R.id.progresss);
                                progress.setProgress(progr);
                                percent = (TextView) findViewById(R.id.percent);
                                percent.setText(Double.toString(perc) +"%");
                                GetTextFromSql1(v);

                            }
                        });
                        sv = (Button) findViewById(R.id.sv);
                        sv.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                balll3 = ball3 + 4;
                                ball3 = balll3;
                                percc = perc + 6.67;
                                perc = percc;
                                progr = progr + 1;
                                progress = (ProgressBar) findViewById(R.id.progresss);
                                progress.setProgress(progr);
                                percent = (TextView) findViewById(R.id.percent);
                                percent.setText(Double.toString(perc) +"%");
                                GetTextFromSql1(v);

                            }
                        });
                        ver = (Button) findViewById(R.id.v);
                        ver.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                balll3 = ball3 + 5;
                                ball3 = balll3;
                                percc = perc + 6.67;
                                perc = percc;
                                progr = progr + 1;
                                progress = (ProgressBar) findViewById(R.id.progresss);
                                progress.setProgress(progr);
                                percent = (TextView) findViewById(R.id.percent);
                                percent.setText(Double.toString(perc) +"%");
                                GetTextFromSql1(v);

                            }
                        });

                    }

                    else if (i[0] == 5 || i[0] == 10 || i[0] == 15){
                        not = (Button) findViewById(R.id.not);
                        not.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                balll4 = ball4 + 1;
                                ball4 = balll4;
                                percc = perc + 6.67;
                                perc = percc;
                                progr = progr + 1;
                                progress = (ProgressBar) findViewById(R.id.progresss);
                                progress.setProgress(progr);
                                percent = (TextView) findViewById(R.id.percent);
                                percent.setText(Double.toString(perc) +"%");
                                GetTextFromSql1(v);

                            }
                        });
                        snv = (Button) findViewById(R.id.snv);
                        snv.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                balll4 = ball4 + 2;
                                ball4 = balll4;
                                percc = perc + 6.67;
                                perc = percc;
                                progr = progr + 1;
                                progress = (ProgressBar) findViewById(R.id.progresss);
                                progress.setProgress(progr);
                                percent = (TextView) findViewById(R.id.percent);
                                percent.setText(Double.toString(perc) +"%");
                                GetTextFromSql1(v);

                            }
                        });
                        iv = (Button) findViewById(R.id.iv);
                        iv.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                balll4 = ball4 + 3;
                                ball4 = balll4;
                                percc = perc + 6.67;
                                perc = percc;
                                progr = progr + 1;
                                progress = (ProgressBar) findViewById(R.id.progresss);
                                progress.setProgress(progr);
                                percent = (TextView) findViewById(R.id.percent);
                                percent.setText(Double.toString(perc) +"%");
                                GetTextFromSql1(v);

                            }
                        });
                        sv = (Button) findViewById(R.id.sv);
                        sv.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                balll4 = ball4 + 4;
                                ball4 = balll4;
                                percc = perc + 6.67;
                                perc = percc;
                                progr = progr + 1;
                                progress = (ProgressBar) findViewById(R.id.progresss);
                                progress.setProgress(progr);
                                percent = (TextView) findViewById(R.id.percent);
                                percent.setText(Double.toString(perc) +"%");
                                GetTextFromSql1(v);

                            }
                        });
                        ver = (Button) findViewById(R.id.v);
                        ver.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                balll4 = ball4 + 5;
                                ball4 = balll4;
                                percc = perc + 6.67;
                                perc = percc;
                                progr = progr + 1;
                                progress = (ProgressBar) findViewById(R.id.progresss);
                                progress.setProgress(progr);
                                percent = (TextView) findViewById(R.id.percent);
                                percent.setText(Double.toString(perc) +"%");
                                GetTextFromSql1(v);

                            }
                        });

                    }

                }else
                {
                    not.setEnabled(false);
                    snv.setEnabled(false);
                    iv.setEnabled(false);
                    sv.setEnabled(false);
                    ver.setEnabled(false);
                }


                String query = "Select * From Questions_t2 where ID = " + i[0] + "";
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


    public void End(View v) {

        int balls = ball + ball1 + ball2 + ball3 + ball4;
        try {
            ConnectionHelper conectionHellper = new ConnectionHelper();
            connection = conectionHellper.connectionClass();
            if (balls <0 )
            {
                Toast.makeText(this,"Тест еще не закончен", Toast.LENGTH_LONG).show();
                return;
            }
            if (connection != null) {

                String query = "Update Result set Result = '"+balls+"' Where ID = '"+ID+"' and Result is NULL ";
                Statement statement = connection.createStatement();
                statement.execute(query);
                Toast.makeText(this,"Успешно добавлено", Toast.LENGTH_LONG).show();
            } else {
                ConnectionResult = "Check Connection";
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }

        Intent intent = new Intent(Question2.this, ResultTests.class);
        intent.putExtra("Соперничество",ball);
        intent.putExtra("Сотрудничество",ball1);
        intent.putExtra("Компромисс",ball2);
        intent.putExtra("Избегание",ball3);
        intent.putExtra("Приспособление",ball4);
        intent.putExtra("test",test);

        startActivity(intent);
        finish();

    }



}