package com.example.durgeshdb;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class databse extends SQLiteOpenHelper {
    public databse(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE MYTABLE(SNO INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT," +
                "PASSWORD TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
          sqLiteDatabase.execSQL("DROP TABLE IF EXISTS MYTABLE");
    }
    public void insertInto(String name,String pass){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues content=new ContentValues();
        content.put("NAME",name);
        content.put("PASSWORD",pass);
        sqLiteDatabase.insert("MYTABLE",null,content);
    }
}
