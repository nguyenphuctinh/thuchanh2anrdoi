package com.example.thuchanh2.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.thuchanh2.R;
import com.example.thuchanh2.models.Product;

import java.util.ArrayList;


public class HomeAdapter extends BaseAdapter {
    private Context context;

    private ArrayList<Product> products;

    public HomeAdapter(Context context) {
        this.context = context;
    }

    public HomeAdapter(Context context, ArrayList<Product> products) {
        this.context = context;
        this.products = products;
    }

    @Override
    public int getCount() {
        return products.size();
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
        view = LayoutInflater.from(context).inflate(R.layout.cardview, null);
        ImageView imgHinh = (ImageView) view.findViewById(R.id.imgHinh);
        TextView productName = view.findViewById(R.id.productName);
        TextView price = view.findViewById(R.id.price);
        productName.setText(products.get(i).getProductName());
        imgHinh.setImageResource(R.drawable.ip12);
        price.setText(products.get(i).getPrice()+" đ");
        return view;
    }
}
