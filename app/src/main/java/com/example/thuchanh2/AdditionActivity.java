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
    private EditText eStartDate, eEndDate;
    private EditText eTaskName;
    private Spinner spCategory;
    CheckBox ckbIsCompleted;
    Button btnAdd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addition_activty);
        initUI();

        spCategory.setAdapter(new ArrayAdapter<String>(this,R.layout.item_spcategory, new ArrayList<String>(Arrays.asList("a","b"))));
        initEvents();
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = eTaskName.getText().toString();
                String startDate =  eStartDate.getText().toString();
                String endDate = eEndDate.getText().toString();
                boolean isCompleted = ckbIsCompleted.isChecked();
                Item item = new Item(name, startDate, endDate, isCompleted);
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

        ckbIsCompleted = findViewById(R.id.ckbIsCompleted);
        spCategory = findViewById(R.id.spCategory);
        initDatePicker();
    }
    private void initEvents() {

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Item task = new Item();
                String name = eTaskName.getText().toString();
                String startDate = eStartDate.getText().toString();
                String endDate = eEndDate.getText().toString();
                if (startDate.isEmpty() || startDate == null
                        || endDate.isEmpty() || endDate == null
                        || name.isEmpty() || name == null

                ) {
                    Toast.makeText(getApplicationContext(), "nhập lại!", Toast.LENGTH_SHORT).show();

                }else{
                    task.setStartDate(startDate);
                    task.setEndDate(endDate);
                    task.setName(name);
                    task.setCompleted(ckbIsCompleted.isChecked());
                }

            }
        });

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
