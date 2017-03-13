package com.ys.didisy.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout.LayoutParams;
import com.ys.didisy.R;
import com.ys.didisy.util.AppManager;

public class OutDialog implements OnClickListener {
	private Context context;
	private Dialog dialog;
	private Button mUpdate;
	private Button mOut;

	public OutDialog(Context context) {
		this.context = context;
		initView();
	}

	private void initView() {
		dialog = BaseDialog.getIntence(context).getDialog(context,R.layout.dialog_out,
				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		mUpdate = (Button) dialog.findViewById(R.id.bt_update_number);
		mOut = (Button) dialog.findViewById(R.id.bt_out);
		mUpdate.setOnClickListener(this);
		mOut.setOnClickListener(this);
	}

	public void showDialog() {
		dialog.show();
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.bt_update_number:
//			Intent intent=new Intent(context, LoginActivity.class);
//			context.startActivity(intent);
//			dialog.dismiss();
			break;
		case R.id.bt_out:
			AppManager.getInstance().finish();
			break;
		default:
			break;
		}
	}

}
