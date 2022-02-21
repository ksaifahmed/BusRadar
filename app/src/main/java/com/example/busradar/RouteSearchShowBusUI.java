package com.example.busradar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;

public class RouteSearchShowBusUI extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_route_search_show_bus_ui);

        //back button to home
        TextView back_btn = findViewById(R.id.route_search_show_bus_back);
        back_btn.setOnClickListener(view -> go_back_home());

        //gridview init
        GridView grid = findViewById(R.id.route_show_bus_grid);
        ArrayList<Bus> busList = new ArrayList<>();

        //call to controller here:
        populateTrendingGrid(busList);

        //filling up the grid view using adapter
        RouteSearchShowBusUIAdapter gridAdapter;
        gridAdapter = new RouteSearchShowBusUIAdapter(this, R.layout.route_search_show_bus_grid_item, busList, this);
        grid.setAdapter(gridAdapter);
    }

    //call to controller here:
    private void populateTrendingGrid(ArrayList<Bus> busList) {
        busList.add(new Bus("bus_name1",R.drawable.square_img_id1));
        busList.add(new Bus("bus_name2",R.drawable.square_img_id2));
        busList.add(new Bus("bus_name3",R.drawable.square_img_id3));
    }

    //loads home again
    private void go_back_home() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    //go to Bus Info Page
    public void LoadBusInfoPage(CharSequence busName) {
        Intent intent = new Intent(this, BusInfoRouteUI.class);
        intent.putExtra("busName", busName); //pass data to new activity
        startActivity(intent);
    }
}