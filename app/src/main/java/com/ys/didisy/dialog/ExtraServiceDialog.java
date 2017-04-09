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
 * 额外服务
 */
public class ExtraServiceDialog implements OnClickListener {
    private Context context;
    private Dialog dialog;
    private RelativeLayout rl_back;


    public ExtraServiceDialog(Context context) {
        this.context = context;
        initView();
    }

    private void initView() {
        dialog = BaseDialog.getIntence(context).getDialog(R.layout.dialog_extra_service,
                LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        rl_back = (RelativeLayout) dialog.findViewById(R.id.rl_back);
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
            default:
                break;
        }
    }

}
