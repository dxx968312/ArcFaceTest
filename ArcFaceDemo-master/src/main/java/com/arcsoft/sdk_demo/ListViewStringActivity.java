package com.arcsoft.sdk_demo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ListViewStringActivity extends Activity {

    ListView listView;
    List<String> list = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        listView = (ListView) findViewById(R.id.listView);

        //页面写死添加数据
        list.add("app");
        list.add("background");
        list.add("clickclick");
        list.add("dictionary");
        list.add("finaly");
        list.add("green");

        //绑定BaseAdapter适配器
        MyStringAdapter myAdapter = new MyStringAdapter(ListViewStringActivity.this,list);
        listView.setAdapter(myAdapter);
    }
}
