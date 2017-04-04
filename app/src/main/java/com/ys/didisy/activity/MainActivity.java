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
import com.ys.didisy.widget.FormerCircleImageView;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/img3/6.
 */
public class MainActivity extends BaseFragmentActivity implements OnCheckedChangeListener {
    private OrderFragment orderFragment;
    private ManageFragment manageFragment;
    private ActivityFragment activityFragment;
    private PersonFragment personFragment;
    private RadioGroup group;
    private SureCancelDialog sureCancelDialog;
    private ViewPager vp_manage;
    public List<Fragment> fragments = new ArrayList<Fragment>();
    private TyViewPagerAdapter adapter;
    private TextView title;
    private DrawerLayout activity_main;
    private LinearLayout menuLayout;
    private FormerCircleImageView useerImage;
    private ImageView my_on;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();//布局初始化
        initLogic();//逻辑处理
    }

    private void initView() {
        sureCancelDialog = new SureCancelDialog(this);//程序退出询问框
        useerImage = (FormerCircleImageView)findViewById(R.id.imageTouxiang);//用户头像
        group = (RadioGroup) findViewById(R.id.rg_main);
        title = (TextView)findViewById(R.id.title);//标题
        activity_main = (DrawerLayout) findViewById(R.id.activity_main);
        my_on = (ImageView) findViewById(R.id.my_on);
//        activity_main.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);//侧滑手势
        menuLayout = (LinearLayout) findViewById(R.id.fragment_person); // 侧滑布局
        vp_manage = (ViewPager) findViewById(R.id.vp_manage_mian); //初始化Fragment
    }

    /**
     * 逻辑处理
     */
    private void initLogic(){
        useerImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(activity_main!=null&&menuLayout!=null){
                    //侧滑界面打开
                    activity_main.openDrawer(menuLayout);
                }
            }
        });
        title.setText("下单");
        group.setOnCheckedChangeListener(this);
        //下单
        orderFragment = new OrderFragment();
        fragments.add(orderFragment);
        //订单管理
        manageFragment = new ManageFragment();
        fragments.add(manageFragment);
        //优惠活动
        activityFragment = new ActivityFragment();
        fragments.add(activityFragment);
        //我的
//        personFragment = new PersonFragment();
//        fragments.add(personFragment);
        adapter = new TyViewPagerAdapter(getSupportFragmentManager(), fragments);
        //预加载4张，避免切换闪屏问题
        vp_manage.setOffscreenPageLimit(3);
        vp_manage.setAdapter(adapter);
        vp_manage.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                ((RadioButton) group.getChildAt(position)).setChecked(true);
                if(position==0){
                    title.setText("下单");
                    my_on.setVisibility(View.VISIBLE);
                }else if(position==1){
                    title.setText("订单管理");
                    my_on.setVisibility(View.GONE);
                }
                else if(position==2){
                    title.setText("优惠活动");
                    my_on.setVisibility(View.GONE);
                }
                else{
                    title.setText("我的");
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int id) {
        switch (id) {
            case R.id.rb_homepage:
                ((RadioButton) group.getChildAt(0)).setChecked(true);
                vp_manage.setCurrentItem(0, false);
                title.setText("下单");
                break;
            case R.id.rb_plan:
                ((RadioButton) group.getChildAt(1)).setChecked(true);
                vp_manage.setCurrentItem(1, false);
                title.setText("订单管理");
                break;
            case R.id.rb_friend:
                ((RadioButton) group.getChildAt(2)).setChecked(true);
                vp_manage.setCurrentItem(2, false);
                title.setText("优惠活动");
                break;
            case R.id.rb_person:
                ((RadioButton) group.getChildAt(3)).setChecked(true);
                vp_manage.setCurrentItem(3, false);
                title.setText("我的");
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
