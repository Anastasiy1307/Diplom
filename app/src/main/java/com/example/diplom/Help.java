package com.example.diplom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;

public class Help extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }


    public void Task(View v) {
        Intent intent = new Intent(Help.this, Tests.class);
        startActivity(intent);
        finish();
    }

    public void Calm(View v) {
        Intent intent = new Intent(Help.this, Calm.class);
        startActivity(intent);
        finish();
    }
}