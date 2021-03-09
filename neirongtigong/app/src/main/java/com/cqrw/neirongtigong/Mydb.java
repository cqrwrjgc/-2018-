package com.cqrw.neirongtigong;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Mydb extends SQLiteOpenHelper {
    public Mydb(@Nullable Context context) {
        super(context, "dbname", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE student(_id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR(20), price INTEGER)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
