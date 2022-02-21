package com.example.busradar;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class RouteSearchController {
    public static BusRoute getRoutesSrcDst(String src, String dst) {
        BusRoute route = new BusRoute();
        try {
            Socket socket = new Socket("192.168.0.186", 6666);
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

            out.writeObject("srcdstquery");
            out.writeObject(src);
            out.writeObject(dst);

            String routeData = (String) in.readObject();

            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return route;
    }
    public static ArrayList<Bus> getBusesAvailable(BusRoute route) {
        ArrayList<Bus> buses = new ArrayList<>();
        try {
            Socket socket = new Socket("192.168.0.186", 6666);
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

            out.writeObject("routequery");
            out.writeObject("routedata");

            int count = (int) in.readObject();
            for( int i=0; i<count; i++ ) {
                String busName = (String) in.readObject();
                buses.add(new Bus(busName, R.drawable.square_img_id1));
            }

            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return buses;
    }
}
