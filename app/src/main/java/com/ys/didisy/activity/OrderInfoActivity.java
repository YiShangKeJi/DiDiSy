package com.ys.didisy.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.LinearLayout;

import com.ys.didisy.R;
import com.ys.didisy.dialog.ExtraServiceDialog;
import com.ys.didisy.dialog.ReceiveInfoDialog;
import com.ys.didisy.dialog.SendInfoDialog;
import com.ys.didisy.popupwindow.AppPopupWindow;


public class OrderInfoActivity extends BaseActivity implements View.OnClickListener{
	private LinearLayout ll_choose_date;
	private LinearLayout ll_location;
	private LinearLayout ll_destination;
	private LinearLayout ll_extra_service;

	private ExtraServiceDialog extraServiceDialog;
    private SendInfoDialog sendInfoDialog;
	private ReceiveInfoDialog receiveInfoDialog;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_order_info);
		init();
		initData();
	}

	private void initData() {
		extraServiceDialog = new ExtraServiceDialog(this);
		sendInfoDialog = new SendInfoDialog(this);
		receiveInfoDialog = new ReceiveInfoDialog(this);
	}

	private void init() {
		ll_choose_date = (LinearLayout) findViewById(R.id.ll_choose_date);
		ll_choose_date.setOnClickListener(this);
		ll_extra_service = (LinearLayout) findViewById(R.id.ll_extra_service);
		ll_extra_service.setOnClickListener(this);
		ll_location = (LinearLayout) findViewById(R.id.ll_location);
		ll_location.setOnClickListener(this);
		ll_destination = (LinearLayout) findViewById(R.id.ll_destination);
		ll_destination.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()){
			case R.id.ll_extra_service:
				extraServiceDialog.showDialog();
				break;
			case R.id.ll_choose_date:
				AppPopupWindow.showBottomPopupWindow(this);
				break;
			case R.id.ll_location:
				sendInfoDialog.showDialog();
				break;
			case R.id.ll_destination:
				receiveInfoDialog.showDialog();
				break;
		}
	}
}