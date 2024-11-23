package com.cookandroid.capstonedesign;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    Button btn_login,btn_register ;
    EditText et_id;
    EditText et_pwd;

    private SQLHelper dbHelper;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        dbHelper = new SQLHelper(this);

        et_id = (EditText) findViewById(R.id.et_id);
        et_pwd = (EditText) findViewById(R.id.et_pwd);
        btn_login = (Button) findViewById(R.id.btn_login);
        btn_register = (Button) findViewById(R.id.btn_register);

        //로그인 버튼
        btn_login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String id = et_id.getText().toString().trim();
                String password = et_pwd.getText().toString().trim();

                // 입력 필드가 비어있는지 확인
                if (id.isEmpty() || password.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "모두 입력해주세요!", Toast.LENGTH_SHORT).show();

                } else {
                    // 데이터베이스에서 사용자 확인
                    if (dbHelper.checkUser(id, password)) {


                        Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                        startActivity(intent);
                        finish(); // 로그인 화면 종료

                    } else {
                        // 로그인 실패 시 토스트 메시지 출력
                        Toast.makeText(LoginActivity.this, "아이디 또는 비밀번호가 일치하지 않습니다.", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
       //회원가입 버튼
        btn_register .setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(), MemberActivity.class);
                startActivity(intent);
            }
        });

    }
}
