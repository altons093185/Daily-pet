package com.example.dailypet_0115;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.auth.FirebaseAuth;

import java.util.HashMap;
import java.util.Map;

public class recordweightandhigh extends AppCompatActivity {
    private Button addheal;
    private Button backheal;
    EditText recordhigh, recordweight;
    private FirebaseFirestore firebaseFirestore;
    private FirebaseAuth firebaseAuth;
    String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recordweightandhigh);
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        email = user.getEmail();


        firebaseFirestore = FirebaseFirestore.getInstance();


        recordhigh = findViewById(R.id.recordhigh);
        recordweight = findViewById(R.id.recordweight);
        addheal = findViewById(R.id.addheal);
        backheal = findViewById(R.id.backheal);

        backheal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        addheal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //String Time=FieldValue.serverTimestamp().toString();
                String rHigh = recordhigh.getText().toString();
                String rWeight = recordweight.getText().toString();
                Map<String, Object> rHealth = new HashMap<>();
                rHealth.put("PetHeightNumber", rHigh);
                rHealth.put("PetWeightNumber", rWeight);
                firebaseFirestore.collection("Pet").document(email).collection("Height&Weight").document("H&W")
                        .set(rHealth).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(recordweightandhigh.this, "加入成功", Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        String error = e.getMessage();
                        Toast.makeText(recordweightandhigh.this, "錯誤" + error, Toast.LENGTH_SHORT).show();
                    }
                });
                String High = recordhigh.getText().toString();
                String Weight = recordweight.getText().toString();
                Map<String, Object> hr = new HashMap<>();
                hr.put("PetHeightNumber", High);
                hr.put("PetWeightNumber", Weight);
                hr.put("Time", FieldValue.serverTimestamp());
                firebaseFirestore.collection("PetHR").document(email).collection("HR").add(hr);
                //Intent rHeal = new Intent();
                //rHeal.setClass(recordweightandhigh.this, com.example.dailypet_0115.MainActivity.class);
                //startActivity(rHeal);
                finish();
            }
        });
    }

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_hr, menu);
        return super.onCreateOptionsMenu(menu);
    }*/

    /*@Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.addheal:
                saveHR();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    private void saveHR(){
        String PetHeightNumber = recordhigh.getText().toString();
        String PetWeightNumber = recordweight.getText().toString();
        CollectionReference HRref=FirebaseFirestore.getInstance()
                .collection("Pet");
        HRref.add(new HRhistory(PetHeightNumber,PetWeightNumber));
    }*/
}
