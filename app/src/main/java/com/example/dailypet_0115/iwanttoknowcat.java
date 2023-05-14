package com.example.dailypet_0115;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class iwanttoknowcat extends AppCompatActivity {
    private ImageView aboutcat,catfood,cathealty,catclean,catbehavior,donotdothistocat;
    private ImageView back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_iwanttoknowcat);

        ImageView aboutcat=findViewById(R.id.aboutcat);
        aboutcat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent();
                intent1.setClass(iwanttoknowcat.this,aboutcat.class);
                startActivity(intent1);
            }
        });

        ImageView catfood=findViewById(R.id.catfood);
        catfood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2=new Intent();
                intent2.setClass(iwanttoknowcat.this,catfood.class);
                startActivity(intent2);
            }
        });

        ImageView cathealty=findViewById(R.id.cathealty);
        cathealty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3=new Intent();
                intent3.setClass(iwanttoknowcat.this,cathealty.class);
                startActivity(intent3);
            }
        });

        ImageView catclean=findViewById(R.id.catclean);
        catclean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent4=new Intent();
                intent4.setClass(iwanttoknowcat.this,catclean.class);
                startActivity(intent4);
            }
        });

        ImageView catbehavior=findViewById(R.id.catbehavior);
        catbehavior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent5=new Intent();
                intent5.setClass(iwanttoknowcat.this,catbehavior.class);
                startActivity(intent5);
            }
        });

        ImageView donotdothistocat=findViewById(R.id.donotdothistocat);
        donotdothistocat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent6=new Intent();
                intent6.setClass(iwanttoknowcat.this,donotdothistocat.class);
                startActivity(intent6);
            }
        });
        back = findViewById(R.id.back3);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent helpintent = new Intent(iwanttoknowcat.this, firsttimepet.class);
                startActivity(helpintent);
            }
        });
    }
}
