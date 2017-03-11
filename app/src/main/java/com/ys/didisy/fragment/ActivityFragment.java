package com.ys.didisy.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ys.didisy.R;

/**
 * 优惠活动
 */
public class ActivityFragment extends Fragment {
    private View view;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_activity, null);
        init();
        return view;
    }

    private void init() {

    }

}
