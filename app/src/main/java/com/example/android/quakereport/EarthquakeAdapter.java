package com.example.android.quakereport;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class EarthquakeAdapter extends ArrayAdapter {

    /**
     * This is our own custom constructor (it doesn't mirror a superclass constructor).
     * The context is used to inflate the layout file, and the list is the data we want
     * to populate into the lists.
     *
     * @param context        The current context. Used to inflate the layout file.
     * @param earthquakes A List of Earthquake objects to display in a list
     */
    public EarthquakeAdapter(Context context, ArrayList<Earthquake> earthquakes) {
        super(context, 0, earthquakes);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.earthquake_list_item, parent, false);
        }

        Earthquake curEarthquake = (Earthquake) getItem(position);

        TextView mag = listItemView.findViewById(R.id.mag);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        mag.setText(curEarthquake.getMag());

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView place = listItemView.findViewById(R.id.place);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        place.setText(curEarthquake.getPlace());
        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView date = listItemView.findViewById(R.id.date);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        date.setText(curEarthquake.getDate());
        return listItemView;
    }
}
