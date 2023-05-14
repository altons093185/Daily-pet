package com.example.dailypet_0115;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v4.app.Fragment;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


/**
 * A simple {@link Fragment} subclass.
 */
public class dogstep_fragment extends Fragment {

    private ImageView back;
    private FirebaseFirestore firebaseFirestore;
    String email;
    String turnStep;
    private Long getStep;
    private TextView step;
    private TextView test;
    private Button stephistory;


    public dogstep_fragment() {
        // Required empty public constructor

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dogstepfragment, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy.MM.dd");
        Date curDate = new Date(System.currentTimeMillis());
        String str = formatter.format(curDate);
        test = getView().findViewById(R.id.testdate);
        test.setText(str);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        email = user.getEmail();
        step = getView().findViewById(R.id.Step);

        firebaseFirestore = FirebaseFirestore.getInstance();
        DocumentReference contactListener = firebaseFirestore.collection("Pet").document(email).collection("PetStep").document(str);
        contactListener.addSnapshotListener(new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(DocumentSnapshot documentSnapshot, FirebaseFirestoreException e) {
                if (e != null) {
                    Log.d("ERROR", e.getMessage());
                    return;
                }
                if (documentSnapshot != null && documentSnapshot.exists()) {
                    step.setText(documentSnapshot.getData().get("step").toString());
                }
                else
                    step.setText("0");
            }
        });
        /*firebaseFirestore.collection("Pet").document(email).collection("PetStep").document(str)
                .get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    getStep = document.getLong("step");
                    turnStep = String.valueOf(getStep);
                    step.setText(turnStep);
                }else {
                    Intent helpintent = new Intent(dogstep_dont_use.this, com.example.dailypet_0115.MainActivity.class);
                    startActivity(helpintent);
                }
            }
        });*/


        stephistory = getView().findViewById(R.id.Stephistory);
        stephistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sh = new Intent(dogstep_fragment.this.getActivity(), Steprecordhistory.class);
                startActivity(sh);
            }
        });



    }
}
