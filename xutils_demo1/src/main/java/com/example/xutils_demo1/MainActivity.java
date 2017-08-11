package com.example.xutils_demo1;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.ex.DbException;
import org.xutils.ex.HttpException;
import org.xutils.http.RequestParams;
import org.xutils.http.request.HttpRequest;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import static android.R.id.list;

@ContentView(R.layout.activity_main)
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private String urlPath = "http://huixinguiyu.cn/Assets/js/data.js";
    private List<DataBean.ApkBean> list = new ArrayList<>();
    //这里使用了xUtils的注解机制。
    @ViewInject(R.id.btn1)
    private Button button;
    @ViewInject(R.id.textview)
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //展示当前视图
        x.view().inject(this);
        button.setOnClickListener(this);//点击事件
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn1:
                doGet();
                break;
            default:
                break;
        }
    }
    //获取数据
    private void doGet() {
        // 获取数据的地址
        RequestParams params = new RequestParams("http://huixinguiyu.cn/Assets/js/data.js");
        // 从网络获取数据
        x.http().get(params, new Callback.CommonCallback<String>() {
            //网络请求成功时的操作
            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                DataBean json = gson.fromJson(result, DataBean.class);
                textView.setText(result);
            }
            //网络请求失败
            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }
            //取消时
            @Override
            public void onCancelled(CancelledException cex) {

            }
            //完成时的操作
            @Override
            public void onFinished() {

            }
        });
    }
}