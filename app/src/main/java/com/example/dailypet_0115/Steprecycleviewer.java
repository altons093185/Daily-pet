package com.example.dailypet_0115;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.Date;

public class Steprecycleviewer extends RecyclerView.Adapter<Stepholder> {
    public ArrayList<Stephistory> Steplist;
    private Context context;
    Steprecordhistory SteprecordHistory;
    FirebaseAuth firebaseAuth;
    String email;

    public Steprecycleviewer(Steprecordhistory SteprecordHistory, ArrayList<Stephistory> Steplist) {
        this.SteprecordHistory=SteprecordHistory;
        this.Steplist=Steplist;
    }
    @NonNull
    @Override
    public Stepholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.listitem,viewGroup,false);
        context=viewGroup.getContext();
        return new Stepholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Stepholder viewHolder,final int i) {
        viewHolder.setIsRecyclable(false);
        viewHolder.Step.setText("步數: "+Steplist.get(i).getStep());

        try {
            long millisecond = Steplist.get(i).getTimestamp().getTime();
            String dateString = DateFormat.format("MM/dd/yyyy", new Date(millisecond)).toString();
            viewHolder.setTime(dateString);
        } catch (Exception e) {
        }
    }
    public void removeitem(int i){
        Steplist.remove(i);
        notifyItemRemoved(i);
    }


    @Override
    public int getItemCount() {
        return Steplist.size();
    }

}

