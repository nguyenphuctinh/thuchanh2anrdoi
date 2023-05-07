package com.example.thuchanh2.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.thuchanh2.R;


public class HomeAdapter extends BaseAdapter {
    private Context context;
    private String[] ten;
    private int[] hinh;

    public HomeAdapter(Context context, String[]ten, int[] hinh) {
        this.context = context;
        this.ten = ten;
        this.hinh= hinh;
    }

    @Override
    public int getCount() {
        return hinh.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
         view = LayoutInflater.from(context).inflate(R.layout.gridview_row, null);

        ImageView imgHinh = (ImageView) view.findViewById(R.id.imgHinh);
        TextView txtTen = (TextView) view.findViewById(R.id.txtTen);

        imgHinh.setImageResource(hinh[i]);
        txtTen.setText(ten[i]);

        return view;
    }
}
