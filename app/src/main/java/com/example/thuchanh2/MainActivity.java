package com.example.thuchanh2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.example.thuchanh2.adapter.ViewPagerAdapter;
import com.example.thuchanh2.home.HomeActivity;
import com.example.thuchanh2.login.LoginActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        String username = sharedPreferences.getString("username", "");

        if(username.isEmpty() || username == null ){
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        }else{
            Intent intent = new Intent(this, HomeActivity.class);
            startActivity(intent);
        }

    }


}