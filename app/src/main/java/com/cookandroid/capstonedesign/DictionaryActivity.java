package com.cookandroid.capstonedesign;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class DictionaryActivity extends AppCompatActivity {

    Button btn_Acne;
    Button btn_Urticaria;
    Button btn_Allergy;
    Button btn_eczema;
    Button btn_foot;
    Button btn_Back;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dictionary);

         btn_Acne = (Button) findViewById(R.id.btn_Acne);
         btn_Urticaria = (Button) findViewById(R.id.btn_Urticaria);
         btn_Allergy = (Button) findViewById(R.id.btn_Allergy);
         btn_eczema = (Button) findViewById(R.id.btn_eczema);
         btn_foot = (Button) findViewById(R.id.btn_foot);
         btn_Back= (Button) findViewById(R.id.btn_Back);




        //여드름 사전
        btn_Acne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AcneActivity.class);
                startActivity(intent);
            }
        });
        //두드러기 사전
        btn_Urticaria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), UrticariaActivity.class);
                startActivity(intent);
            }
        });
        //알레르기 사전
        btn_Allergy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AllergyActivity.class);
                startActivity(intent);
            }
        });
        // 습진 사전
        btn_eczema.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), EczemaActivity.class);
                startActivity(intent);
            }
        });
        //무좀 사전
        btn_foot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), FootActivity.class);
                startActivity(intent);
            }
        });
        //뒤로가기 버튼
        btn_Back.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(),HomeActivity.class);
                startActivity(intent); // hoe
            }
        });


    }
}
