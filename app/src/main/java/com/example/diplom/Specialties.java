package com.example.diplom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Specialties extends AppCompatActivity {

    View v;
    Connection connection;
    List<Mask_specialties> data;
    ListView listView;
    Adapter_Specialties pAdapter;
    int mask1;
    int maskk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specialties);
        final int getExtra2 = getIntent().getIntExtra("korp",mask1);
        maskk = getExtra2;
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        v = findViewById(com.google.android.material.R.id.ghost_view);


        GetTextFromSQL(v);
    }
    public void enterMobile() {
        pAdapter.notifyDataSetInvalidated();
        listView.setAdapter(pAdapter);
    }

    public void GetTextFromSQL(View v) {
        data = new ArrayList<Mask_specialties>();
        listView = findViewById(R.id.r1);
        pAdapter = new Adapter_Specialties(Specialties.this, data);
        try {
            ConnectionHelper connectionHelper = new ConnectionHelper();
            connection = connectionHelper.connectionClass();
            if (connection != null) {

                String query = "Select * From Specialties Where ID_building ="+maskk+"";
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query);

                while (resultSet.next()) {
                    Mask_specialties tempMask = new Mask_specialties
                            (resultSet.getInt("ID"),
                                    resultSet.getString("Name_specialties"),
                                    resultSet.getString("Code_specialties")

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
}