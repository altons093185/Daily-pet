package com.example.dailypet_0115;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class cathealty extends AppCompatActivity {
    private ImageView back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_cathealty);

        ExpandableListView expandableListView = findViewById(R.id.EXP8);

        HashMap<String, List<String>> item = new HashMap<>();
        ArrayList<String> content1 = new ArrayList<>();
        content1.add("有病的貓常表現為無精打采、喜臥、眼睛無神或半閉。對聲音或外來刺激反應遲鈍，病情越重，反應越弱，甚至出現昏迷、各種反射消失（如瞳孔對光反射）等情況。\n" +
                "        有的也可能出一種相反的精神異常，即貓興奮不安，轉圈，亂咬東西，亂叫，狂躁等。\n" +
                "        營養狀況病貓往往背毛粗亂、焦幹、缺乏光澤，消瘦，無力。健康貓通常被毛乎順而富有不澤，肌肉豐滿健壯。");


        ArrayList<String> content2 = new ArrayList<>();
        content2.add("體溫除可直接用體溫表測量外，一般情況下，可觀察貓的鼻端，如鼻端乾燥則是體溫高的表現。此外，耳根部、體表皮溫變化也可以作為體溫的參考依據。\n" +
                "        一般健康貓體溫為 38.0-39.5 ℃ 。貓一旦出現體溫升高則往往伴有口渴、精神不振、動作遲鈍、食慾減退等現象。");


        ArrayList<String> content3 = new ArrayList<>();
        content3.add("貓站立、躺臥、步行、跳躍時的姿態異常也是貓患病的一種症比如貓四肢疼痛往往行走時出現跛行，站立時姿勢不正貓腹疼時則常蜷縮身體，頭放在腹下和不自然的躺臥姿勢。");


        ArrayList<String> content4 = new ArrayList<>();
        content4.add("貓正常的呼吸次數為每分鐘20 次～ 30 次。如果呼吸次數則加或減少，同時出出呼吸困難、鼻孔張大、甚至張口呼吸、腹部扇動，就說明可能患有呼吸系統疾病或其它全身性疾患。\n" +
                "        不過要注意區別季節、氣溫，以及活動量改變而引起的貓正常生理性呼吸的變化。");


        ArrayList<String> content5 = new ArrayList<>();
        content5.add("病貓一般都有不同程度的厭食和拒食現象。當然，這裡應注意與貓的挑食習性相區別，留心貓的飲水量。\n" +
                "        如貓發燒或腹瀉脫水時飲水量常會增加，但病重或嚴重衰竭時飲水量減少，甚至不飲水。");


        item.put("食慾",content5);
        item.put("呼吸",content4);
        item.put("姿態",content3);
        item.put("體溫",content2);
        item.put("精神狀態",content1);

        MyExpandableListAdapter adapter = new MyExpandableListAdapter(item);
        expandableListView.setAdapter(adapter);

        back = findViewById(R.id.back13);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent helpintent = new Intent(cathealty.this, iwanttoknowcat.class);
                startActivity(helpintent);
            }
        });
    }
}
