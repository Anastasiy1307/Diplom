package com.example.diplom;

import android.os.Parcel;
import android.os.Parcelable;

public class Maska_Answer implements Parcelable {

    private int ID;
    private int id_question;
    private String answer;

    protected Maska_Answer(Parcel in) {
        ID = in.readInt();
        id_question = in.readInt();
        answer = in.readString();
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getId_question() {
        return id_question;
    }

    public void setId_question(int id_question) {
        this.id_question = id_question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Maska_Answer(int ID, int Id_test, String Question) {
        this.ID = ID;
        this.id_question = Id_test;
        this.answer = Question;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(ID);
        dest.writeInt(id_question);
        dest.writeString(answer);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Maska_Answer> CREATOR = new Creator<Maska_Answer>() {
        @Override
        public Maska_Answer createFromParcel(Parcel in) {
            return new Maska_Answer(in);
        }

        @Override
        public Maska_Answer[] newArray(int size) {
            return new Maska_Answer[size];
        }
    };
}
