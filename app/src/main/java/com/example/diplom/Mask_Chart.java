package com.example.diplom;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

public class Mask_Chart implements Parcelable {

    private int ID;
    private int ID_group;
    private String Result;
    private String Date;




    protected Mask_Chart(Parcel in) {
        ID = in.readInt();
        ID_group = in.readInt();
        Result = in.readString();
        Date = in.readString();
    }


    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getID_group() {
        return ID_group;
    }

    public void setID_group(int ID_group) {
        this.ID_group = ID_group;
    }

    public String getResult() {
        return Result;
    }

    public void setResult(String result) {
        Result = result;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public Mask_Chart(int ID, int ID_group, String Result, String Date) {
        this.ID = ID;
        this.ID_group = ID_group;
        this.Result = Result;
        this.Date = Date;
    }

    public static final Parcelable.Creator<Mask_Chart> CREATOR = new Parcelable.Creator<Mask_Chart>() {
        @Override
        public Mask_Chart createFromParcel(Parcel in) {
            return new Mask_Chart(in);
        }

        @Override
        public Mask_Chart[] newArray(int size) {
            return new Mask_Chart[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(ID);
        dest.writeInt(ID_group);
        dest.writeString(Result);
        dest.writeString(Date);
    }
}