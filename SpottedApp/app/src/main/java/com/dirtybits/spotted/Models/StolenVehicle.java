package com.dirtybits.spotted.Models;

import java.util.Date;

public class StolenVehicle extends Vehicle {

    private static int id = 0;

    private String stolenVehicleId;

    public StolenVehicle(String brand, String color, Date theftDate, String engineNumber,
                   String chassisNumber, String licensePlateNumber, int timesSpotted)
    {
        super(brand, color, theftDate, engineNumber, chassisNumber, licensePlateNumber, timesSpotted);
        this.setType(Type.StolenVehicle);
        this.stolenVehicleId = Integer.toString(++id);
    }

    public String getstolenVehicleId(){
        return this.stolenVehicleId;
    }
}
