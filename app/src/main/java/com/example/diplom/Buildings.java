package com.example.diplom;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

public class Buildings implements Parcelable {


    private int ID;
    private String Img;


    protected Buildings(Parcel in) {
        ID = in.readInt();
        Img = in.readString();

    }

    public static final Creator<Buildings> CREATOR = new Creator<Buildings>() {
        @Override
        public Buildings createFromParcel(Parcel in) {
            return new Buildings(in);
        }

        @Override
        public Buildings[] newArray(int size) {
            return new Buildings[size];
        }
    };

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }


    public void setImg(String img) {
        Img = img;
    }





    public String getImg() {
        return Img;
    }



    public Buildings(int ID, String img) {
        this.ID = ID;
        Img = img;

    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(ID);

        dest.writeString(Img);
    }
}