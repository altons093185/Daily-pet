package com.example.dailypet_0115;

import android.app.Activity;
import android.content.Context;
import android.renderscript.Sampler;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.ObservableSnapshotArray;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static java.lang.Long.valueOf;

public class HRrecycleviewer extends RecyclerView.Adapter<HRholder> {
    public ArrayList<HRhistory> HRlist;
    private Context context;
    HrecordHistory hrecordHistory;
    FirebaseAuth firebaseAuth;
    String email;

    public HRrecycleviewer(HrecordHistory hrecordHistory,ArrayList<HRhistory> HRlist) {
        this.hrecordHistory=hrecordHistory;
        this.HRlist=HRlist;
    }
    @NonNull
    @Override
    public HRholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recordhistory_list_item,viewGroup,false);
        context=viewGroup.getContext();
        return new HRholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HRholder viewHolder,final int i) {
        viewHolder.setIsRecyclable(false);
        viewHolder.PetHeightNumber.setText("身高: "+HRlist.get(i).getPetHeightNumber());
        viewHolder.PetWeightNumber.setText("體重: "+HRlist.get(i).getPetWeightNumber());
        viewHolder.delebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteRow(i);
            }
        });
        /*String phn=HRlist.get(i).getPetHeightNumber();
        viewHolder.setPetHeightNumber(phn);
        String pwn=HRlist.get(i).getPetWeightNumber();
        viewHolder.setPetWeightNumber(pwn);*/


        try {
            long millisecond = HRlist.get(i).getTimestamp().getTime();
            String dateString = DateFormat.format("MM/dd/yyyy", new Date(millisecond)).toString();
            viewHolder.setTime(dateString);
        } catch (Exception e) {
        }
    }

    private void deleteRow(final int i) {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        email = user.getEmail();
        hrecordHistory.firebaseFirestore.collection("PetHR").document(email).collection("HR")
                .document(HRlist.get(i).getUser_id())
                .delete()
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(@NonNull Void aVoid) {
                        Toast.makeText(hrecordHistory.getBaseContext(),"刪除成功",Toast.LENGTH_SHORT).show();
                        hrecordHistory.loadData();
                        /*HRlist.remove(i);
                        notifyItemRemoved(i);
                        notifyItemRangeChanged(i,HRlist.size());*/
                    }
                });

    }

    public void removeitem(int i){
        HRlist.remove(i);
        notifyItemRemoved(i);
    }


    @Override
    public int getItemCount() {
        return HRlist.size();
    }

}
