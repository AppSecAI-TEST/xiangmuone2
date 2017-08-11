package com.example.jichengshi_view;

import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

/**
 * 经过我们的观察：发现这个标题，是随着顶部图片高度关系，颜色变浅
 */
public class MainActivity extends AppCompatActivity implements ObservableScrollView.ScrollViewListenner {

    private int mImageHeight;
    private ImageView mIvDetail;
    private ObservableScrollView mScrollView;
    private TextView mTvTitlebar;
    private RelativeLayout mLayoutTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mIvDetail = (ImageView) findViewById(R.id.iv_detail);
        mScrollView = (ObservableScrollView) findViewById(R.id.scrollView);
        mTvTitlebar = (TextView) findViewById(R.id.tv_titlebar);
        mLayoutTitle = (RelativeLayout) findViewById(R.id.layout_title);
        //获取顶部的图片高度
        initListener();
        mScrollView.setScrollViewListenner(this);
    }

    //获取顶部的图片高度,设置Scrollview的滚动监听时，要使用这个参数
    private void initListener() {
        //获取控件的视图观察者，以便通过视图观察者得到空间的宽高参数
        ViewTreeObserver viewTreeObserver = mIvDetail.getViewTreeObserver();
        viewTreeObserver.addOnGlobalFocusChangeListener(new ViewTreeObserver.OnGlobalFocusChangeListener() {


            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onGlobalFocusChanged(View oldFocus, View newFocus) {

                mIvDetail.getViewTreeObserver().removeOnGlobalLayoutListener((OnGlobalLayoutListener) MainActivity.this);
                mImageHeight = mIvDetail.getHeight();

            }
        });
    }

    //自定义BoservableScrollview滑动监听器，是ObservableScrollView在把图片滑消失后，显示出标题的效果
    @Override
    public void onScrollChanged(ObservableScrollView scrollView, int l, int t, int oldl, int oldt) {
        //对T轴进行判断，就两种形态：1、消失没有、2、随着滑动
        if (t <= 0) {
            mTvTitlebar.setVisibility(View.GONE);
            //设置标题所在背景为透明
            mLayoutTitle.setBackgroundColor(Color.argb(0, 0, 0, 0));
        } else if (t > 0 && t < mImageHeight) {
            //让标题显示出来
            mTvTitlebar.setVisibility(View.VISIBLE);
            //获取Scrollview向下滑动，图片消失部分的比例
            float scale = (float) t / mImageHeight;
            float alpha = 255 * scale;
            //设置标题的内容及颜色
            mTvTitlebar.setText("1506D颜值担当是谁");
            mTvTitlebar.setTextColor(Color.argb((int) alpha, 0, 0, 0));
            //设置标题布局颜色
            mLayoutTitle.setBackgroundColor(Color.argb((int) alpha, 255, 255, 255));


        }

    }

}
