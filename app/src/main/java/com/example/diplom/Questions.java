package com.example.diplom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Questions extends AppCompatActivity {
    String extra = "";
    TextView nameTest;
    Button end;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);
        nameTest = (TextView) findViewById(R.id.nameTest);
        final String getExtra = getIntent().getStringExtra("test");
        nameTest.setText(getExtra);
        extra = nameTest.getText().toString();
        end = (Button) findViewById(R.id.end);



        end.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Questions.this, ResultTests.class);
                intent.putExtra("nameTest",extra);
                startActivity(intent);
                finish();
            }
        });

    }
}