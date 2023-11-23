package com.example.layouts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToSecondActivity();
            }
        });
        Button btn2 = findViewById(R.id.btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               openWebPage();
            }
        });
    }

    public void goToSecondActivity(){
        Intent intent = new Intent(this, SecondAcivity.class);
        startActivity(intent);
    }

    public void openWebPage(){
        Uri webPage = Uri.parse("https://www.google.com");

        Intent intent = new Intent(Intent.ACTION_VIEW, webPage);
        startActivity(intent);
    }
}
