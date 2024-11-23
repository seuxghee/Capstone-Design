package com.cookandroid.capstonedesign;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MemberActivity extends AppCompatActivity {

    Button btn_Registor, btn_Back, btn_Reset;
    EditText txtId, txtEmail, txtPw, txtName, txtBirth;
    RadioButton radioMan, radioWoman;
    RadioGroup RadioSex;
    SQLHelper dbHelper;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member);
         //버튼
         btn_Registor = (Button) findViewById(R.id.btn_Registor);
         btn_Reset = (Button) findViewById(R.id.btn_Reset);
         btn_Back = (Button) findViewById(R.id.btn_Back);
         //텍스트박스
         txtId = (EditText) findViewById(R.id.txtId);
         txtEmail = (EditText) findViewById(R.id.txtUserId);
         txtPw = (EditText) findViewById(R.id.txtPw);
         txtName = (EditText) findViewById(R.id.txtUserName);
         txtBirth = (EditText) findViewById(R.id.txtBirth);
         //레디오버튼
         RadioSex = (RadioGroup) findViewById(R.id.RadioSex);
         radioMan = (RadioButton) findViewById(R.id.radioMan);
         radioWoman = (RadioButton) findViewById(R.id.radioWoman);



        dbHelper = new SQLHelper(this);

        //등록 버튼
        btn_Registor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = txtId.getText().toString().trim();
                String email = txtEmail.getText().toString().trim();
                String password = txtPw.getText().toString().trim();
                String name = txtName.getText().toString().trim();
                String birth =txtBirth.getText().toString().trim();

                // 선택된 라디오 버튼의 값 가져오기
                int selectedRadioId = RadioSex.getCheckedRadioButtonId();
                String gender = "";

                // 라디오 버튼 선택 확인
                if (selectedRadioId == R.id.radioMan) {
                    gender = "남자";
                } else if (selectedRadioId == R.id.radioWoman) {
                    gender = "여자";
                } else {
                    // 성별이 선택되지 않은 경우 메시지 표시
                    Toast.makeText(getApplicationContext(), "성별을 선택해주세요!", Toast.LENGTH_SHORT).show();
                    return; // 나머지 코드 실행하지 않고 종료
                }


                // 입력 필드가 비어있는지 확인
                if (id.isEmpty() || email.isEmpty() || password.isEmpty() || name.isEmpty() || birth.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "모두 입력해주세요!", Toast.LENGTH_SHORT).show();
                } else {

                    // 이메일 형식 검증
                    if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                        Toast.makeText(getApplicationContext(), "유효한 이메일 주소를 입력해주세요!", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    // 비밀번호 복잡성 검증
                    if (!isPasswordValid(password)) {
                        Toast.makeText(getApplicationContext(), "비밀번호는 최소 8자 이상이며 대문자, 소문자, 숫자, 특수문자를 포함해야 합니다.", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    // SQLHelper 객체 생성
                    SQLHelper dbHelper = new SQLHelper(getApplicationContext());

                    // id 중복 확인
                    if (dbHelper.isUserIdExists(id)) {
                        Toast.makeText(getApplicationContext(), "이미 존재하는 ID입니다. 다른 ID를 사용해주세요.", Toast.LENGTH_SHORT).show();
                    }
                    // 이메일 중복 확인
                    if (dbHelper.isEmailExists(email)) {
                        Toast.makeText(getApplicationContext(), "이미 존재하는 이메일입니다. 다른 이메일을 사용해주세요.", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    else {
                        // 중복이 없으면 사용자 삽입
                        dbHelper.insertUser(id, email, password, name, birth, gender);

                        // 회원가입 성공 메시지 표시
                        Toast.makeText(getApplicationContext(), "회원가입 성공!", Toast.LENGTH_SHORT).show();

                     }   // 회원가입 후 다른 화면으로 이동 등 추가 동작 가능
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
                txtName.setText("");
                txtBirth.setText("");

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
    // 비밀번호 복잡성 검증 메서드
    private boolean isPasswordValid(String password) {
        // 최소 8자 이상, 대문자, 소문자, 숫자, 특수문자를 포함하는 정규식
        String passwordPattern = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@#$%^&+=]).{8,}$";
        return password.matches(passwordPattern);
    }
}
