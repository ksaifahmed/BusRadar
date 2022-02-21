package com.example.busradar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;

public class BusInfoReviewUI extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus_info_review_ui);

        //KSA
        TextView routeBtn = findViewById(R.id.route_button);
        routeBtn.setOnClickListener(view -> LoadRouteView());

        //set rating stars
        RatingBar mRatingBar = findViewById(R.id.ratingBar);
        mRatingBar.setRating(3);

        //set rate text
        TextView rateText = findViewById(R.id.bus_info_rate_text);
        rateText.setText("Rating: 4.5/5");

        //set first review
        TextView reviewer1 = findViewById(R.id.bus_info_rev_1_name);
        reviewer1.setText("Takbir");
        TextView review1 = findViewById(R.id.bus_info_rev_1_content);
        review1.setText("Bhalo Service");

        //set second review
        TextView reviewer2 = findViewById(R.id.bus_info_rev_2_name);
        reviewer1.setText("Saif");
        TextView review2 = findViewById(R.id.bus_info_rev_2_content);
        review1.setText("Great Trip Experience");

    }

    //switch to routeView - KSA
    private void LoadRouteView() {
        Intent intent = new Intent(this, BusInfoRouteUI.class);
        startActivity(intent);
    }
}