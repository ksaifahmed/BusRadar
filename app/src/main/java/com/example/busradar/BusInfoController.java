package com.example.busradar;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class BusInfoController {
    public static double getRating(String name) {
        double rating=0;
        try {
            Socket socket = new Socket("192.168.0.186", 6666);
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

            out.writeObject("ratingquery");
            out.writeObject(name);
            rating = (double) in.readObject();

            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rating;
    }
    public static ArrayList<Review> getReviews(String name) {
        ArrayList<Review> reviews = new ArrayList<>();
        try {
            Socket socket = new Socket("192.168.0.186", 6666);
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

            out.writeObject("reviewquery");
            out.writeObject(name);
            int count = (int) in.readObject();
            for( int i=0; i<count; i++ ) {
                int companyID, reviewID, busNo, rating;
                String comment;
                companyID = (int) in.readObject();
                reviewID = (int) in.readObject();
                busNo = (int) in.readObject();
                rating = (int) in.readObject();
                comment = (String) in.readObject();
                reviews.add( new Review(companyID, reviewID, busNo, rating, comment) );
            }
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return reviews;
    }
}
