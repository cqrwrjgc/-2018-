package com.cqrw.fuwu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    Myagent myAgent;
    MyService.MyAgentImpl myAgent1;
    MyConn myConn = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void start(View view){
        Intent intent = new Intent();
        intent.setClass(MainActivity.this,MyService.class);
        startService(intent);
    }
    public void stop(View view){
        Intent intent = new Intent();
        intent.setClass(MainActivity.this,MyService.class);
        stopService(intent);
    }
    public void call(View view){
        MyService myService = new MyService();
        myService.call();
    }

    /**
     * 绑定服务
     * @param view
     */
    public void bind(View view){
        Intent intent = new Intent();
        intent.setClass(MainActivity.this,MyService.class);
        if(myConn==null){
            myConn = new MyConn();
        }
        bindService(intent,myConn,BIND_AUTO_CREATE);
    }

    public class MyConn implements ServiceConnection{
        //服务绑定成功时调用
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
           // myAgent = (MyService.MyAgentImpl) iBinder;
        }
    //应用程序异常关闭时调用
        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    }

    public void bindCall(View view){
        myAgent.mycall(110);

    }
    public void unbind(View view){
        if(myConn!=null){
            unbindService(myConn);
            myConn=null;
            myAgent=null;
        }

    }
}