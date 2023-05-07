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

import com.example.thuchanh2.models.Item;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;

public class UpdateDeleteActivity extends AppCompatActivity {
    private EditText eStartDate, eEndDate;
    private EditText eTaskName;
    private Spinner spCategory;
    CheckBox ckbIsCompleted;
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
        spCategory.setAdapter(new ArrayAdapter<String>(this,R.layout.item_spcategory, new ArrayList<String>(Arrays.asList("a","b"))));

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
                String startDate =  eStartDate.getText().toString();
                String endDate = eEndDate.getText().toString();
                boolean isCompleted = ckbIsCompleted.isChecked();
                item.setName(name);
//                SQLiteHelper  db = new SQLiteHelper(UpdateDeleteActivity.this);




//                    db.remove(item);
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
                String startDate =  eStartDate.getText().toString();
                String endDate = eEndDate.getText().toString();
                boolean isCompleted = ckbIsCompleted.isChecked();
                item.setName(name);
//                SQLiteHelper  db = new SQLiteHelper(UpdateDeleteActivity.this);




//                db.updateItem(item);
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
        ckbIsCompleted = findViewById(R.id.ckbIsCompleted);
        spCategory = findViewById(R.id.spCategory);
        initDatePicker();
    }
    private void initDatePicker() {
        eStartDate = findViewById(R.id.eStartDate);
        Calendar c = Calendar.getInstance();
        int hh = c.get(Calendar.HOUR_OF_DAY);
        int mm = c.get(Calendar.MINUTE);
        int year = c.get(Calendar.YEAR);
        int mounth = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        Context me = this;
        eStartDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(me, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int y, int m, int d) {
                        eStartDate.setText(y + "/" + m + "/" + d);
                    }
                }, year, mounth, day);
                datePickerDialog.show();
            }
        });

        eEndDate = findViewById(R.id.eEndDate);
        eEndDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(me, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int y, int m, int d) {
                        eEndDate.setText(y + "/" + m + "/" + d);
                    }
                }, year, mounth, day);
                datePickerDialog.show();
            }
        });

    }
    


}
