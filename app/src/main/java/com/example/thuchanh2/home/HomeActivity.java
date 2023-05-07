package com.example.thuchanh2.home;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.thuchanh2.R;
import com.example.thuchanh2.TopicActivity;


public class HomeActivity  extends AppCompatActivity {
    private GridView gvTrangChu;
    private FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_home);
        gvTrangChu = (GridView) findViewById(R.id.gvTrangChu);
        addEvent();
        khoiTao();
    }
    private void khoiTao() {
        String[] ten = {
                "Chủ đề",
                "Vocabulary",
                "Listen",
                "Listen - Response",
                "Grammar",
                "Reading"
        };

        int[] hinh = {
                R.drawable.topic_img,
                R.drawable.topic_img,
                R.drawable.topic_img,
                R.drawable.topic_img,
                R.drawable.topic_img,
                R.drawable.topic_img
        };

       HomeAdapter mainAdapter = new HomeAdapter(this,ten,hinh);
        gvTrangChu.setAdapter(mainAdapter);
    }
    private void addEvent() {
        gvTrangChu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0 :
                        Intent intent = new Intent(getApplicationContext(), TopicActivity.class);
                        startActivity(intent);
                        break;
                    case 1:

                        break;
                    case 2:

                        break;
                    case 3:

                        break;
                    case 4:

                        break;
                    case 5:

                        break;
                }
            }
        });
    }

}
