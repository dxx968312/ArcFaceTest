package com.arcsoft.sdk_demo;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class SlitherActivity extends Activity {

    ViewPager viewPager;
    //定义数组存入图片
    int[] mImgId = new int[]{R.mipmap.p1, R.mipmap.p2, R.mipmap.p3, R.mipmap.p4};
    //定义集合加载添加图片
    List<ImageView> mList = new ArrayList<ImageView>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slither);

        viewPager = (ViewPager) findViewById(R.id.viewPager);

        //为ViewPager添加动画效果工具类
        viewPager.setPageTransformer(true, new ZoomOutPageTransformer());

        //绑定Adapter适配器
        viewPager.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                //获取数组长度
                return mImgId.length;
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                //判断视图是否一样
                return view == object;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                //临时集合移除视图
                container.removeView(mList.get(position));
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                //代码创建ImageView控件
                ImageView imageView = new ImageView(SlitherActivity.this);
                //ImageView赋值图片
                imageView.setImageResource(mImgId[position]);
                //ImageView赋值动画效果
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                //容器添加ImageView
                container.addView(imageView);
                //临时集合添加ImageView
                mList.add(imageView);
                return imageView;
            }
        });
    }
}
