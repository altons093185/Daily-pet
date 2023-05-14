package com.example.dailypet_0115;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HRholder extends RecyclerView.ViewHolder {
    public TextView PetHeightNumber,PetWeightNumber,hrDate;
            View mview;
           public Button delebutton;
    public HRholder(@NonNull View itemView) {
        super(itemView);
        mview=itemView;
        PetHeightNumber=itemView.findViewById(R.id.HIShigh);
        PetWeightNumber=itemView.findViewById(R.id.HISweight);
        delebutton=itemView.findViewById(R.id.delete);

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

        hrDate = itemView.findViewById(R.id.HISdate);
        hrDate.setText(date);

    }
}
