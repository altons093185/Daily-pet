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

public class catclean extends AppCompatActivity {
    private ImageView back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_cleancat);

        ExpandableListView expandableListView = findViewById(R.id.EXP9);

        HashMap<String, List<String>> item = new HashMap<>();
        ArrayList<String> content1 = new ArrayList<>();
        content1.add("水溫不能太低或太高，以不燙手〈40—50℃〉為宜；室內保持溫暖，防止貓著涼引起感冒。");


        ArrayList<String> content2 = new ArrayList<>();
        content2.add("所用的洗滌劑刺激性不能太大，以免刺激皮膚；為防止洗澡水進入眼睛，在洗澡前，把貓的眼睛滴上油性眼藥水，以保護眼睛。");


        ArrayList<String> content3 = new ArrayList<>();
        content3.add("長毛貓，洗澡前應將其被毛進行充分梳理，清除脫落的被毛，防止洗時造成糾結，以致要花費更多的時間進行整理。");


        ArrayList<String> content4 = new ArrayList<>();
        content4.add("健康狀態不佳時別洗澡，6月齡以內的小貓容易得病，一般不要洗澡，6月齡以上的貓洗澡次數也不宜太多，一般以每月1次為宜。");


        ArrayList<String> content5 = new ArrayList<>();
        content5.add("沒打疫苗前不能洗澡。因抵抗力低，洗澡容易著涼拉稀以至造成嚴重問題，建議千萬要打過兩針疫苗後的兩周後再洗。");

        ArrayList<String> content6 = new ArrayList<>();
        content6.add("小貓因為淘氣弄得自己很髒的話可以考慮用熱毛巾擦擦，或用刷子刷刷。打過疫苗後就可以給咪咪洗澡了，若是短毛貓可以幾個月洗一次，長毛貓一月一次也足夠了。");


        item.put("洗澡頻率建議",content6);
        item.put("打過疫苗才洗",content5);
        item.put("避免洗澡時期",content4);
        item.put("長毛貓先梳理",content3);
        item.put("低刺激洗滌劑",content2);
        item.put("水溫應該適當",content1);

        MyExpandableListAdapter adapter = new MyExpandableListAdapter(item);
        expandableListView.setAdapter(adapter);

        back = findViewById(R.id.back14);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent helpintent = new Intent(catclean.this, iwanttoknowcat.class);
                startActivity(helpintent);
            }
        });
    }
}
