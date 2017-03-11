package com.ys.didisy.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.Display;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;

import com.ys.didisy.R;

public class BaseDialog extends Dialog {

    public BaseDialog(Context context) {
        super(context);

    }

    public static  Dialog getDialog(Activity m_Context, int layout, int width, int height) {
        // TODO Auto-generated constructor stub
        Dialog dialog = new Dialog(m_Context, R.style.dialog);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(layout);
        Window dialogWindow = dialog.getWindow();
        dialogWindow.setGravity(Gravity.CENTER_VERTICAL);
        WindowManager manager = m_Context.getWindow().getWindowManager();
        Display d = manager.getDefaultDisplay(); // 获取屏幕宽、高用
        WindowManager.LayoutParams p = dialogWindow.getAttributes(); // 获取对话框当前的参数值
        p.height = height;
        p.width = width;
        p.alpha = 1.0f; // 透明度
        if (width == 0) {
            p.height = (int) (d.getHeight() * 0.4); // 高度设置为屏幕的0.4
        }
        if (height == 0) {
            p.width = (int) (d.getWidth() * 0.8); // 宽度设置为屏幕的0.8
        }
        // 设置窗体始终点亮
        dialog.getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON,
                WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        dialogWindow.setAttributes(p);
        return dialog;
    }

}
