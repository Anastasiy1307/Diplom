package com.example.diplom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class masks_Questions3 implements Parcelable {

    private int ID;
    private String Question;


    protected masks_Questions3(Parcel in) {
        ID = in.readInt();
        Question = in.readString();
    }


    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getQuestion() {
        return Question;
    }

    public void setQuestion(String question) {
        Question = question;
    }

    public masks_Questions3(int ID, String Question) {
        this.ID = ID;
        this.Question = Question;
    }

    public static final Creator<masks_Questions3> CREATOR = new Creator<masks_Questions3>() {
        @Override
        public masks_Questions3 createFromParcel(Parcel in) {
            return new masks_Questions3(in);
        }

        @Override
        public masks_Questions3[] newArray(int size) {
            return new masks_Questions3[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(ID);
        dest.writeString(Question);
    }
}