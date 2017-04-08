package com.ys.didisy.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;

import com.ys.didisy.R;
import com.ys.didisy.adapter.TyViewPagerAdapter;
import com.ys.didisy.constant.Constant;
import com.ys.didisy.dialog.SureCancelDialog;
import com.ys.didisy.fragment.PersonFragment;
import com.ys.didisy.fragment.OrderFragment;
import com.ys.didisy.fragment.ActivityFragment;
import com.ys.didisy.fragment.ManageFragment;
import com.ys.didisy.util.BitmapUtil;
import com.ys.didisy.util.MeadUtil;
import com.ys.didisy.widget.FormerCircleImageView;

import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/img3/6.
 */
public class MainActivity extends BaseFragmentActivity implements OnCheckedChangeListener,View.OnClickListener {
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
    private FormerCircleImageView menu_userImage;
    private LinearLayout my_Route,invite_Friends,fee_Scale,user_Agreement,about_Us,call_Center;
    private Bitmap photodata;
    private String path;
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
//        activity_main.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);//侧滑手势关闭
        menuLayout = (LinearLayout) findViewById(R.id.fragment_person); // 侧滑布局
        initViewMenu();//侧滑布局初始化
        vp_manage = (ViewPager) findViewById(R.id.vp_manage_mian); //初始化Fragment
    }
   private void initViewMenu(){
       menu_userImage  = (FormerCircleImageView)findViewById(R.id.imgUser);
       my_Route = (LinearLayout) findViewById(R.id.my_Route);
       invite_Friends = (LinearLayout) findViewById(R.id.invite_Friends);
       fee_Scale = (LinearLayout) findViewById(R.id.fee_Scale);
       user_Agreement = (LinearLayout) findViewById(R.id.user_Agreement);
       about_Us = (LinearLayout) findViewById(R.id.about_Us);
       call_Center = (LinearLayout) findViewById(R.id.call_Center);
       menu_userImage.setOnClickListener(this);
       my_Route.setOnClickListener(this);
       invite_Friends.setOnClickListener(this);
       fee_Scale.setOnClickListener(this);
       user_Agreement.setOnClickListener(this);
       about_Us.setOnClickListener(this);
       call_Center.setOnClickListener(this);


   }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.imgUser:
                setUserImage();
                break;
            case R.id.my_Route:
                startActivity(new Intent(MainActivity.this,MyRouteActivity.class));
                break;
            case R.id.invite_Friends:
                startActivity(new Intent(MainActivity.this,InviteFriendsActivity.class));
                break;
            case R.id.fee_Scale:
                startActivity(new Intent(MainActivity.this,FeeScaleActivity.class));
                break;
            case R.id.user_Agreement:
                startActivity(new Intent(MainActivity.this,UserAgreementActivity.class));
                break;
            case R.id.about_Us:
                startActivity(new Intent(MainActivity.this,AboutUsActivity.class));
                break;
            case R.id.call_Center:
                startActivity(new Intent(MainActivity.this,CallCenterActivity.class));
                break;
            default:
                break;

        }

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
    int selected;
    public void setUserImage(){
        String[] str = { "拍照", "从手机相册选择" };
        new AlertDialog.Builder(MainActivity.this, R.style.MyDialog)
                .setTitle("请选择")
                .setSingleChoiceItems(str, selected,
                        new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog,
                                                int which) {
                                selected = which;
                                switch (which) {
                                    case 0:
                                        // 拍照
                                        // 销毁图片
                                        destoryBitmap();
                                        // 判断sd卡是否存在
                                        String state = Environment
                                                .getExternalStorageState();
                                        if (state
                                                .equals(Environment.MEDIA_MOUNTED)) {
                                            // 打开指定的照相机
                                            Intent intentPhoto = new Intent(
                                                    "android.media.action.IMAGE_CAPTURE");
                                            // 获取所拍照片存取的路径
                                            Uri uriPhoto = savePhoto();
                                            // 设置系统相机拍摄照片完成后图片文件的存放地址
                                            intentPhoto
                                                    .putExtra(
                                                            MediaStore.EXTRA_OUTPUT,
                                                            uriPhoto);
                                            startActivityForResult(
                                                    intentPhoto, 2);

                                        } else {
                                            Toast.makeText(
                                                    MainActivity.this,
                                                    "SD卡不存在",
                                                    Toast.LENGTH_LONG)
                                                    .show();
                                        }
                                        break;
                                    case 1:
                                        // 本地图片
                                        destoryBitmap();
                                        Intent intentPic = new Intent(
                                                Intent.ACTION_GET_CONTENT);
                                        intentPic.setType("image/*");
                                        startActivityForResult(intentPic, 1);
                                        break;

                                    default:
                                        break;
                                }
                                dialog.dismiss();
                            }
                        }).create().show();

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.i("info", "回到onActivityResult");
        // 三星GT-I9268手机录像后会停留在录像界面,不会自动返回当前界面,不能通过resultCode判断是否录像
        String phoneName = android.os.Build.BRAND;
        if (phoneName.contains("samsung") && requestCode == 3) {
            File f = new File(path);
            if (!f.exists()) {
                return;
            }
           // upload();
            // 三星以外的手机可以通过resultCode判断是否录像
        } else if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case 1:// 本地照片
                    Log.i("info", "进入switch 1");
                    if (data != null) {
                        Uri uri1 = data.getData();
                        path = getpath(uri1);
                       //上传图片upload();
                        photodata=BitmapUtil.getScaleBitmap(MainActivity.this, path);
                        menu_userImage.setImageBitmap(photodata);
                        useerImage.setImageBitmap(photodata);
                    } else {
                        Toast.makeText(MainActivity.this, "请选择适合的照片",
                                Toast.LENGTH_LONG).show();
                    }
                    break;
                case 2:// 拍照
                    try {
                        //上传图片upload();
                        photodata= BitmapUtil.getScaleBitmap(MainActivity.this, path);
                        menu_userImage.setImageBitmap(photodata);
                        useerImage.setImageBitmap(photodata);
                    } catch (Exception e) {
                        Toast.makeText(MainActivity.this, "照片储存失败",
                                Toast.LENGTH_LONG).show();
                    }
                    break;

                default:
                    break;
            }
        }
    }
    // 销毁图片文件
    private void destoryBitmap() {
        if (photodata != null && !photodata.isRecycled()) {
            photodata.recycle();
            photodata = null;
        }
    }
    public Uri savePhoto() {
        String saveDir = Environment.getExternalStorageDirectory() + "/images";
        File sdir = new File(saveDir);
        // 新建目录的文件夹
        if (!sdir.exists()) {
            sdir.mkdir();
        }
        // 生成文件名
        SimpleDateFormat t = new SimpleDateFormat("yyyyMMddssSSS");
        String filename = "AQI" + (t.format(new Date())) + ".jpg";
        // 创建文件(新建在sdir文件夹下有个这个filename名的文件)
        File file = new File(sdir, filename);
        path = file.getPath();
        Uri uri = Uri.fromFile(file);
        return uri;
    }
    public String getpath(Uri uri) {
        String filepath = null;
        filepath = MeadUtil.getPath(this, uri);
        return filepath;
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
