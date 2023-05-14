package com.example.dailypet_0115;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

public class remind_addschdule_Clear extends AppCompatActivity {
    private Button cancel3;
    private Button addsch3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_remind_addschdule__clear);
        cancel3 = findViewById(R.id.cancel3);
        addsch3 = findViewById(R.id.addsch3);
        Button addsch=(Button)findViewById(R.id.addsch3);
        addsch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText EditTextTel = (EditText) findViewById(R.id.newschtitle3);
                String Tel = EditTextTel.getText().toString();

                EditText EditTextTime = (EditText) findViewById(R.id.newschtime3);
                String Time = EditTextTime.getText().toString();

                EditText EditTextRepeat = (EditText) findViewById(R.id.newschrepeat3);
                String Repeat = EditTextRepeat.getText().toString();

                EditText EditTextHint = (EditText) findViewById(R.id.newschhint3);
                String Hint =EditTextHint.getText().toString();

                EditText EditTextMessage = (EditText) findViewById(R.id.newschmessage3);
                String Message = EditTextMessage.getText().toString();

                Bundle bundle = new Bundle();
                bundle.putString("Tel", Tel);
                bundle.putString("Time", Time);
                bundle.putString("Repeat", Repeat);
                bundle.putString("Hint", Hint);
                bundle.putString("Message", Message);

                Intent intent = new Intent();
                intent.setClass(remind_addschdule_Clear.this, remindclear.class);
                intent.putExtras(bundle); //將Bundle物件assign給intent
                startActivity(intent);


            }
        });

        cancel3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }
}
