package com.example.xutils_demo1;

import android.app.Application;

import org.xutils.x;

/**
 * data 2017/8/6.
 * author:霍远东(Rain)
 * function:
 */

public class App extends Application {
    //在Application中初始化xUtils
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        x.Ext.setDebug(BuildConfig.DEBUG);
    }
}
