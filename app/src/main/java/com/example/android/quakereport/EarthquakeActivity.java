/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.quakereport;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class EarthquakeActivity extends AppCompatActivity {

    public static final String LOG_TAG = EarthquakeActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.earthquake_activity);
        TextView textView = findViewById(R.id.date);

        String strJson =
            "{\n" +
            "   \"sys\":\n" +
            "   {\n" +
            "      \"country\":\"GB\",\n" +
            "      \"sunrise\":1381107633,\n" +
            "      \"sunset\":1381149604\n" +
            "   },\n" +
            "   \"weather\":[\n" +
            "      {\n" +
            "         \"id\":711,\n" +
            "         \"main\":\"Smoke\",\n" +
            "         \"description\":\"smoke\",\n" +
            "         \"icon\":\"50n\"\n" +
            "      }\n" +
            "   ],\n" +
            "\t\n" +
            "  \"main\":\n" +
            "   {\n" +
            "      \"temp\":304.15,\n" +
            "      \"pressure\":1009,\n" +
            "   }\n" +
            "}";

        String data = "";

        try{
            JSONObject jsonRootObject = new JSONObject(strJson);
            Toast.makeText(getApplicationContext(), "NO", Toast.LENGTH_SHORT).show();

            JSONArray jsonArray = jsonRootObject.optJSONArray("weather");

            for (int i = 0; i < jsonArray.length(); i++)
            {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                int id = Integer.parseInt(jsonObject.optString("id"));
                String main = jsonObject.optString("main");
                String description = jsonObject.optString("description");
                String icon = jsonObject.optString("icon");

                data += "Node" + i + ": \n id= " + id + "\n main= " + main + "\n description= "
                        + description +"\n icon" + icon + " \n ";
                Toast.makeText(getApplicationContext(), data, Toast.LENGTH_SHORT).show();
            }
            textView.setText(data);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        ArrayList<Earthquake> earthquakes = QueryUtils.extractEarthquakes();

        // Create a fake list of earthquake locations.
//        ArrayList<Earthquake> earthquakes = new ArrayList<>();
//        earthquakes.add(new Earthquake("1.5", "San Francisco", "2015-02-06"));
//        earthquakes.add(new Earthquake("1.5", "London", "2015-02-06"));
//        earthquakes.add(new Earthquake("1.5", "Tokyo", "2015-02-06"));
//        earthquakes.add(new Earthquake("1.5", "Mexico City", "2015-02-06"));
//        earthquakes.add(new Earthquake("1.5", "Moscow", "2015-02-06"));
//        earthquakes.add(new Earthquake("1.5", "Rio de Janeiro", "2015-02-06"));
//        earthquakes.add(new Earthquake("1.5", "Paris", "2015-02-06"));
//
        // Find a reference to the {@link ListView} in the layout
        ListView earthquakeListView = findViewById(R.id.list);

        // Create a new {@link ArrayAdapter} of earthquakes
        EarthquakeAdapter adapter = new EarthquakeAdapter(
                this, earthquakes);
//
        // Set the adapter on the {@link ListView}
        // so the list can be populated in the user interface
        earthquakeListView.setAdapter(adapter);
    }
}
