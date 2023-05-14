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

public class donotdothistodog extends AppCompatActivity {
    private ImageView back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_dontdothistodog);

        ExpandableListView expandableListView = findViewById(R.id.EXP6);

        HashMap<String, List<String>> item = new HashMap<>();
        ArrayList<String> content1 = new ArrayList<>();
        content1.add("在溫暖的天氣時，沒有冷氣的車子內部環境就會像溫室一樣(無論有沒有開窗戶)，導致你的狗狗在裡頭過熱、中暑，嚴重時會導致狗狗死亡。\n" +
                "相反的，在寒冷的季節時，車子就會像一台冰箱，同樣會導致狗狗不舒服。無論如何，千萬不要單獨將狗狗留在車子裡。");


        ArrayList<String> content2 = new ArrayList<>();
        content2.add("雖然平日都應該讓狗狗有空到外頭走走，天氣溫和時也可以在讓它在院子裡活動，但絕對不能一年到頭都強迫狗狗住在戶外。\n" +
                "狗狗需要人類的互動跟關愛，一直養在庭院而不跟它互動的話，它會變成一隻不快樂的狗，這對它來說既不公平也不健康。");


        ArrayList<String> content3 = new ArrayList<>();
        content3.add("雖然獸醫都會囑咐狗爸媽記得幫寶貝刷牙，但實際上有做到了卻是相當少數。除此之外，很多患有初期牙周病的狗狗並沒有接受治療。\n" +
                "記得一定要每年至少讓獸醫檢查一次牙齒，並且建立刷牙的習慣。");


        ArrayList<String> content4 = new ArrayList<>();
        content4.add("打它來做為懲罰是不對的。這會傷害到你們之間的關係，導致你更無法好好訓練它。\n" +
                "當你打狗的時候，你反而是教它害怕你、不信任你，並且削弱它的自信心。沒有安全感的狗狗會更容易在暴力的對待下 表現出攻擊性。");


        ArrayList<String> content5 = new ArrayList<>();
        content5.add("狗狗其實也是有感覺的，它們有情感，也了解情感。最近的研究顯示，狗狗跟人類一樣都能體會愛，也能依據人類的表情來讀出情緒。\n" +
                "它們的確能夠愛人、感覺被愛、會沮喪，也會感到興奮。訓斥狗狗或是故意惹惱它，久了會導致它情感受傷喔！");

        ArrayList<String> content6 = new ArrayList<>();
        content6.add("雖然聽起來很無腦，但真的有很多狗爸媽自以為能夠靠網絡上的資訊來診斷狗狗的病，甚至自己買藥回去給狗用。\n" +
                "雖然平常多上網了解寵物相關的醫療知識是好事，但如果狗狗已經有健康上的問題時，直接帶它去找獸醫是最好的方法。");


        ArrayList<String> content7 = new ArrayList<>();
        content7.add("如果狗狗又叫又跳時，你把它帶去關在狗籠里是不對的。事實上這會讓它覺得狗籠是個不好的地方，而不是把它當作一個安全的避風港。\n" +
                "在籠內訓練中，我們希望狗狗對狗籠有正向的聯想，所以千萬不要用狗籠來懲罰它 。");

        item.put("不當的關籠",content7);
        item.put("不帶狗狗去看獸醫",content6);
        item.put("誤以為你的狗狗沒有情感上的感受",content5);
        item.put("動手打狗",content4);
        item.put("忽視狗狗的牙齒問題",content3);
        item.put("讓狗狗住在房子外",content2);
        item.put("讓狗狗獨自待在車內",content1);

        MyExpandableListAdapter adapter = new MyExpandableListAdapter(item);
        expandableListView.setAdapter(adapter);

        back = findViewById(R.id.back10);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent helpintent = new Intent(donotdothistodog.this, iwanttoknowdog.class);
                startActivity(helpintent);
            }
        });
    }
}
