package com.cookandroid.capstonedesign;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class QAActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        Button btn_Back5;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qa);

        btn_Back5 = (Button) findViewById(R.id.btn_Back5);

        btn_Back5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(),MypageActivity.class);
                startActivity(intent);
            }
        });


    }

}
