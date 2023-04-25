package com.example.diplom;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

public class Maska_Tests implements Parcelable {

   private int ID;
   private String Name_test;
    private String Short_descroption;
    private String Image;
   private int number_of_questions;

    protected Maska_Tests(Parcel in) {
        ID = in.readInt();
        Name_test = in.readString();
        Short_descroption = in.readString();
        Image = in.readString();
        number_of_questions = in.readInt();
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName_test() {
        return Name_test;
    }

    public void setName_test(String name_test) {
        Name_test = name_test;
    }

    public String getShort_descroption() {
        return Short_descroption;
    }

    public void setShort_descroption(String short_descroption) {
        Short_descroption = short_descroption;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public int getNumber_of_questions() {
        return number_of_questions;
    }

    public void setNumber_of_questions(int number_of_questions) {
        this.number_of_questions = number_of_questions;
    }

    public Maska_Tests(int ID, String Name_test, String Short_descroption, String Image, int number_of_questions) {
        this.ID = ID;
        this.Name_test = Name_test;
        this.Short_descroption = Short_descroption;
        this.Image = Image;
        this.number_of_questions = number_of_questions;
    }

    public static final Creator<Maska_Tests> CREATOR = new Creator<Maska_Tests>() {
        @Override
        public Maska_Tests createFromParcel(Parcel in) {
            return new Maska_Tests(in);
        }

        @Override
        public Maska_Tests[] newArray(int size) {
            return new Maska_Tests[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(ID);
        dest.writeString(Name_test);
        dest.writeString(Short_descroption);
        dest.writeString(Image);
        dest.writeInt(number_of_questions);
    }
}