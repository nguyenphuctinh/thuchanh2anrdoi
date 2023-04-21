package com.example.thuchanh2.fragment;
;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.thuchanh2.R;
import com.example.thuchanh2.adapter.TaskAdapter;
import com.example.thuchanh2.dal.SQLiteHelper;
import com.example.thuchanh2.models.Item;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DanhSachFragment extends Fragment  implements TaskAdapter.ItemListener{
    private RecyclerView recyclerView;
    private ArrayList<Item> taskList;
    private TaskAdapter adapter;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_fragment, container, false);
        return  view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recycleView);
        adapter =  new TaskAdapter();
       SQLiteHelper db = new SQLiteHelper(getContext());
        List<Item>  items = db.getAll();
        adapter.setLstTask(items);
        LinearLayoutManager manager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
        adapter.setItemListener(this);

    }

    @Override
    public void onItemClick(View view, int position) {
//        Item item = adapter.getItem(position);
//        Intent intent = new Intent(getActivity(), UpdateDeleteActivity.class);
//        intent.putExtra("item", item);
//        startActivity(intent);
    }


}
