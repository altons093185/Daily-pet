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

public class doghealty extends AppCompatActivity{
    private ImageView back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_doghealty);

        ExpandableListView expandableListView = findViewById(R.id.EXP3);

        HashMap<String, List<String>> item = new HashMap<>();
        ArrayList<String> content1 = new ArrayList<>();
        content1.add("看犬是否活潑，對外界的反應是否正常，有無異常的神態等。健康犬活潑、敏捷，見到主人頻頻搖尾，以示親近，對外界的刺激反應靈敏。\n" +
                "如果犬頭似尾垂，表情冷淡，呆立不動或縮於牆角，反應遲鈍，即為生病的表現。");

        item.put("從精神判斷",content1);

        ArrayList<String> content2 = new ArrayList<>();
        content2.add("看犬有無食欲，食量多少，有天挑食或拒食等表現，健康大食欲旺盛，每到餵食時非常興奮，常圍著主人打轉，採食迅速，食量較穩定，不挑不揀。\n" +
                "而病犬則食欲不振，食欲減少，喜飲冷水或清水，挑揀食物或拒食。");

        item.put("從食欲判斷",content2);

        ArrayList<String> content3 = new ArrayList<>();
        content3.add("看犬站、臥、坐等姿態有無異常，運動時有否跛行、步態蹣跚或肢體麻痹等症狀。健康犬作各種姿勢時自然、輕快，能聽從口令。\n" +
                "而病犬則不大執行口令，各種姿態不自然，強迫執行命令時有痛苦表現。");

        item.put("從姿態判斷",content3);

        ArrayList<String> content4 = new ArrayList<>();
        content4.add("看犬的被毛有無脫落，皮膚的彈性強度，皮膚上有無皮疹、水皰、痂皮和潰瘍等。\n" +
                "健康犬的被毛光滑，有光澤，皮膚彈性良好，若犬的被毛不斷脫落，粗糙無光擇，皮膚乾燥，缺乏彈性，或見結癡和潰瘍等缺損則為病犬。");

        item.put("從皮膚判斷",content4);

        ArrayList<String> content5 = new ArrayList<>();
        content5.add("看犬的兩眼是否有神，有無流淚，角膜有無混濁，眼角處有無眼屎或分泌物等。健康犬兩眼有神，眼周乾淨，無眼屎，不流淚，結膜粉紅。\n" +
                "如見犬雙眼無神、眼周不潔、結膜發紅等，則可能與眼病或消化不良等病相關。");

        item.put("從眼睛判斷",content5);

        MyExpandableListAdapter adapter = new MyExpandableListAdapter(item);
        expandableListView.setAdapter(adapter);

        back = findViewById(R.id.back7);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent helpintent = new Intent(doghealty.this, iwanttoknowdog.class);
                startActivity(helpintent);
            }
        });
    }
}
