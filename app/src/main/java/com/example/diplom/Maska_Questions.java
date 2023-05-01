package com.example.diplom;

import android.os.Parcel;
import android.os.Parcelable;

public class Maska_Questions implements Parcelable {

    private int ID;
    private String Question;


    protected Maska_Questions(Parcel in) {
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

    public Maska_Questions(int ID, String Question) {
        this.ID = ID;
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
        dest.writeString(Question);
    }
}