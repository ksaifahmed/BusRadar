package com.example.busradar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;

public class BusInfoRouteUI extends AppCompatActivity {
    private CharSequence busName;

    private void go_back_home() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus_info_route_ui);

        //back button to home
        TextView back_btn = findViewById(R.id.bus_info_route_back);
        back_btn.setOnClickListener(view -> go_back_home());

        //get data from previous activity
        busName = "bus_name";
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

        Button b = findViewById(R.id.btn);
        b.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        BusRoute route = BusInfoController.getRoute(busName.toString());
                        Intent intent = new Intent(getApplicationContext(), MapActivity.class);
                        Bundle args = new Bundle();
                        args.putSerializable("route",(Serializable)route);
                        intent.putExtra("BUNDLE",args);
                        startActivity(intent);
                    }
                }
        );

        ImageView imgView = findViewById(R.id.map_guidance_btn);
        imgView.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        BusRoute route = BusInfoController.getRoute(busName.toString());
                        Intent intent = new Intent(getApplicationContext(), MapActivity.class);
                        Bundle args = new Bundle();
                        args.putSerializable("route",(Serializable)route);
                        intent.putExtra("BUNDLE",args);
                        startActivity(intent);
                    }
                }
        );
    }

    //switch to reviewView - KSA
    private void LoadReviewView() {
        Intent intent = new Intent(this, BusInfoReviewUI.class);
        intent.putExtra("busName", busName.toString()); //pass data to new activity
        startActivity(intent);
    }
}