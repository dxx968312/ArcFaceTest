package com.arcsoft.sdk_demo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/8/31.
 */

public class ThreeFragment extends Fragment {

    GridView gridView;
    List<People> list=new ArrayList<>();

    private  int[] iconImg = {R.mipmap.d1,R.mipmap.d2,R.mipmap.d3,
            R.mipmap.d4,R.mipmap.d5,R.mipmap.d6};

    private String[] iconName = {"夏目友人帐第一季","夏目友人帐第二季","夏目友人帐第三季",
            "夏目友人帐第四季","夏目友人帐第五季","夏目友人帐第六季"};

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_three,null);
        gridView = (GridView) view.findViewById(R.id.gridView);
        for (int i = 0; i < iconImg.length; i++) {
            People people = new People();
            people.setIconImg(iconImg[i]);
            people.setIconName(iconName[i]);
            list.add(people);
        }

        MyGridViewAdapter myGridViewAdapter = new MyGridViewAdapter(getActivity(), list);
        gridView.setAdapter(myGridViewAdapter);
        return view;
    }
}
