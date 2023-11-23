package com.example.datepicker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DatePicker datePicker;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        datePicker = findViewById(R.id.datePicker);
        button = findViewById(R.id.btn);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String day = "Day " + datePicker.getDayOfMonth();
                String month = "Month " + (datePicker.getMonth()+1);
                String year = "Year " + datePicker.getYear();

                Toast.makeText(
                        MainActivity.this,
                        day + " " + month + " " + year,
                        Toast.LENGTH_LONG).show();
            }
        });
    }
}