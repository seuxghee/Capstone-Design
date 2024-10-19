package com.cookandroid.capstonedesign;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MemberActivity extends AppCompatActivity {

    Button btn_Registor, btn_Back, btn_Reset;
    EditText txtId, txtEmail, txtPw, txtPwc;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member);

         btn_Registor = (Button) findViewById(R.id.btn_Registor);
         btn_Reset = (Button) findViewById(R.id.btn_Reset);
         btn_Back = (Button) findViewById(R.id.btn_Back);


         txtId = (EditText) findViewById(R.id.txtId);
         txtEmail = (EditText) findViewById(R.id.txtEmail);
         txtPw = (EditText) findViewById(R.id.txtPw);
         txtPwc = (EditText) findViewById(R.id.txtPwc);

        btn_Registor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                startActivity(intent);
            }

        });
        btn_Reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtId.setText("");
                txtEmail.setText("");
                txtPw.setText("");
                txtPwc.setText("");
            }
        });

        btn_Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });

    }
}
