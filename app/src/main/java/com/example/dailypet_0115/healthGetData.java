package com.example.dailypet_0115;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class healthGetData extends AppCompatActivity {
    private ListView ListView;
    DatabaseReference databaseReference;
    private List<healthclass> healthList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_get_data);

        ListView=findViewById(R.id.list_view);
        databaseReference= FirebaseDatabase.getInstance().getReference("health");
        healthList=new ArrayList<>();
    }

    @Override
    protected void onStart() {
        super.onStart();
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot healSnapshot :dataSnapshot.getChildren()){
                    healthclass healthclass=healSnapshot.getValue(healthclass.class);
                    healthList.add(healthclass);
                }
                healthinfoclass healthinfoclass=new healthinfoclass(healthGetData.this,healthList);
                ListView.setAdapter(healthinfoclass);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
