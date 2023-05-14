package com.example.dailypet_0115;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toolbar;

public class firsttimepet extends AppCompatActivity {
    private ImageView backknow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_firsttimepet);

        ImageView dog=findViewById(R.id.dog);
        dog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent();
                intent1.setClass(firsttimepet.this,iwanttoknowdog.class);
                startActivity(intent1);
            }
        });

        ImageView cat=findViewById(R.id.cat);
        cat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2=new Intent();
                intent2.setClass(firsttimepet.this,iwanttoknowcat.class);
                startActivity(intent2);
            }
        });

        backknow = findViewById(R.id.backknow);
        backknow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent helpintent = new Intent(firsttimepet.this, MainActivity.class);
                startActivity(helpintent);
            }
        });
    }
}
