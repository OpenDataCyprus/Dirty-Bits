package com.dirtybits.spotted.Models;

import android.databinding.Bindable;
import android.media.Image;
import android.os.Parcel;
import android.os.Parcelable;

import com.dirtybits.spotted.BR;
import java.util.Date;

public class MissingPerson extends Person implements Parcelable{

    private static int id = 0;

    private Date missingDate;

    public MissingPerson(String fullName, String description, Image photograph, int timesSpotted, Date missingDate)
    {
        super(fullName, description, photograph, timesSpotted);
        this.setPersonId(Integer.toString(++id));
        this.setType(Type.MissingPerson);
        this.missingDate = missingDate;
    }


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

    public MissingPerson(String fullName, String description, Image photograph, int timesSpotted) {
        super(fullName, description, photograph, timesSpotted);
    }

    public MissingPerson(Parcel in) {
        super(in);
    }

    public void setMissingDate(Date missingDate){
        this.missingDate = missingDate;
        notifyPropertyChanged(BR.missingDate);
    }

    @Bindable
    public Date getMissingDate(){
        return this.missingDate;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    dest.writeString(missingDate.toString());
    }
}
