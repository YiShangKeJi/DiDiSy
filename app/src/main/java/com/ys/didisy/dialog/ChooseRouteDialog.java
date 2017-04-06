package com.ys.didisy.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;

import com.ys.didisy.R;

/**
 * 路线管理
 */
public class ChooseRouteDialog implements OnClickListener {
    private Context context;
    private Dialog dialog;
    private TextView tv_back;
    private TextView tv_add_route;
    private AddRouteDialog addRouteDialog;


    public ChooseRouteDialog(Context context) {
        this.context = context;
        initView();
        initData();
    }

    private void initData() {
        addRouteDialog = new AddRouteDialog(context);
    }

    private void initView() {
        dialog = BaseDialog.getIntence(context).getDialog(R.layout.dialog_choose_route,
                LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        tv_back = (TextView) dialog.findViewById(R.id.tv_back);
        tv_add_route = (TextView) dialog.findViewById(R.id.tv_add_route);
        tv_back.setOnClickListener(this);
        tv_add_route.setOnClickListener(this);
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
            case R.id.tv_add_route:
                addRouteDialog.showDialog();
                break;
            default:
                break;
        }
    }

}
