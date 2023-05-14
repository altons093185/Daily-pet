package com.example.dailypet_0115;

import android.app.ProgressDialog;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;
import android.util.Log;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.FirebaseAuth;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;


public class register extends AppCompatActivity {

    private Button register;
    private EditText account;
    private EditText password;
    private ProgressDialog progressDialog;
    private ProgressBar progressbar;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mAuth = FirebaseAuth.getInstance();

        account = findViewById(R.id.account);
        password = findViewById(R.id.password);
        register = findViewById(R.id.register);
        progressbar = findViewById(R.id.progress);


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = account.getText().toString();
                String psw = password.getText().toString();


                if (!TextUtils.isEmpty(email) && !TextUtils.isEmpty(psw) ) {


                    progressbar.setVisibility(View.VISIBLE);

                    mAuth.createUserWithEmailAndPassword(email, psw).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if (task.isSuccessful()) {

                                String user_id = mAuth.getCurrentUser().getUid();

                                Intent setupIntent = new Intent(register.this, MainActivity.class);
                                startActivity(setupIntent);
                                finish();

                            } else {
                                String errorMes = task.getException().getMessage();
                                Toast.makeText(register.this, "Error : " + errorMes, Toast.LENGTH_LONG).show();

                            }
                            progressbar.setVisibility(View.INVISIBLE);
                        }
                    });

                }

            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseUser currentUser = mAuth.getCurrentUser();

        if (currentUser != null) {
            sendtoMain();
        }
    }

    private void sendtoMain() {

        Intent mainIntent = new Intent(register.this, MainActivity.class);
        startActivity(mainIntent);
        finish();
    }
}
