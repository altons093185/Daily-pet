package com.example.dailypet_0115;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
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

import de.hdodenhof.circleimageview.CircleImageView;

public class createpet extends AppCompatActivity {

    private Button edit;
    private Button new11;

    private FirebaseAuth.AuthStateListener mAuthStateListener;

    private String getname;
    private String getkind;
    private String getbirth;
    private String getage;

    private TextView name;
    private TextView kind;
    private TextView birth;
    private TextView age;
    private Uri ImageUri = null;
    private CircleImageView downloadimage;
    private FirebaseAuth firebaseAuth;
    String email;
    private FirebaseFirestore firebaseFirestore;
    ImageView crback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_createpet);
        crback=findViewById(R.id.crback);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        email = user.getEmail();

        firebaseAuth = FirebaseAuth.getInstance();
        downloadimage=findViewById(R.id.downloadimage);
        edit = findViewById(R.id.editdescription);
        //final String user_id=firebaseAuth.getCurrentUser().getUid();
        final String value=getIntent().getStringExtra("pPictureID");
        firebaseFirestore = FirebaseFirestore.getInstance();
        firebaseFirestore.collection("PetPicture").document(email).get()
                .addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                        if (task.isSuccessful()) {
                            if (task.getResult().exists()) {
                                String image = task.getResult().getString("image");
                                ImageUri=Uri.parse(image);
                                try {
                                    Glide.with(createpet.this).load(image).into(downloadimage);
                                }catch (Exception e) {
                                    e.printStackTrace();
                                }

                            }
                        } else {
                            String error = task.getException().getMessage();
                            Toast.makeText(createpet.this, "Error: " + error, Toast.LENGTH_LONG).show();
                        }
                    }
                });
        DocumentReference contactListener=firebaseFirestore.collection("Pet").document(email);
        contactListener.addSnapshotListener(new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
                if (e != null) {
                    Log.d("ERROR", e.getMessage());
                    return;
                }
                if (documentSnapshot != null && documentSnapshot.exists()) {
                    name.setText(documentSnapshot.getData().get("Petname").toString());
                    kind.setText(documentSnapshot.getData().get("PetVariety").toString());
                    birth.setText(documentSnapshot.getData().get("PetBirthday").toString());
                    age.setText(documentSnapshot.getData().get("PetAge").toString());
                }
            }
        });
        /*firebaseFirestore.collection("Pet").document(email).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    getname = document.getString("Petname");
                    getkind = document.getString("PetVariety");
                    getbirth = document.getString("PetBirthday");
                    getage = document.getString("PetAge");

                    name.setText(getname);
                    kind.setText(getkind);
                    birth.setText(getbirth);
                    age.setText(getage);
                }
            }
        });*/

        name = findViewById(R.id.name);
        kind = findViewById(R.id.kind);
        birth = findViewById(R.id.birth);
        age = findViewById(R.id.age);

        name.setText(getname);
        kind.setText(getkind);
        birth.setText(getbirth);
        age.setText(getage);

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent helpintent = new Intent(createpet.this, editpet.class);
                startActivity(helpintent);

            }
        });
        crback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent crb=new Intent(createpet.this,MainActivity.class);
                startActivity(crb);
            }
        });

    }
}
