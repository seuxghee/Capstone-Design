package com.cookandroid.capstonedesign;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {

    Button btn_AI;
    Button btn_dic;
    Button btn_map;
    Button btn_myinfo;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

         btn_AI = (Button) findViewById(R.id.btn_AI);
         btn_dic = (Button) findViewById(R.id.btn_dic);
         btn_map = (Button) findViewById(R.id.btn_map);
         btn_myinfo = (Button) findViewById(R.id.btn_myinfo);

        //AI카메라 액티비티로 이동
        btn_AI.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(), CameraActivity.class);
                startActivity(intent);
            }
        });
        //피부과 사전 액티비티로 이동
        btn_dic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), DictionaryActivity.class);
                startActivity(intent);
            }
        });
        //피부과 지도 액티비티로 이동
        btn_map .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MapActivity.class);
                startActivity(intent);
            }
        });
        //Mypage 액티비티로 이동
        btn_myinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MyinfoActivity.class);
                startActivity(intent);
            }
        });
    }
}
