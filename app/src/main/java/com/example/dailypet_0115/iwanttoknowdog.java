package com.example.dailypet_0115;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class iwanttoknowdog extends AppCompatActivity {
    private Button aboutdog,dogfood,doghealty,dogclean,dogbeheavior,donotdothistodog;
    private ImageView back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_iwanttoknowdog);

        ImageView aboutdog=findViewById(R.id.aboutdog);
        aboutdog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent();
                intent1.setClass(iwanttoknowdog.this,knowaboutdog.class);
                startActivity(intent1);
            }
        });

        ImageView dogfood=findViewById(R.id.dogfood);
        dogfood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2=new Intent();
                intent2.setClass(iwanttoknowdog.this,dogfood.class);
                startActivity(intent2);
            }
        });

        ImageView doghealty=findViewById(R.id.doghealty);
        doghealty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3=new Intent();
                intent3.setClass(iwanttoknowdog.this,doghealty.class);
                startActivity(intent3);
            }
        });

        ImageView dogclean=findViewById(R.id.dogbath);
        dogclean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent4=new Intent();
                intent4.setClass(iwanttoknowdog.this,dogclean.class);
                startActivity(intent4);
            }
        });

        ImageView dogbeheavior=findViewById(R.id.dogbehavior);
        dogbeheavior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent5=new Intent();
                intent5.setClass(iwanttoknowdog.this,dogbeheavior.class);
                startActivity(intent5);
            }
        });

        ImageView donotdothistodog=findViewById(R.id.donotdothistodog);
        donotdothistodog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent6=new Intent();
                intent6.setClass(iwanttoknowdog.this,donotdothistodog.class);
                startActivity(intent6);
            }
        });
        back = findViewById(R.id.back2);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent helpintent = new Intent(iwanttoknowdog.this, firsttimepet.class);
                startActivity(helpintent);
            }
        });
    }
}
