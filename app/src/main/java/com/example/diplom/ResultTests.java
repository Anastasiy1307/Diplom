package com.example.diplom;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ResultTests extends AppCompatActivity {
    TextView Name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_tests);

        Name = (TextView) findViewById(R.id.nameTests);

        final String getExtra = getIntent().getStringExtra("nameTest");

        Name.setText(getExtra);
    }
}