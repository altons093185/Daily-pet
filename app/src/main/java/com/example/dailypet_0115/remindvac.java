package com.example.dailypet_0115;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class remindvac extends AppCompatActivity {
private ImageButton img_btn_vac;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remindvac);

        Bundle bundle =this.getIntent().getExtras();
        if(bundle!=null) {
            String Tel = bundle.getString("Tel");
            String Time = bundle.getString("Time");
            String Repeat = bundle.getString("Repeat");
            String Hint = bundle.getString("Hint");
            String Message = bundle.getString("Message");
            TextView tv1 = (TextView) findViewById(R.id.revac01);
            TextView tv2 = (TextView) findViewById(R.id.revac02);
            TextView tv3 = (TextView) findViewById(R.id.revac03);
            TextView tv4 = (TextView) findViewById(R.id.revac04);
            TextView tv5 = (TextView) findViewById(R.id.revac05);
            tv1.setText("標題: " + Tel);
            tv2.setText("選擇時間: " + Time);
            tv3.setText("重複: " + Repeat);
            tv4.setText("提示: " + Hint);
            tv5.setText("附註: " + Message);
        }
        img_btn_vac=findViewById(R.id.img_btn_vac);

        img_btn_vac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent addsch_int = new Intent(remindvac.this,remind_addschdule_Vac.class);
                startActivity(addsch_int);
            }
        });
    }
}
