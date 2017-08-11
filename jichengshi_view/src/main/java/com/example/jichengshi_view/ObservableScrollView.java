package com.example.jichengshi_view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

/**
 * data 2017/8/9.
 * author:霍远东(Rain)
 * function:扩展式自定义view,在scrollview的基础上添加新的功能
 * 1、类继承基础控件,实现三个复写方法
 * 2、自定一个scrollview滑动监听
 * 3、复写scrollview自带的一个滑动监听
 * 4、提供方法，让外界可以设置scrollview的监听对象
 * 5、使用ObservableScroollview自定义控件
 * <p>
 * 做自定义控件思路：
 * 1、看效果，判断是哪种类型的自定义控件
 * 2、如果是继承式自定义控件，那么我们就要判断这个效果是基于哪种基础控件之上
 */

public class ObservableScrollView extends ScrollView {

    //1.创建对象的时候
    public ObservableScrollView(Context context) {
//        super(context);
        this(context, null);
    }

    //2.XML中使用的时候回调
    public ObservableScrollView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    //3.在XML中使用,且使用Style风格中.
    public ObservableScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public interface ScrollViewListenner {

        //ScrollView自动一个滑动监听,对其进行复写 参数1、监听的view对象 2、3 新的坐标 4、5旧的坐标
        void onScrollChanged(ObservableScrollView scrollView, int l, int t, int oldl, int oldt);
    }

    //自己的监听对象
    private ScrollViewListenner mScrollViewListener;

    //提供方法,让外界可以设置ScrollView的监听对象
    public void setScrollViewListenner(ScrollViewListenner scrollViewListenner) {
        mScrollViewListener = scrollViewListenner;
    }

    //提供一个复写的滑动监听方法,让外界可以设置ScrollView的监听对象
    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        if (mScrollViewListener != null) {
            mScrollViewListener.onScrollChanged(this, l, t, oldl, oldt);
        }
    }

}
