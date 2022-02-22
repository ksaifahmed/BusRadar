package com.example.busradar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;

public class BusInfoReviewUI extends AppCompatActivity {
    private String busName;

    private void go_back_home() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus_info_review_ui);

        //back button to home
        TextView back_btn = findViewById(R.id.bus_info_rev_back);
        back_btn.setOnClickListener(view -> go_back_home());

        busName = "busName";
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            busName = extras.getString("busName");
        }

        TextView busNameText = findViewById(R.id.bus_info_name);
        busNameText.setText(busName);

        //KSA
        TextView routeBtn = findViewById(R.id.route_button);
        routeBtn.setOnClickListener(view -> LoadRouteView());

        //set rating stars
        float rating = (float) (Math.round(BusInfoController.getRating(busName) * 100.0) / 100.0);
        RatingBar mRatingBar = findViewById(R.id.ratingBar);
        mRatingBar.setRating(rating);

        //set rate text
        TextView rateText = findViewById(R.id.bus_info_rate_text);
        rateText.setText("Rating: "+Double.toString(rating)+"/5.0");

        ArrayList<Review> reviews = BusInfoController.getReviews(busName);

        if( reviews.size()==0 ) {
            TextView reviewer1 = findViewById(R.id.bus_info_rev_1_name);
            reviewer1.setText("");
            TextView review1 = findViewById(R.id.bus_info_rev_1_content);
            review1.setText("");

            TextView reviewer2 = findViewById(R.id.bus_info_rev_2_name);
            reviewer2.setText("");
            TextView review2 = findViewById(R.id.bus_info_rev_2_content);
            review2.setText("");
        }
        else if( reviews.size()==1 ) {
            TextView reviewer1 = findViewById(R.id.bus_info_rev_1_name);
            reviewer1.setText(reviews.get(0).getCustomer());
            TextView review1 = findViewById(R.id.bus_info_rev_1_content);
            review1.setText(reviews.get(0).getComment());

            TextView reviewer2 = findViewById(R.id.bus_info_rev_2_name);
            reviewer2.setText("");
            TextView review2 = findViewById(R.id.bus_info_rev_2_content);
            review2.setText("");
        }
        else if( reviews.size()>=2 ) {
            TextView reviewer1 = findViewById(R.id.bus_info_rev_1_name);
            reviewer1.setText(reviews.get(0).getCustomer());
            TextView review1 = findViewById(R.id.bus_info_rev_1_content);
            review1.setText(reviews.get(0).getComment());

            TextView reviewer2 = findViewById(R.id.bus_info_rev_2_name);
            reviewer2.setText(reviews.get(1).getCustomer());
            TextView review2 = findViewById(R.id.bus_info_rev_2_content);
            review2.setText(reviews.get(1).getComment());
        }
    }

    //switch to routeView - KSA
    private void LoadRouteView() {
        Intent intent = new Intent(this, BusInfoRouteUI.class);
        intent.putExtra("busName", busName);
        startActivity(intent);
    }
}