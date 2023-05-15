package com.example.diplom;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;


public class mask_result implements Parcelable {

    private int ID;
    private String Name_group;
    private String Result;
    private String Date;




    protected mask_result(Parcel in) {
        ID = in.readInt();
        Name_group = in.readString();
        Result = in.readString();
        Date = in.readString();
    }


    public String getName_group() {
        return Name_group;
    }

    public void setName_group(String name_group) {
        Name_group = name_group;
    }

    public mask_result(int ID, String Name_group, String Result, String Date) {
        this.ID = ID;
        this.Name_group = Name_group;
        this.Result = Result;
        this.Date = Date;
    }

    public static final Parcelable.Creator<mask_result> CREATOR = new Parcelable.Creator<mask_result>() {
        @Override
        public mask_result createFromParcel(Parcel in) {
            return new mask_result(in);
        }

        @Override
        public mask_result[] newArray(int size) {
            return new mask_result[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(ID);
        dest.writeString(Name_group);
        dest.writeString(Result);
        dest.writeString(Date);
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
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
}