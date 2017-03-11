package com.ys.didisy.viewpager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import com.ys.didisy.R;

/**
 * 订单管理--服务中
 */
public class ManageServicePage {
    public View view;
    private Context mContext;

    public ManageServicePage(Context context) {
        mContext = context;
        view = LayoutInflater.from(mContext).inflate(R.layout.viewpager_manage_service,
                null);
    }
}
