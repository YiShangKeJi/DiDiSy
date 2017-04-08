package com.ys.didisy.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;

import com.ys.didisy.R;

/**
 * 订单确认
 */
public class OrderAffirmDialog implements OnClickListener {
    private Context context;
    private Dialog dialog;
    private TextView tv_back;
    private TextView tv_order;


    public OrderAffirmDialog(Context context) {
        this.context = context;
        initView();
    }

    private void initView() {
        dialog = BaseDialog.getIntence(context).getDialog(R.layout.dialog_order_affirm,
                LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        tv_back = (TextView) dialog.findViewById(R.id.tv_back);
        tv_back.setOnClickListener(this);
        tv_order = (TextView) dialog.findViewById(R.id.tv_order);
        tv_order.setOnClickListener(this);
    }

    public void showDialog() {
        dialog.show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_back:
                dialog.dismiss();
                break;
            case R.id.tv_order:

                break;
            default:
                break;
        }
    }

}
