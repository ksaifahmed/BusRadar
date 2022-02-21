package com.example.busradar;


//HARD CODED MODEL BUS INFO
public class Bus {
    String busName;
    int imageID;

    public Bus(String busName,int imageID) {
        this.busName=busName;
        this.imageID=imageID;
    }
    public String getBusName()
    {
        return this.busName;
    }
    public int getImageID()
    {
        return this.imageID;
    }
}
