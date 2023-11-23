package com.example.sportsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ItemClickListener {
    private RecyclerView recyclerView;
    private List<Sport> sportList;
    private MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        sportList = new ArrayList<>();

        Sport football = new Sport("Football", R.drawable.football);
        Sport basketBall = new Sport("Basketball", R.drawable.basketball);
        Sport volleyBall = new Sport("Volleyball", R.drawable.volley);
        Sport tennis = new Sport("Tennis", R.drawable.tennis);
        Sport pingPong = new Sport("Ping pong", R.drawable.ping);
        sportList.add(football);
        sportList.add(basketBall);
        sportList.add(volleyBall);
        sportList.add(tennis);
        sportList.add(pingPong);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        myAdapter = new MyAdapter(sportList);


        recyclerView.setAdapter(myAdapter);

        myAdapter.setClickListener(this);
    }

    @Override
    public void onClick(View v, int pos) {
        Toast.makeText(this,
                "You choose " + sportList.get(pos).sportName,
                Toast.LENGTH_LONG).show();
    }
}