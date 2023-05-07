package com.example.thuchanh2.register;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


import com.example.thuchanh2.R;
import com.example.thuchanh2.dal.BaseSQliteHelper;
import com.example.thuchanh2.login.LoginActivity;
import com.example.thuchanh2.models.User;

import java.util.List;

public class RegisterActivity extends AppCompatActivity {
    private EditText etUserName, etPassword, etConfirmPassword;
    private Button btnLogin, btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_activity);
        initUI();
        initEvents();
    }

    private void initEvents() {
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                register();
            }
        });
    }

    private void register() {
        String userName = etUserName.getText().toString();
        String password = etPassword.getText().toString();
        String confirmPassword = etConfirmPassword.getText().toString();
        if(!confirmPassword.equals(password)){
            Toast.makeText(getApplicationContext(), "Mật khẩu nhập lại không khớp!" , Toast.LENGTH_LONG).show();//display the response on screen
            return;
        }
        BaseSQliteHelper db = new BaseSQliteHelper<User>(this, User.class);
        List<User> items = db.getAll();
        boolean isOK = true;
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getUsername().equals(userName)) {
                isOK = false;
            }
        }

        if (isOK) {
            db.add(new User(userName, password));
            Toast.makeText(getApplicationContext(), "Đăng ký thành công!" , Toast.LENGTH_LONG).show();//display the response on screen

        }else{
            Toast.makeText(getApplicationContext(), "Tên tài khoản đã tồn tại!" , Toast.LENGTH_LONG).show();//display the response on screen
        }

    }

    private void initUI() {
        etUserName = findViewById(R.id.etUserName);
        etPassword = findViewById(R.id.etPassword);
        etConfirmPassword = findViewById(R.id.etConfirmPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnRegister = findViewById(R.id.btnRegister);
    }

}
