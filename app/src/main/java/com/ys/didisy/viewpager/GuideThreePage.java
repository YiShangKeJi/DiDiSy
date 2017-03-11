package com.ys.didisy.viewpager;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.ys.didisy.R;
import com.ys.didisy.activity.MainActivity;

public class GuideThreePage implements OnClickListener {
    public View view;
    private Activity mContext;
    private TextView tv_look;
    private TextView tv_sign_in;

    public GuideThreePage(Activity context) {
        mContext = context;
        view = LayoutInflater.from(mContext).inflate(R.layout.viewpager_three, null);
        init();
    }

    private void init() {
        tv_look = (TextView) view.findViewById(R.id.tv_look);
        tv_look.setOnClickListener(this);
        tv_sign_in = (TextView) view.findViewById(R.id.tv_sign_in);
        tv_sign_in.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId() ){
            case R.id.tv_look:
                Intent intent1 = new Intent(mContext,MainActivity.class);
                mContext.startActivity(intent1);
                break;
            case R.id.tv_sign_in:
                Intent intent2 = new Intent(mContext,MainActivity.class);
                mContext.startActivity(intent2);
                break;
        }
    }
}
