package com.example.diplom;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;

import android.widget.TextView;

public class ResultTests extends AppCompatActivity {
    TextView Name;
    TextView ball;
    TextView result;
    int ball1 = 0;
    int ball2 = 0;
    int ball3 = 0;
    int ball4 = 0;
    int ball5 = 0;
    int ball6 = 0;
    String soper;
    String sotr;
    String komp;
    String izbeg;
    String prisp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_tests);

        Name = (TextView) findViewById(R.id.nameTests);

        final String getExtra = getIntent().getStringExtra("test");
        Name.setText(getExtra);


        ball = (TextView) findViewById(R.id.Result);


        //баллы Шкала "Профессиональный рост и мотивации"
        final int getExtra1 = getIntent().getIntExtra("ball",ball1);
        ball.setText("Количество баллов: "+Integer.toString(getExtra1));
        //баллы "Шкалирование по Томасу" Соперничество
        final int getExtra2 = getIntent().getIntExtra("Соперничество",ball2);

        //баллы "Шкалирование по Томасу" Сотрудничество
        final int getExtra3 = getIntent().getIntExtra("Сотрудничество",ball3);

        //баллы "Шкалирование по Томасу" Компромис
        final int getExtra4 = getIntent().getIntExtra("Компромисс",ball4);

        //баллы "Шкалирование по Томасу" Избегание
        final int getExtra5 = getIntent().getIntExtra("Избегание",ball5);

        //баллы "Шкалирование по Томасу" Приспособление
        final int getExtra6 = getIntent().getIntExtra("Приспособление",ball6);

        int balls = getExtra2 + getExtra3 + getExtra4 + getExtra5 + getExtra6;
        ball.setText("Количество баллов: "+Integer.toString(balls));
        soper = Integer.toString(getExtra2);
        sotr = Integer.toString(getExtra3);
        komp = Integer.toString(getExtra4);
        izbeg = Integer.toString(getExtra5);
        prisp = Integer.toString(getExtra6);


        result = (TextView) findViewById(R.id.resultat);


        if (getExtra1<=100 && getExtra1>=80)
        {
           result.setText("Ваш результат: Высокий уровень профессионльного роста и мотивации\n\nВысокий уровень проффессионального роста и мотивации - от 80 до 100 баллов\nСредний уровень проффессионального роста и мотивации - от 50 до 79 баллов\nНизкий уровень проффессионального роста и мотивации - от 20 до 49 баллов");
        } else if (getExtra1<=79 && getExtra1>=50)
        {

           result.setText("Ваш результат:\nСредний уровень профессионльного роста и мотивации\n\nВысокий уровень проффессионального роста и мотивации - от 80 до 100 баллов\nСредний уровень проффессионального роста и мотивации - от 50 до 79 баллов\nНизкий уровень проффессионального роста и мотивации - от 20 до 49 баллов");
        } else if (getExtra1<=49 && getExtra1>=20)
        {

           result.setText("Ваш результат:\nНизкий уровень профессионльного роста и мотивации\n\nВысокий уровень проффессионального роста и мотивации - от 80 до 100 баллов\nСредний уровень проффессионального роста и мотивации - от 50 до 79 баллов\nНизкий уровень проффессионального роста и мотивации - от 20 до 49 баллов");
        }

        if (getExtra2>0)
        {
            result.setText("Ваш результат:\nСоперничество: " + soper + "\nСотрудничество: " + sotr + "\nКомпромисс: " + komp + "\nИзбегание: " + izbeg + "\n Приспособление: " + prisp + "");
        }
    }


}