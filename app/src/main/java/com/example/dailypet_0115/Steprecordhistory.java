package com.example.dailypet_0115;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;


public class Steprecordhistory extends AppCompatActivity {
    RecyclerView Steplistview;
    ArrayList<Stephistory> StepList;
    FirebaseFirestore firebaseFirestore;
    FirebaseAuth firebaseAuth;
    Steprecycleviewer Steprecycleviewer;
    String email;
    View view;
    Button delet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_steprecordhistory);
        StepList = new ArrayList<>();
        setupRecyclerview();
        setupFirebase();
        loadData();
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        email = user.getEmail();
    }

    public void loadData() {
        if (StepList.size() > 0)
            StepList.clear();
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        email = user.getEmail();
        Query query = firebaseFirestore.collection("Pet").document(email).collection("PetStep")
                .orderBy("Time", Query.Direction.DESCENDING);
        query.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                for (DocumentSnapshot querySnapshot : task.getResult()) {
                    Stephistory Shistory = new Stephistory(querySnapshot.getString("step"), querySnapshot.getDate("Time"));
                    StepList.add(Shistory);
                }
                Steprecycleviewer = new Steprecycleviewer(Steprecordhistory.this, StepList);
                Steplistview.setAdapter(Steprecycleviewer);
            }
        });

    }

    private void setupFirebase() {
        firebaseFirestore = FirebaseFirestore.getInstance();
    }

    private void setupRecyclerview() {
        Steplistview = findViewById(R.id.Steplistview);
        Steplistview.setHasFixedSize(true);
        Steplistview.setLayoutManager(new LinearLayoutManager(this));
        Steplistview.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        /*new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,
       /* new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,
                ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                firebaseFirestore.collection("Pet").document(email).collection("PetStep");
                Steprecycleviewer.removeitem(viewHolder.getAdapterPosition());
            }
        }).attachToRecyclerView(Steplistview);
        Steplistview.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }
        });*/
    }
}
