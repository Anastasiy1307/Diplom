package com.example.diplom;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.ListView;
import android.widget.SearchView;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Glavn_Ps extends AppCompatActivity {

    View v;
    Connection connection;
    List<Buildings> data;
    ListView listView;
    AdapterBuilding pAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glavn_ps);
        v = findViewById(com.google.android.material.R.id.ghost_view);
        GetTextFromSQL(v);
    }
    public void enterMobile() {
        pAdapter.notifyDataSetInvalidated();
        listView.setAdapter(pAdapter);
    }

    public void GetTextFromSQL(View v) {
        data = new ArrayList<Buildings>();
        listView = findViewById(R.id.List_build);
        pAdapter = new AdapterBuilding(Glavn_Ps.this, data);
        try {
            ConnectionHelper connectionHelper = new ConnectionHelper();
            connection = connectionHelper.connectionClass();
            if (connection != null) {

                String query = "Select * From Building";
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query);

                while (resultSet.next()) {
                    Buildings tempMask = new Buildings
                            (resultSet.getInt("ID"),
                                    resultSet.getString("Number"),
                                    resultSet.getString("Image")

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