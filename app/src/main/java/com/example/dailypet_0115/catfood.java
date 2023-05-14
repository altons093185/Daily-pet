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

public class catfood extends AppCompatActivity {
    private ImageView back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_knowcatfood);

        ExpandableListView expandableListView = findViewById(R.id.EXP7);

        HashMap<String, List<String>> item = new HashMap<>();
        ArrayList<String> content1 = new ArrayList<>();
        content1.add("關鍵在於這些植物中一種名為「烯丙基丙基二硫醚」(allyl propyl disulfide)的化合物，它對人類的影響很小，頂多讓你流眼淚；對貓咪卻有致命危害，無論煮過沒煮過都一樣，吃下肚子便會破壞紅血球，造成嚴重的貧血症。");


        ArrayList<String> content2 = new ArrayList<>();
        content2.add("人類常吃的補品，由於一顆藥丸對貓咪來說往往劑量過大，反而會帶來致命的效果。特別是熱門的抗藥化藥物硫辛酸(α-lipoic acid)，更是不能讓貓咪嚐到喔！");


        ArrayList<String> content3 = new ArrayList<>();
        content3.add("應該不會有人餵貓咪喝酒啦，但是酒精飲料也是相當危險的；一般來說，每公斤體重只要5-8毫升的酒精，就有可能導致嚴重的酒精中毒。");


        ArrayList<String> content4 = new ArrayList<>();
        content4.add("酪梨果肉、果皮部位皆含有persin毒素，這對人類的影響很小，卻會造成貓咪腸胃不適、嘔吐、腹瀉、心臟周圍組織積水，嚴重時甚至會導致死亡。");


        ArrayList<String> content5 = new ArrayList<>();
        content5.add("不對呀，貓咪不是很喜歡鮪魚嗎？嗯～沒錯，但是吃多了有可能導致黃脂症，這是因為飲食中過多不飽和脂肪酸和維生素E不足導致；所以如果要給貓咪吃鮪魚，當作獎勵比較好。\n" +
                "        另外，長期吃生魚片會造成維生素B1攝取不足，可能導致食慾不振、癲癇等問題，最嚴重會導致死亡。");

        ArrayList<String> content6 = new ArrayList<>();
        content6.add("生雞蛋裡含有抗生物素酶，它會降低維生素B的吸收，導致貓咪皮膚、毛髮出現問題。而且生雞蛋裡也可能含有沙門氏菌，會造成嚴重腹瀉及嘔吐。");


        ArrayList<String> content7 = new ArrayList<>();
        content7.add("糖會導致蛀牙、肥胖、糖尿病問題；過量攝取鹽分也會增加腎臟負荷，導致電解質失衡。\n" +
                "其他像是辣椒、醬油、胡椒更是萬萬不可喔！貓咪會因為口味新奇而去舔鹹酥雞的袋子，也要立刻阻止牠們。");

        ArrayList<String> content8 = new ArrayList<>();
        content8.add("大家都知道貓咪不能吃巧克力，因為裡面含有巧克力鹼，一旦進入血液就會使牠們變得超亢奮、口渴；但過幾個小時後，攝取巧克力的貓咪就會開始嘔吐、腹瀉，最後心臟病發作。\n" +
                "而咖啡和茶因為含有咖啡因，屬於一種興奮劑，劑量過多可能致死。");


        ArrayList<String> content9 = new ArrayList<>();
        content9.add("蘋果籽、梨籽及許多核果的果仁都含有氰苷，可能導致氰化物中毒。特別要注意的是「杏仁小魚乾」，大多數貓咪對小魚乾沒甚麼抵抗力，常常會偷咬開包裝來吃，要是不小心吃了太多杏仁那可就不妙啦！");


        ArrayList<String> content10 = new ArrayList<>();
        content10.add("發酵中的生麵團會使貓咪的胃部膨脹、疼痛，嚴重時更有可能導致內臟破裂。所以像蛋糕、麵包等烘焙品中多含有酵母，最好都不要給貓咪吃。");

        ArrayList<String> content11 = new ArrayList<>();
        content11.add("老一輩人都以為貓咪很會啃骨頭，其實不然。牠們會傻傻地把骨頭咬成碎片吞下肚，結果就是食道、胃、腸等消化器官被刺穿。");


        ArrayList<String> content12 = new ArrayList<>();
        content12.add("隨著年齡漸長，貓咪的尿液會越來越偏酸性，同時草酸鈣也會逐漸累積。草酸鈣是甚麼呢？就是我們腎結石、尿道結石的主要成分，為了避免貓咪也碰到這種痛苦，盡可能不要讓牠們吃下菠菜等會讓尿路草酸增加的食物喔！");

        item.put("菠菜",content12);
        item.put("雞骨、魚骨",content11);
        item.put("酵母麵團",content10);
        item.put("蘋果籽、李子、杏仁",content9);
        item.put("巧克力、咖啡、茶",content8);
        item.put("任何調味料",content7);
        item.put("生雞蛋",content6);
        item.put("鮪魚、生魚片",content5);
        item.put("酪梨",content4);
        item.put("酒精飲料",content3);
        item.put("維他命等營養補充劑",content2);
        item.put("蔥、洋蔥、大蒜、韭菜及任何百合科植物",content1);

        MyExpandableListAdapter adapter = new MyExpandableListAdapter(item);
        expandableListView.setAdapter(adapter);

        back = findViewById(R.id.back12);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent helpintent = new Intent(catfood.this, iwanttoknowcat.class);
                startActivity(helpintent);
            }
        });
    }
}
