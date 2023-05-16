package com.example.diplom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Groups extends AppCompatActivity {


    View v;
    Mask_specialties mask1;
    Connection connection;
    List<maska_group> data;
    GridView listView;
    Adapter_group pAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_groups);
        v = findViewById(com.google.android.material.R.id.ghost_view);
        mask1=getIntent().getParcelableExtra("special");
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        GetTextFromSQL(v);


    }
    public void enterMobile() {
        pAdapter.notifyDataSetInvalidated();
        listView.setAdapter(pAdapter);
    }



    public void GetTextFromSQL(View v) {
        data = new ArrayList<maska_group>();
        listView = findViewById(R.id.r1);
        pAdapter = new Adapter_group(Groups.this, data);
        try {
            ConnectionHelper connectionHelper = new ConnectionHelper();
            connection = connectionHelper.connectionClass();
            if (connection != null) {

                String query = "Select * From Classes Where Id_specialties = "+mask1.getID()+"";
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query);

                while (resultSet.next()) {
                    maska_group tempMask = new maska_group
                            (resultSet.getInt("ID"),
                                    resultSet.getInt("Id_specialties"),
                                    resultSet.getString("Name_group")

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
    public void special(View view) {
        this.finish();
    }

}