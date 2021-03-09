package com.cqrw.diaoyong;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.View;

import com.cqrw.fuwutigong.MyAidl;

public class MainActivity extends AppCompatActivity {
    MyAidl myAidl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void bind(View view){
        Intent intent = new Intent();
        intent.setAction("com.cqrw.fuwu");
        intent.setPackage("com.cqrw.fuwutigong");
        bindService(intent,new Myconn(),BIND_AUTO_CREATE);
    }
    public void call(View view) throws RemoteException {
        myAidl.mycall();
    }

    public class Myconn implements ServiceConnection{
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            myAidl = MyAidl.Stub.asInterface(iBinder);
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    }
}