package com.ys.didisy.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;

import com.ys.didisy.R;

/**
 * 登录
 */
public class LoginDialog implements OnClickListener {
    private Context context;
    private Dialog dialog;
    private RelativeLayout rl_back;
    private VerityDialog verityDialog;
    private TextView tv_next;


    public LoginDialog(Context context) {
        this.context = context;
        initView();
        initData();
    }

    private void initData() {
        verityDialog = new VerityDialog(context);
    }

    private void initView() {
        dialog = BaseDialog.getIntence(context).getDialog(R.layout.dialog_login,
                LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        rl_back = (RelativeLayout) dialog.findViewById(R.id.rl_back);
        tv_next = (TextView) dialog.findViewById(R.id.tv_next);
        rl_back.setOnClickListener(this);
        tv_next.setOnClickListener(this);
    }

    public void showDialog() {
        dialog.show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rl_back:
                dialog.dismiss();
                break;
            case R.id.tv_next:
                verityDialog.showDialog();
                break;
            default:
                break;
        }
    }

}
