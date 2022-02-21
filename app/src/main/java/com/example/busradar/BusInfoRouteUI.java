package com.example.busradar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class BusInfoRouteUI extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus_info_route_ui);

        //get data from previous activity
        CharSequence busName = "bus_name";
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            busName = extras.getString("busName");
        }

        //set bus name
        TextView busNameText = findViewById(R.id.bus_info_name);
        busNameText.setText(busName);

        double rating = BusInfoController.getRating(busName.toString());
        ArrayList<Review> reviews = BusInfoController.getReviews(busName.toString());
    }
}