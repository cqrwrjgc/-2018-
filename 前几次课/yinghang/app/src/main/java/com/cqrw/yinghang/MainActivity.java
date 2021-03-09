package com.cqrw.yinghang;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.pm.PackageManager;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int pross = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_SMS);
        if(pross!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.READ_SMS},0);
        }
    }
    public class Myclass extends ContentObserver{

        public Myclass(Handler handler) {
            super(handler);
        }

        @Override
        public void onChange(boolean selfChange, @Nullable Uri uri) {
            super.onChange(selfChange, uri);
        }
    }
    public void add(View view){
      ContentResolver resolver =  getContentResolver();
        Uri uri = Uri.parse("content://com.cqrw.bd/cqrw");
        ContentValues values = new ContentValues();
        values.put("name","二蛋");
        values.put("price",101);
        resolver.insert(uri,values);
    }
    public void query(View view) {
        ContentResolver resolver =  getContentResolver();
        Uri uri = Uri.parse("content://sms");
        Cursor cursor =  resolver.query(uri,new String[]{"address","type","body","date"},null,null,null);
        while(cursor.moveToNext()){
            System.out.println(cursor.getString(cursor.getColumnIndex("address")));
            System.out.println(cursor.getString(cursor.getColumnIndex("body")));
        }
    }
}