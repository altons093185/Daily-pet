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

public class dogbeheavior extends AppCompatActivity {
    private ImageView back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_dogbehavior);

        ExpandableListView expandableListView = findViewById(R.id.EXP5);

        HashMap<String, List<String>> item = new HashMap<>();
        ArrayList<String> content1 = new ArrayList<>();
        content1.add("根據狗訓練師和行為專家的說法，這個問題的一部分可能在於觸發詞，例如“你想去散步嗎？”正如解釋的那樣，有時像你這樣的短語“在你的狗裡製造混亂和瘋狂”甚至在步行開始之前。\n" +
                "         解決方案是在走路前靜靜地放置你的狗的皮帶，不使用觸發詞。一旦你的狗被牽引，引導她在房子周圍幾分鐘。最後，在項圈被夾住的時間和實際離開散步的時間之間留出一些空間。");


        ArrayList<String> content2 = new ArrayList<>();
        content2.add("由於許多原因，狗轉向破壞性咀嚼，但主要的是厭倦和過度的能量。\n" +
                "         第一步是確保你的狗是給予適當的咀嚼玩具，在你獨自離開的時候讓你的小狗有可咀嚼珍貴的玩具是更好的選擇。\n" +
                "         最重要的是要確保你的狗“進行大量的體育鍛煉和精神刺激”。");


        ArrayList<String> content3 = new ArrayList<>();
        content3.add("狗在幼犬期後繼續在室內尿尿嗎？首先，排除任何身體問題。狗行為專家建議不適當的排尿可能是泌尿系統感染等問題的標誌，所以一定要讓你的狗進行獸醫檢查。\n" +
                "        如果問題不是身體問題，那麼狗可能會在室內撒尿的原因，包括壓力、焦慮或以前家中的學習行為等多種原因。不管是什麼原因，建議“從頭開始訓練”是一個不錯的選擇。");


        ArrayList<String> content4 = new ArrayList<>();
        content4.add("根據獸醫和專家動物行為學家的說法，你需要從狗的角度來看這個場景。當他服從你的命令“來”時，代表牠的樂趣就此結束了。遵守命令並不是一個很好的獎勵！\n" +
                "        為了幫助你的狗回憶起來，建議教狗進入較小的區域，然後再在像狗公園等分散注意力的區域進行嘗試。一旦你進入了更多分心的區域，你需要教你的小狗，當被叫時並不一定意味著結束有趣的活動。一旦進入一個分散注意力的區域，請讓你的狗來，如果牠遵守，就誇獎牠，然後立即說“去玩”，讓牠回到有趣的遊戲環節。 這樣牠以後就不會覺得被叫就代表不能繼續玩耍了。");


        ArrayList<String> content5 = new ArrayList<>();
        content5.add("這是最重要的一個。經常有過度吠叫的原因有時候可能是好的，例如保護自己的領地。但在你努力工作或放鬆的時候，聽到你的狗叫聲絕對是一件令人討厭的事情。\n" +
                "        培訓師提醒我們，我們需要明白吠叫是狗交流的方式。如果你的狗吠叫成問題，我們“需要弄清楚為什狗在吠叫，並且是在什麼情況下吠叫，然後積極和人道地解決問題。”\n" +
                "        因此，你的狗吠叫的原因有很多很多，你如何處理它將取決於原因。例如，如果你的狗因為想要的東西而吠叫，就教她吠叫不會導致獎勵（無論是注意力，感情還是款待）。\n" +
                "        如果你的狗得知牠的行為沒辦法得到想要的東西，牠可能會意識到吠叫不會導致任何積極的東西並停止吠叫。\n" +
                "        如果你的狗在門口有人吠叫，這是一種標記和保衛她的領土的方式。建議使用餅乾之類的正強化來“告訴牠，經過幾次吠叫，牠的工作就是跑到遠離門的指定區域。”通過練習，這可以減少門鈴的吠叫。\n" +
                "        你的狗的吠叫也可能是出於恐懼的動機。如果你的狗吠叫的原因是以恐懼為基礎，“與專業的獎勵培訓師合作，幫助你的狗了解牠是安全的，你會照顧他。”");

        item.put("胡亂吠叫",content5);
        item.put("不聽你的召喚",content4);
        item.put("尿尿在室內",content3);
        item.put("亂咬家具",content2);
        item.put("愛拉扯項圈",content1);

        MyExpandableListAdapter adapter = new MyExpandableListAdapter(item);
        expandableListView.setAdapter(adapter);

        back = findViewById(R.id.back9);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent helpintent = new Intent(dogbeheavior.this, iwanttoknowdog.class);
                startActivity(helpintent);
            }
        });
    }
}
