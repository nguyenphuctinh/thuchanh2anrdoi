package com.example.thuchanh2;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.example.thuchanh2.dal.BaseSQliteHelper;
import com.example.thuchanh2.models.Item;
import com.example.thuchanh2.models.Vocabulary;

public class VocabularyDetailActivity  extends AppCompatActivity {
    private EditText etWord, etDefinition;
    Spinner spWordType,spTopic;
    Button btnAdd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vocabulary_detail);
        initUI();
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String word = etWord.getText().toString();
                SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
                String username = sharedPreferences.getString("username", "");
                Vocabulary item = new Vocabulary();
                BaseSQliteHelper<Vocabulary> sql = new BaseSQliteHelper<>(VocabularyDetailActivity.this, Vocabulary.class);
                sql.add(item);
                finish();
            }
        });
    }
    /**
     *
     */
    private void initUI() {
        etWord = findViewById(R.id.etWord);
        etDefinition = findViewById(R.id.etDefinition);
        btnAdd = findViewById(R.id.btnAdd);
        spWordType = findViewById(R.id.spWordType);
        String[] items = {"Item 1", "Item 2", "Item 3"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        spWordType.setAdapter(adapter);
    }
}
