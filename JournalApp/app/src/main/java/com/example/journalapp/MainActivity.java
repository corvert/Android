package com.example.journalapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    //widgets
    Button loginBtn, createAccountBtn;
    EditText emailET, passwordET;

    //Firebase auth
    private FirebaseAuth firebaseAuth;
    private FirebaseAuth.AuthStateListener authStateListener;
    private FirebaseUser currentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createAccountBtn = findViewById(R.id.create_account);
        createAccountBtn.setOnClickListener(v -> {
            //OnClick()
            Intent i = new Intent(MainActivity.this, SignUpActivity.class);
            startActivity(i);

        });

        //Login
        loginBtn = findViewById(R.id.email_signing);
        emailET = findViewById(R.id.email);
        passwordET = findViewById(R.id.password);

        //Firebase Authentication
        firebaseAuth = FirebaseAuth.getInstance();

        loginBtn.setOnClickListener(v ->{
            logEmailPassUser(
                    emailET.getText().toString().trim(),
                    passwordET.getText().toString().trim()
            );
        });

    }

    private void logEmailPassUser(String email, String password){
        //Checking for empty texts
        if (!TextUtils.isEmpty(email) && !TextUtils.isEmpty(password)){
            firebaseAuth.signInWithEmailAndPassword(email, password)
                    .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                        @Override
                        public void onSuccess(AuthResult authResult) {
                            FirebaseUser user = firebaseAuth.getCurrentUser();
                            Intent i = new Intent(MainActivity.this, JouranlListActivity.class);
                            startActivity(i);


                }
            });
        }
    }
}