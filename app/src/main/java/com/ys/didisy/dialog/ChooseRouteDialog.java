package com.ys.didisy.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;

import com.ys.didisy.R;

import static com.ys.didisy.R.id.tv_add_route;

/**
 * 选择常用路线
 */
public class ChooseRouteDialog implements OnClickListener {
    private Context context;
    private Dialog dialog;
    private RelativeLayout rl_back;
    private LinearLayout ll_add_route;
    private TextView tv_manage;
    private AddRouteDialog addRouteDialog;
    private ManageRouteDialog manageRouteDialog;


    public ChooseRouteDialog(Context context) {
        this.context = context;
        initView();
        initData();
    }

    private void initData() {
        addRouteDialog = new AddRouteDialog(context);
        manageRouteDialog = new ManageRouteDialog(context);
    }

    private void initView() {
        dialog = BaseDialog.getIntence(context).getDialog(R.layout.dialog_choose_route,
                LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        rl_back = (RelativeLayout) dialog.findViewById(R.id.rl_back);
        ll_add_route = (LinearLayout) dialog.findViewById(R.id.ll_add_route);
        tv_manage = (TextView) dialog.findViewById(R.id.tv_manage);
        tv_manage.setOnClickListener(this);
        rl_back.setOnClickListener(this);
        ll_add_route.setOnClickListener(this);
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
            case R.id.ll_add_route:
                addRouteDialog.showDialog();
                break;
            case R.id.tv_manage:
                manageRouteDialog.showDialog();
                break;
            default:
                break;
        }
    }

}
