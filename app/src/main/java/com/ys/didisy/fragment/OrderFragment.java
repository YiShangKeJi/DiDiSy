package com.ys.didisy.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ys.didisy.R;
import com.ys.didisy.activity.MapActivity;

/**
 * 下单
 */
public class OrderFragment extends Fragment implements View.OnClickListener{
	public View view;
	private TextView tv_map;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.fragment_order, null);
		initView();
		return view;
	}

	private void initView() {
		tv_map = (TextView) view.findViewById(R.id.tv_map);
		tv_map.setOnClickListener(this);
	}


	@Override
	public void onClick(View view) {
		switch (view.getId()){
			case R.id.tv_map:
				Intent intent = new Intent(getActivity(), MapActivity.class);
				startActivity(intent);
				break;
		}
	}
}