package com.example.thuchanh2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.thuchanh2.adapter.ViewPagerAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

public class VocabularyActivity   extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private FloatingActionButton fabAdd;

    private BottomNavigationView bottomNavi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUI();
        initEvents();
    }

    private void initEvents() {
        fabAdd.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(VocabularyActivity.this, VocabularyDetailActivity.class);
                startActivity(intent);
            }
        });
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager(),
                FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
    }

    private void initUI() {
        viewPager = findViewById(R.id.viewPager);
        tabLayout = findViewById(R.id.bottom_nav);
        tabLayout.setupWithViewPager(viewPager);
        fabAdd = findViewById(R.id.fabAdd);
        bottomNavi = findViewById(R.id.bottomNavi);
    }
}
