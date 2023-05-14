package com.example.dailypet_0115;

import android.graphics.Paint;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.type.DayOfWeek;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class wts_average extends AppCompatActivity {
    private TextView step;
    private EditText water;
    private EditText temp;
    private Button clear;
    private Button analysis;
    private FirebaseFirestore firebaseFirestore;
    private TextView date, recordwater, recordtemp;
    private ImageView back;
    String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wts_average);

        step = findViewById(R.id.textView40);
        water = findViewById(R.id.editText4);
        temp = findViewById(R.id.editText6);
        clear = findViewById(R.id.clear);
        analysis = findViewById(R.id.analysis);
        back = findViewById(R.id.backknow2);

        recordwater = findViewById(R.id.lastrecordwater);
        recordtemp = findViewById(R.id.lastrecordtemp);

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy.MM.dd");
        Date curDate = new Date(System.currentTimeMillis());
        final String str = formatter.format(curDate);
        date = findViewById(R.id.date);
        date.setText(str);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        email = user.getEmail();


        firebaseFirestore = FirebaseFirestore.getInstance();
        final DocumentReference contactListener = firebaseFirestore.collection("Pet").document(email).collection("PetStep").document(str);
        contactListener.addSnapshotListener(new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(DocumentSnapshot documentSnapshot, FirebaseFirestoreException e) {
                if (e != null) {
                    Log.d("ERROR", e.getMessage());
                    return;
                }
                if (documentSnapshot != null && documentSnapshot.exists()) {
                    step.setText(documentSnapshot.getData().get("step").toString());
                } else
                    step.setText("今天還沒走路");
            }
        });
        //step.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                water.setText("");
                temp.setText("");
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        final DocumentReference address = firebaseFirestore.collection("Pet")
                .document(email).collection("TWS").document(str);//抓到欄位位址

        ///////////////////////////////
        address.get()
                //address是資料庫位址
                .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {//歷史紀錄
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                        if (documentSnapshot.exists()) {
                            String watervalue = documentSnapshot.getString("water");
                            String tempvalue = documentSnapshot.getString("temperature");
                            recordwater.setText(watervalue);
                            recordtemp.setText(tempvalue);

                        } else {//還沒輸入

                            Map<String, String> empty = new HashMap<>();
                            empty.put("water", "");
                            empty.put("temperature", "");
                            firebaseFirestore.collection("Pet").document(email).collection("TWS").document(str).set(empty);
                        }
                    }
                });


        analysis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //抓兩個值
                String waterdata = water.getText().toString();
                String tempdata = temp.getText().toString();

                if (waterdata.equals("") || tempdata.equals("")) {
                    Toast.makeText(wts_average.this, "請輸入數值", Toast.LENGTH_SHORT).show();

                } else {
                    //兩個欄位值傳上去
                    Map<String, String> healthanalysis = new HashMap<>();
                    healthanalysis.put("water", waterdata);
                    healthanalysis.put("temperature", tempdata);
                    address.update("water", waterdata, "temperature", tempdata)

                            //firebaseFirestore.collection("Pet").document(email).collection("TWS").document(str).set(healthanalysis)//set會全部刷掉
                            .addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void avoid) {
                                    try {
                                        //set time in mili
                                        Thread.sleep(2000);
                                    }catch (Exception e){
                                        e.printStackTrace();
                                    }
                                    Toast.makeText(wts_average.this, "評估中...", Toast.LENGTH_SHORT).show();
                                    getstatus();
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(wts_average.this, "failure analysis", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });
    }




    //抓statuts下來判斷lor0
    public void getstatus() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy.MM.dd");
        Date curDate = new Date(System.currentTimeMillis());
        final String str = formatter.format(curDate);

        final DocumentReference address = firebaseFirestore.collection("Pet")
                .document(email).collection("TWS").document(str);//抓到欄位位址

            address.get()
                    //address是資料庫位址
                    .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                        @Override
                        public void onSuccess(DocumentSnapshot documentSnapshot) {
                            if (documentSnapshot.exists()) {
                                String status = documentSnapshot.getString("status");
                                //Toast.makeText(wts_average.this, status, Toast.LENGTH_SHORT).show();
                                if (status.equals("1")) {//條件:1=健康;0=不健康
                                    Toast.makeText(wts_average.this, "健康", Toast.LENGTH_SHORT).show();
                                } else if (status.equals("0")) {
                                    Toast.makeText(wts_average.this, "不健康", Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(wts_average.this, "不正常數值", Toast.LENGTH_SHORT).show();//不正常數值
                                    //textViewData.setText("Title: " + title + "\n" + "Description: " + description);
                                }
                            } else {
                                Toast.makeText(wts_average.this, "Document does not exist", Toast.LENGTH_SHORT).show();
                            }
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(wts_average.this, "Error get status!", Toast.LENGTH_SHORT).show();
                        }
                    });
        }
    }



