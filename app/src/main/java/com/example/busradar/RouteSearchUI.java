package com.example.busradar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

public class RouteSearchUI extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_route_search_ui);

        //back button to home
        TextView back_btn = findViewById(R.id.route_search_back);
        back_btn.setOnClickListener(view -> go_back_home());

        final ImageView img = findViewById(R.id.show_buses_avail_btn);
        img.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText source = findViewById(R.id.sourceField);
                EditText destination = findViewById(R.id.destinationField);
                String src = source.getText().toString();
                String dst = destination.getText().toString();
                if( !src.equalsIgnoreCase("") && !dst.equalsIgnoreCase("") ) {
                    BusRoute route = RouteSearchController.getRoutesSrcDst(src, dst);
                    if( route.getBusStops().size()==0 ) {
                        Toast.makeText(getApplicationContext(), "Unknown Source/Destination", Toast.LENGTH_LONG).show();
                    }
                    else loadRouteSearchShowBusUI(src, dst);
                }
                else {
                    Toast.makeText(getApplicationContext(), "Empty Source/Destination", Toast.LENGTH_LONG).show();
                }
            }
        });

        Button b = findViewById(R.id.btn);
        b.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        EditText source = findViewById(R.id.sourceField);
                        EditText destination = findViewById(R.id.destinationField);
                        String src = source.getText().toString();
                        String dst = destination.getText().toString();
                        if( !src.equalsIgnoreCase("") && !dst.equalsIgnoreCase("") ) {
                            BusRoute route = RouteSearchController.getRoutesSrcDst(src, dst);
                            if( route.getBusStops().size()==0 ) {
                                Toast.makeText(getApplicationContext(), "Unknown Source/Destination", Toast.LENGTH_LONG).show();
                            }
                            else {
                                Intent intent = new Intent(getApplicationContext(), MapActivity.class);
                                Bundle args = new Bundle();
                                args.putSerializable("route",(Serializable)route);
                                intent.putExtra("BUNDLE",args);
                                startActivity(intent);
                            }
                        }
                        else {
                            Toast.makeText(getApplicationContext(), "Empty Source/Destination", Toast.LENGTH_LONG).show();
                        }
                    }
                }
        );
    }

    private void loadRouteSearchShowBusUI(String src, String dst) {
        Intent intent = new Intent(this, RouteSearchShowBusUI.class);
        intent.putExtra("src", src);
        intent.putExtra("dst", dst);
        startActivity(intent);
    }

    //loads home again
    private void go_back_home() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}