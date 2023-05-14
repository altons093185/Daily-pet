package com.example.dailypet_0115;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class recordexcretion extends AppCompatActivity {
private Button AD_NewP;
private Button History;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recordexcretion);
        AD_NewP=findViewById(R.id.AD_NewP);
        History=findViewById(R.id.History);
        Bundle bundle4=this.getIntent().getExtras();
        if(bundle4!=null){
            String RC1=bundle4.getString("RC1");
            String RC2=bundle4.getString("RC2");
            TextView tt1=(TextView)findViewById(R.id.rcsitution1);
            TextView tt2=(TextView)findViewById(R.id.rcstution2);
            tt1.setText(RC1);
            tt2.setText(RC2);
        }
        AD_NewP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent rc1=new Intent(recordexcretion.this,addexcretion.class);
                startActivity(rc1);
            }
        });
        History.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent rc2=new Intent(recordexcretion.this,excretionhistory.class);
                startActivity(rc2);
            }
        });

    }
}
