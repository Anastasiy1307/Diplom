package com.example.diplom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Tests extends AppCompatActivity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tests);

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