package com.example.dailypet_0115;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class remindclear extends AppCompatActivity {
private ImageButton img_btn_clean;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remindclear);
        Bundle bundle =this.getIntent().getExtras();
        if(bundle!=null) {
            String Tel = bundle.getString("Tel");
            String Time = bundle.getString("Time");
            String Repeat = bundle.getString("Repeat");
            String Hint = bundle.getString("Hint");
            String Message = bundle.getString("Message");
            TextView tv1 = (TextView) findViewById(R.id.reclear01);
            TextView tv2 = (TextView) findViewById(R.id.reclear02);
            TextView tv3 = (TextView) findViewById(R.id.reclear03);
            TextView tv4 = (TextView) findViewById(R.id.reclear04);
            TextView tv5 = (TextView) findViewById(R.id.reclear05);
            tv1.setText("標題: " + Tel);
            tv2.setText("選擇時間: " + Time);
            tv3.setText("重複: " + Repeat);
            tv4.setText("提示: " + Hint);
            tv5.setText("附註: " + Message);
        }
        img_btn_clean=findViewById(R.id.img_btn_clean);



        img_btn_clean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent addsch_int = new Intent(remindclear.this,remind_addschdule_Clear.class);
                startActivity(addsch_int);
            }
        });
    }
}
