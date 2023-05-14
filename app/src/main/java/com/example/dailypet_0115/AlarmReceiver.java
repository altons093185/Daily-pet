package com.example.dailypet_0115;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.os.Bundle;
import android.provider.DocumentsContract;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.widget.Toast;

import com.bumptech.glide.request.transition.ViewAnimationFactory;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.core.Tag;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;



import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Nullable;

public class AlarmReceiver extends BroadcastReceiver {
    /*  Context mContext;
     public AlarmReceiver(Context mContext){
          this.mContext =mContext;
      }*/
    String email;
    String step;
    String str2;
    String TAG;
    private FirebaseFirestore firebaseFirestore;





    public void onReceive(final Context context, final Intent intent){




        SimpleDateFormat format =new SimpleDateFormat("yyyy.MM.dd");
        Date curDate = new Date(System.currentTimeMillis());
        final String str = format.format(curDate);
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        email=user.getEmail();
        firebaseFirestore=FirebaseFirestore.getInstance();
        final DocumentReference contactListener=firebaseFirestore.collection("Pet").document(email).collection("PetStep").document(str);
        contactListener.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if(task.isSuccessful()){
                    DocumentSnapshot STEP = task.getResult();
                    int intstep;
                    str2= STEP.getString("step");
                    intstep=Integer.valueOf(str2);
                    if (intstep<10000){//步數寫這裡
                        notification(context);
                    }
                }
            }
        });

    }
    public void notification(Context context){
        //Toast.makeText(context,"帶狗散步",Toast.LENGTH_LONG).show();


        NotificationHelper notificationHelper = new NotificationHelper(context);
        NotificationCompat.Builder nb = notificationHelper.getChannelNotification();
        notificationHelper.getManager().notify(1, nb.build());
    }


}