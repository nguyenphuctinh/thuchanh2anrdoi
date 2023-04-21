package com.example.thuchanh2.dal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.thuchanh2.models.Item;

import java.util.ArrayList;
import java.util.List;

public class SQLiteHelper  extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "ThucHanh2.db";
    private static int DATABASE_VERSION = 1;

    public SQLiteHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION );
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE items (\n" +
                "  id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "  name TEXT NOT NULL,\n" +
                "  startDate TEXT NOT NULL,\n" +
                "  endDate TEXT NOT NULL,\n" +
                "  isCompleted INTEGER NOT NULL\n" +
                ");\n";

        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public List<Item> getAll(){
        List<Item> items = new ArrayList<>();
        SQLiteDatabase st = getReadableDatabase();
        String order = "";
        Cursor cursor = st.query("items",null, null, null,null,null,order);
        while (cursor != null && cursor.moveToNext()){
            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            String startDate = cursor.getString(2);
            String endDate = cursor.getString(3);
            int isCompleted = cursor.getInt(4);
            items.add(new Item(name, startDate, endDate, isCompleted==1));
        }
        return  items;
    }

    public long addItem(Item item){
        ContentValues values = new ContentValues();
        values.put("name", item.getName());
        values.put("startDate", item.getStartDate());
        values.put("endDate", item.getEndDate());
        values.put("isCompleted", item.getIsCompleted());

        SQLiteDatabase sql = getWritableDatabase();
        return sql.insert("items", null, values);
    }
}
