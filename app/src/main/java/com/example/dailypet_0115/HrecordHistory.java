package com.example.dailypet_0115;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.annotation.Nullable;


public class HrecordHistory extends AppCompatActivity {
     RecyclerView HRlistview;
    //private List<HRhistory> HRList;
    ArrayList<HRhistory>HRList;
     FirebaseFirestore firebaseFirestore;
     FirebaseAuth firebaseAuth;
    HRrecycleviewer hRrecycleviewer;
    String email;
    View view;
    Button delete;
     DocumentSnapshot lastVisible;
     Boolean isFirstPageFirstLoad = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hrecord_history);
        HRList=new ArrayList<>();
        setupRecyclerview();
        setupFirebase();
        loadData();
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        email = user.getEmail();
    }


    public void loadData(){
        if(HRList.size()>0)
            HRList.clear();
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        email = user.getEmail();
        Query query=firebaseFirestore.collection("PetHR").document(email).collection("HR")
                .orderBy("Time",Query.Direction.DESCENDING);
               query.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                for(DocumentSnapshot querySnapshot:task.getResult()){
                    HRhistory hRhistory=new HRhistory(querySnapshot.getId(),querySnapshot.getString("PetHeightNumber"),
                            querySnapshot.getString("PetWeightNumber"),querySnapshot.getDate("Time"));
                    HRList.add(hRhistory);
                }
                hRrecycleviewer=new HRrecycleviewer(HrecordHistory.this,HRList);
                HRlistview.setAdapter(hRrecycleviewer);
            }
        });

    }
    private void setupFirebase(){
        firebaseFirestore=FirebaseFirestore.getInstance();
    }
    private void setupRecyclerview(){
        HRlistview=findViewById(R.id.HRlistview);
        HRlistview.setHasFixedSize(true);
        HRlistview.setLayoutManager(new LinearLayoutManager(this));
        HRlistview.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        /*new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,
                ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                //firebaseFirestore.collection("PetHR").document(email).collection("HR");
                hRrecycleviewer.removeitem(viewHolder.getAdapterPosition());
            }
        }).attachToRecyclerView(HRlistview);
        HRlistview.addOnScrollListener( new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                Boolean reachedBottom = !recyclerView.canScrollVertically(1);
                if(reachedBottom){
                }
            }
        });*/
    }
    }


