package com.example.diplom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Tests extends AppCompatActivity {
    private String test = "";
    Button profrost;
    Button shkalT;
    Button samooc;
    Button KOS;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tests);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        final String getExtra = getIntent().getStringExtra("ID");
        profrost = (Button) findViewById(R.id.prim);
        profrost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                test = "Шкала Профессиональный рост и мотивация";
                Intent intent = new Intent(Tests.this, Questions.class);
                intent.putExtra("test",test);
                intent.putExtra("ID",getExtra);
                startActivity(intent);
                finish();
            }
        });

        shkalT = (Button) findViewById(R.id.hpt);
        shkalT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                test = "Шкалирование по Томасу";
                Intent intent = new Intent(Tests.this, Question2.class);
                intent.putExtra("test",test);
                intent.putExtra("ID",getExtra);
                startActivity(intent);
                finish();
            }
        });

        samooc = (Button) findViewById(R.id.sytav);
        samooc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                test = "Самооценка уровня творческой активности воспитанников";
                Intent intent = new Intent(Tests.this, Questions3.class);
                intent.putExtra("test",test);
                intent.putExtra("ID",getExtra);
                startActivity(intent);
                finish();
            }
        });

        KOS = (Button) findViewById(R.id.okios);
        KOS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                test = "Определение коммуникативных и организаторских способностей";
                Intent intent = new Intent(Tests.this, Questions4.class);
                intent.putExtra("test",test);
                intent.putExtra("ID",getExtra);
                startActivity(intent);
                finish();
            }
        });

    }

    public void Help(View v) {
        Intent intent = new Intent(Tests.this, Help.class);
        startActivity(intent);
        finish();
    }

    public void Calm(View v) {
        Intent intent = new Intent(Tests.this, Calm.class);
        startActivity(intent);
        finish();
    }

}