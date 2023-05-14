package com.example.dailypet_0115;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

import javax.annotation.Nullable;

public class healthrecord_fragment extends Fragment {

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

    public healthrecord_fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.healthrecord_fragment, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        email = user.getEmail();
        firebaseFirestore = FirebaseFirestore.getInstance();
        firebaseAuth = FirebaseAuth.getInstance();
        userid = firebaseAuth.getCurrentUser().getUid();
        ShowTh = getView().findViewById(R.id.ShowTh);
        ShowTw = getView(). findViewById(R.id.ShowTw);
        HRhistory = getView(). findViewById(R.id.HRhistory);
        DocumentReference contactListener= firebaseFirestore.collection("Pet").document(email).collection("Height&Weight").document("H&W");
        contactListener.addSnapshotListener(new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
                if (e != null) {
                    Log.d("ERROR", e.getMessage());
                    return;
                }
                if(documentSnapshot != null && documentSnapshot.exists()){
                    ShowTh.setText(documentSnapshot.getData().get("PetHeightNumber").toString());
                    ShowTw.setText(documentSnapshot.getData().get("PetWeightNumber").toString());
                }
            }
        });
        /*firebaseFirestore.collection("Pet").document(email).collection("Height&Weight").document("H&W")
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
        });*/

        EnterNHW = getView().findViewById(R.id.EnterNHW);
        EnterNHW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(healthrecord_fragment.this.getActivity(), recordweightandhigh.class);
                startActivity(intent);
            }
        });
        HRhistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent HRHintent = new Intent();
                HRHintent.setClass(healthrecord_fragment.this.getActivity(), HrecordHistory.class);
                startActivity(HRHintent);
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
    }
}



