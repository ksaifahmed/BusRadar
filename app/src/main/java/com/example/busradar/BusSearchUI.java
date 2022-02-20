package com.example.busradar;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class BusSearchUI extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus_search_ui);

        //back button to home
        TextView back_btn = findViewById(R.id.bus_search_back);
        back_btn.setOnClickListener(view -> go_back_home());

        //gridview init
        GridView grid = findViewById(R.id.trending_grid);
        ArrayList<Bus> busList = new ArrayList<>();

        //call to controller here:
        populateTrendingGrid(busList);

        //filling up the grid view using adapter
        BusSearchUIAdapter gridAdapter;
        gridAdapter =new BusSearchUIAdapter(this, R.layout.bus_search_grid_item, busList, this);
        grid.setAdapter(gridAdapter);
    }


    //call to controller here:
    private void populateTrendingGrid(ArrayList<Bus> busList) {
        busList.add(new Bus("bus_name1",R.drawable.square_img_id1));
        busList.add(new Bus("bus_name2",R.drawable.square_img_id2));
        busList.add(new Bus("bus_name3",R.drawable.square_img_id3));

        busList.add(new Bus("bus_name",R.drawable.square_img_id1));
        busList.add(new Bus("bus_name",R.drawable.square_img_id1));
        busList.add(new Bus("bus_name",R.drawable.square_img_id1));

        busList.add(new Bus("bus_name",R.drawable.square_img_id1));
        busList.add(new Bus("bus_name",R.drawable.square_img_id2));
        busList.add(new Bus("bus_name",R.drawable.square_img_id3));
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


