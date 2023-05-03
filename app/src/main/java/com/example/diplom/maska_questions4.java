package com.example.diplom;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

public class maska_questions4 implements Parcelable {

    private int ID;
    private String Question;


    protected maska_questions4(Parcel in) {
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

    public maska_questions4(int ID, String Question) {
        this.ID = ID;
        this.Question = Question;
    }

    public static final Parcelable.Creator<maska_questions4> CREATOR = new Parcelable.Creator<maska_questions4>() {
        @Override
        public maska_questions4 createFromParcel(Parcel in) {
            return new maska_questions4(in);
        }

        @Override
        public maska_questions4[] newArray(int size) {
            return new maska_questions4[size];
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