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

public class TopicActivity extends AppCompatActivity {
    //    private BottomNavigationView navigationView;
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
        fabAdd.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TopicActivity.this, AdditionActivity.class);
                startActivity(intent);
            }
        });
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager(),
                FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);

        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
//                    case 0: navigationView.getMenu().findItem(R.id.mHome).setChecked(true);
//                    break;
//                    case 1: navigationView.getMenu().findItem(R.id.mHistory).setChecked(true);
//                    break;
//                    case 2: navigationView.getMenu().findItem(R.id.mSearch).setChecked(true);
//                    break;
                }
                switch (position) {
                    case 0:
                        bottomNavi.getMenu().findItem(R.id.item_1).setChecked(true);
                        break;
                    case 1:
                        bottomNavi.getMenu().findItem(R.id.item_2).setChecked(true);
                        break;
                    case 2:
                        bottomNavi.getMenu().findItem(R.id.item_3).setChecked(true);
                        break;

                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        bottomNavi.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.item_1:
                    viewPager.setCurrentItem(0);
                    break;
                case R.id.item_2:
                    viewPager.setCurrentItem(1);
                    break;
                case R.id.item_3:
                    viewPager.setCurrentItem(3);
                    break;
            }
            return true;
        });

    }

    private void initUI() {
        viewPager = findViewById(R.id.viewPager);
        tabLayout = findViewById(R.id.bottom_nav);
        tabLayout.setupWithViewPager(viewPager);
        fabAdd = findViewById(R.id.fabAdd);
        bottomNavi = findViewById(R.id.bottomNavi);
    }
}