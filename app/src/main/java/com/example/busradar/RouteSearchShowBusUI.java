package com.example.busradar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;

public class RouteSearchShowBusUI extends AppCompatActivity {
    private String src="src", dst="dst";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_route_search_show_bus_ui);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            src = extras.getString("src");
            dst = extras.getString("dst");
        }

        //back button to home
        TextView back_btn = findViewById(R.id.route_search_show_bus_back);
        back_btn.setOnClickListener(view -> go_back_home());

        //gridview init
        GridView grid = findViewById(R.id.route_show_bus_grid);
        ArrayList<Bus> busList = RouteSearchController.getBusesAvailable(src, dst);

        //filling up the grid view using adapter
        RouteSearchShowBusUIAdapter gridAdapter;
        gridAdapter = new RouteSearchShowBusUIAdapter(this, R.layout.route_search_show_bus_grid_item, busList, this);
        grid.setAdapter(gridAdapter);

        TextView srcdst = findViewById(R.id.src_dst);
        srcdst.setText(src + " to " + dst);

        Button b = findViewById(R.id.btn);
        b.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        BusRoute route = RouteSearchController.getRoutesSrcDst(src, dst);
                        Intent intent = new Intent(getApplicationContext(), MapActivity.class);
                        Bundle args = new Bundle();
                        args.putSerializable("route",(Serializable)route);
                        intent.putExtra("BUNDLE",args);
                        startActivity(intent);
                    }
                }
        );
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