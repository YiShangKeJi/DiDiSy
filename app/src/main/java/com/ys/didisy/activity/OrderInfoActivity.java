package com.ys.didisy.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ys.didisy.R;
import com.ys.didisy.dialog.ExtraServiceDialog;
import com.ys.didisy.dialog.NoteDialog;
import com.ys.didisy.dialog.ReceiveInfoDialog;
import com.ys.didisy.dialog.SendInfoDialog;
import com.ys.didisy.popupwindow.BottomPopupWindow;


public class OrderInfoActivity extends BaseActivity implements View.OnClickListener {
    private LinearLayout ll_choose_date;
    private LinearLayout ll_location;
    private LinearLayout ll_destination;
    private LinearLayout ll_extra_service;
    private LinearLayout ll_note;

    private TextView tv_back;

    private ExtraServiceDialog extraServiceDialog;
    private SendInfoDialog sendInfoDialog;
    private ReceiveInfoDialog receiveInfoDialog;
    private NoteDialog noteDialog;

    private BottomPopupWindow bottomPopupWindow;

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
        noteDialog = new NoteDialog(this);
        bottomPopupWindow = new BottomPopupWindow(this);
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
        ll_note = (LinearLayout) findViewById(R.id.ll_note);
        ll_note.setOnClickListener(this);
        tv_back = (TextView) findViewById(R.id.tv_back);
        tv_back.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_back:
                finish();
                break;
            case R.id.ll_extra_service:
                extraServiceDialog.showDialog();
                break;
            case R.id.ll_choose_date:
                bottomPopupWindow.showPopupWindow(ll_choose_date);
                break;
            case R.id.ll_location:
                sendInfoDialog.showDialog();
                break;
            case R.id.ll_destination:
                receiveInfoDialog.showDialog();
                break;
            case R.id.ll_note:
                noteDialog.showDialog();
                break;
        }
    }
}