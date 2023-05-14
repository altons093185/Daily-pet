package com.example.dailypet_0115;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Interpolator;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.FirebaseAuth;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;

public class login extends AppCompatActivity {
    private EditText edtaccount, edtpass;
    private Button btnlogin;
    private ProgressDialog progressDialog;
    private FirebaseAuth mAuth;
    private ProgressBar loginProgress;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        setContentView(R.layout.activity_login);
        progressDialog = new ProgressDialog(this);
        btnlogin = findViewById(R.id.login_btn);
        edtaccount = (EditText) findViewById(R.id.username);
        edtpass = (EditText) findViewById(R.id.password);
        loginProgress =  findViewById(R.id.loginprogress);

        mAuth = FirebaseAuth.getInstance();

        btnlogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                String loginEmail = edtaccount.getText().toString();
                String loginPsw = edtpass.getText().toString();
                if(!TextUtils.isEmpty(loginEmail) && !TextUtils.isEmpty(loginPsw)){

                    loginProgress.setVisibility(View.VISIBLE);

                    mAuth.signInWithEmailAndPassword(loginEmail,loginPsw).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){

                                sendToMain();

                            }else{
                                String errorMes = task.getException().getMessage();
                                Toast.makeText(login.this,"Error : " + errorMes,Toast.LENGTH_LONG).show();
                            }
                            loginProgress.setVisibility(View.INVISIBLE);
                        }
                    });
                }
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
        Intent mainIntent=new Intent(login.this,MainActivity.class);
        startActivity(mainIntent);
        finish();
    }

}