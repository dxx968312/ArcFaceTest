package com.arcsoft.sdk_demo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

public class GridViewActivity extends Activity {

    GridView gridView;
    List<People> list=new ArrayList<>();

    private  int[] iconImg = {R.mipmap.d1,R.mipmap.d2,R.mipmap.d3,
            R.mipmap.d4,R.mipmap.d5,R.mipmap.d6};

    private String[] iconName = {"夏目友人帐第一季","夏目友人帐第二季","夏目友人帐第三季",
            "夏目友人帐第四季","夏目友人帐第五季","夏目友人帐第六季"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);

        gridView = (GridView) findViewById(R.id.gridView);
        for (int i = 0; i < iconImg.length; i++) {
            People people = new People();
            people.setIconImg(iconImg[i]);
            people.setIconName(iconName[i]);
            list.add(people);
        }

        MyGridViewAdapter myGridViewAdapter = new MyGridViewAdapter(GridViewActivity.this, list);
        gridView.setAdapter(myGridViewAdapter);

    }
}
