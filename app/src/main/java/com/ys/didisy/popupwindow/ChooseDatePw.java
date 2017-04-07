package com.ys.didisy.popupwindow;

import android.app.Activity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.ys.didisy.R;

/**
 * Created by Administrator on 2017/4/6.
 */

public class ChooseDatePw implements View.OnClickListener{
    private Activity context;
    private PopupWindow popupWindow;
    private WindowManager.LayoutParams alpha;
    private TextView tv_sure;
    private TextView tv_cancel;


    public ChooseDatePw(Activity context) {
        this.context = context;
        initView();
    }

    private void initView() {
        View contentView = LayoutInflater.from(context).inflate(R.layout.pw_choose_date, null);
        alpha = context.getWindow().getAttributes();
        popupWindow = new PopupWindow(contentView);
        popupWindow.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        popupWindow.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.setFocusable(true);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setAnimationStyle(R.style.bottom_anim);
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                alpha.alpha = 1f;
                context.getWindow().setAttributes(alpha);
            }
        });
        //
        tv_cancel = (TextView) contentView.findViewById(R.id.tv_cancel);
        tv_cancel.setOnClickListener(this);
        tv_sure = (TextView) contentView.findViewById(R.id.tv_sure);
        tv_sure.setOnClickListener(this);
    }

    public void showPopupWindow(View view) {
        alpha.alpha = 0.5f;
        context.getWindow().setAttributes(alpha);
        popupWindow.showAtLocation(view, Gravity.BOTTOM, 0, 0);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_cancel:
                popupWindow.dismiss();
                break;
            case R.id.tv_sure:
                popupWindow.dismiss();
                break;
        }
    }
}
