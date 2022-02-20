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

public class BusSearchUIAdapter extends ArrayAdapter {
    BusSearchUI parentActivity;
    ArrayList<Bus> busList = new ArrayList<>();

    public BusSearchUIAdapter(Context context, int textViewResourceId, ArrayList<Bus> objects, BusSearchUI parentActivity) {
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
        v = inflater.inflate(R.layout.bus_search_grid_item, null);
        TextView textView = (TextView) v.findViewById(R.id.bus_search_item_text);
        ImageView imageView = (ImageView) v.findViewById(R.id.bus_search_item_img);
        textView.setText(busList.get(position).getBusName());
        imageView.setImageResource(busList.get(position).getImageID());


        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                parentActivity.LoadBusInfoPage(textView.getText());
            }
        });
        return v;

    }
}
