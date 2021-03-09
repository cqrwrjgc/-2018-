package com.cqrw.diaoyong;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.View;

import com.cqrw.fuwu.IMyAidlInterface;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void call(View view) throws RemoteException {
        Sql s = new Sql(MainActivity.this);
        SQLiteDatabase sb = s.getWritableDatabase();
        sb.execSQL("insert into sut (name,price) values('张三',100)");
        sb.close();
    }
    public void bind(View view){
        Sql s = new Sql(MainActivity.this);
        SQLiteDatabase sb = s.getReadableDatabase();
       Cursor cursor =  sb.rawQuery("select * from sut where name=?",new String[]{"张三"});
       while(cursor.moveToNext()){
           String name = cursor.getString(cursor.getColumnIndex("name"));
           System.out.println(name);
       }
    }
    private IMyAidlInterface myAidlInterface;
    private class MyConnection implements ServiceConnection {

        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            myAidlInterface = IMyAidlInterface.Stub.asInterface(iBinder);
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    }
}