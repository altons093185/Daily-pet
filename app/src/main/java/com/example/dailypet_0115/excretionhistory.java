package com.example.dailypet_0115;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class excretionhistory extends AppCompatActivity {
private Button historyback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_excretionhistory);
        historyback=findViewById(R.id.histroyback);
        historyback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent rc5=new Intent(excretionhistory.this,recordexcretion.class);
                startActivity(rc5);
            }
        });
    }
}
