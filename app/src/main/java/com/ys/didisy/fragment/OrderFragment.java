package com.ys.didisy.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ys.didisy.R;
import com.ys.didisy.activity.MapActivity;
import com.ys.didisy.activity.OrderInfoActivity;

/**
 * 下单
 */
public class OrderFragment extends Fragment implements View.OnClickListener {
    public View view;
    private TextView tv_map;
    private LinearLayout ll_small;
    private LinearLayout ll_middle;
    private LinearLayout ll_big;
    private LinearLayout ll_most;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_order, null);
        initView();
        return view;
    }

    private void initView() {
        tv_map = (TextView) view.findViewById(R.id.tv_map);
        ll_small = (LinearLayout) view.findViewById(R.id.ll_small);
        ll_middle = (LinearLayout) view.findViewById(R.id.ll_middle);
        ll_big = (LinearLayout) view.findViewById(R.id.ll_big);
        ll_most = (LinearLayout) view.findViewById(R.id.ll_most);
        ll_small.setOnClickListener(this);
        ll_middle.setOnClickListener(this);
        ll_big.setOnClickListener(this);
        ll_most.setOnClickListener(this);
        tv_map.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        Intent intent = null;
        switch (view.getId()) {
            case R.id.tv_map:
                intent = new Intent(getActivity(), MapActivity.class);
                startActivity(intent);
                break;
            case R.id.ll_small:
                intent = new Intent(getActivity(), OrderInfoActivity.class);

                break;
            case R.id.ll_middle:
                intent = new Intent(getActivity(), OrderInfoActivity.class);
                break;
            case R.id.ll_big:
                intent = new Intent(getActivity(), OrderInfoActivity.class);
                break;
            case R.id.ll_most:
                intent = new Intent(getActivity(), OrderInfoActivity.class);
                break;
        }
        startActivity(intent);
    }
}