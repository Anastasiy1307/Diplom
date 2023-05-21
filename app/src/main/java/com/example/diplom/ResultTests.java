package com.example.diplom;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;

import android.view.View;
import android.widget.TextView;

public class ResultTests extends AppCompatActivity {
    TextView Name;
    TextView ball;
    TextView result;
    TextView result1;
    int ball1 = 0;
    int ball2 = 0;
    int ball3 = 0;
    int ball4 = 0;
    int ball5 = 0;
    int ball6 = 0;

    float ball7 = 0;
    float ball8 = 0;
    float ball9 = 0;
    float ball10 = 0;
    float ball11 = 0;

    int ball12 = 0;
    int ball13 = 0;
    int ball14 = 0;

    String soper;
    String sotr;
    String komp;
    String izbeg;
    String prisp;

    String cn;
    String krit;
    String spso;
    String nnt;

    String ks;
    String os;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_tests);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        Name = (TextView) findViewById(R.id.nameTests);

        final String getExtra = getIntent().getStringExtra("test");
        Name.setText(getExtra);


        ball = (TextView) findViewById(R.id.Result);


        //баллы Шкала "Профессиональный рост и мотивации"
        final int getExtra1 = getIntent().getIntExtra("ball",ball1);

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


        //баллы Самооценка уровня творческой активности воспитанников
        final float getExtra7 = getIntent().getFloatExtra("балл Самооценка уровня творческой активности воспитанников",ball7);
        ball.setText("Количество баллов: "+Float.toString(getExtra7));
        //балл чувство новизны
        final float getExtra8 = getIntent().getFloatExtra("чувство новизны",ball8);

        //балл критичность
        final float getExtra9 = getIntent().getFloatExtra("критичность",ball9);
        //балл способность преобразовывать структуру объекта
        final float getExtra10 = getIntent().getFloatExtra("способность преобразовывать структуру объекта",ball10);
        //балл направленность на творчество
        final float getExtra11 = getIntent().getFloatExtra("направленность на творчество",ball11);

        cn = Float.toString(getExtra8);
        krit = Float.toString(getExtra9);
        spso = Float.toString(getExtra10);
        nnt = Float.toString(getExtra11);

        //баллы КОС-2
        final int getExtra12 = getIntent().getIntExtra("КОС-2",ball12);

        //баллы КОС-2 Коммуникативные склонности
        final int getExtra13 = getIntent().getIntExtra("Коммуникативные склонности",ball13);

        //баллы КОС-2 Организаторские склонности
        final int getExtra14 = getIntent().getIntExtra("Организаторские склонности",ball14);

        ks = Integer.toString(getExtra13);
        os = Integer.toString(getExtra14);
        if (balls == 0 && getExtra7 == 0.0 && getExtra12 == 0){
            ball.setText("Количество баллов: "+Integer.toString(getExtra1));
        }else if (getExtra1 == 0 && getExtra7 == 0.0 && getExtra12 == 0){
            ball.setText("Количество баллов: "+Integer.toString(balls));
        }else if (getExtra1 == 0 && balls == 0 && getExtra12 == 0){
            ball.setText("Количество баллов: "+Float.toString(getExtra7));
        }else if (getExtra1 == 0 && balls == 0 && getExtra7 == 0.0){
            ball.setText("Количество баллов: "+Integer.toString(getExtra12));
        }




        result = (TextView) findViewById(R.id.resultat);
        result1 = (TextView) findViewById(R.id.resultat1);

        if(getExtra1>0) {
            if (getExtra1 <= 100 && getExtra1 >= 80) {
                result.setText("Ваш результат: Высокий уровень профессионльного роста и мотивации\n\nВысокий уровень проффессионального роста и мотивации - от 80 до 100 баллов\nСредний уровень проффессионального роста и мотивации - от 50 до 79 баллов\nНизкий уровень проффессионального роста и мотивации - от 20 до 49 баллов");
            } else if (getExtra1 <= 79 && getExtra1 >= 50) {

                result.setText("Ваш результат:\nСредний уровень профессионльного роста и мотивации\n\nВысокий уровень проффессионального роста и мотивации - от 80 до 100 баллов\nСредний уровень проффессионального роста и мотивации - от 50 до 79 баллов\nНизкий уровень проффессионального роста и мотивации - от 20 до 49 баллов");
            } else if (getExtra1 <= 49 && getExtra1 >= 20) {

                result.setText("Ваш результат:\nНизкий уровень профессионльного роста и мотивации\n\nВысокий уровень проффессионального роста и мотивации - от 80 до 100 баллов\nСредний уровень проффессионального роста и мотивации - от 50 до 79 баллов\nНизкий уровень проффессионального роста и мотивации - от 20 до 49 баллов");
            }
        } else if (getExtra2>0)
        {
            result.setText("Ваш результат:\nСоперничество: " + soper + "\nСотрудничество: " + sotr + "\nКомпромисс: " + komp + "\nИзбегание: " + izbeg + "\n Приспособление: " + prisp + "");
        }else if (getExtra7>0.0){

        if (getExtra7 >= 0.0 && getExtra7 <= 1.0)
        {
            result.setText("Ваш результат:\nУровень творческой активности: Низкий \nЧувство новизны: " + cn + "\nКритичность: " + krit + "\nСпособность преобразовывать структуру объекта: " + spso + "\nНаправленность на творчество: " + nnt + "");
        } else if (getExtra7>1.0 && getExtra7<= 1.5)
        {
            result.setText("Ваш результат:\nУровень творческой активности: Средний \nЧувство новизны: " + cn + "\nКритичность: " + krit + "\nСпособность преобразовывать структуру объекта: " + spso + "\nНаправленность на творчество: " + nnt + "");
        }else if (getExtra7>1.5 && getExtra7<= 2.0)
        {
            result.setText("Ваш результат:\nУровень творческой активности: Высокий \nЧувство новизны: " + cn + "\nКритичность: " + krit + "\nСпособность преобразовывать структуру объекта: " + spso + "\nНаправленность на творчество: " + nnt + "");
        }
        }else if (getExtra12>0) {
            if (getExtra13 >= 1 && getExtra13 <= 2) {
                result.setText("Коммуникативные склонности: Низкий уровень проявления коммуникативных склонностей.");
            } else if (getExtra13 >= 3 && getExtra13 <= 4) {
                result.setText("Коммуникативные склонности: коммуникативные склонности на уровне ниже среднего. Такие люди не стремятся к общению, предпочитают проводить время наедине с собой. В новой компании или коллективе чувствуют себя скованно. Испытывают трудности в у становлении контактов с людьми. Не отстаивают своего мнения, тяжело переживают обиды. Редко проявляют инициативу, избегают принятия самостоятельных решений.");
            } else if (getExtra13 >= 5 && getExtra13 <= 6) {
                result.setText("Коммуникативные склонности: Средний уровень проявления коммуникативных склонностей. Присутствует стремление к контактам с людьми, отстаивание своего мнения. Однако потенциал склонностей не отличается высокой устойчивостью.");
            } else if (getExtra13 >= 7 && getExtra13 <= 8) {
                result.setText("Коммуникативные склонности: высокий уровень проявления коммуникативных склонностей испытуемых. Они не теряются в новой обстановке, быстро находят друзей, стремятся расширить круг своих знакомых помогают близким и друзьям, проявляют инициативу в общении, способны принимать решения в трудных, нестандартных ситуациях");
            } else if (getExtra13 >= 9 && getExtra13 <= 10) {
                result.setText("Коммуникативные склонности: высший уровень коммуникативных склонностей. У испытуемых свидетельствует о сформированной потребности в коммуникативной и организаторской деятельности. Они быстро ориентируются в трудных ситуациях, непринужденно ведут себя в новом коллективе, инициативны, принимают самостоятельные решения. Отстаивают свое мнение и добиваются принятия своих решений. Любят организовывать игры, различные мероприятия, настойчивы и одержимы в деятельности.");
            }
            if (getExtra13 >= 1 && getExtra13 <= 2) {
                result1.setText("Организаторские склонности: Низкий уровень проявления коммуникативных склонностей.\n\nКоммуникативные склонности: " + ks + "\nОрганизаторские склонности: " + os + "\n");
            } else if (getExtra13 >= 3 && getExtra13 <= 4) {
                result1.setText("Организаторские склонности: Организаторские склонности на уровне ниже среднего. Такие люди не стремятся к общению, предпочитают проводить время наедине с собой. В новой компании или коллективе чувствуют себя скованно. Испытывают трудности в у становлении контактов с людьми. Не отстаивают своего мнения, тяжело переживают обиды. Редко проявляют инициативу, избегают принятия самостоятельных решений.\n\nКоммуникативные склонности: " + ks + "\nОрганизаторские склонности: " + os + "\n");
            } else if (getExtra13 >= 5 && getExtra13 <= 6) {
                result1.setText("Организаторские склонности: Средний уровень проявления организаторских склонностей. Присутствует стремление к контактам с людьми, отстаивание своего мнения. Однако потенциал склонностей не отличается высокой устойчивостью.\n\nКоммуникативные склонности: " + ks + "\nОрганизаторские склонности: " + os + "\n");
            } else if (getExtra13 >= 7 && getExtra13 <= 8) {
                result1.setText("Организаторские склонности: высокий уровень проявления организаторских склонностей испытуемых. Они не теряются в новой обстановке, быстро находят друзей, стремятся расширить круг своих знакомых помогают близким и друзьям, проявляют инициативу в общении, способны принимать решения в трудных, нестандартных ситуациях\n\nКоммуникативные склонности: " + ks + "\nОрганизаторские склонности: " + os + "\n");
            } else if (getExtra13 >= 9 && getExtra13 <= 10) {
                result1.setText("Организаторские склонности: высший уровень организаторских склонностей. У испытуемых свидетельствует о сформированной потребности в коммуникативной и организаторской деятельности. Они быстро ориентируются в трудных ситуациях, непринужденно ведут себя в новом коллективе, инициативны, принимают самостоятельные решения. Отстаивают свое мнение и добиваются принятия своих решений. Любят организовывать игры, различные мероприятия, настойчивы и одержимы в деятельности.\n\nКоммуникативные склонности: " + ks + "\nОрганизаторские склонности: " + os + "\n");
            }

        }

    }
    public void Back(View v) {
        Intent intent = new Intent(ResultTests.this, AVT.class);
        startActivity(intent);
        finish();
    }


}