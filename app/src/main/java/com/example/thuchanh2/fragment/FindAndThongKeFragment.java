package com.example.thuchanh2.fragment;

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

import java.util.List;

public class FindAndThongKeFragment extends Fragment {
    private SearchView searchView;
    private Spinner spCategory;
    private Button btSearch;
    private EditText edFrom, edTo;
    private RecyclerView recycleView;
    private TaskAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_search, container, false);
        searchView = view.findViewById(R.id.search);
        spCategory = view.findViewById(R.id.spCategory);
        btSearch = view.findViewById(R.id.btSearch);
        edTo = view.findViewById(R.id.edTo);
        edFrom = view.findViewById(R.id.edFrom);
        recycleView = view.findViewById(R.id.recycleView);
        BaseSQliteHelper<Item> db = new BaseSQliteHelper<Item>(getContext(), Item.class);
        List<Item>  items = db.getAll();
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
                List<Item> items =  db.findBy(s);
                adapter.setLstTask(items);
                return false;
            }
        });

        return view;
    }
}
