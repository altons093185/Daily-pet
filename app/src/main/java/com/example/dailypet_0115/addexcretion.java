package com.example.dailypet_0115;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class addexcretion extends AppCompatActivity {
private Button cancelrc;
private Button addrc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addexcretion);
        cancelrc=findViewById(R.id.cancelrc);
        addrc=findViewById(R.id.addrc);
        addrc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editrc1=(EditText)findViewById(R.id.recordrc1);
                String RC1=editrc1.getText().toString();
                EditText editrc2=(EditText)findViewById(R.id.recordrc2);
                String RC2=editrc2.getText().toString();
                Bundle bundle4=new Bundle();
                bundle4.putString("RC1",RC1);
                bundle4.putString("RC2",RC2);
                Intent c= new Intent();
                c.setClass(addexcretion.this,recordexcretion.class);
                c.putExtras(bundle4);
                startActivity(c);
            }
        });
        cancelrc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent rc4=new Intent(addexcretion.this,recordexcretion.class);
                startActivity(rc4);
            }
        });
    }
}
