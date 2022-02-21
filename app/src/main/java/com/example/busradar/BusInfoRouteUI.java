package com.example.busradar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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

        //KSA
        TextView reviewBtn = findViewById(R.id.review_btn);
        reviewBtn.setOnClickListener(view -> LoadReviewView());

        TextView bus_fare_Text = findViewById(R.id.bus_info_fare);
        bus_fare_Text.setText("10bucks");
    }

    //switch to reviewView - KSA
    private void LoadReviewView() {
        Intent intent = new Intent(this, BusInfoReviewUI.class);
        startActivity(intent);
    }
}