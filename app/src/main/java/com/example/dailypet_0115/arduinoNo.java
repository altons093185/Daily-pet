package com.example.dailypet_0115;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class arduinoNo extends AppCompatActivity {
        Button  button2;
        private ImageView callback;
        TextView ipp;
    String email,a,b,c;
    OkHttpClient client = new OkHttpClient().newBuilder().build();
    private FirebaseFirestore firebaseFirestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arduino_no);
        button2=(Button)findViewById(R.id.button2);
        callback=(ImageView)findViewById(R.id.callback);
        ipp=(TextView)findViewById(R.id.ipp);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
         email = user.getEmail();

        callback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent call = new Intent(arduinoNo.this, MainActivity.class);
                startActivity(call);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firebaseFirestore = FirebaseFirestore.getInstance();
        DocumentReference contactListener = firebaseFirestore.collection("Pet").document(email).collection("IP").document("IP");
                contactListener.get()
                        .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                          @Override
                          public void onSuccess(DocumentSnapshot documentSnapshot) {
                             if (documentSnapshot.exists()) {
                          String a = documentSnapshot.getString("IP");//填欄位你填IP
                                 Request request = new Request.Builder()
                                         .url(a)
                                         .build();

                                 // 建立Call
                                 Call call = client.newCall(request);

                                 // 執行Call連線到網址
                                 call.enqueue(new Callback() {
                                     @Override
                                     public void onResponse(Call call, Response response) throws IOException {
                                         // 連線成功，自response取得連線結果
                                         assert response.body() != null;
                                         String result = response.body().string();
                                         Log.d("OkHttp result", result);

                                     }

                                     @Override
                                     public void onFailure(Call call, IOException e) {
                                         // 連線失敗

                                     }
                                 });
                              Toast.makeText(getApplication(),"呼叫中...", Toast.LENGTH_LONG).show();
                           } else {

                             }
                           }
                        });

        /*contactListener.addSnapshotListener(new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(DocumentSnapshot documentSnapshot, FirebaseFirestoreException e) {
                if (e != null) {
                    Log.d("ERROR", e.getMessage());
                    return;
                }
                if (documentSnapshot != null && documentSnapshot.exists()) {
                    //ipp.setText(documentSnapshot.getData().get("IP").toString());
                   // a=documentSnapshot.getData().get("IP").toString();



                   // Toast.makeText(getApplication(),a,Toast.LENGTH_LONG).show();
                    a="http://192.168.43.217";
                  Request request = new Request.Builder()
                            .url(a)
                            .build();

                    // 建立Call
                    Call call = client.newCall(request);

                    // 執行Call連線到網址
                    call.enqueue(new Callback() {
                        @Override
                        public void onResponse(Call call, Response response) throws IOException {
                            // 連線成功，自response取得連線結果
                            assert response.body() != null;
                            String result = response.body().string();
                            Log.d("OkHttp result", result);

                        }

                        @Override
                        public void onFailure(Call call, IOException e) {
                            // 連線失敗

                        }
                    });
                }
            }
        });*/
                //a="http://192.168.43.217";

                /*Request request = new Request.Builder()
                        .url(a)
                        .build();

                // 建立Call
                Call call = client.newCall(request);

                // 執行Call連線到網址
                call.enqueue(new Callback() {
                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        // 連線成功，自response取得連線結果
                        assert response.body() != null;
                        String result = response.body().string();
                        Log.d("OkHttp result", result);

                    }

                    @Override
                    public void onFailure(Call call, IOException e) {
                        // 連線失敗

                    }
                });*/
            }
        });
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
//        statusRecebimento=false;
    }

    }



