package com.cookandroid.capstonedesign;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MypageActivity extends AppCompatActivity {

    Button btn_Myinfo, btn_QA, btn_Back2;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypage);

         btn_Myinfo = (Button) findViewById(R.id.btn_Myinfo);
         btn_QA = (Button) findViewById(R.id.btn_QA);
         btn_Back2 = (Button) findViewById(R.id.btn_Back2);

       //myinfo 버튼
        btn_Myinfo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(),MyinfoActivity.class);
                startActivity(intent);
            }
        });
        //QA버튼
        btn_QA.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(),QAActivity.class);
                startActivity(intent);
            }
        });
        //뒤로가기버튼
        btn_Back2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(),HomeActivity.class);
                startActivity(intent);
            }
        });
    }
}
