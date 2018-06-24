package com.arcsoft.sdk_demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class LogoActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logo);

        //设置等待时间,单位为毫秒
        Integer time = 2000;

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //Activity页面跳转
                Intent intent = new Intent(LogoActivity.this,SlideActivity.class);
                startActivity(intent);
                //关闭自身
                finish();
            }
        }, time);

    }
}
