package com.example.diplom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;

public class Help extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    public void VK12k(View v) {
        Uri address = Uri.parse("https://vk.com/id42380911");
        Intent openlink = new Intent(Intent.ACTION_VIEW, address);
        startActivity(openlink);
    }
    public void VK3k(View v) {
        Uri address = Uri.parse("https://vk.com/id458842179");
        Intent openlink = new Intent(Intent.ACTION_VIEW, address);
        startActivity(openlink);
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