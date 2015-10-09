package com.jpt168.view.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.jpt168.view.MainActivity;
import com.jpt168.R;

import java.util.List;

/**
 * Created by caomingyu on 15/9/14.
 * email:361786231@qq.com
 */
public class ViewPagerAdapter extends PagerAdapter {

    //界面列表
    private List<View> views;
    private Activity activity;
    private static final String SHAREDPREFERENCES_NAME = "first_pref";

    public ViewPagerAdapter(List<View> views, Activity activity) {
        this.views = views;
        this.activity = activity;
    }

    //销毁arg1位置的界面
    @Override
    public void destroyItem(ViewGroup arg0, int arg1, Object arg2) {
        ((ViewPager)arg0).removeView(views.get(arg1));
    }

    @Override
    public int getCount() {
        if (views != null) {
            return views.size();
        }
        return 0;
    }

    @Override
    public Object instantiateItem(View arg0, int arg1) {
        ((ViewPager)arg0).addView(views.get(arg1),0);
        if (arg1 == views.size() - 1) {
            ImageView mStartInternationalJourneyButton = (ImageView) arg0.findViewById(R.id.iv_start_international_journey);
            mStartInternationalJourneyButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //设置已引导
                    setGuided();
                    goHome();
                }
            });
        }
        return views.get(arg1);
    }

    private void goHome() {
        //跳转
        Intent intent = new Intent(activity, MainActivity.class);
        activity.startActivity(intent);
        activity.finish();
    }

    /**
     * 设置已经引导过了，下次启动不用再次引导
     */
    private void setGuided() {
        SharedPreferences preferences = activity.getSharedPreferences(SHAREDPREFERENCES_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        //存入数据
        editor.putBoolean("isFirstIn",false);
        //提交修改
        editor.commit();
    }

    @Override
    public boolean isViewFromObject(View arg0, Object arg1) {
        return (arg0 == arg1);
    }
}
