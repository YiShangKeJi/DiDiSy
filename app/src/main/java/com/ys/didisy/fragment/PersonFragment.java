package com.ys.didisy.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.ys.didisy.R;

/**
 * 我的
 */
public class PersonFragment extends Fragment implements OnClickListener {
    public View view;
    private Activity mActivity;
    private LinearLayout mPerson;
    private LinearLayout mMember;
    private LinearLayout mSet;
    private TextView mNickName;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_person, null);
        initView();
        return view;
    }

    private void initView() {
    }


    @Override
    public void onClick(View view) {

    }
}
