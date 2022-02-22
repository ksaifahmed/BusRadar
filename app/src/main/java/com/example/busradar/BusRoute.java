package com.example.busradar;

import java.io.Serializable;
import java.util.ArrayList;

public class BusRoute implements Serializable {
    ArrayList<position> busStops = new ArrayList<>();
    double maxFare, minFare;

    public double getMaxFare() {
        return maxFare;
    }

    public void setMaxFare(double maxFare) {
        this.maxFare = maxFare;
    }

    public double getMinFare() {
        return minFare;
    }

    public void setMinFare(double minFare) {
        this.minFare = minFare;
    }

    void addBusStop(double latitude, double longitude) {
        busStops.add(new position(latitude, longitude));
    }

    void addBusStop(double latitude, double longitude, String name) {
        busStops.add(new position(latitude, longitude, name));
    }

    ArrayList<position> getBusStops() {
        return busStops;
    }
}

class position implements Serializable {
    double latitude, longitude;
    String name;

    public position(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.name = "";
    }

    public position(double latitude, double longitude, String name) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.name = name;
    }

    public String getName() { return name; }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }
}
