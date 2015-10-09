package com.jpt168.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.jpt168.R;
import com.jpt168.application.LogManager;
import com.jpt168.util.Util;
import com.jpt168.view.fragment.FlightOrderFragment;
import com.jpt168.view.fragment.HomeFragment;
import com.jpt168.view.fragment.MessageFragment;
import com.jpt168.view.fragment.OrderManageFragment;
import com.jpt168.view.fragment.PersonalCenterFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by caomingyu on 15/9/16.
 * email:361786231@qq.com
 */
public class MainActivity extends FragmentActivity{
    private ViewPager mViewPager;
    private FragmentPagerAdapter mAdapter;
    private List<Fragment> mFragment = new ArrayList<Fragment>();

    /**
     * 底部五个按钮
     */
    private LinearLayout mTabBtnHome;
    private LinearLayout mTabBtnFlightOrder;
    private LinearLayout mTabBtnOrderManage;
    private LinearLayout mTabBtnMessage;
    private LinearLayout mTabBtnPersonalCenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
        setContentView(R.layout.activity_main);
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.title);
//        int userId = Util.getUserIdFromSharedPrefrences(MainActivity.this);
//        Log.i("Test","userId-->" + userId);
//        if (userId == -1) {
//            Intent intent = new Intent(MainActivity.this,LoginActivity.class);
//            startActivity(intent);
//        }
        mViewPager = (ViewPager) findViewById(R.id.id_viewpager);
        initView();
        mAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return mFragment.get(i);
            }

            @Override
            public int getCount() {
                return mFragment.size();
            }

        };

        mViewPager.setAdapter(mAdapter);
        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            private int currentIndex;
            @Override
            public void onPageScrolled(int i, float v, int i2) {

            }

            @Override
            public void onPageSelected(int i) {
                resetTabBtn();
                switch (i){
                    case 0:
                        ((ImageButton)mTabBtnHome.findViewById(R.id.btn_tab_bottom_home)).setImageResource(R.drawable.home_pressed);
                        break;
                    case 1:
                        ((ImageButton)mTabBtnFlightOrder.findViewById(R.id.btn_tab_bottom_flight_order)).setImageResource(R.drawable.flight_order_pressed);
                        break;
                    case 2:
                        ((ImageButton)mTabBtnOrderManage.findViewById(R.id.btn_tab_bottom_order_manage)).setImageResource(R.drawable.order_manage_pressed);
                        break;
                    case 3:
                        ((ImageButton)mTabBtnMessage.findViewById(R.id.btn_tab_bottom_message)).setImageResource(R.drawable.message_pressed);
                        break;
                    case 4:
                        ((ImageButton)mTabBtnPersonalCenter.findViewById(R.id.btn_tab_bottom_personal_center)).setImageResource(R.drawable.personal_center_pressed);
                        break;
                }
                currentIndex = i;
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        int userId = Util.getUserIdFromSharedPrefrences(MainActivity.this);
        Log.i("Test","userId-->" + userId);
        if (userId == -1) {
            Intent intent = new Intent(MainActivity.this,LoginActivity.class);
            startActivity(intent);
        }
    }

    protected void resetTabBtn() {
        ((ImageButton)mTabBtnHome.findViewById(R.id.btn_tab_bottom_home)).setImageResource(R.drawable.home);
        ((ImageButton)mTabBtnFlightOrder.findViewById(R.id.btn_tab_bottom_flight_order)).setImageResource(R.drawable.flight_order);
        ((ImageButton)mTabBtnOrderManage.findViewById(R.id.btn_tab_bottom_order_manage)).setImageResource(R.drawable.order_manage);
        ((ImageButton)mTabBtnMessage.findViewById(R.id.btn_tab_bottom_message)).setImageResource(R.drawable.message);
        ((ImageButton)mTabBtnPersonalCenter.findViewById(R.id.btn_tab_bottom_personal_center)).setImageResource(R.drawable.personal_center);

    }

    private void initView() {
        mTabBtnHome = (LinearLayout) findViewById(R.id.id_tab_bottom_home);
        mTabBtnFlightOrder = (LinearLayout) findViewById(R.id.id_tab_bottom_flight_order);
        mTabBtnOrderManage = (LinearLayout) findViewById(R.id.id_tab_bottom_order_manage);
        mTabBtnMessage = (LinearLayout) findViewById(R.id.id_tab_bottom_message);
        mTabBtnPersonalCenter = (LinearLayout) findViewById(R.id.id_tab_bottom_personal_center);
        mTabBtnHome.setOnClickListener(new onClickListener());
        mTabBtnFlightOrder.setOnClickListener(new onClickListener());
        mTabBtnOrderManage.setOnClickListener(new onClickListener());
        mTabBtnMessage.setOnClickListener(new onClickListener());
        mTabBtnPersonalCenter.setOnClickListener(new onClickListener());
        HomeFragment homeFragment = new HomeFragment();
        FlightOrderFragment flightOrderFragment = new FlightOrderFragment();
        OrderManageFragment orderManageFragment = new OrderManageFragment();
        MessageFragment messageFragment = new MessageFragment();
        PersonalCenterFragment personalCenterFragment = new PersonalCenterFragment();
        mFragment.add(homeFragment);
        mFragment.add(flightOrderFragment);
        mFragment.add(orderManageFragment);
        mFragment.add(messageFragment);
        mFragment.add(personalCenterFragment);
    }

    private final class onClickListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            LogManager.i("v-->" + v.getId());
            Log.i("test","v-->" + v.getId());
            switch (v.getId()){
                case R.id.id_tab_bottom_home:
                    mViewPager.setCurrentItem(0);
                    break;
                case R.id.id_tab_bottom_flight_order:
                    mViewPager.setCurrentItem(1);
                    break;
                case R.id.id_tab_bottom_order_manage:
                    mViewPager.setCurrentItem(2);
                    break;
                case R.id.id_tab_bottom_message:
                    mViewPager.setCurrentItem(3);
                    break;
                case R.id.id_tab_bottom_personal_center:
                    mViewPager.setCurrentItem(4);
                    break;
            }
        }
    }

}
