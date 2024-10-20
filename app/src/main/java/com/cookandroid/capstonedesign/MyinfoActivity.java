package com.cookandroid.capstonedesign;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MyinfoActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {

        EditText txt_Name, txt_Phone, txt_Id, txt_Email, txt_Password, txt_PasswordCrm;
        Button btn_Reset, btn_Modify, btn_Back3;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myinfo);

        btn_Reset = (Button) findViewById(R.id.btn_Reset );
        btn_Modify = (Button) findViewById(R.id.btn_Modify);
        btn_Back3 = (Button) findViewById(R.id.btn_Back3);
        txt_Name = (EditText) findViewById(R.id.txt_Name);
        txt_Phone = (EditText) findViewById(R.id.txt_Phone);
        txt_Id = (EditText) findViewById(R.id.txt_Id);
        txt_Email = (EditText) findViewById(R.id.txt_Email);
        txt_Password = (EditText) findViewById(R.id.txt_Password);
        txt_PasswordCrm = (EditText) findViewById(R.id.txt_PasswordCrm);

        btn_Back3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(),MypageActivity.class);
                startActivity(intent);
            }
        });
        btn_Reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt_Name.setText("");
                txt_Phone.setText("");
                txt_Id.setText("");
                txt_Email.setText("");
                txt_Password.setText("");
                txt_PasswordCrm.setText("");

            }
        });



    }
}
