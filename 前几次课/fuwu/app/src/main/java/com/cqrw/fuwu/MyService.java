package com.cqrw.fuwu;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.SystemClock;

import java.net.SocketTimeoutException;

public class MyService extends Service {
    public MyService() {
    }
    public class MyAgentImpl extends IMyAidlInterface.Stub{
        public void mycall(int i){
            if(i>100){
                guangjie();
            }else {
                gundan();
            }

        }
        public void guangjie(){
            System.out.println("逛街");
            call();
        }
        public void gundan(){
            System.out.println("滚蛋");
        }

        @Override
        public void mycall() throws RemoteException {
            call();
        }
    }
    @Override
    public IBinder onBind(Intent intent) {
       return new MyAgentImpl();
}

    @Override
    public void onCreate() {
        super.onCreate();
        /*while (true){
            System.out.println("服务启动了");
            SystemClock.sleep(1000);
        }*/
        /*new Thread(){
            @Override
            public void run() {
                super.run();
                while (true){
                    System.out.println("服务启动了");
                    SystemClock.sleep(1000);
                }
            }
        }.start();*/
        System.out.println("===================>onCreate()");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        System.out.println("===============>+onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        System.out.println("===============>+onDestroy");
        super.onDestroy();
    }
    public void call(){
        System.out.println("11111111111111");
    }
}
