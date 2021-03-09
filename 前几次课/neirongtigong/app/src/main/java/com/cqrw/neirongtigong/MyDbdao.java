package com.cqrw.neirongtigong;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyDbdao {
    Mydb db = null;
    SQLiteDatabase sb =null;
    public MyDbdao(Context context) {
       if(db == null){
           db = new Mydb(context);
           sb = db.getReadableDatabase();
           sb.close();
       }
    }

    public void insert(){
        sb = db.getWritableDatabase();
        sb.execSQL("insert into student(name,price) values('张三',100)");
        sb.close();
    }
    public List<Map<String,String>> select(){
        sb = db.getReadableDatabase();
       Cursor cursor =  sb.rawQuery("select * from student ",new String[]{});
        List<Map<String,String>> list = new ArrayList<Map<String,String>>();
       while (cursor.moveToNext()){
           Map<String,String> map = new HashMap<>();
           String name = cursor.getString(cursor.getColumnIndex("name"));
           map.put("name",name );
           map.put("age",cursor.getString(cursor.getColumnIndex("price")) );
           list.add(map);
       }
     return list;
    }
}
