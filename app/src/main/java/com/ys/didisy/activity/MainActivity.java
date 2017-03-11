package com.ys.didisy.activity;

import android.os.Bundle;
import com.ys.didisy.R;
import com.ys.didisy.constant.Constant;
import com.ys.didisy.dialog.SureCancelDialog;
import com.ys.didisy.fragment.PersonFragment;
import com.ys.didisy.fragment.OrderFragment;
import com.ys.didisy.fragment.ActivityFragment;
import com.ys.didisy.fragment.ManageFragment;
import com.ys.didisy.util.AppManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.WindowManager;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

/**
 * Created by Administrator on 2017/3/6.
 */
public class MainActivity extends FragmentActivity implements OnCheckedChangeListener {
    private FragmentManager manager;
    private FragmentTransaction transaction;
    private OrderFragment orderFragment;
    private ManageFragment manageFragment;
    private ActivityFragment activityFragment;
    private PersonFragment personFragment;
    private RadioGroup group;
    private SureCancelDialog sureCancelDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        AppManager.getInstance().addActivity(this);
        sureCancelDialog = new SureCancelDialog(this);
        initView();
        setFragment(orderFragment);
    }

    private void initView() {
        group = (RadioGroup) findViewById(R.id.rg_main);
        group.setOnCheckedChangeListener(this);
        //初始化Fragment
        orderFragment = new OrderFragment();
        manageFragment = new ManageFragment();
        activityFragment = new ActivityFragment();
        personFragment = new PersonFragment();
    }


    private void setFragment(Fragment currenFragment) {
        manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();
        transaction.hide(orderFragment).hide(manageFragment)
                .hide(activityFragment).hide(personFragment);
        if (currenFragment.isAdded()) {
            transaction.show(currenFragment);
        } else {
            transaction.add(R.id.fl_main, currenFragment);
            transaction.show(currenFragment);
        }
        transaction.commit();
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int id) {
        switch (id) {
            case R.id.rb_homepage:
                setFragment(orderFragment);
                break;
            case R.id.rb_plan:
                setFragment(manageFragment);
                break;
            case R.id.rb_friend:
                setFragment(activityFragment);
                break;
            case R.id.rb_person:
                setFragment(personFragment);
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
