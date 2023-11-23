package com.example.checkbox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    CheckBox checkBox;
    RadioGroup radioGroup;
    Spinner spinner;

    TimePicker timePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkBox = findViewById(R.id.checkbox);

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b == true){
                    Toast.makeText(MainActivity.this,
                            "Checkbox is checked",
                            Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(MainActivity.this,
                            "Checkbox is EMPTY",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        radioGroup = findViewById(R.id.radioGroup);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioButton radioButton = findViewById(i);

                Toast.makeText(MainActivity.this,
                        "You select " + radioButton.getText().toString(),
                        Toast.LENGTH_SHORT).show();
            }
        });

        //view
        spinner = findViewById(R.id.spinner);
        //Data Source
        String[] courses = {"C++", "Java", "Kotlin", "Python"};
        //ArrayAdapter: used to populate the 'Spinner' with items from a string array resourse
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                courses
        );
        //Apply the adapter to the spinner
        spinner.setAdapter(arrayAdapter);


    }
}