package com.dirtybits.spotted.Models;

import android.databinding.Bindable;
import android.media.Image;
import com.dirtybits.spotted.BR;
import java.util.Date;

public class WantedPerson extends Person {

    private static int id = 0;

    private Date wantedDate;

    public WantedPerson(String fullName, String description, Image photograph, int timesSpotted, Date wantedDate)
    {
        super(fullName, description, photograph, timesSpotted);
        this.setPersonId(Integer.toString(++id));
        this.setType(Type.WantedPerson);
        this.wantedDate = wantedDate;
    }

    public void setWantedDate(Date wantedDate){
        this.wantedDate = wantedDate;
        notifyPropertyChanged(BR.missingDate);
    }

    @Bindable
    public Date getWantedDate(){
        return this.wantedDate;
    }
}
