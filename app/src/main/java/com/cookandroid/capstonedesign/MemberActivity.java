package com.cookandroid.capstonedesign;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MemberActivity extends AppCompatActivity {

    Button btn_Registor, btn_Back, btn_Reset;
    EditText txtId, txtEmail, txtPw, txtPwc;
    DBHelper dbHelper;


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

        dbHelper = new DBHelper(this);

        //등록 버튼
        btn_Registor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = txtId.getText().toString().trim();
                String email = txtEmail.getText().toString().trim();
                String password = txtPw.getText().toString().trim();
                String passwordconfirm = txtPwc.getText().toString().trim();

                // 입력 필드가 비어있는지 확인
                if (id.isEmpty() || email.isEmpty() || password.isEmpty() || passwordconfirm.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "모두 입력해주세요!", Toast.LENGTH_SHORT).show();
                } else {
                    // SQLite에 회원 정보 저장
                    dbHelper.insertUser(id, password);

                    // 회원가입 성공 메시지 표시
                    Toast.makeText(getApplicationContext(), "회원가입 성공!", Toast.LENGTH_SHORT).show();

                    // 회원가입 후 다른 화면으로 이동 등 추가 동작 가능
                }
            }

        });
        //초키화 버튼
        btn_Reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtId.setText("");
                txtEmail.setText("");
                txtPw.setText("");
                txtPwc.setText("");
            }
        });
        //뒤로가기 버튼
        btn_Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });

    }
}
