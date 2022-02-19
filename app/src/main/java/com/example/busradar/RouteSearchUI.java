package com.example.busradar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class RouteSearchUI extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_route_search_ui);

        //back button to home
        TextView back_btn = findViewById(R.id.route_search_back);
        back_btn.setOnClickListener(view -> go_back_home());
    }

    //loads home again
    private void go_back_home() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}