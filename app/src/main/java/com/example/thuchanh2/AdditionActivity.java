package com.example.thuchanh2;

import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.thuchanh2.dal.SQLiteHelper;
import com.example.thuchanh2.models.Item;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;

public class AdditionActivity extends AppCompatActivity {
    private EditText eTaskName;
    Button btnAdd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addition_activty);
        initUI();
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = eTaskName.getText().toString();
                Item item = new Item(name, "startDate", "endDate", false);
                SQLiteHelper sql = new SQLiteHelper(AdditionActivity.this);
                sql.addItem(item);
                finish();
            }
        });
    }
    /**
     *
     */
    private void initUI() {
        eTaskName = findViewById(R.id.eTaskName);
        btnAdd = findViewById(R.id.btnAdd);
    }


}
