package com.ys.didisy.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;

import com.ys.didisy.R;
import com.ys.didisy.activity.MainActivity;

/**
 * 验证手机号
 */
public class VerityDialog implements OnClickListener {
    private Context context;
    private Dialog dialog;
    private RelativeLayout rl_back;
    private TextView tv_next;


    public VerityDialog(Context context) {
        this.context = context;
        initView();
        initData();
    }

    private void initData() {

    }

    private void initView() {
        dialog = BaseDialog.getIntence(context).getDialog(R.layout.dialog_verity,
                LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        rl_back = (RelativeLayout) dialog.findViewById(R.id.rl_back);
        tv_next = (TextView) dialog.findViewById(R.id.tv_next);
        tv_next.setOnClickListener(this);
        rl_back.setOnClickListener(this);
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
                Intent intent = new Intent(context, MainActivity.class);
                context.startActivity(intent);
                break;
            default:
                break;
        }
    }

}
