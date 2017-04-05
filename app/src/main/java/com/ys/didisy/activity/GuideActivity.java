package com.ys.didisy.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ys.didisy.R;
import com.ys.didisy.adapter.MyPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * 引导页
 */
public class GuideActivity extends Activity implements
        ViewPager.OnPageChangeListener, View.OnClickListener {
    private ViewPager viewPager;
    private View[] mPoint;// 存放小圆点
    private MyPagerAdapter adapter;
    private List<Integer> mImageList;
    private SharedPreferences preferences;

    private LinearLayout mGroup;
    private LinearLayout ll_enter;
    private TextView tv_look;
    private TextView tv_sign;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        init();
        initPoint();
        setShared();
    }

    private void setShared() {
        preferences = getSharedPreferences("use", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt("count", 1);
        editor.commit();
    }

    private void init() {
        viewPager = (ViewPager) findViewById(R.id.vp_welcome);
        ll_enter = (LinearLayout) findViewById(R.id.ll_enter);
        mGroup = (LinearLayout) findViewById(R.id.view_group_welcome);
        tv_look = (TextView) findViewById(R.id.tv_look);
        tv_look.setOnClickListener(this);
        tv_sign = (TextView) findViewById(R.id.tv_sign);
        tv_sign.setOnClickListener(this);
        mImageList = new ArrayList<Integer>();
        mImageList.add(R.drawable.img1);
        mImageList.add(R.drawable.img2);
        mImageList.add(R.drawable.img3);
        adapter = new MyPagerAdapter(this, mImageList);
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(this);
    }

    /**
     * 初始化小圆点
     */
    private void initPoint() {
        // 给数组添加小圆点
        mPoint = new View[mImageList.size()];
        LinearLayout.LayoutParams paramsv = new LinearLayout.LayoutParams(15,
                15);
        for (int i = 0; i < mPoint.length; i++) {
            View v = new View(this);
            if (i == 0) {
                // 设置大小
                v.setLayoutParams(paramsv);
                // 设置背景
                v.setBackgroundResource(R.drawable.yuan_baise);
                paramsv.setMargins(6, 0, 6, 0);
                mPoint[i] = v;
                mGroup.addView(v);
            } else {
                // 设置大小
                v.setLayoutParams(paramsv);
                // 设置背景
                v.setBackgroundResource(R.drawable.yuan_toming);
                paramsv.setMargins(6, 0, 6, 0);
                mPoint[i] = v;
                mGroup.addView(v);
            }
        }
    }

    @Override
    public void onPageScrollStateChanged(int arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onPageScrolled(int arg0, float arg1, int arg2) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onPageSelected(int position) {
        if (position == mPoint.length - 1) {
            ll_enter.setVisibility(View.VISIBLE);
            mGroup.setVisibility(View.GONE);
        } else {
            ll_enter.setVisibility(View.GONE);
            mGroup.setVisibility(View.VISIBLE);
            for (int i = 0; i < mPoint.length; i++) {
                mPoint[position].setBackgroundResource(R.drawable.yuan_baise);
                if (position != i) {
                    mPoint[i].setBackgroundResource(R.drawable.yuan_toming);
                }
            }
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_look:
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.tv_sign:
                Intent intent1 = new Intent(this, MainActivity.class);
                startActivity(intent1);
                break;
        }
    }
}