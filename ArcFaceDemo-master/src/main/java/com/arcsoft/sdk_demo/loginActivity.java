package com.arcsoft.sdk_demo;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.AlertDialog;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


public class loginActivity extends Activity implements View.OnClickListener {

    private long mExitTime=0;

    View view;
    //页面公共头部
    ImageView titleLeftImageView;
    ImageView titleRightImageView;
    TextView titleTextView;

    FrameLayout frameLayout;

    Fragment oneFragment;
    Fragment twoFragment;
    Fragment threeFragment;
    Fragment fourFragment;

    FragmentManager fragmentManager;

    RelativeLayout oneRelativeLayout;
    RelativeLayout twoRelativeLayout;
    RelativeLayout threeRelativeLayout;
    RelativeLayout fourRelativeLayout;

    int white = 0xffffff;
    int black = 0xff000000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //首页
        setContentView(R.layout.activity_main);

        view = (View) findViewById(R.id.activity_title);
        titleLeftImageView = (ImageView) view.findViewById(R.id.titleLeftImageView);
        titleRightImageView = (ImageView) view.findViewById(R.id.titleRightImageView);
        titleTextView = (TextView) view.findViewById(R.id.titleTextView);

       // titleLeftImageView.setImageResource(R.mipmap.ic_launcher);
        //titleRightImageView.setImageResource(R.mipmap.ic_launcher_round);
        titleTextView.setText(this.getString(R.string.main_title));

        oneRelativeLayout = (RelativeLayout) findViewById(R.id.oneRelativeLayout);
        twoRelativeLayout = (RelativeLayout) findViewById(R.id.twoRelativeLayout);
        threeRelativeLayout = (RelativeLayout) findViewById(R.id.threeRelativeLayout);
        fourRelativeLayout = (RelativeLayout) findViewById(R.id.fourRelativeLayout);

        oneRelativeLayout.setOnClickListener(this);
        twoRelativeLayout.setOnClickListener(this);
        threeRelativeLayout.setOnClickListener(this);
        fourRelativeLayout.setOnClickListener(this);

        titleLeftImageView.setOnClickListener(this);
        titleRightImageView.setOnClickListener(this);

        fragmentManager = getFragmentManager();
        //默认加载第一个Fragment
        setChioceItem(0);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.oneRelativeLayout:
                setChioceItem(0);
                break;
            case R.id.twoRelativeLayout:
                setChioceItem(1);
                break;
            case R.id.threeRelativeLayout:
                setChioceItem(2);
                break;
            case R.id.fourRelativeLayout:
                setChioceItem(3);
                break;
            case R.id.titleLeftImageView:
                //调用打电话功能
                //创建弹框
                AlertDialog.Builder builder=new AlertDialog.Builder(this);
                builder.setTitle("错误提示")
                        .setIcon(R.mipmap.ic_launcher)
                        .setMessage("确定呼叫10086？")
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent();
                                //设置Intent对象动作
                                intent.setAction(Intent.ACTION_CALL);
                                //设置拨打电话号码
                                intent.setData(Uri.parse("tel:10086"));
                                startActivity(intent);
                            }
                            })
                             .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                                 @Override
                                 public void onClick(DialogInterface dialogInterface, int i) {
                                 }

                            });
                            //显示弹框
                builder.show();
                break;
            case R.id.titleRightImageView:
                Intent intent = new Intent();
                //设置Intent对象动作
                intent.setAction(Intent.ACTION_VIEW);
                //设置手机自带浏览器打开的网址
                intent.setData(Uri.parse("https://baike.baidu.com/item/%E5%A4%8F%E7%9B%AE%E5%8F%8B%E4%BA%BA%E5%B8%90/27649?fr=aladdin"));
                startActivity(intent);
                break;
        }
    }

    public void setChioceItem(int index) {
        //开启事务
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        //清空重置选项
        clearChioce();
        //隐藏所有Fragment
        hideFragments(fragmentTransaction);

        switch (index) {
            case 0:
                oneRelativeLayout.setBackgroundColor(black);

                if (oneFragment == null) {
                    oneFragment = new OneFragment();
                    fragmentTransaction.add(R.id.frameLayout, oneFragment);
                } else {
                    fragmentTransaction.show(oneFragment);
                }
                break;
            case 1:
                twoRelativeLayout.setBackgroundColor(black);

                if (twoFragment == null) {
                    twoFragment = new TwoFragment();
                    fragmentTransaction.add(R.id.frameLayout, twoFragment);
                } else {
                    fragmentTransaction.show(twoFragment);
                }
                break;
            case 2:
                threeRelativeLayout.setBackgroundColor(black);

                if (threeFragment == null) {
                    threeFragment = new ThreeFragment();
                    fragmentTransaction.add(R.id.frameLayout, threeFragment);
                } else {
                    fragmentTransaction.show(threeFragment);
                }
                break;
            case 3:
                fourRelativeLayout.setBackgroundColor(black);

                if (fourFragment == null) {
                    fourFragment = new FourFragment();
                    fragmentTransaction.add(R.id.frameLayout, fourFragment);
                } else {
                    fragmentTransaction.show(fourFragment);
                }
                break;
        }
        fragmentTransaction.commit();
    }

    /**
     * 清空重置选项
     */
    public void clearChioce() {
        oneRelativeLayout.setBackgroundColor(white);
        twoRelativeLayout.setBackgroundColor(white);
        threeRelativeLayout.setBackgroundColor(white);
        fourRelativeLayout.setBackgroundColor(white);
    }


    /**
     * 隐藏所有Fragment
     */
    public void hideFragments(FragmentTransaction fragmentTransaction) {
        if (oneFragment != null) {
            fragmentTransaction.hide(oneFragment);
        }
        if (twoFragment != null) {
            fragmentTransaction.hide(twoFragment);
        }
        if (threeFragment != null) {
            fragmentTransaction.hide(threeFragment);
        }
        if (fourFragment != null) {
            fragmentTransaction.hide(fourFragment);
        }
    }

    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    //回退键事件
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        /*
        //单击回退键
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
            //创建弹框
            AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
            builder.setTitle("错误提示")
            .setIcon(R.mipmap.ic_launcher)
            .setMessage("确定退出该软件？")
            .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    //关闭页面
                    finish();
                }
            })
            .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Toast.makeText(MainActivity.this,"取消退出",Toast.LENGTH_LONG).show();
                }
            });
            builder.show();
        }
        */

        //双击回退键
        if ((System.currentTimeMillis() - mExitTime) > 2000) {
            Toast.makeText(loginActivity.this, "再按一次退出", Toast.LENGTH_SHORT).show();
            mExitTime = System.currentTimeMillis();
        }
        else{
            finish();
        }
        return true;
    }

}
