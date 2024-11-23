package com.cookandroid.capstonedesign;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MypageActivity extends AppCompatActivity {

    Button  btn_QA, btn_Back2;
    TextView txtUserId;

    SQLHelper dbHelper;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypage);

        btn_QA = (Button) findViewById(R.id.btn_QA);
        btn_Back2 = (Button) findViewById(R.id.btn_Back2);
        txtUserId = (TextView) findViewById(R.id.txtUserId);

        Intent  myPageIntent = getIntent();
        String id =  myPageIntent.getStringExtra("userId");

        txtUserId.setText("user_id : " + id);
        // SQLHelper 초기화
        dbHelper = new SQLHelper(this);

        //QA버튼
        btn_QA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), QAActivity.class);
                startActivity(intent);
            }
        });
        //뒤로가기버튼
        btn_Back2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                startActivity(intent);
            }
        });
    }
}
