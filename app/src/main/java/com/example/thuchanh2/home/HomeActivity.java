package com.example.thuchanh2.home;

import android.app.FragmentTransaction;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.thuchanh2.R;
import com.example.thuchanh2.models.Product;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.Arrays;


public class HomeActivity extends AppCompatActivity {
    private GridView gvTrangChu;
    private FragmentTransaction transaction;
    BottomNavigationView bottom_navigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_home);
        gvTrangChu = (GridView) findViewById(R.id.gvTrangChu);
        bottom_navigation =  findViewById(R.id.bottom_navigation);
        BadgeDrawable badge = bottom_navigation.getOrCreateBadge(R.id.item_2);
        badge.setVisible(true);
        badge.setNumber(99);
        addEvent();
        khoiTao();
    }

    private void khoiTao() {
        ArrayList<Product> products = new ArrayList<Product>(Arrays.asList(
                new Product(1,"iphone 19", 10000),
                new Product(1,"iphone 18", 10002),
                new Product(1,"iphone 17", 10000),
                new Product(1,"iphone 16", 100004),
                new Product(1,"iphone 15", 100005),
                new Product(1,"iphone 12", 10200),
                new Product(1,"iphone 11", 10300)
                ));
        HomeAdapter mainAdapter = new HomeAdapter(this,products);
        gvTrangChu.setAdapter(mainAdapter);
    }

    private void addEvent() {
//        gvTrangChu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Intent intent;
//                switch (position) {
//                    case 0:
//                        intent = new Intent(getApplicationContext(), TopicActivity.class);
//                        startActivity(intent);
//                        break;
//                    case 1:
//                        intent = new Intent(getApplicationContext(), VocabularyActivity.class);
//                        startActivity(intent);
//                        break;
//                    case 2:
//
//                        break;
//                    case 3:
//
//                        break;
//                    case 4:
//
//                        break;
//                    case 5:
//
//                        break;
//                    case 6:
//                        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
//                        SharedPreferences.Editor editor = sharedPreferences.edit();
//                        editor.putString("username", null);
//                        editor.apply();
//                        intent = new Intent(getApplicationContext(), LoginActivity.class);
//                        startActivity(intent);
//                        break;
//                }
//            }
//        });
    }

}
