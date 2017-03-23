package com.ys.didisy.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class TyViewPagerAdapter extends FragmentPagerAdapter {

	private List<Fragment>  Fragmentlist;
	private String[] title;

	public TyViewPagerAdapter(FragmentManager fm) {
		super(fm);
	}

	public TyViewPagerAdapter(FragmentManager fm,
									 List<Fragment> Fragmentlist) {
		super(fm);
		this.Fragmentlist = Fragmentlist;

	}

	public void setPublishListFragment(List<Fragment> list) {
		this.Fragmentlist = list;
	}

	public void settitle(String[] title) {
		this.title = title;
	}

	@Override
	public Fragment getItem(int arg0) {
		if (Fragmentlist != null)
			return Fragmentlist.get(arg0);
		else
			return null;
	}

	@Override
	public int getCount() {
		if (Fragmentlist != null)
			return Fragmentlist.size();
		else
			return 0;
	}

	@Override
	public CharSequence getPageTitle(int position) {

		if (title != null)
			return title[position];
		else
			return super.getPageTitle(position);
	}

	@Override
	public int getItemPosition(Object object) {
		return POSITION_NONE;
	}

	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		// TODO Auto-generated method stub
		super.destroyItem(container, position, object);
	}
	//加载页面
	@Override
	public Object instantiateItem(ViewGroup container, int position) {

		return super.instantiateItem(container, position);
	}
}