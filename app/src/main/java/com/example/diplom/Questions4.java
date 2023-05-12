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

public class Questions4 extends AppCompatActivity {

    TextView nameTest;
    View v;
    Connection connection;
    String ConnectionResult = "";
    String test = "";
    public final int[] i = {0};

    Button yes;
    Button not;
    int ballks1;
    int ballos1;
    int ball;
    int ballks = 0;
    int ballos = 0;

    String ID;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions4);
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
            ball = ballks + ballos;
            if (ball < 0 )
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


        Intent intent = new Intent(Questions4.this, ResultTests.class);

        intent.putExtra("КОС-2",ball);
        intent.putExtra("test",test);

        intent.putExtra("Коммуникативные склонности",ballks);
        intent.putExtra("Организаторские склонности",ballos);


        startActivity(intent);
        finish();

    }

    public void GetTextFromSql1(View v) {
        TextView BaseId = findViewById(R.id.Question);

        try {
            ConnectionHelper conectionHellper = new ConnectionHelper();
            connection = conectionHellper.connectionClass();
            if (connection != null) {

                String query0 = "select count(ID) from Questions_t4 ";
                Statement statement0 = connection.createStatement();
                ResultSet resultSet0 = statement0.executeQuery(query0);
                int c = 0;
                while (resultSet0.next()) {
                    c = resultSet0.getInt(1);
                }

                int finalC = c;

                if (i[0] != finalC) {
                    i[0] = i[0] + 1;
                    if (i[0] ==1 || i[0] == 5 || i[0] == 9 || i[0] == 13 || i[0] == 17){
                        not = (Button) findViewById(R.id.not);
                        not.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                ballks1 = ballks + 0;
                                ballks = ballks1;
                                GetTextFromSql1(v);

                            }
                        });
                        yes = (Button) findViewById(R.id.yes);
                        yes.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                ballks1 = ballks + 1;
                                ballks = ballks1;
                                GetTextFromSql1(v);

                            }
                        });

                    }
                    else if (i[0] == 3 || i[0] == 7 || i[0] == 11 || i[0] == 15 || i[0] == 19){
                        not = (Button) findViewById(R.id.not);
                        not.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                ballks1 = ballks + 1;
                                ballks = ballks1;
                                GetTextFromSql1(v);

                            }
                        });
                        yes = (Button) findViewById(R.id.yes);
                        yes.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                ballks1 = ballks + 0;
                                ballks = ballks1;
                                GetTextFromSql1(v);

                            }
                        });

                    }

                    else if (i[0] == 2 || i[0] == 6 || i[0] == 10 || i[0] == 14 || i[0] == 18){
                        not = (Button) findViewById(R.id.not);
                        not.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                ballos1 = ballos + 0;
                                ballos = ballos1;
                                GetTextFromSql1(v);

                            }
                        });
                        yes = (Button) findViewById(R.id.yes);
                        yes.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                ballos1 = ballos + 1;
                                ballos = ballos1;
                                GetTextFromSql1(v);

                            }
                        });
                    }

                    else if (i[0] == 4 || i[0] == 8 || i[0] == 12 || i[0] == 16 || i[0] == 20){
                        not = (Button) findViewById(R.id.not);
                        not.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                ballos1 = ballos + 1;
                                ballos = ballos1;
                                GetTextFromSql1(v);

                            }
                        });
                        yes = (Button) findViewById(R.id.yes);
                        yes.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                ballos1 = ballos + 0;
                                ballos = ballos1;
                                GetTextFromSql1(v);

                            }
                        });
                    }
                }else
                {
                    not.setEnabled(false);
                    yes.setEnabled(false);


                }


                String query = "Select * From Questions_t4 where ID = " + i[0] + "";
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