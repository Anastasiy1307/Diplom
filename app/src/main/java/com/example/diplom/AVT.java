package com.example.diplom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AVT extends AppCompatActivity {

    Button Student;
    Button Psychologist;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avt);
        Student = (Button) findViewById(R.id.Login);
        Psychologist = (Button) findViewById(R.id.psychologist);
        Student.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AVT.this, LogIn_student.class);
                startActivity(intent);
                finish();
            }
        });
        Psychologist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AVT.this, LogIn_psychologist.class);
                startActivity(intent);
                finish();
            }
        });
    }
}