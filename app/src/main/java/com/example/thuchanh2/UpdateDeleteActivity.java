package com.example.thuchanh2;

import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.example.thuchanh2.dal.BaseSQliteHelper;
import com.example.thuchanh2.models.Item;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;

public class UpdateDeleteActivity extends AppCompatActivity {
    private EditText eTaskName;
    Button btnUpdate,btnDelete;
    private Item item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update_delete_activy);
        item = (Item) this.getIntent().getSerializableExtra("item");
        initUI();
        eTaskName.setText(item.getName());
        initEvents();

    }

    private void initEvents() {
        Context context = this;
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                String[] categories = getResources().getStringArray(R.array.category);
//                spCategory.setAdapter(new ArrayAdapter<String>(this,R.layout.item_spcategory,categories));
//        for(int i = 0; i < categories.length ; i++){
//            if(categories[i].equals(item.getCategory())){
//                spCategory.setSelection(i);
//            }
//        }
                String name = eTaskName.getText().toString();
                item.setName(name);
                BaseSQliteHelper<Item> db = new BaseSQliteHelper<Item>(UpdateDeleteActivity.this, Item.class);
                   db.remove(item, item.getId());
                    finish();
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                String[] categories = getResources().getStringArray(R.array.category);
//                spCategory.setAdapter(new ArrayAdapter<String>(this,R.layout.item_spcategory,categories));
//        for(int i = 0; i < categories.length ; i++){
//            if(categories[i].equals(item.getCategory())){
//                spCategory.setSelection(i);
//            }
//        }
                String name = eTaskName.getText().toString();
                item.setName(name);
                BaseSQliteHelper<Item>  db = new BaseSQliteHelper<>(UpdateDeleteActivity.this, Item.class);
               db.update(item);
                finish();
            }
        });
    }

    /**
     *
     */
    private void initUI() {

        eTaskName = findViewById(R.id.eTaskName);

        btnDelete = findViewById(R.id.btnRemove);
        btnUpdate = findViewById(R.id.btnUpdate);
    }

}
