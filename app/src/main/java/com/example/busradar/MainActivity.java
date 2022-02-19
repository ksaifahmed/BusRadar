package com.example.busradar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Choose Bus Button
        ImageButton choose_bus_btn = findViewById(R.id.choose_bus_btn);
        choose_bus_btn.setOnClickListener(view -> load_bus_search());

        //Choose Route Button
        ImageButton choose_route_btn = findViewById(R.id.choose_route_btn);
        choose_route_btn.setOnClickListener(view -> load_route_search());
    }

    //changes to RouteSearchUI activity
    private void load_route_search() {
        Intent intent = new Intent(this, RouteSearchUI.class);
        startActivity(intent);
    }

    //changes to BusSearchUI activity
    private void load_bus_search() {
        Intent intent = new Intent(this, BusSearchUI.class);
        startActivity(intent);
    }
}