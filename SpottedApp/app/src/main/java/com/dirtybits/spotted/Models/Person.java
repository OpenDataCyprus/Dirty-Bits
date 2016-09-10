package com.dirtybits.spotted.Models;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.graphics.Bitmap;
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
    private Bitmap photograph;
    private String description;
    private String photographNameString;

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

    public void setPhotograph(Bitmap photograph) {
        this.photograph = photograph;
        notifyPropertyChanged(BR.photograph);
    }

    @Bindable
    public Bitmap getPhotograph() {
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

    @Bindable
    public String getPhotographString() {
       return photographNameString;
    }

    public void setPhotographString(String photographString) {
        this.photographNameString = photographString;
        notifyPropertyChanged(BR.photographString);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.type == null ? -1 : this.type.ordinal());
        dest.writeString(this.personId);
        dest.writeString(this.fullName);
        dest.writeInt(this.timesSpotted);
        dest.writeParcelable(this.photograph, flags);
        dest.writeString(this.description);
    }

    public Person(Parcel in) {
        int tmpType = in.readInt();
        this.type = tmpType == -1 ? null : Type.values()[tmpType];
        this.personId = in.readString();
        this.fullName = in.readString();
        this.timesSpotted = in.readInt();
        this.photograph = in.readParcelable(Image.class.getClassLoader());
        this.description = in.readString();
        this.photographNameString = in.readString();
    }

}
