package com.dirtybits.spotted.Models;

import android.databinding.Bindable;
import android.os.Parcel;
import android.os.Parcelable;

import com.dirtybits.spotted.BR;

public class MissingPerson extends Person implements Parcelable{

    private static int id = 0;

    private String missingDate;

    public static final Creator<MissingPerson> CREATOR = new Creator<MissingPerson>() {
        @Override
        public MissingPerson createFromParcel(Parcel in) {
            return new MissingPerson(in);
        }

        @Override
        public MissingPerson[] newArray(int size) {
            return new MissingPerson[size];
        }
    };


    public MissingPerson(Parcel in) {
        super(in);
    }

    public void setMissingDate(String missingDate){
        this.missingDate = missingDate;
        notifyPropertyChanged(BR.missingDate);
    }

    @Bindable
    public String getMissingDate(){
        return String.format("Missing since %s", this.missingDate);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    dest.writeString("");
    }
}
