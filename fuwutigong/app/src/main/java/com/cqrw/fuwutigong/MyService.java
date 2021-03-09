package com.cqrw.fuwutigong;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

public class MyService extends Service {
    public MyService() {
    }
    public class MyAgent extends  MyAidl.Stub{

        @Override
        public void mycall() throws RemoteException {
            call();
        }
    }
    @Override
    public IBinder onBind(Intent intent) {
        return new MyAgent();
    }

    public void call(){
        System.out.println("11111111111");
    }
}
