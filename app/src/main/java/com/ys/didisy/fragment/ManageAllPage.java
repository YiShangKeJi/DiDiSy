package com.ys.didisy.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ys.didisy.R;
import com.ys.didisy.activity.BaseFragmentActivity;

/**
 * 订单管理--全部
 */
public class ManageAllPage extends Fragment {
    public View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.viewpager_manage_all, null);
        return view;
    }
}
