package com.example.jpush_demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


/**
 * 使用JpushSDK的思路总结:项目在集成SDK前一定要备份,否则出错了,项目就悲剧了
 * 1、获取极光的APPKey
 * 2、下载SDK
 * 3、快速集成
 *   1、拷贝Libs目录下的所有文件
 *   2、拷贝res目录下的所有文件
 *   3、配置build文件
 *   4、配置清单文件
 *   5、Appliciton初始化
 *   6、java代码中
 *
 *
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
