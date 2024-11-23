package com.cookandroid.capstonedesign;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TabHost;

import androidx.appcompat.app.AppCompatActivity;

public class AcneActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acne);

        Button btn_Back4;
        TabHost th;

            btn_Back4= (Button) findViewById(R.id.btn_Back4);
            th = (TabHost) findViewById(R.id.tabHost);
            th.setup();
            //원인
            TabHost.TabSpec tap1 = th.newTabSpec("CAUSE");
            tap1.setIndicator("원인");
            tap1.setContent(R.id.tab1);
            th.addTab(tap1);
            //증상
            TabHost.TabSpec tap2 = th.newTabSpec("SYMPTOM");
            tap2.setIndicator("증상");
            tap2.setContent(R.id.tab2);
            th.addTab(tap2);
            //치료법
            TabHost.TabSpec tap3 = th.newTabSpec("TREATMENT");
            tap3.setIndicator("치료법");
            tap3.setContent(R.id.tab3);
            th.addTab(tap3);

            th.setCurrentTab(0);
            // 뒤로가기 버튼
            btn_Back4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(),DictionaryActivity.class);
                startActivity(intent); // hoe
            }
        });

    }
}
