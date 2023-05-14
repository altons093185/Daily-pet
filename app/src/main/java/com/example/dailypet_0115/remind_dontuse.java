package com.example.dailypet_0115;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class remind_dontuse extends AppCompatActivity {
    private Button doctor;
    private Button drugs;
    private Button neddle;
    private Button clean;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remind);

        doctor=findViewById(R.id.doctor);
        drugs=findViewById(R.id.drugs);
        neddle=findViewById(R.id.neddle);
        clean=findViewById(R.id.clean);

        doctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent doctorint = new Intent(remind_dontuse.this,remind_doctor.class);
                startActivity(doctorint);
            }
        });

        drugs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent drugsint = new Intent(remind_dontuse.this,reminddrug.class);
                startActivity(drugsint);
            }
        });

        neddle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent neddleint = new Intent(remind_dontuse.this,remindvac.class);
                startActivity(neddleint);
            }
        });

        clean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cleanint = new Intent(remind_dontuse.this,remindclear.class);
                startActivity(cleanint);
            }
        });

    }
}
