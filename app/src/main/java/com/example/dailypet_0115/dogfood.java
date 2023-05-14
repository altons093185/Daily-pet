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

public class dogfood extends AppCompatActivity {
    private ImageView back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_knowdogfood);

        ExpandableListView expandableListView = findViewById(R.id.EXP2);

        HashMap<String, List<String>> item = new HashMap<>();
        ArrayList<String> content1 = new ArrayList<>();
        content1.add("        雖然狗狗和我們一樣是雜食動物，但是千萬要記得有些食物是千萬不能讓他們吞下肚的。\n" +
                "例如：可能引發溶血性貧血的洋蔥、造成急性腎衰竭的葡萄；因為不小心吃到巧克力、茶葉或是蘋婆而出現神經症狀的狗兒也不在少數。\n" +
                "此外，太油或太鹹的飲食也會造成狗狗的健康負擔。因此建議在和狗兒一起吃飯時，務必要斟酌食材以及選擇少油少鹽的調理方式哦。");

        item.put("人沒吃完的飯菜，分給狗狗吃一些應該沒關係？",content1);

        ArrayList<String> content2 = new ArrayList<>();
        content2.add("最不好的缺點就是有飼料不新鮮的問題。在寒冷的冬天可能不那麼明顯，然而尤其是在夏天，食物不趕緊吃完很快就會開始發酵腐敗，另外，吃到飽的飲食模式也會養成寵物不珍惜食物、越來越挑食的壞習慣，更不用說任食制會讓大胃王型的毛孩子體重直線上升。\n" +
                "         要讓毛小孩養成良好的飲食習慣，最重要還是回歸定食定量的模式，早晚的餵食時間到了，給予飼料後大約十分鐘內沒有吃完的話就收起來，讓寵物明白現在這個時間就是吃飯的時間，這樣不只能夠掌握寵物的進食狀況，久了以後他們自然會理解進而養成好習慣。");

        item.put("不在家的時候把飼料倒好倒滿以免寵物餓到？",content2);

        ArrayList<String> content3 = new ArrayList<>();
        content3.add("「護食」是狗狗本能的行為。在原始的自然環境中，是否具備搶到食物的本事可是攸關存活的頭等大事，即使被人類馴化了，狗狗依然保有護食的本能。\n" +
                "所以當狗狗出現護食行為，家長別先解讀為是狗狗不乖、不好，而是應該理解這對他們來說是一種直覺反應，建議主人請教專業的動物行為專家，而不是一昧的打罵喔。");

        item.put("狗狗護食是他不乖，一定要好好罵一罵才不會太囂張？",content3);

        MyExpandableListAdapter adapter = new MyExpandableListAdapter(item);
        expandableListView.setAdapter(adapter);

        back = findViewById(R.id.back6);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent helpintent = new Intent(dogfood.this, iwanttoknowdog.class);
                startActivity(helpintent);
            }
        });
    }
}

