package com.example.dailypet_0115;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class knowaboutdog extends AppCompatActivity {
    private ImageView back;
    private FirebaseFirestore firebaseFirestore;
    private TextView context;
    String getcontext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_knowaboutdog);

        /*context = (TextView) findViewById(R.id.context1);
        firebaseFirestore = FirebaseFirestore.getInstance();

        firebaseFirestore.collection("Pet_Helper").document("狗的基本認識").get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    getcontext = document.getString("context");
                    context.setText(getcontext);
                }else {
                    Intent helpintent = new Intent(knowaboutdog.this, iwanttoknowdog.class);
                    startActivity(helpintent);
                }
            }
        }) ;*/



        back = findViewById(R.id.back5);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent helpintent = new Intent(knowaboutdog.this, iwanttoknowdog.class);
                startActivity(helpintent);
            }
        });
    }
}
