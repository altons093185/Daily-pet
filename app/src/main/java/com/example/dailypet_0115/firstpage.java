package com.example.dailypet_0115;


import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.view.View;

import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class firstpage extends AppCompatActivity {
    private Button normal_signin_btn;
    private Button register_btn;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firstpage);

        mAuth = FirebaseAuth.getInstance();

        normal_signin_btn=findViewById(R.id.normal_signin_btn);
        register_btn=findViewById(R.id.register_btn);

        normal_signin_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginintent = new Intent(firstpage.this,login.class);
                startActivity(loginintent);
            }
        });

        register_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent regIntent = new Intent(firstpage.this,register.class);
                startActivity(regIntent);
            }
        });

    }

    @Override
    protected void onStart(){
        super.onStart();

        FirebaseUser currentUser = mAuth.getCurrentUser();

        if(currentUser != null){
            sendToMain();

        }
    }

    private void sendToMain() {
        Intent mainIntent=new Intent(firstpage.this,MainActivity.class);
        startActivity(mainIntent);
        finish();
    }
}
