package com.example.thuchanh2.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.ListFragment;

import com.example.thuchanh2.fragment.DanhSachFragment;
import com.example.thuchanh2.fragment.FindAndThongKeFragment;
import com.example.thuchanh2.fragment.InfoFragment;


public class ViewPagerAdapter extends FragmentPagerAdapter {

    public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:return new DanhSachFragment();
            case 1:return new InfoFragment();
            case 2:return new FindAndThongKeFragment();
        }

        return  null;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0: return "HOME NAY";
            case 1: return  "LICH SU";
            case 2: return  "TIM KIEM";
        }
        return super.getPageTitle(position);
    }
}
