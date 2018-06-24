package com.arcsoft.sdk_demo;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Calendar;
import java.util.TimeZone;

/**
 * Created by Administrator on 2017/8/31.
 */

public class OneFragment extends Fragment {
    TextView textView;
    final int msgKey = 1;

    String Tag = FourFragment.class.getSimpleName();

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_one,null);

        textView = (TextView) view.findViewById(R.id.textView);
        new MyThread().start();
        return view;
    }

    class MyThread extends Thread {
        @Override
        public void run() {
            do {
                try {
                    Message msg = new Message();
                    msg.what = msgKey;
                    handler.sendMessage(msg);
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } while (true);
        }
    }


    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case msgKey:
                    textView.setText(getTime());
                    break;
            }
        }
    };



    public String getTime(){
        //创建日历对象
        Calendar calendar = Calendar.getInstance();
        //设置时区
        calendar.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
        //年份
        String year = String.valueOf(calendar.get(Calendar.YEAR));
        //月份
        String month = String.valueOf(calendar.get(Calendar.MONTH) + 1);
        //本月的第几天
        String day = String.valueOf(calendar.get(Calendar.DAY_OF_MONTH));
        //时
        String hour = String.valueOf(calendar.get(Calendar.HOUR_OF_DAY));
        //分
        String minute = String.valueOf(calendar.get(Calendar.MINUTE));
        //秒
        String second = String.valueOf(calendar.get(Calendar.SECOND));
        //星期几
        String week = String.valueOf(calendar.get(Calendar.DAY_OF_WEEK));

        switch (week){
            case "1":
                week="天";
                break;
            case "2":
                week="一";
                break;
            case "3":
                week="二";
                break;
            case "4":
                week="三";
                break;
            case "5":
                week="四";
                break;
            case "6":
                week="五";
                break;
            case "7":
                week="六";
                break;
        }
        return year+"年"+month+"月"+day+"日"+"    星期"+week+"    现在是北京时间："+hour+"时"+minute+"分"+second+"秒";
    }
}
