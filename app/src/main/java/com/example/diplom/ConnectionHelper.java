package com.example.diplom;

import android.annotation.SuppressLint;
import android.os.StrictMode;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionHelper {
    String userName, userPassword, ip, port, dataBase;

    @SuppressLint("NewApi")
    public Connection connectionClass()
    {
        ip ="ngknn.ru";
        dataBase ="Tests_NGK";
        userPassword="12357";
        userName="33П";
        port="1433";

        StrictMode.ThreadPolicy policy= new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        Connection connection=null;
        String ConnectionURL=null;

        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            ConnectionURL = "jdbc:jtds:sqlserver://" + ip + ":" + port + ";" + "databasename=" + dataBase + ";user=" + userName + ";password=" + userPassword + ";";
            connection = DriverManager.getConnection(ConnectionURL);

        }

        catch (Exception ex)
        {
            Log.e("Error", ex.getMessage());
        }
        return connection;
    }


}
