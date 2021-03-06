package com.ys.didisy.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ys.didisy.R;
import com.ys.didisy.dialog.ChooseRouteDialog;
import com.ys.didisy.dialog.ExtraServiceDialog;
import com.ys.didisy.dialog.NoteDialog;
import com.ys.didisy.dialog.OrderAffirmDialog;
import com.ys.didisy.dialog.ReceiveInfoDialog;
import com.ys.didisy.dialog.SendInfoDialog;
import com.ys.didisy.popupwindow.ChooseDatePw;


public class OrderInfoActivity extends BaseActivity implements View.OnClickListener {
    private LinearLayout ll_choose_date;
    private LinearLayout ll_location;
    private LinearLayout ll_destination;
    private LinearLayout ll_extra_service;
    private LinearLayout ll_note;

    private RelativeLayout rl_back;
    private TextView tv_rote;
    private TextView tv_next;

    private ExtraServiceDialog extraServiceDialog;
    private SendInfoDialog sendInfoDialog;
    private ReceiveInfoDialog receiveInfoDialog;
    private NoteDialog noteDialog;
    private ChooseRouteDialog chooseRouteDialog;
    private OrderAffirmDialog orderAffirmDialog;

    private ChooseDatePw chooseDatePw;

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
        chooseDatePw = new ChooseDatePw(this);
        chooseRouteDialog = new ChooseRouteDialog(this);
        orderAffirmDialog = new OrderAffirmDialog(this);
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
        rl_back = (RelativeLayout) findViewById(R.id.rl_back);
        rl_back.setOnClickListener(this);
        tv_rote = (TextView) findViewById(R.id.tv_rote);
        tv_rote.setOnClickListener(this);
        tv_next = (TextView) findViewById(R.id.tv_next);
        tv_next.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rl_back:
                finish();
                break;
            case R.id.tv_rote:
                chooseRouteDialog.showDialog();
                break;
            case R.id.ll_extra_service:
                extraServiceDialog.showDialog();
                break;
            case R.id.ll_choose_date:
                chooseDatePw.showPopupWindow(ll_choose_date);
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
            case R.id.tv_next:
                orderAffirmDialog.showDialog();
                break;
        }
    }
}