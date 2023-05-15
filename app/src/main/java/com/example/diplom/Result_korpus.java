package com.example.diplom;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import java.io.ByteArrayOutputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class Result_korpus extends AppCompatActivity {


    mask_result mask;
    Connection connection;
    List<mask_result> data;
    ListView listView;
    Adapter_reskorpus pAdapter;
    View v;

    int mask1;
    Button result_korp;
    Button result_group;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_korpus);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        final int getExtra2 = getIntent().getIntExtra("korp",mask1);
        mask1 = getExtra2;

        v =findViewById(com.google.android.material.R.id.ghost_view);


        GetTextFromSQL(v);
    }
    public void GetTextFromSQL(View v) {
        data = new ArrayList<mask_result>();
        listView = findViewById(R.id.r);
        pAdapter = new Adapter_reskorpus(Result_korpus.this, data);
        try {
            ConnectionHelper connectionHelper = new ConnectionHelper();
            connection = connectionHelper.connectionClass();
            if (connection != null) {
                String query = "SELECT DISTINCT Result.ID, Result.ID, Classes.Name_group,  Result.Result, Result.Date FROM Result, Classes,Specialties,Building WHERE Result.ID_group = Classes.ID and Specialties.ID_building = '"+mask1+"' and Classes.ID_specialties = Specialties.ID";
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query);

                while (resultSet.next()) {
                    mask_result tempMask = new mask_result
                            (resultSet.getInt("ID"),
                                    resultSet.getString("Name_group"),
                                    resultSet.getString("Result"),
                                    resultSet.getString("Date")

                            );
                    data.add(tempMask);
                    pAdapter.notifyDataSetInvalidated();
                }
                connection.close();
            } else {
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        enterMobile();

    }
    public void enterMobile() {
        pAdapter.notifyDataSetInvalidated();
        listView.setAdapter(pAdapter);
    }
}