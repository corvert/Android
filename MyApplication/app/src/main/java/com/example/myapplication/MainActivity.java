package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.mlkit.common.model.DownloadConditions;
import com.google.mlkit.nl.translate.TranslateLanguage;
import com.google.mlkit.nl.translate.Translation;
import com.google.mlkit.nl.translate.Translator;
import com.google.mlkit.nl.translate.TranslatorOptions;

public class MainActivity extends AppCompatActivity {

    private Spinner fromSpinner, toSpinner;
    private EditText sourceEdt;
    private Button btn;
    private TextView translatedTV;

    //Source Array of Strings - Spinners Data
    String[] fromLanguages = {
            "from", "English", "Afrikaans","Estonian", "Arabic", "Belarus", "Bengali", "Vatalan", "Hindi"
    };
    String[] toLanguages = {
            "to", "English", "Afrikaans","Estonian", "Arabic", "Belarus", "Bengali", "Vatalan", "Hindi"
    };

//Permissions
    private static final int REQUEST_CODE = 1;
    String languageCode, fromLanguageCode, toLanguageCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fromSpinner = findViewById(R.id.idFromSpinner);
        toSpinner = findViewById(R.id.idToSpinner);
        sourceEdt = findViewById(R.id.idEdtSource);
        btn = findViewById(R.id.button);
        translatedTV = findViewById(R.id.idTvTranslatedTV);

        //Spinner 1
        fromSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                fromLanguageCode = getLanguageCode(fromLanguages[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayAdapter fromAdapter = new ArrayAdapter(this,
                R.layout.spinner_item, fromLanguages);
        fromAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        fromSpinner.setAdapter(fromAdapter);

        //Spinner 2
        toSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                toLanguageCode = getLanguageCode(toLanguages[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayAdapter toAdapter = new ArrayAdapter(this,
                R.layout.spinner_item, toLanguages);
        toAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        toSpinner.setAdapter(toAdapter);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                translatedTV.setText("");

                if(sourceEdt.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this,
                            "Please enter your text",
                            Toast.LENGTH_LONG).show();
                } else if (fromLanguageCode.isEmpty()) {
                    Toast.makeText(MainActivity.this,
                            "Please select source language",
                            Toast.LENGTH_LONG).show();
                } else if (toLanguageCode.isEmpty()) {
                    Toast.makeText(MainActivity.this,
                            "Please select language to translate",
                            Toast.LENGTH_LONG).show();
                }else {
                    translateText(fromLanguageCode, toLanguageCode, sourceEdt.getText().toString());
                }
            }
        });


    }

    private void translateText(String fromLanguageCode, String toLanguageCode, String src) {

        translatedTV.setText("Downloading language model");
    try {
        TranslatorOptions options = new TranslatorOptions.Builder().setSourceLanguage(fromLanguageCode)
                .setTargetLanguage(toLanguageCode).build();

        Translator translator = Translation.getClient(options);

        DownloadConditions conditions = new DownloadConditions.Builder().build();

        translator.downloadModelIfNeeded(conditions).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                translatedTV.setText("Transalating ...");

                translator.translate(src).addOnSuccessListener(new OnSuccessListener<String>() {
                    @Override
                    public void onSuccess(String s) {
                        translatedTV.setText(s);
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(MainActivity.this,
                                "Fail to translate",
                                Toast.LENGTH_LONG).show();
                    }
                });
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(MainActivity.this,
                        "Fail to download the language",
                        Toast.LENGTH_LONG).show();
            }
        });

    }catch (Exception e){
        e.printStackTrace();
    }


    }

    private String getLanguageCode(String language) {
        String languageCode;
        switch (language){
            case "English":
                languageCode = TranslateLanguage.ENGLISH;
                break;
            case "Afrikaans":
                languageCode = TranslateLanguage.AFRIKAANS;
                break;
            case "Estonian":
                languageCode = TranslateLanguage.ESTONIAN;
                break;
            default:
                languageCode = "";
        }
        return languageCode;
    }
}