package com.ys.didisy.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;

import com.ys.didisy.R;

/**
 * 增加路线
 */
public class AddRouteDialog implements OnClickListener {
    private Context context;
    private Dialog dialog;
    private TextView tv_back;
    private LinearLayout ll_start_address;
    private LinearLayout ll_end_address;

    private SendInfoDialog sendInfoDialog;
    private ReceiveInfoDialog receiveInfoDialog;

    public AddRouteDialog(Context context) {
        this.context = context;
        initView();
        initData();
    }

    private void initData() {
        sendInfoDialog = new SendInfoDialog(context);
        receiveInfoDialog = new ReceiveInfoDialog(context);
    }

    private void initView() {
        dialog = BaseDialog.getIntence(context).getDialog(R.layout.dialog_add_route,
                LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        tv_back = (TextView) dialog.findViewById(R.id.tv_back);
        tv_back.setOnClickListener(this);
        ll_start_address = (LinearLayout) dialog.findViewById(R.id.ll_start_address);
        ll_start_address.setOnClickListener(this);
        ll_end_address = (LinearLayout) dialog.findViewById(R.id.ll_end_address);
        ll_end_address.setOnClickListener(this);
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
            case R.id.ll_start_address:
                sendInfoDialog.showDialog();
                break;
            case R.id.ll_end_address:
                receiveInfoDialog.showDialog();
                break;
            default:
                break;
        }
    }

}
