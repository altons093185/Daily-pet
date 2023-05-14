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

public class donotdothistocat extends AppCompatActivity {
    private ImageView back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_dontdothistocat);

        ExpandableListView expandableListView = findViewById(R.id.EXP11);

        HashMap<String, List<String>> item = new HashMap<>();
        ArrayList<String> content1 = new ArrayList<>();
        content1.add("貓咪躲起來的時候，可能是因為害怕或想獨自靜一靜。當貓咪因「害怕」躲起來的時候，請耐心等牠卸下心防再跟牠玩，就讓牠獨處吧！\n" +
                "        還有，如果能事先為愛貓準備安全的避難場所，例如大小剛好的紙箱、貓窩，當牠感到害怕或討厭的人事物出現時，就可以從容地躲起來。");


        ArrayList<String> content2 = new ArrayList<>();
        content2.add("貓看到討厭的人或害怕的人逃走時，如果因為好玩而追著牠跑，此刻牠的內心會更加恐慌。如此一來，牠會更討厭這個人。\n" +
                "        為了帶愛貓看病，硬是把牠抓起來關進貓籃裡時，貓咪可能因此視主人為可怕的人。你應該平常就讓牠習慣待在貓籃裡，再給牠喜歡的玩具，這樣牠就不會害怕了。");


        ArrayList<String> content3 = new ArrayList<>();
        content3.add("膽小貓對於大聲響或突然的動作最敏感。譬如你突然站起來或打噴涕嚇到牠，牠就會在無形中產生警戒心。尤其男人的動作都很粗魯，嗓門也大，常會嚇到貓咪。\n" +
                "        動作儘量輕柔，不要嚇到愛貓。還有，當愛貓因聲音或動作被嚇到時，就讓牠放心地逃跑，並躲起來。曾經不小心嚇過貓的人，不妨跟牠喜歡的人一起餵牠吃東西，產生正面連結，慢慢地讓牠知道，你不是那麼可怕的人。");


        ArrayList<String> content4 = new ArrayList<>();
        content4.add("當你不小心踩到愛貓尾巴，讓牠覺得痛的時候，剛開始會對你有所警戒，但時間久了，牠應該會原諒你。\n" +
                "        因為幫貓治病或餵藥，讓牠有了痛苦回憶時，只要事後溫柔對待牠，貓咪就會忘記這件事。");


        ArrayList<String> content5 = new ArrayList<>();
        content5.add("當愛貓走過來要你抱牠時，你不理牠；牠想一個人獨處時，你卻硬抓牠出來，逼牠跟你玩……這些行為都會讓貓咪很不舒服。牠希望你抱牠，你卻不理牠，牠的心當然會受到傷害。可是當牠不想被抱時，你卻硬要抱牠，此時牠的壓力可是比前者大！如果你發現自己每次抱牠時，牠就出現緊張提防的態度，那你該自我反省了。\n" +
                "        貓是可以獨居的動物，相當重視自我。牠想被抱的時候才抱牠，不想被抱時就讓牠獨處，這才是最理想的相處模式。請仔細觀察愛貓的態度，解讀牠的想法，儘量配合牠。");

        ArrayList<String> content6 = new ArrayList<>();
        content6.add("如果你平常很疼愛貓，總是溫柔對待的話，就算罵牠，牠也不會被你嚇到。可是，如果是超級膽小的貓咪，只要你大聲責備牠，從此牠會認定你就是可怕的主人。\n" +
                "        想阻止愛貓惡作劇的話，為了不讓愛貓討厭主人，你最好裝作沒看到牠在耍壞。當愛貓惡作劇的瞬間，不要讓牠看見，從牠背後噴水，或是把牠趕到牠不想待的地方，牠自然就會心情平靜，不會再吵鬧。");

        ArrayList<String> content7 = new ArrayList<>();
        content7.add("貓會對常與牠接觸的人產生好感，如果你將照顧愛貓的工作委託其他家人，很少跟愛貓相處的話，牠當然不會跟你親近。至於愛貓會把你當成「危險人物」或「空氣」，就要視其性格而定。\n" +
                "        愛貓對你有所警戒，不想與你親近時，若想改善關係，就從餵牠吃飯開始。重點就是要讓牠習慣有你這號人物的存在。");


        ArrayList<String> content8 = new ArrayList<>();
        content8.add("當貓咬主人，要主人給牠飯吃，主人馬上餵牠吃飯的話，牠就會記住「只要咬主人，就能有求必應。」如果你一直對愛貓有求必應，哪一天沒有順應牠的要求，牠可能會攻擊你。\n" +
                "        你一定要讓愛貓知道，用咬人方式來要求，是「無效」的行為。首先，當牠希望你抱牠時，故意發出聲音，假裝在做事情不理牠。不要對牠有求必應，用餐時間應該由主人決定，不是愛貓決定，你要擺出主人應有的態度。");


        item.put("每次都有求必應",content8);
        item.put("你們的相處時間短",content7);
        item.put("曾經嚴厲責備愛貓",content6);
        item.put("不顧愛貓感受硬要抱牠",content5);
        item.put("愛貓對你留有痛苦的回憶",content4);
        item.put("突如其來的動作或大聲響嚇到牠了",content3);
        item.put("愛貓逃走你卻追著牠跑",content2);
        item.put("愛貓躲起來了，卻硬抓牠出來",content1);

        MyExpandableListAdapter adapter = new MyExpandableListAdapter(item);
        expandableListView.setAdapter(adapter);

        back = findViewById(R.id.back16);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent helpintent = new Intent(donotdothistocat.this, iwanttoknowcat.class);
                startActivity(helpintent);
            }
        });
    }
}
