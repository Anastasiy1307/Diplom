package com.example.diplom;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

public class maska_group implements Parcelable {

    private int ID;
    private int Id_specialties;
    private String Name_group;





    protected maska_group(Parcel in) {
        ID = in.readInt();
        Id_specialties = in.readInt();
        Name_group = in.readString();

    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getId_specialties() {
        return Id_specialties;
    }

    public void setId_specialties(int id_specialties) {
        Id_specialties = id_specialties;
    }

    public String getName_group() {
        return Name_group;
    }

    public void setName_group(String name_group) {
        Name_group = name_group;
    }

    public maska_group(int ID, int Id_specialties, String Name_group) {
        this.ID = ID;
        this.Id_specialties = Id_specialties;
        this.Name_group = Name_group;

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
        dest.writeInt(Id_specialties);
        dest.writeString(Name_group);
    }



}