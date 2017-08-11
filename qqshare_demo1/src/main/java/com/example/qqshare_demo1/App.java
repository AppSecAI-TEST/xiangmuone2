package com.example.qqshare_demo1;

import android.app.Application;

import com.umeng.socialize.PlatformConfig;


public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        PlatformConfig.setQQZone("1106036236", "mjFCi0oxXZKZEWJs");
    }
}
