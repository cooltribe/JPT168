package com.jpt168.view;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.jpt168.R;
import com.jpt168.view.adapter.ViewPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by caomingyu on 15/9/14.
 * email:361786231@qq.com
 */
public class GuideActivity extends Activity implements ViewPager.OnPageChangeListener {

    private ViewPager viewPager;
    private ViewPagerAdapter viewPagerAdapter;
    private List<View> views;
    //底部小点图片
    private ImageView[] dots;
    //记录当前选中位置
    private int currentIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guide);
        //初始化页面
        initViews();
        //初始化底部小点
        initDots();
    }

    private void initViews() {
        LayoutInflater inflater = LayoutInflater.from(this);
        views = new ArrayList<View>();
        //初始化引导图片
        views.add(inflater.inflate(R.layout.guide_one,null));
        views.add(inflater.inflate(R.layout.guide_two,null));
        views.add(inflater.inflate(R.layout.guide_three,null));
        views.add(inflater.inflate(R.layout.guide_four,null));
        //初始化adapter
        viewPagerAdapter = new ViewPagerAdapter(views,this);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(viewPagerAdapter);
        //绑定回调
        viewPager.setOnPageChangeListener(this);
    }

    private void initDots() {
        LinearLayout ll = (LinearLayout) findViewById(R.id.ll);
        dots = new ImageView[views.size()];
        //循环取得小点图片
        for (int i = 0; i < views.size(); i++) {
            dots[i] = (ImageView)ll.getChildAt(i);
            dots[i].setEnabled(false);//都设成灰色
        }
        currentIndex = 0;
        dots[currentIndex].setEnabled(true);
    }

    private void setCurrentDot(int position){
        if (position < 0 || position > views.size() - 1 || currentIndex == position) {
            return;
        }
        dots[position].setEnabled(true);
        dots[currentIndex].setEnabled(false);
        currentIndex = position;
    }

    //当前页面被滑动时调用
    @Override
    public void onPageScrolled(int i, float v, int i2) {

    }

    //当新的页面被选中时调用
    @Override
    public void onPageSelected(int arg0) {
        //设置底部小点选中状态
        setCurrentDot(arg0);
    }

    //当滑动状态改变时调用
    @Override
    public void onPageScrollStateChanged(int i) {

    }
}
