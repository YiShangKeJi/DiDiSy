package com.ys.didisy.viewpager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import com.ys.didisy.R;

/**
 * 订单管理--全部
 */
public class ManageAllPage {
    public View view;
    private Context mContext;

    public ManageAllPage(Context context) {
        mContext = context;
        view = LayoutInflater.from(mContext).inflate(R.layout.viewpager_manage_all,
                null);
    }
}
