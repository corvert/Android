package com.example.marketapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements  ItemClickListener {
    //1 adapterView
    RecyclerView recyclerView;
    //2 data source
    List<Item> itemList;
    //3 adapter
    MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        itemList = new ArrayList<>();

        Item fruit = new Item(R.drawable.fruit, "Fruits", "Fresh fruits");
        Item vegetables = new Item(R.drawable.vegitables, "Vegetables", "Delicious vegetables");
        Item bakery = new Item(R.drawable.bread, "Bakery", "Bread, Wheat and Beans");
        Item beverage = new Item(R.drawable.beverage, "Beverage", "Juice, Tea coffee and soda");
        Item milk = new Item(R.drawable.milk, "Milk", "Milk, shakes and yogurt");
        Item snacks = new Item(R.drawable.popcorn, "Snacks", "Popcorn, donut and drinks");
        itemList.add(fruit);
        itemList.add(vegetables);
        itemList.add(bakery);
        itemList.add(beverage);
        itemList.add(milk);
        itemList.add(snacks);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        myAdapter = new MyAdapter(itemList);
        recyclerView.setAdapter(myAdapter);

        myAdapter.setClickListener(this);

    }

    @Override
    public void onClick(View v, int pos) {
        Toast.makeText(this,
                "You choose " + itemList.get(pos).getItemName(),
                Toast.LENGTH_SHORT).show();

    }
}