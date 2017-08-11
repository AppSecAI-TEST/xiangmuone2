package com.example.rain.xiangmuone2;

import android.app.Application;

import org.xutils.x;

/**
 * data 2017/8/4.
 * author:霍远东(Rain)
 * function:
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
    }
}
