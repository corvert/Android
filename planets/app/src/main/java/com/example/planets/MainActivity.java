package com.example.planets;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<Planet> planetsArrayList;
    private static MyCustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //1 - AdapterView: a ListView
        listView = findViewById(R.id.listview);

        //2 - Data Source: ArrayList<Planet>
        planetsArrayList = new ArrayList<>();

        Planet earth = new Planet("Earth", "1", R.drawable.earth);
        Planet mercury = new Planet("Mercury", "0", R.drawable.mercury);
        Planet venus = new Planet("Venus", "0", R.drawable.venus);
        Planet mars = new Planet("Mars", "2", R.drawable.mars);
        Planet jupiter = new Planet("Jupiter", "79", R.drawable.jupiter);
        Planet saturn = new Planet("saturn", "83", R.drawable.saturn);
        Planet uranus = new Planet("Uranus", "27", R.drawable.uranus);
        Planet neptune = new Planet("Neptune", "14", R.drawable.neptune);

        planetsArrayList.add(earth);
        planetsArrayList.add(mercury);
        planetsArrayList.add(venus);
        planetsArrayList.add(mars);
        planetsArrayList.add(jupiter);
        planetsArrayList.add(saturn);
        planetsArrayList.add(uranus);
        planetsArrayList.add(neptune);


        //adapter
        adapter = new MyCustomAdapter(planetsArrayList, getApplicationContext());
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Toast.makeText(MainActivity.this,
                        "Planet name: " + adapter.getItem(position).getPlanetName(),
                        Toast.LENGTH_SHORT).show();
            }
        });

    }
}