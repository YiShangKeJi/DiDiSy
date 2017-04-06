package com.ys.didisy.popupwindow;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import com.ys.didisy.R;


/**
 * Created by Administrator on 2017/4/6.
 */

public class BasePopupWindow extends PopupWindow {

    public static BasePopupWindow basePopupWindow;
    public static Context mContext;

    public BasePopupWindow(Context context) {
        super(context);

    }

    public static BasePopupWindow getIntence(Context context) {
        if (basePopupWindow == null) {
            basePopupWindow = new BasePopupWindow(context);
        }
        mContext = context;
        return basePopupWindow;
    }

    public PopupWindow getPopupWindow(int layout, int width, int height) {
        // TODO Auto-generated constructor stub
        View contentView = LayoutInflater.from(mContext).inflate(layout, null);
        PopupWindow popupWindow = new PopupWindow(contentView);
        popupWindow.setWidth(width);
        popupWindow.setHeight(height);
        popupWindow.setFocusable(true);
        // 实例化一个ColorDrawable颜色为半透明
        popupWindow.setBackgroundDrawable(new ColorDrawable(0xb0000000));
        popupWindow.setOutsideTouchable(true);
        return popupWindow;
    }
}
