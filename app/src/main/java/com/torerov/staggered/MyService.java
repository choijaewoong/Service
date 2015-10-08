package com.torerov.staggered;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class MyService extends Service {
    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    private static final String TAG = "MyService";
    boolean isRunning = false;
    int mCount = 0;

    @Override
    public void onCreate() {
        super.onCreate();
        Toast.makeText(this, "onCreate...", Toast.LENGTH_SHORT).show();
        new Thread(new Runnable() {
            @Override
            public void run() {
                isRunning = true;
                while(isRunning) {
                    Log.i(TAG, "count : " + mCount);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    mCount++;
                }
            }
        }).start();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this, "onStartCommand...", Toast.LENGTH_SHORT).show();
        if (intent != null) { //START_NOT_STICKY 인경우 굳이 필요하지 않음.
            mCount = intent.getIntExtra("count", 0);
        }
        return Service.START_NOT_STICKY; // 죽었다가 다시 실행하지 않음
    }

    @Override
    public void onDestroy() {
        Toast.makeText(this, "onDestroy...", Toast.LENGTH_SHORT).show();
        super.onDestroy();
        isRunning = false;
    }
}
