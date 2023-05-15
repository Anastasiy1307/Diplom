package com.example.diplom;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

public class Mask_specialties implements Parcelable {

    private int ID;
    private String Name_specialties;
    private String Code_specialties;





    protected Mask_specialties(Parcel in) {
        ID = in.readInt();
        Name_specialties = in.readString();
        Code_specialties = in.readString();

    }

    public Mask_specialties(int ID, String Name_specialties, String Code_specialties) {
        this.ID = ID;
        this.Name_specialties = Name_specialties;
        this.Code_specialties = Code_specialties;

    }

    public static final Parcelable.Creator<Mask_specialties> CREATOR = new Parcelable.Creator<Mask_specialties>() {
        @Override
        public Mask_specialties createFromParcel(Parcel in) {
            return new Mask_specialties(in);
        }

        @Override
        public Mask_specialties[] newArray(int size) {
            return new Mask_specialties[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(ID);
        dest.writeString(Name_specialties);
        dest.writeString(Code_specialties);
    }


    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName_specialties() {
        return Name_specialties;
    }

    public void setName_specialties(String name_specialties) {
        Name_specialties = name_specialties;
    }

    public String getCode_specialtires() {
        return Code_specialties;
    }

    public void setCode_specialtires(String code_specialtires) {
        Code_specialties = code_specialtires;
    }
}