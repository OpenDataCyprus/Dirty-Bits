package com.dirtybits.spotted.Models;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.dirtybits.spotted.BR;

import java.util.Date;

public class Vehicle extends BaseObservable{

    private Type type;
    private String brand;
    private String color;
    private Date theftDate;
    private int timesSpotted;
    private String engineNumber;
    private String chassisNumber;
    private String licensePlateNumber;

    public Vehicle(String brand, String color, Date theftDate, String engineNumber,
                   String chassisNumber, String licensePlateNumber, int timesSpotted)
    {
        this.brand = brand;
        this.color = color;
        this.theftDate = theftDate;
        this.engineNumber = engineNumber;
        this.chassisNumber = chassisNumber;
        this.licensePlateNumber = licensePlateNumber;
        this.timesSpotted = timesSpotted;
    }

    @Bindable
    public String getBrand() {
        return this.brand;
    }

    @Bindable
    public String getColor() {
        return this.color;
    }

    @Bindable
    public Date getTheftDate() {
        return this.theftDate;
    }

    @Bindable
    public String getEngineNumber() {
        return this.engineNumber;
    }

    @Bindable
    public String getChassisNumber() {
        return this.chassisNumber;
    }

    @Bindable
    public String getLicensePlateNumber() {
        return this.licensePlateNumber;
    }

    @Bindable
    public int getTimesSpotted() {
        return this.timesSpotted;
    }

    @Bindable
    public Type getType(){
        return this.type;
    }

    public void setType(Type type){
        this.type = type;
        notifyPropertyChanged(BR.type);
    }

    public void setBrand(String brand) {
        this.brand = brand;
        notifyPropertyChanged(BR.brand);
    }

    public void setColor(String color) {
        this.color = color;
        notifyPropertyChanged(BR.color);
    }

    public void setTheftDate(Date theftDate) {
        this.theftDate = theftDate;
        notifyPropertyChanged(BR.theftDate);
    }

    public void setTimesSpotted(int timesSpotted) {
        this.timesSpotted = timesSpotted;
        notifyPropertyChanged(BR.timesSpotted);
    }

    public void setEngineNumber(String engineNumber) {
        this.engineNumber = engineNumber;
        notifyPropertyChanged(BR.engineNumber);
    }

    public void setChassisNumber(String chassisNumber) {
        this.chassisNumber = chassisNumber;
        notifyPropertyChanged(BR.chassisNumber);
    }

    public void setLicensePlateNumber(String licensePlateNumber) {
        this.licensePlateNumber = licensePlateNumber;
        notifyPropertyChanged(BR.licensePlateNumber);
    }

}
