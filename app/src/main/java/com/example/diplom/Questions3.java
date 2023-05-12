package com.example.diplom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Questions3 extends AppCompatActivity {

    TextView nameTest;
    View v;
    Connection connection;
    String ConnectionResult = "";
    String test = "";
    public final int[] i = {0};

    Button yes;
    Button ts;
    Button not;


    float ball = 0;
    float ball11 = 0;
    float ball22 = 0;
    float ball33 = 0;
    float ball44 = 0;
    int balll1;
    int ball1 = 0;
    int balll2;
    int ball2 = 0;
    int balll3;
    int ball3 = 0;
    int balll4;
    int ball4 = 0;

    String ID;

    TextView bal;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions3);
        v = findViewById(com.google.android.material.R.id.ghost_view);
        nameTest = (TextView) findViewById(R.id.nameTest);
        final String getExtra = getIntent().getStringExtra("test");
        final String getExtra1= getIntent().getStringExtra("ID");
        test = getExtra;
        ID = getExtra1;
        nameTest.setText(getExtra);
        GetTextFromSql1(v);





    }





    public void End(View v) {

        try {
            ConnectionHelper conectionHellper = new ConnectionHelper();
            connection = conectionHellper.connectionClass();
            ball = ball1+ ball2+ball3+ball4;
            if (ball < 0 )
            {
                Toast.makeText(this,"Тест еще не закончен", Toast.LENGTH_LONG).show();
                return;
            }
            if (connection != null) {
                ball = ball/16;
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
        ball11 =ball1/4;
        ball22 =ball2/4;
        ball33 =ball3/4;
        ball44 =ball4/4;

        Intent intent = new Intent(Questions3.this, ResultTests.class);

        intent.putExtra("балл Самооценка уровня творческой активности воспитанников",ball);
        intent.putExtra("test",test);

        intent.putExtra("чувство новизны",ball11);
        intent.putExtra("критичность",ball22);
        intent.putExtra("способность преобразовывать структуру объекта",ball33);
        intent.putExtra("направленность на творчество",ball44);

        startActivity(intent);
        finish();

    }

    public void GetTextFromSql1(View v) {
        TextView BaseId = findViewById(R.id.Question);

        try {
            ConnectionHelper conectionHellper = new ConnectionHelper();
            connection = conectionHellper.connectionClass();
            if (connection != null) {

                String query0 = "select count(ID) from Questions_t3 ";
                Statement statement0 = connection.createStatement();
                ResultSet resultSet0 = statement0.executeQuery(query0);
                int c = 0;
                while (resultSet0.next()) {
                    c = resultSet0.getInt(1);
                }

                int finalC = c;

                if (i[0] != finalC) {
                    i[0] = i[0] + 1;
                    if (i[0] ==1 || i[0] == 5 || i[0] == 9 || i[0] == 13){
                        not = (Button) findViewById(R.id.not);
                        not.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                balll1 = ball1 + 0;
                                ball1 = balll1;
                                GetTextFromSql1(v);

                            }
                        });
                        yes = (Button) findViewById(R.id.yes);
                        yes.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                balll1 = ball1 + 2;
                                ball1 = balll1;
                                GetTextFromSql1(v);

                            }
                        });
                        ts = (Button) findViewById(R.id.ts);
                        ts.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                balll1 = ball1 + 1;
                                ball1 = balll1;
                                GetTextFromSql1(v);

                            }
                        });

                    }
                    else if (i[0] == 2 || i[0] == 6 || i[0] == 10 || i[0] == 14){
                        not = (Button) findViewById(R.id.not);
                        not.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                balll2 = ball2 + 0;
                                ball2 = balll2;
                                GetTextFromSql1(v);

                            }
                        });
                        yes = (Button) findViewById(R.id.yes);
                        yes.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                balll2 = ball2 + 2;
                                ball2 = balll2;
                                GetTextFromSql1(v);

                            }
                        });
                        ts = (Button) findViewById(R.id.ts);
                        ts.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                balll2 = ball2 + 1;
                                ball2 = balll2;
                                GetTextFromSql1(v);

                            }
                        });

                    }

                    else if (i[0] == 3 || i[0] == 7 || i[0] == 11 || i[0] == 15){
                        not = (Button) findViewById(R.id.not);
                        not.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                balll3 = ball3 + 0;
                                ball3 = balll3;
                                GetTextFromSql1(v);

                            }
                        });
                        yes = (Button) findViewById(R.id.yes);
                        yes.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                balll3 = ball3 + 2;
                                ball3 = balll3;
                                GetTextFromSql1(v);

                            }
                        });
                        ts = (Button) findViewById(R.id.ts);
                        ts.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                balll3 = ball3 + 1;
                                ball3 = balll3;
                                GetTextFromSql1(v);

                            }
                        });
                    }

                    else if (i[0] == 4 || i[0] == 8 || i[0] == 12 || i[0] == 16){
                        not = (Button) findViewById(R.id.not);
                        not.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                balll4 = ball4 + 0;
                                ball4 = balll4;
                                GetTextFromSql1(v);

                            }
                        });
                        yes = (Button) findViewById(R.id.yes);
                        yes.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                balll4 = ball4 + 2;
                                ball4 = balll4;
                                GetTextFromSql1(v);

                            }
                        });
                        ts = (Button) findViewById(R.id.ts);
                        ts.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                balll4 = ball4 + 1;
                                ball4 = balll4;
                                GetTextFromSql1(v);

                            }
                        });

                    }
                }else
                {
                    not.setEnabled(false);
                    yes.setEnabled(false);
                    ts.setEnabled(false);

                }


                String query = "Select * From Questions_t3 where ID = " + i[0] + "";
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