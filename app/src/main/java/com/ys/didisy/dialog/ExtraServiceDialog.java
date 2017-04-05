package com.ys.didisy.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.ys.didisy.R;

/**
 * 额外服务
 */
public class ExtraServiceDialog implements OnClickListener {
    private Context context;
    private Dialog dialog;
    private TextView tv_back;


    public ExtraServiceDialog(Context context) {
        this.context = context;
        initView();
    }

    private void initView() {
        dialog = BaseDialog.getIntence(context).getDialog(context, R.layout.dialog_extra_service,
                LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        tv_back = (TextView) dialog.findViewById(R.id.tv_back);
        tv_back.setOnClickListener(this);
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
            default:
                break;
        }
    }

}
