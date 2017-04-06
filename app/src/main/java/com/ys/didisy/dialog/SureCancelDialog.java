package com.ys.didisy.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.ys.didisy.R;
import com.ys.didisy.constant.Constant;
import com.ys.didisy.util.AppManager;

public class SureCancelDialog implements OnClickListener {
    private Context context;
    private Dialog dialog;
    private TextView mTitle;
    private Button mSure;
    private Button mCancel;
    private String title;

    public SureCancelDialog(Context context) {
        this.context = context;
        initView();
    }

    public void initView() {
        dialog = BaseDialog.getIntence(context).getDialog(R.layout.dialog_sure_cancel,
                LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        mSure = (Button) dialog.findViewById(R.id.bt_sure_dialog);
        mCancel = (Button) dialog.findViewById(R.id.bt_cancel_dialog);
        mTitle = (TextView) dialog.findViewById(R.id.tv_dialog_info);
        mSure.setOnClickListener(this);
        mCancel.setOnClickListener(this);

    }

    /**
     * 传入标题
     *
     * @param title
     */
    public void showDialog(String title) {
        dialog.show();
        this.title = title;
        if (title.equals(Constant.OUT_APP)) {
            mTitle.setText(R.string.out_app);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_sure_dialog:
                sure();
                break;
            case R.id.bt_cancel_dialog:
                dialog.dismiss();
                break;
            default:
                break;
        }
    }

    private void sure() {
        if (title.equals(Constant.OUT_APP)) {
            AppManager.getInstance().finish();
            dialog.dismiss();
        }
    }

}