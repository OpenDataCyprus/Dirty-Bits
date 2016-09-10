package com.dirtybits.spotted.Models;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Parcel;
import android.os.Parcelable;

import com.dirtybits.spotted.BR;

public class Person extends BaseObservable implements Parcelable {

    private static int id = 0;

    private Type type;
    private String personId;
    private String fullName;
    private int timesSpotted;
    private Image photograph;
    private String description;
    private Drawable photographString;

    public Person(String fullName, String description, Image photograph, int timesSpotted) {
        this.personId = Integer.toString(++id);
        this.fullName = fullName;
        this.description = description;
        this.photograph = photograph;
        this.timesSpotted = timesSpotted;

    }

    protected Person(Parcel in) {
        personId = in.readString();
        fullName = in.readString();
        timesSpotted = in.readInt();
        description = in.readString();
    }

    public static final Creator<Person> CREATOR = new Creator<Person>() {
        @Override
        public Person createFromParcel(Parcel in) {
            return new Person(in);
        }

        @Override
        public Person[] newArray(int size) {
            return new Person[size];
        }
    };

    public void setFullName(String fullName) {
        this.fullName = fullName;
        notifyPropertyChanged(BR.fullName);
    }

    protected void setPersonId(String personId) {
        this.personId = personId;
    }

    @Bindable
    public String getFullName() {
        return this.fullName;
    }

    public void setDescription(String description) {
        this.description = description;
        notifyPropertyChanged(BR.description);
    }

    @Bindable
    public String getDescription() {
        return this.description;
    }

    public void setPhotograph(Image photograph) {
        this.photograph = photograph;
        notifyPropertyChanged(BR.photograph);
    }

    @Bindable
    public Image getPhotograph() {
        return this.photograph;
    }

    public void setType(Type type) {
        this.type = type;
        notifyPropertyChanged(BR.type);
    }

    @Bindable
    public Type getType() {
        return this.type;
    }

    public void setTimesSpotted(int timesSpotted) {
        this.timesSpotted = timesSpotted;
        notifyPropertyChanged(BR.timesSpotted);
    }

    @Bindable
    public int getTimesSpotted() {
        return this.timesSpotted;
    }

    public String getPersonId() {
        return this.personId;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Bindable
    public Drawable getPhotographString() {
        return photographString;
    }

    public void setPhotographString(Drawable photographString) {
        this.photographString = photographString;
        notifyPropertyChanged(BR.photographString);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(personId);
        dest.writeString(fullName);
        dest.writeInt(timesSpotted);
        dest.writeString(description);
        dest.writeString(photographString.toString());
    }
}
