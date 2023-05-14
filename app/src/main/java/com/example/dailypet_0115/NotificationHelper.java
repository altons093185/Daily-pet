package com.example.dailypet_0115;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.NotificationCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.security.PublicKey;



public class NotificationHelper extends ContextWrapper {
    public static final String channelID = "channelID";
    public static final String channelName = "Channel Name";
    String petname="毛小孩";
    String email;

    private NotificationManager mManager;
    private FirebaseFirestore firebaseFirestore;

    public NotificationHelper(Context base) {
        super(base);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            createChannel();
        }
    }

    @TargetApi(Build.VERSION_CODES.O)
    private void createChannel() {
        NotificationChannel channel = new NotificationChannel(channelID, channelName, NotificationManager.IMPORTANCE_HIGH);

        getManager().createNotificationChannel(channel);
    }

    public NotificationManager getManager() {
        if (mManager == null) {
            mManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        }

        return mManager;
    }

    public NotificationCompat.Builder getChannelNotification() {

        Intent activityintent = new Intent(this,MainActivity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(this, 0,activityintent,0);
        int importance = NotificationManager.IMPORTANCE_HIGH;
        return new NotificationCompat.Builder(getApplicationContext(), channelID)
                .setContentTitle("Daily Pet建議您")
                .setContentText("今天"+petname +"運動量稍嫌不足喔!")
                .setSmallIcon(R.drawable.dogstep_alarm)
                .setPriority(Notification.PRIORITY_MAX)
                .setDefaults(Notification.DEFAULT_ALL)
                .setContentIntent(contentIntent)
                .setColor(Color.rgb(73,73,255));

    }
    /*public String getname(){
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        email = user.getEmail();
        final DocumentReference name = firebaseFirestore.collection("Pet").document(email);
        name.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                String a;
                if(task.isSuccessful()){
                    DocumentSnapshot get = task.getResult();
                    get.getString("Petname");
                    a=get.getString("Petname");
                    System.out.println("this is"+a);
                }
            }
        });
        return email;
    }*/
}
