package com.ys.didisy.activity;

import android.os.Bundle;

import com.ys.didisy.R;
import com.ys.didisy.adapter.TyViewPagerAdapter;
import com.ys.didisy.constant.Constant;
import com.ys.didisy.dialog.SureCancelDialog;
import com.ys.didisy.fragment.PersonFragment;
import com.ys.didisy.fragment.OrderFragment;
import com.ys.didisy.fragment.ActivityFragment;
import com.ys.didisy.fragment.ManageFragment;
import com.ys.didisy.util.AppManager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.KeyEvent;
import android.view.WindowManager;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/img3/6.
 */
public class MainActivity extends FragmentActivity implements OnCheckedChangeListener {
    private OrderFragment orderFragment;
    private ManageFragment manageFragment;
    private ActivityFragment activityFragment;
    private PersonFragment personFragment;
    private RadioGroup group;
    private SureCancelDialog sureCancelDialog;


    private ViewPager vp_manage;
    public List<Fragment> fragments = new ArrayList<Fragment>();
    private TyViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        AppManager.getInstance().addActivity(this);
        sureCancelDialog = new SureCancelDialog(this);
        initView();
    }

    private void initView() {
        group = (RadioGroup) findViewById(R.id.rg_main);
        group.setOnCheckedChangeListener(this);
        //初始化Fragment
        vp_manage = (ViewPager) findViewById(R.id.vp_manage_mian);
        manageFragment = new ManageFragment();
        fragments.add(manageFragment);
        orderFragment = new OrderFragment();
        fragments.add(orderFragment);
        activityFragment = new ActivityFragment();
        fragments.add(activityFragment);
        personFragment = new PersonFragment();
        fragments.add(personFragment);
        adapter = new TyViewPagerAdapter(getSupportFragmentManager(), fragments);
        vp_manage.setAdapter(adapter);
        vp_manage.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                ((RadioButton) group.getChildAt(position)).setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    @Override
    public void onCheckedChanged(RadioGroup group, int id) {
        switch (id) {
            case R.id.rb_plan:
                ((RadioButton) group.getChildAt(0)).setChecked(true);
                vp_manage.setCurrentItem(0, true);
                break;
            case R.id.rb_homepage:
                ((RadioButton) group.getChildAt(1)).setChecked(true);
                vp_manage.setCurrentItem(1, true);
                break;
            case R.id.rb_friend:
                ((RadioButton) group.getChildAt(2)).setChecked(true);
                vp_manage.setCurrentItem(2, true);
                break;
            case R.id.rb_person:
                ((RadioButton) group.getChildAt(3)).setChecked(true);
                vp_manage.setCurrentItem(3, true);
                break;
            default:
                break;
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_DOWN
                && event.getKeyCode() == KeyEvent.KEYCODE_BACK) {
            sureCancelDialog.showDialog(Constant.OUT_APP);
        }
        return false;
    }

}
