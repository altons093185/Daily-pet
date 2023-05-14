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

public class catbehavior extends AppCompatActivity {
    private ImageView back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_catbehavior);

        ExpandableListView expandableListView = findViewById(R.id.EXP10);

        HashMap<String, List<String>> item = new HashMap<>();
        ArrayList<String> content1 = new ArrayList<>();
        content1.add("貓用鼻子貼鼻子來表達友好");


        ArrayList<String> content2 = new ArrayList<>();
        content2.add("貓慢慢地眨眼是說喜歡你");


        ArrayList<String> content3 = new ArrayList<>();
        content3.add("豎尾巴是撒嬌，左右搖動尾巴是不耐煩，尾巴尖小幅擺動表示輕鬆和趣味盎然，露出腹部表示「別再碰我」");


        ArrayList<String> content4 = new ArrayList<>();
        content4.add("對高4音階「咪」感到興奮， 因為貓求愛的聲音就是這個「咪」的音");


        ArrayList<String> content5 = new ArrayList<>();
        content5.add("啃咬是貓性行為的動作之一，貓撲咬主人要向對方傳達熱情和「我愛你」");

        ArrayList<String> content6 = new ArrayList<>();
        content6.add("大都討厭孩子，討厭嘈雜、喧鬧、陌生的地方");

        ArrayList<String> content7 = new ArrayList<>();
        content7.add("貓只讓心裡最信任的人抱著，抱一小會兒");


        ArrayList<String> content8 = new ArrayList<>();
        content8.add("貓只會按照自己的意志行事，不接受人類的命令，只接受建議");


        ArrayList<String> content9 = new ArrayList<>();
        content9.add("貓理解不了你的憤怒，打罵糾正不了惡習除非當場。訓斥貓時它們轉過臉，是不想和處於怒火中的你對視");


        ArrayList<String> content10 = new ArrayList<>();
        content10.add("看到主人沒有捕捉獵物，會擔心他在餓肚子，於是會懷著媽媽的心情，給主人帶來獵物。同時它們會沉浸在「小菜一碟」的沽沾自喜中，並為自己給了你充足的母愛而感到心滿意足");

        ArrayList<String> content11 = new ArrayList<>();
        content11.add("貓打呼嚕不只是表達愛意，更多是「我很不舒服、感到很不安全，請在我身邊守護我」的依賴，因此打呼嚕過多的貓可能健康出了問題");


        item.put("打呼嚕",content11);
        item.put("給主人帶來獵物",content10);
        item.put("不能理解",content9);
        item.put("行事",content8);
        item.put("抱",content7);
        item.put("討厭",content6);
        item.put("啃咬",content5);
        item.put("高4音階「咪」",content4);
        item.put("尾巴",content3);
        item.put("慢慢地眨眼",content2);
        item.put("貼鼻子",content1);

        MyExpandableListAdapter adapter = new MyExpandableListAdapter(item);
        expandableListView.setAdapter(adapter);

        back = findViewById(R.id.back15);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent helpintent = new Intent(catbehavior.this, iwanttoknowcat.class);
                startActivity(helpintent);
            }
        });
    }
}
