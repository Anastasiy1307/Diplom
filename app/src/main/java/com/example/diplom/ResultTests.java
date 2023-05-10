package com.example.diplom;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ResultTests extends AppCompatActivity {
    TextView Name;
    TextView ball;
    TextView result;
    int ball1 = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_tests);

        Name = (TextView) findViewById(R.id.nameTests);

        final String getExtra = getIntent().getStringExtra("test");
        Name.setText(getExtra);


        ball = (TextView) findViewById(R.id.Result);

        final int getExtra1 = getIntent().getIntExtra("ball",ball1);
        ball.setText("Количество баллов: " + Integer.toString(getExtra1));

        result = (TextView) findViewById(R.id.resultat);

        if (getExtra1<=100 && getExtra1>=80)
        {
           result.setText("Ваш результат: Высокий уровень профессионльного роста и мотивации\nВысокий уровень проффессионального роста и мотивации - от 80 до 100 баллов\nСредний уровень проффессионального роста и мотивации - от 50 до 79 баллов\nНизкий уровень проффессионального роста и мотивации - от 20 до 49 баллов");
        } else if (getExtra1<=79 && getExtra1>=50)
        {

           result.setText("Ваш результат:\nСредний уровень профессионльного роста и мотивации\nВысокий уровень проффессионального роста и мотивации - от 80 до 100 баллов\nСредний уровень проффессионального роста и мотивации - от 50 до 79 баллов\nНизкий уровень проффессионального роста и мотивации - от 20 до 49 баллов");
        } else if (getExtra1<=49 && getExtra1>=20)
        {

           result.setText("Ваш результат:\nНизкий уровень профессионльного роста и мотивации\nВысокий уровень проффессионального роста и мотивации - от 80 до 100 баллов\nСредний уровень проффессионального роста и мотивации - от 50 до 79 баллов\nНизкий уровень проффессионального роста и мотивации - от 20 до 49 баллов");
        }
    }


}