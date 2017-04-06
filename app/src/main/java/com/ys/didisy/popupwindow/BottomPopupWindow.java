package com.ys.didisy.popupwindow;

import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ys.didisy.R;

/**
 * Created by Administrator on 2017/4/6.
 */

public class BottomPopupWindow {
    private Context context;
    private PopupWindow popupWindow;


    public BottomPopupWindow(Context context) {
        this.context = context;
        initView();
    }

    private void initView() {
        popupWindow = BasePopupWindow.getIntence(context).getPopupWindow(R.layout.pw_choose_date,
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.setAnimationStyle(R.style.bottom_anim);
    }

    public void showPopupWindow(View view) {
        popupWindow.showAtLocation(view, Gravity.BOTTOM, 0, 0);
    }
}
