package com.example.dailypet_0115;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

public class remind_addschdule_Drug extends AppCompatActivity {
    private Button cancel2;
    private Button addsch2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_remind_addschdule__drug);
        cancel2 = findViewById(R.id.cancel2);
        addsch2 = findViewById(R.id.addsch2);
        Button addsch=(Button)findViewById(R.id.addsch2);
        addsch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText EditTextTel = (EditText) findViewById(R.id.newschtitle2);
                String Tel = EditTextTel.getText().toString();

                EditText EditTextTime = (EditText) findViewById(R.id.newschtime2);
                String Time = EditTextTime.getText().toString();

                EditText EditTextRepeat = (EditText) findViewById(R.id.newschrepeat2);
                String Repeat = EditTextRepeat.getText().toString();

                EditText EditTextHint = (EditText) findViewById(R.id.newschhint2);
                String Hint =EditTextHint.getText().toString();

                EditText EditTextMessage = (EditText) findViewById(R.id.newschmessage2);
                String Message = EditTextMessage.getText().toString();

                Bundle bundle = new Bundle();
                bundle.putString("Tel", Tel);
                bundle.putString("Time", Time);
                bundle.putString("Repeat", Repeat);
                bundle.putString("Hint", Hint);
                bundle.putString("Message", Message);

                Intent intent = new Intent();
                intent.setClass(remind_addschdule_Drug.this, reminddrug.class);
                intent.putExtras(bundle); //將Bundle物件assign給intent
                startActivity(intent);


            }
        });

        cancel2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }
}
