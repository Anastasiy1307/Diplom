package com.example.diplom;

import android.os.Parcel;
import android.os.Parcelable;

public class Students implements Parcelable {
    private int ID;
    private int ID_specialties;
    private String Name_group;

    protected Students(Parcel in) {
        ID = in.readInt();
        ID_specialties = in.readInt();
        Name_group = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(ID);
        dest.writeInt(ID_specialties);
        dest.writeString(Name_group);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Students> CREATOR = new Creator<Students>() {
        @Override
        public Students createFromParcel(Parcel in) {
            return new Students(in);
        }

        @Override
        public Students[] newArray(int size) {
            return new Students[size];
        }
    };

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getID_specialties() {
        return ID_specialties;
    }

    public void setID_specialties(int ID_specialties) {
        this.ID_specialties = ID_specialties;
    }

    public String getName_group() {
        return Name_group;
    }

    public void setName_group(String name_group) {
        Name_group = name_group;
    }

    public Students(int ID, int ID_specialties, String Name_group ) {
        this.ID = ID;
        this.ID_specialties = ID_specialties;
        this.Name_group = Name_group;

    }
}
