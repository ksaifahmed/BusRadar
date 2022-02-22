package com.example.busradar;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class BusSearchController {
    public static ArrayList<Bus> queryBusByName(String name) {
        ArrayList<Bus> relevantBuses = new ArrayList<>();
        try {
            Socket socket = new Socket("192.168.0.186", 6666);
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

            out.writeObject("namequery");
            out.writeObject(name);

            int count = (int) in.readObject();
            for( int i=0; i<count; i++ ) {
                String busName = (String) in.readObject();
                relevantBuses.add(new Bus(busName, R.drawable.square_img_id1));
            }
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return relevantBuses;
    }
    public static ArrayList<Bus> getTrendingSearches() {
        ArrayList<Bus> trendingBuses = new ArrayList<>();
        try {
            Socket socket = new Socket("192.168.0.186", 6666);
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

            out.writeObject("trending");
            int count = (int) in.readObject();
            for( int i=0; i<count; i++ ) {
                String busName = (String) in.readObject();
                for(int j=0; j<100; j++ ) System.out.println(busName + " HERE");
                trendingBuses.add(new Bus(busName, R.drawable.square_img_id1));
            }
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return trendingBuses;
    }
    public static double getRating(String name) {
        return 0;
    }
}
