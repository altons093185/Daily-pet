package com.example.dailypet_0115;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.firestore.DocumentSnapshot;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

public class healthrecord_dontuse extends AppCompatActivity {
    private Button EnterNHW;
    private Button HRhistory;
    private TextView ShowTh;
    private TextView ShowTw;
    private FirebaseFirestore firebaseFirestore;
    private FirebaseAuth firebaseAuth;
    String userid;
    String email;
    String TAG;
    ImageView hrimageview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.healthrecord_dontuse);
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        email = user.getEmail();
        firebaseFirestore = FirebaseFirestore.getInstance();
        firebaseAuth=FirebaseAuth.getInstance();
        userid = firebaseAuth.getCurrentUser().getUid();
        ShowTh = (TextView) findViewById(R.id.ShowTh);
        ShowTw = (TextView) findViewById(R.id.ShowTw);
        HRhistory = (Button) findViewById(R.id.HRhistory);

        TAG = "aaaa";
        firebaseFirestore.collection("Pet").document(email).collection("Height&Weight").document("H&W")
                .get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                        if (task.isSuccessful()) {
                            DocumentSnapshot documentSnapshot = task.getResult();
                            String gHigh = documentSnapshot.getString("PetHeightNumber");
                            ShowTh.setText("身高 :" + gHigh);
                            String gWeight = documentSnapshot.getString("PetWeightNumber");
                            ShowTw.setText("體重 :" + gWeight);

                        }
                    }
                });
        /*firebaseFirestore.collection("PetHR").document(email).collection("HR")
                .get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    for(DocumentSnapshot documentSnapshot:task.getResult()) {
                        String gHigh = documentSnapshot.getString("PetHeightNumber");
                        ShowTh.setText("身高 :" + gHigh);
                        String gWeight = documentSnapshot.getString("PetWeightNumber");
                        ShowTw.setText("體重 :" + gWeight);
                    }
                }
            }
        });*/
        EnterNHW = findViewById(R.id.EnterNHW);
        /*Bundle bundleRHeal=this.getIntent().getExtras();
        if(bundleRHeal!=null){
            String rHigh=bundleRHeal.getString("rHigh");
            String rWeight=bundleRHeal.getString("rWeight");
            TextView h1=(TextView)findViewById(R.id.ShowTh);
            TextView h2=(TextView)findViewById(R.id.ShowTw);
            h1.setText(rHigh);
            h2.setText(rWeight);
        }*/
        EnterNHW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(healthrecord_dontuse.this, recordweightandhigh.class);
                startActivity(intent);
            }
        });
        HRhistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent HRHintent = new Intent();
                HRHintent.setClass(healthrecord_dontuse.this, HrecordHistory.class);
                startActivity(HRHintent);
            }
        });

    }
}
