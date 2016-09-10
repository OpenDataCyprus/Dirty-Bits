package com.dirtybits.spotted.Models;

import android.databinding.Bindable;
import android.media.Image;
import android.os.Parcel;

import com.dirtybits.spotted.BR;
import java.util.Date;

public class WantedPerson extends Person {

    private static int id = 0;

    private Date wantedDate;

    protected WantedPerson(Parcel in) {
        super(in);
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

    public void setWantedDate(Date wantedDate){
        this.wantedDate = wantedDate;
        notifyPropertyChanged(BR.missingDate);
    }

    @Bindable
    public Date getWantedDate(){
        return this.wantedDate;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(wantedDate.toString());
    }
}
