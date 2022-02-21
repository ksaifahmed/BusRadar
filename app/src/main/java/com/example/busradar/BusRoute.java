package com.example.busradar;

import java.util.ArrayList;

public class BusRoute {
    ArrayList<position> busStops = new ArrayList<>();

    void addBusStop(int latitude, int longitude) {
        busStops.add(new position(latitude, longitude));
    }

    ArrayList<position> getBusStops() {
        return busStops;
    }
}

class position {
    int latitude, longitude;

    public position(int latitude, int longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public int getLatitude() {
        return latitude;
    }

    public int getLongitude() {
        return longitude;
    }
}
