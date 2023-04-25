package com.example.diplom;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

public class Maska_Questions implements Parcelable {

    private int ID;
    private int Id_test;
    private String Question;



    protected Maska_Questions(Parcel in) {
        ID = in.readInt();
        Id_test = in.readInt();
        Question = in.readString();
    }


    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getId_test() {
        return Id_test;
    }

    public void setId_test(int id_test) {
        Id_test = id_test;
    }

    public String getQuestion() {
        return Question;
    }

    public void setQuestion(String question) {
        Question = question;
    }

    public Maska_Questions(int ID, int Id_test, String Question) {
        this.ID = ID;
        this.Id_test = Id_test;
        this.Question = Question;
    }

    public static final Creator<Maska_Questions> CREATOR = new Creator<Maska_Questions>() {
        @Override
        public Maska_Questions createFromParcel(Parcel in) {
            return new Maska_Questions(in);
        }

        @Override
        public Maska_Questions[] newArray(int size) {
            return new Maska_Questions[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(ID);
        dest.writeInt(Id_test);
        dest.writeString(Question);
    }
}