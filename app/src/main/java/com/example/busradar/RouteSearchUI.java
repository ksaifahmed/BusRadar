package com.example.busradar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class RouteSearchUI extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_route_search_ui);

        //back button to home
        TextView back_btn = findViewById(R.id.route_search_back);
        back_btn.setOnClickListener(view -> go_back_home());

        final Button button = findViewById(R.id.route_search_button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText source = findViewById(R.id.sourceField);
                EditText destination = findViewById(R.id.destinationField);
                String src = source.getText().toString();
                String dst = destination.getText().toString();
                if( !src.equalsIgnoreCase("") && !dst.equalsIgnoreCase("") ) {
                    RouteSearchController.getRoutesSrcDst(src, dst);
                }
            }
        });

        final ImageView img = findViewById(R.id.show_buses_avail_btn);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText source = findViewById(R.id.sourceField);
                EditText destination = findViewById(R.id.destinationField);
                String src = source.getText().toString();
                String dst = destination.getText().toString();
                if( !src.equalsIgnoreCase("") && !dst.equalsIgnoreCase("") ) {
                    RouteSearchController.getBusesAvailable(RouteSearchController.getRoutesSrcDst(src, dst));

                }
            }
        });
    }

    //loads home again
    private void go_back_home() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}