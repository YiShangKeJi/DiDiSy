package com.ys.didisy.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.ys.didisy.R;

/**
 * Created by Administrator on 2017/4/8 0008.
 */
public class UserAgreementActivity extends BaseActivity implements View.OnClickListener{
    private TextView tv_back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_useragreement);
        initView();
    }
    public void initView() {
        tv_back = (TextView) findViewById(R.id.tv_back);
        tv_back.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_back:
                finish();
                break;
            default:
                break;
        }
    }
}
