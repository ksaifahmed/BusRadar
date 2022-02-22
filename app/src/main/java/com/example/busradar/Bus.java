package com.example.busradar;


//HARD CODED MODEL BUS INFO
public class Bus {
    String busName;
    int imageID;
    double fare;
    double rating;

    public Bus(String busName,int imageID) {
        this.busName=busName;
        this.imageID=imageID;
    }

    public Bus(String busName, int imageID, double fare, double rating) {
        this.busName=busName;
        this.imageID=imageID;
        this.fare = fare;
        this.rating = rating;
    }

    public Bus(String busName,int imageID, double fare) {
        this.busName=busName;
        this.imageID=imageID;
        this.fare = fare;
    }

    public double getFare() {
        return fare;
    }
    public double getRating() { return rating; }

    public String getBusName()
    {
        return this.busName;
    }
    public int getImageID()
    {
        return this.imageID;
    }
}
