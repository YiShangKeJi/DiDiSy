package com.ys.didisy.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.ys.didisy.R;
import com.ys.didisy.adapter.TyViewPagerAdapter;
import com.ys.didisy.viewpager.GuideOnePage;
import com.ys.didisy.viewpager.GuideThreePage;
import com.ys.didisy.viewpager.GuideTwoPage;
import java.util.ArrayList;
import java.util.List;

/**
 * 引导页
 */
public class GuideActivity extends BaseActivity implements
		ViewPager.OnPageChangeListener {
	private ViewPager viewPager;
	private ViewGroup mGroup;
	private View[] mPoint;// 存放小圆点
	private TyViewPagerAdapter adapter;
	private List<View> mViewList;
	private SharedPreferences preferences;

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
		mGroup = (ViewGroup) findViewById(R.id.view_group_welcome);
		GuideOnePage onePage = new GuideOnePage(this);
		GuideTwoPage twoPage = new GuideTwoPage(this);
		GuideThreePage threePage = new GuideThreePage(this);
		mViewList = new ArrayList<View>();
		mViewList.add(onePage.view);
		mViewList.add(twoPage.view);
		mViewList.add(threePage.view);
		adapter = new TyViewPagerAdapter(mViewList);
		viewPager.setAdapter(adapter);
		viewPager.addOnPageChangeListener(this);
	}
	/**
	 * 初始化小圆点
	 */
	private void initPoint() {
		// 给数组添加小圆点
		mPoint = new View[mViewList.size()];
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
		for (int i = 0; i < mPoint.length; i++) {
			mPoint[position].setBackgroundResource(R.drawable.yuan_baise);
			if (position != i) {
				mPoint[i].setBackgroundResource(R.drawable.yuan_toming);
			}
			if(position==mPoint.length-1){
				mGroup.setVisibility(View.GONE);
			}
		}

	}
}