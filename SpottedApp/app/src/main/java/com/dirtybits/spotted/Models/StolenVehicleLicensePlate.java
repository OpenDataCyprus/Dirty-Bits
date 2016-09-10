package com.dirtybits.spotted.Models;

import android.databinding.Bindable;
import com.dirtybits.spotted.BR;
import java.util.Date;

public class StolenVehicleLicensePlate extends Vehicle{

    private static int id = 0;

    private String districtStolenFrom;
    private String stolenVehicleLicensePlateId;

    public StolenVehicleLicensePlate(String brand, String color, Date theftDate, String engineNumber,
                              String chassisNumber, String licensePlateNumber, int timesSpotted, String districtStolenFrom)
    {
        super(brand, color, theftDate, engineNumber, chassisNumber, licensePlateNumber, timesSpotted);
        this.setType(Type.StolenVehicleLicensePlate);
        this.districtStolenFrom = districtStolenFrom;
        this.stolenVehicleLicensePlateId = Integer.toString(++id);
    }

    public String getStolenVehicleLicensePlateId(){
        return this.stolenVehicleLicensePlateId;
    }

    @Bindable
    public String getDistrictStolenFrom(){
        return this.districtStolenFrom;
    }

    public void setType(String districtStolenFrom){
        this.districtStolenFrom = districtStolenFrom;
        notifyPropertyChanged(BR.districtStolenFrom);
    }
}
