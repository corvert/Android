package com.example.adaptersapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //AdapterView: ListView
        listView = findViewById(R.id.listView);

        //Data source: String array
        String[] countries = {"USA", "Germany", "Estonia", "Latvia"};

       //Adapter: acts as a bridge between the 'data source' and the AdapterView
        MyCustomAdapter adapter = new MyCustomAdapter(
                this,
                countries
        );

        //link ListView with the Adapter
        listView.setAdapter(adapter);
    }
}