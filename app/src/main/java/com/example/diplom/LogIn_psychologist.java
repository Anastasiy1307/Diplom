package com.example.diplom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LogIn_psychologist extends AppCompatActivity {

    EditText login, password;
    Button Login;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in_psychologist);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        login = (EditText) findViewById(R.id.LogIn);
        password = (EditText) findViewById(R.id.password);
        Login = (Button) findViewById(R.id.Login);
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(login.getText().toString().equals("123") && password.getText().toString().equals("123")){
                    Toast.makeText(LogIn_psychologist.this, "Вход выполнен успешно", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(LogIn_psychologist.this, Glavn_Ps.class);
                    startActivity(intent);
                    finish();
                }
                else {//Условие не выпоняется
                    Toast.makeText(LogIn_psychologist.this, "Проверьте логин или пароль", Toast.LENGTH_LONG).show();
                }

            }
        });
    }
    public void Back(View v) {
        Intent intent = new Intent(LogIn_psychologist.this, AVT.class);
        startActivity(intent);
        finish();
    }

}