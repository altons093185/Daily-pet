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

public class dogclean extends AppCompatActivity {
    private ImageView back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_cleandog);

        ExpandableListView expandableListView = findViewById(R.id.EXP4);

        HashMap<String, List<String>> item = new HashMap<>();
        ArrayList<String> content1 = new ArrayList<>();
        content1.add("有些狗狗很不喜歡洗澡，可在洗澡前後給予零食讓他愛上這件事，同時主人要多加溫柔安撫。");


        ArrayList<String> content2 = new ArrayList<>();
        content2.add("有些美容師會在清洗狗狗的同時擠肛門腺，若主人擔心技術不夠好造成亂噴的慘事，可以在毛髮還是乾的時候，一手輕輕拉起尾巴，一手拿衛生紙覆蓋在肛門口，在肛門兩側5點和7點鐘方向推擠即可。\n" +
                "小心如果太用力會造成狗狗不舒服，也不要將肛門面向人臉，不然會發生悲劇。");


        ArrayList<String> content3 = new ArrayList<>();
        content3.add("狗狗體溫比人類高，約在38～39.5゜C，加上沒有汗腺可以排汗，淋浴前主人最好先用手試水溫，溫度落在35゜C左右，也就是我們覺得溫涼的溫度最為適合。\n" +
                "尤其皮膚過敏或搔癢的狗狗水溫更不能太高，否則會讓症狀加劇。先將身體沖濕後再沖頭、尾和四肢。");


        ArrayList<String> content4 = new ArrayList<>();
        content4.add("一手戴上沐浴手套，利用手套搓揉起泡，開始洗澡程序；沒戴手套的手用來清洗眼睛等細微部位。\n" +
                "清洗順序為：頭、臉、耳、身體、腹部、尾巴、屁股、較髒的四肢放在最後洗，容易卡污的指縫不要漏掉了。");


        ArrayList<String> content5 = new ArrayList<>();
        content5.add("跟抹上泡一樣的順序以清水沖洗，要小心眼、耳、鼻不要進水即可，頭部及耳朵可用手將水帶到抹去泡泡，不要用水柱直接沖洗會讓狗狗焦慮，沖到毛髮摸起來有些澀澀的就是沖乾淨了。");


        ArrayList<String> content7 = new ArrayList<>();
        content7.add("長毛的狗狗需要柔順、皮膚較易過敏也可藉由狗狗專用的潤絲精塗抹全身，利用按摩時促進血液循環，約2～3分鐘就可以用清水洗淨。");


        ArrayList<String> content8 = new ArrayList<>();
        content8.add("建議拿可擰乾的吸水毛巾重覆使用，確認狗狗從皮膚到被毛有8～9成乾後再吹毛，可減少吹毛的時程。");


        ArrayList<String> content9 = new ArrayList<>();
        content9.add("可以試試看把吹風機掛在胸前，雙手就能空出，一手固定狗狗、另一手梳毛，縮短吹毛的工程外，毛也會比較蓬。如果覺得不夠熟練，可以先將毛吹8成乾後，梳一梳再吹，會乾得更快也更蓬鬆。\n" +
                "記得腹部與腳趾、趾縫也要吹乾到根根分明。吹風機的溫度也不要太高以免狗狗燙傷。");

        item.put("吹乾毛髮",content9);
        item.put("擦乾毛髮",content8);
        item.put("潤絲護毛",content7);
        item.put("清水沖洗",content5);
        item.put("泡泡浴",content4);
        item.put("打濕毛髮",content3);
        item.put("擠肛門腺",content2);
        item.put("心理建設",content1);

        MyExpandableListAdapter adapter = new MyExpandableListAdapter(item);
        expandableListView.setAdapter(adapter);

        back = findViewById(R.id.back8);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent helpintent = new Intent(dogclean.this, iwanttoknowdog.class);
                startActivity(helpintent);
            }
        });
    }
}
