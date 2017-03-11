package com.ys.didisy.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.ys.didisy.R;

/**
 * 下单
 */
public class OrderFragment extends Fragment{
	public View view;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.fragment_order, null);
		initView();
		return view;
	}

	private void initView() {


	}

}