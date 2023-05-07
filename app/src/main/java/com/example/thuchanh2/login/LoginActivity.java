package com.example.thuchanh2.login;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;


import com.example.thuchanh2.R;
import com.example.thuchanh2.dal.BaseSQliteHelper;
import com.example.thuchanh2.home.HomeActivity;
import com.example.thuchanh2.models.User;
import com.example.thuchanh2.register.RegisterActivity;

import java.util.List;


public class LoginActivity extends AppCompatActivity {
    private EditText etUserName, etPassword;
    private Button btnLogin,btnRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initUI();
        initEvents();
    }

    private void initEvents() {
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(intent);
            }
        });
    }

    private void login() {
        String userName = etUserName.getText().toString();
        String password = etPassword.getText().toString();

        BaseSQliteHelper db = new BaseSQliteHelper<User>(this, User.class);
        List<User> items = db.getAll();
        boolean isOK = false;
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getUsername().equals(userName) && items.get(i).getPassword().equals(password)) {
                isOK = true;
            }
        }
        if(isOK){
            SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("username", userName);
            editor.apply();
            Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
            startActivity(intent);
        }
    }

    private void initUI() {
        etUserName = findViewById(R.id.etUserName);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnRegister = findViewById(R.id.btnRegister);
    }
}