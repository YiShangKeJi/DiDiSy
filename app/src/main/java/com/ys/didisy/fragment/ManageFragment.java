package com.ys.didisy.fragment;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.ys.didisy.R;
import com.ys.didisy.adapter.TyViewPagerAdapter;
import java.util.ArrayList;
import java.util.List;

/**
 * 订单管理
 */
public class ManageFragment extends Fragment implements View.OnClickListener {
    public View view;
    private Context context;
    private TextView tv_all;
    private TextView tv_service;
    private TextView tv_evaluate;
    private TextView tv_cancel;
    //
    private ViewPager vp_manage;
    private TyViewPagerAdapter adapter;
    public List<Fragment> fragments = new ArrayList<Fragment>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_manage, null);
        context = getActivity();
        initView();
        setDefault();
        return view;
    }

    private void setDefault() {
        setBottomDrawable(tv_all);
        ManageAllPage manageAllPage = new ManageAllPage();
        ManageServicePage manageServicePage = new ManageServicePage();
        ManageEvaluatePage manageEvaluatePage = new ManageEvaluatePage();
        ManageCancelPage manageCancelPage = new ManageCancelPage();
        fragments.add(manageAllPage);
        fragments.add(manageServicePage);
        fragments.add(manageEvaluatePage);
        fragments.add(manageCancelPage);
        adapter = new TyViewPagerAdapter(getActivity().getSupportFragmentManager(), fragments);
        vp_manage.setAdapter(adapter);
    }

    private void initView() {
        tv_all = (TextView) view.findViewById(R.id.tv_all);
        tv_service = (TextView) view.findViewById(R.id.tv_service);
        tv_evaluate = (TextView) view.findViewById(R.id.tv_evaluate);
        tv_cancel = (TextView) view.findViewById(R.id.tv_cancel);
        //
        vp_manage = (ViewPager) view.findViewById(R.id.vp_manage);
        tv_all.setOnClickListener(this);
        tv_service.setOnClickListener(this);
        tv_evaluate.setOnClickListener(this);
        tv_cancel.setOnClickListener(this);
        vp_manage.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == 0) {
                    setBottomDrawable(tv_all);
                } else if (position == 1) {
                    setBottomDrawable(tv_service);
                } else if (position == 2) {
                    setBottomDrawable(tv_evaluate);
                } else if (position == 3) {
                    setBottomDrawable(tv_cancel);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_all:
                setBottomDrawable(tv_all);
                vp_manage.setCurrentItem(0);
                break;
            case R.id.tv_service:
                setBottomDrawable(tv_service);
                vp_manage.setCurrentItem(1);
                break;
            case R.id.tv_evaluate:
                setBottomDrawable(tv_evaluate);
                vp_manage.setCurrentItem(2);
                break;
            case R.id.tv_cancel:
                setBottomDrawable(tv_cancel);
                vp_manage.setCurrentItem(3);
                break;
            default:
                break;
        }
    }

    /**
     * 设置滑动活点击选中状态
     *
     * @param textView
     */
    private void setBottomDrawable(TextView textView) {
        Drawable drawableOn = getResources().getDrawable(R.color.button_yellow);
        Drawable drawableOff = getResources().getDrawable(R.color.touming);
        drawableOn.setBounds(0, 0, 200, 6);
        drawableOff.setBounds(0, 0, 200, 6);
        tv_all.setCompoundDrawables(null, null, null, drawableOff);
        tv_service.setCompoundDrawables(null, null, null, drawableOff);
        tv_evaluate.setCompoundDrawables(null, null, null, drawableOff);
        tv_cancel.setCompoundDrawables(null, null, null, drawableOff);
        textView.setCompoundDrawables(null, null, null, drawableOn);

        tv_all.setTextColor(Color.BLACK);
        tv_service.setTextColor(Color.BLACK);
        tv_evaluate.setTextColor(Color.BLACK);
        tv_cancel.setTextColor(Color.BLACK);
        textView.setTextColor(getResources().getColor(R.color.zise));
    }

}
