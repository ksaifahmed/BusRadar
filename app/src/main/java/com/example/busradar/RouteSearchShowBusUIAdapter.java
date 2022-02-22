package com.example.busradar;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.ArrayList;

public class RouteSearchShowBusUIAdapter extends ArrayAdapter {
    RouteSearchShowBusUI parentActivity;
    ArrayList<Bus> busList = new ArrayList<>();

    public RouteSearchShowBusUIAdapter(Context context, int textViewResourceId, ArrayList<Bus> objects, RouteSearchShowBusUI parentActivity) {
        super(context, textViewResourceId, objects);
        busList = objects;
        this.parentActivity = parentActivity;
    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v = inflater.inflate(R.layout.route_search_show_bus_grid_item, null);
        TextView busName = (TextView) v.findViewById(R.id.avail_bus_1_name);
        TextView busFare = (TextView) v.findViewById(R.id.avail_bus_1_fare);
        TextView busRating = (TextView) v.findViewById(R.id.avail_bus_1_rating);
        ImageView busImage = (ImageView) v.findViewById(R.id.avail_bus_1_img);
        busName.setText(busList.get(position).getBusName());
        busFare.setText("Fare: "+Double.toString(busList.get(position).getFare()));
        busRating.setText("Rating: "+Double.toString(busList.get(position).getRating()));
        busImage.setImageResource(busList.get(position).getImageID());


        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                parentActivity.LoadBusInfoPage(busName.getText());
            }
        });
        return v;

    }
}
