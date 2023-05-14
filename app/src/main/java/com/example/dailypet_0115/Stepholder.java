package com.example.dailypet_0115;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class Stepholder extends RecyclerView.ViewHolder {
    public TextView Step,stepDate;
    View mview;
    public Stepholder(@NonNull View itemView) {
        super(itemView);
        mview=itemView;
        Step=itemView.findViewById(R.id.StepQuantity);

    }
    /* public void setPetWeightNumber(String petw){
         PetWeightNumber=mview.findViewById(R.id.HIShigh);
         PetWeightNumber.setText(petw);
     }
     public void setPetHeightNumber(String peth){
         PetHeightNumber=mview.findViewById(R.id.HIShigh);
         PetHeightNumber.setText(peth);
     }*/
    public void setTime(String date) {

        stepDate = itemView.findViewById(R.id.Stepdate);
        stepDate.setText(date);

    }
}

