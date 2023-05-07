package com.example.thuchanh2.dal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class BaseSQliteHelper<TEntity> extends SQLiteOpenHelper {
    private Class<TEntity> type;
    private static final String DATABASE_NAME = "5.db";
    private static int DATABASE_VERSION = 3;

    public BaseSQliteHelper(@Nullable Context context, Class<TEntity> type) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.type = type;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createTblTopic = "CREATE TABLE item (\n" +
                "  itemID INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "  itemName TEXT NOT NULL,\n" +
                "  username TEXT NOT NULL\n" +
                ");\n";
        sqLiteDatabase.execSQL(createTblTopic);

        String createTblVocab = "CREATE TABLE vocabulary (\n" +
                "  vocabularyID INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "  word TEXT NOT NULL,\n" +
                "  definition TEXT NOT NULL,\n" +
                "  wordType INTEGER NOT NULL,\n" +
                "  topicID INTEGER NOT NULL\n" +
                ");\n";
        sqLiteDatabase.execSQL(createTblVocab);

        String createTblUser = "CREATE TABLE user (\n" +
                "  userID INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "  username TEXT NOT NULL,\n" +
                "  password TEXT NOT NULL\n" +
                ");\n";
        sqLiteDatabase.execSQL(createTblUser);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    private Class<?> getEntityClass() {
        return this.type;
    }

    public List<TEntity> getAll() {
        try {
            List<TEntity> items = new ArrayList<>();
            SQLiteDatabase st = getReadableDatabase();
            String order = "";
            Class<?> clazz = getEntityClass();

            Cursor cursor = st.query(clazz.getSimpleName(), null, null, null, null, null, order);
            while (cursor != null && cursor.moveToNext()) {
                List<Field> fields = Arrays.asList(clazz.getDeclaredFields());
                TEntity entity = (TEntity) clazz.newInstance();

                for (Field field : fields) {
                    field.setAccessible(true);
                    String fieldName = field.getName();
                    Object fieldValue = null;
                    int columnIndex = cursor.getColumnIndex(fieldName);
                    switch (field.getType().getSimpleName()) {
                        case "int":
                            fieldValue = cursor.getInt(columnIndex);
                            break;
                        case "String":
                            fieldValue = cursor.getString(columnIndex);
                            break;
                        case "double":
                            fieldValue = cursor.getDouble(columnIndex);
                            break;
                        case "float":
                            fieldValue = cursor.getFloat(columnIndex);
                            break;
                    }
                    field.set(entity, fieldValue);
                }
                items.add(entity);
            }
            return items;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public long add(TEntity item) {
        try {
            ContentValues values = new ContentValues();
            List<Field> fields = Arrays.asList(item.getClass().getDeclaredFields());
            for (Field field : fields) {
                field.setAccessible(true);
                String fieldName = field.getName();
                if (fieldName.toLowerCase().equals(item.getClass().getSimpleName().toLowerCase() + "id")) {
                    continue;
                }
                Object fieldValue = null;
                fieldValue = field.get(item);
                switch (field.getType().getSimpleName()) {
                    case "int":
                        values.put(fieldName, (int) fieldValue);
                        break;
                    case "String":
                        values.put(fieldName, (String) fieldValue);
                        break;
                    case "double":
                        values.put(fieldName, (Double) fieldValue);
                        break;
                    case "float":
                        values.put(fieldName, (Float) fieldValue);
                        break;
                }
            }

            SQLiteDatabase sql = getWritableDatabase();
            return sql.insert(item.getClass().getSimpleName(), null, values);
        } catch (Exception e) {
            System.out.println(e);
        }
        return -1;
    }

    public void update(TEntity item) {
        try {
            String[] args = {""};
            ContentValues values = new ContentValues();
            List<Field> fields = Arrays.asList(item.getClass().getDeclaredFields());
            for (Field field : fields) {
                field.setAccessible(true);
                String fieldName = field.getName();
                if (fieldName.toLowerCase().equals(item.getClass().getSimpleName().toLowerCase() + "id")) {
                    args[0] = field.get(item) + "";
                }
                Object fieldValue = null;
                fieldValue = field.get(item);
                switch (field.getType().getSimpleName()) {
                    case "int":
                        values.put(fieldName, (int) fieldValue);
                        break;
                    case "String":
                        values.put(fieldName, (String) fieldValue);
                        break;
                    case "double":
                        values.put(fieldName, (Double) fieldValue);
                        break;
                    case "float":
                        values.put(fieldName, (Float) fieldValue);
                        break;
                }
            }
            SQLiteDatabase sql = getWritableDatabase();
            sql.update(item.getClass().getSimpleName(), values, item.getClass().getSimpleName().toLowerCase()+"ID=?", args);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void remove(TEntity item, int recordID) {
        SQLiteDatabase sql = getWritableDatabase();
        String[] args = {recordID+""};
        sql.delete(item.getClass().getSimpleName(),item.getClass().getSimpleName().toLowerCase()+"ID=?",args);
    }

    public List<TEntity> findBy(String where) {
        List<TEntity> items = new ArrayList<>();
        try {
          SQLiteDatabase st = getReadableDatabase();
          Class<?> clazz = getEntityClass();
          String order = "";
          String q = " 1=1 ";
          List<String> a = new ArrayList<>();

          Cursor cursor = st.query(clazz.getSimpleName(),null, where, null,null,null,order);
          while (cursor != null && cursor.moveToNext()) {
              List<Field> fields = Arrays.asList(clazz.getDeclaredFields());
              TEntity entity = (TEntity) clazz.newInstance();

              for (Field field : fields) {
                  field.setAccessible(true);
                  String fieldName = field.getName();
                  Object fieldValue = null;
                  int columnIndex = cursor.getColumnIndex(fieldName);
                  switch (field.getType().getSimpleName()) {
                      case "int":
                          fieldValue = cursor.getInt(columnIndex);
                          break;
                      case "String":
                          fieldValue = cursor.getString(columnIndex);
                          break;
                      case "double":
                          fieldValue = cursor.getDouble(columnIndex);
                          break;
                      case "float":
                          fieldValue = cursor.getFloat(columnIndex);
                          break;
                  }
                  field.set(entity, fieldValue);
              }
              items.add(entity);
          }

      }catch (Exception e){
          System.out.println(e);
      }
        return items;
    }
}
