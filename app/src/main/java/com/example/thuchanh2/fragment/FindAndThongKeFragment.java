package com.example.thuchanh2.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SearchView;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.thuchanh2.R;
import com.example.thuchanh2.adapter.TaskAdapter;
import com.example.thuchanh2.dal.BaseSQliteHelper;
import com.example.thuchanh2.models.Item;

import java.util.HashMap;
import java.util.List;

public class FindAndThongKeFragment extends Fragment {
    private SearchView searchView;
    private Button btSearch;
    private RecyclerView recycleView;
    private TaskAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_search, container, false);
        searchView = view.findViewById(R.id.search);
        btSearch = view.findViewById(R.id.btSearch);
        recycleView = view.findViewById(R.id.recycleView);
        BaseSQliteHelper<Item> db = new BaseSQliteHelper<Item>(getContext(), Item.class);
        SharedPreferences sharedPreferences = requireContext().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        String username = sharedPreferences.getString("username", "");
        List<Item>  items = db.findBy("username = '"+username+"' ");
        adapter = new TaskAdapter();
        adapter.setLstTask(items);

        LinearLayoutManager manager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL,false);
        recycleView.setLayoutManager(manager);
        recycleView.setAdapter(adapter);


        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                SharedPreferences sharedPreferences = requireContext().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
                String username = sharedPreferences.getString("username", "");
                List<Item>  items = db.findBy("username = '"+username+"' ");
                adapter.setLstTask(items);
                return false;
            }
        });

        return view;
    }
}
