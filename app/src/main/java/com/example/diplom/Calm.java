package com.example.diplom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;

public class Calm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calm);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }
    public void Help(View v) {
        Intent intent = new Intent(Calm.this, Help.class);
        startActivity(intent);
        finish();
    }

    public void Task(View v) {
        Intent intent = new Intent(Calm.this, Tests.class);
        startActivity(intent);
        finish();
    }
}