package com.ys.didisy.popupwindow;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import com.ys.didisy.R;

/**
 * Created by Administrator on 2017/4/5.
 */

public class AppPopupWindow {

    /**
     * 底部弹出PopupWindow
     * 点击PopupWindow以外部分或点击返回键时,PopupWindow 会 消失
     */
    public static void showBottomPopupWindow(Context context) {
        //自定义PopupWindow的布局
        View contentView = LayoutInflater.from(context).inflate(R.layout.pw_choose_date, null);
        //初始化PopupWindow,并为其设置布局文件

        PopupWindow popupWindow = new PopupWindow(contentView);
        //设置PopupWindow的宽和高,必须设置,否则不显示内容(也可用PopupWindow的构造方法设置宽高)
        popupWindow.setWidth(LinearLayout.LayoutParams.MATCH_PARENT);
        popupWindow.setHeight(LinearLayout.LayoutParams.WRAP_CONTENT);
        //当需要点击返回键,或者点击空白时,需要设置下面两句代码.
        //如果有背景，则会在contentView外面包一层PopupViewContainer之后作为mPopupView，如果没有背景，则直接用contentView作为mPopupView。
        //而这个PopupViewContainer是一个内部私有类，它继承了FrameLayout，在其中重写了Key和Touch事件的分发处理
        popupWindow.setFocusable(true);
        popupWindow.setBackgroundDrawable(new ColorDrawable(0x00000000));   //为PopupWindow设置透明背景.
        popupWindow.setOutsideTouchable(false);
        //设置PopupWindow进入和退出动画
        popupWindow.setAnimationStyle(R.anim.in_bottomtotop);
        //设置PopupWindow显示的位置
        popupWindow.showAtLocation(contentView, Gravity.BOTTOM, 0, 0);
    }
}
