package com.arcsoft.sdk_demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class SlideActivity extends Activity {

    String TAG = SlideActivity.class.getSimpleName();

    ViewPager viewPager;
    int[] mViewId = new int[]{R.layout.viewpager_one, R.layout.viewpager_two, R.layout.viewpager_three, R.layout.viewpager_four};
    List<View> view_list = new ArrayList<>();

    //声明放置底部小圆点的LinearLayout
    LinearLayout linearLayout;
    //底部小圆点的集合
    List<ImageView> mDots = new ArrayList<ImageView>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slide);

        viewPager = (ViewPager) findViewById(R.id.viewPager);
        //为ViewPager对象添加动画效果工具类
        viewPager.setPageTransformer(true, new ZoomOutPageTransformer());

        //循环添加XML页面资源
        for (int i = 0; i < mViewId.length; i++) {
            //通过LayoutInflater加载页面资源
            View view = getLayoutInflater().inflate(mViewId[i], null);
            view_list.add(view);
        }

        //绑定Adapter适配器
        viewPager.setAdapter(new MyAdapter());
        //绑定PageChangeListener监听器
        viewPager.addOnPageChangeListener(new MyOnPageChangeListener());

        //输出log日志
        Log.i("aaa","lelouch");
        Log.i(TAG,"china");
        //输出System.out日志
        System.out.println("夏目");

        linearLayout = (LinearLayout) findViewById(R.id.linearLayout);

        //初始化小圆点集合
        for (int i = 0; i < mViewId.length; i++) {
            //代码创建ImageView
            ImageView imageView = new ImageView(this);
            //设置小圆点宽高
            imageView.setLayoutParams(new ViewGroup.LayoutParams(40, 40));
            //设置小圆点边距
            imageView.setPadding(10, 10, 10, 10);
            //设置小圆点图片全部为绿色
            //imageView.setImageResource(R.mipmap.circle_green);
            imageView.setImageResource(R.mipmap.img5);
            //添加到圆点集合中
            mDots.add(imageView);
            //添加到LinearLayout中
            linearLayout.addView(imageView);
        }
        //设置初始小圆点为红色
        //mDots.get(0).setImageResource(R.mipmap.circle_red);
        mDots.get(0).setImageResource(R.mipmap.img7);
    }

    //绑定Adapter适配器
    class MyAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            //返回资源长度
            return mViewId.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            //判断资源类型是否加载正确
            return view == object;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            //移除资源
            View view = view_list.get(position);
            container.removeView(view);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            //初始化资源
            View view = view_list.get(position);
            container.addView(view);
            return view;
        }
    }

    //绑定OnPageChangeListener监听器
    class MyOnPageChangeListener implements ViewPager.OnPageChangeListener {

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        }

        @Override
        public void onPageSelected(int position) {
            //循环将所有的小圆点全部设置为绿色
            for (int i = 0; i < mViewId.length; i++) {
                //mDots.get(i).setImageResource(R.mipmap.circle_green);
                mDots.get(i).setImageResource(R.mipmap.img5);
            }
            //将被选中图片的小圆点设置成红色
            //mDots.get(position).setImageResource(R.mipmap.circle_red);
            mDots.get(position).setImageResource(R.mipmap.img7);
        }

        @Override
        public void onPageScrollStateChanged(int state) {
        }
    }

    /**
     * 点击事件
     */
    public void viewPagerFourOnClick(View view) {
        Intent intent = new Intent(SlideActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}

