package com.example.diplom;

import static com.github.mikephil.charting.utils.ColorTemplate.*;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Chart extends AppCompatActivity {

    View v;
    Mask_specialties mask1;
    maska_group maskkk;
    Connection connection;
    List<Mask_Chart> data;
    ListView listView;
    TextView nameGroup;
    String grup;
    int data1;
    int data2;
    int data3;
    int data4;

    public final float[] y = {0};
    public final int[] i = {0};

    ArrayList barEntriesArrayList;
    Adapter_Chart pAdapter;
    int maskk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        v = findViewById(com.google.android.material.R.id.ghost_view);
        mask1 = getIntent().getParcelableExtra("gruppa");
        maskk = mask1.getID();
        getBarEntries();
        BarChart barChart = findViewById(R.id.chart);
        BarDataSet barDataSet = new BarDataSet(barEntriesArrayList , "Результаты группы");
        BarData barData = new BarData(barDataSet);
        barChart.setData(barData);
        barDataSet.setColors(COLORFUL_COLORS);
        barDataSet.setValueTextColor(Color.BLACK);
        barDataSet.setValueTextSize(16f);
        barChart.getDescription().setEnabled(true);
        GetTextFromSQL(v);


    }
    public void enterMobile() {
        pAdapter.notifyDataSetInvalidated();
        listView.setAdapter(pAdapter);
    }




    public void GetTextFromSQL(View v) {
        data = new ArrayList<Mask_Chart>();

        listView = findViewById(R.id.chartlist);
        pAdapter = new Adapter_Chart(Chart.this, data);
        try {
            ConnectionHelper connectionHelper = new ConnectionHelper();
            connection = connectionHelper.connectionClass();
            if (connection != null) {

                String query = "SELECT DISTINCT Result.ID, Result.ID_group, Classes.Name_group,  Result.Result, Result.Date FROM Result, Classes,Specialties,Building WHERE Result.ID_group = Classes.ID and Result.ID_group = '"+maskk+"'";
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query);

                while (resultSet.next()) {
                    Mask_Chart tempMask = new Mask_Chart
                            (resultSet.getInt("ID"),
                                    resultSet.getInt("ID_group"),
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
    public void special(View view) {
        this.finish();
    }


    public void GetCountResult75() {
        try {
            ConnectionHelper connectionHelper = new ConnectionHelper();
            connection = connectionHelper.connectionClass();
            if (connection != null) {

                String query = "select count(ID) from Result Where ID_group = "+maskk+" and Result >= 75";
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query);
                int c = 0;
                while (resultSet.next()) {
                    c = resultSet.getInt(1);
                }

                data1 = c;

                String query0 = "select count(ID) from Result Where ID_group = "+maskk+" and Result < 75 and Result >= 50";
                Statement statement0 = connection.createStatement();
                ResultSet resultSet0 = statement0.executeQuery(query0);
                int c0 = 0;
                while (resultSet0.next()) {
                    c0 = resultSet0.getInt(1);
                }

                data2 = c0;

                String query1 = "select count(ID) from Result Where ID_group = "+maskk+" and Result < 50 and Result >= 20";
                Statement statement1 = connection.createStatement();
                ResultSet resultSet1 = statement1.executeQuery(query1);
                int c1 = 0;
                while (resultSet1.next()) {
                    c1 = resultSet1.getInt(1);
                }

                data3 = c1;

                String query2 = "select count(ID) from Result Where ID_group = "+maskk+" and Result < 20";
                Statement statement2 = connection.createStatement();
                ResultSet resultSet2 = statement2.executeQuery(query2);
                int c2 = 0;
                while (resultSet2.next()) {
                    c2 = resultSet2.getInt(1);
                }

                data4 = c2;

                connection.close();
            } else {
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }

    private void getBarEntries() {
        // creating a new array list
        barEntriesArrayList = new ArrayList<>();
        GetCountResult75();

        // adding new entry to our array list with bar
        // entry and passing x and y axis value to it.
        barEntriesArrayList.add(new BarEntry(1f, data1));

        barEntriesArrayList.add(new BarEntry(2f, data2));
        barEntriesArrayList.add(new BarEntry(3f, data3));
        barEntriesArrayList.add(new BarEntry(4f, data4));


    }
}