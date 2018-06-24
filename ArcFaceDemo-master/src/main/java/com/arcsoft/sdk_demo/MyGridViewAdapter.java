package com.arcsoft.sdk_demo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator on 2017/9/1.
 */

public class MyGridViewAdapter extends BaseAdapter {
    Context context;
    List<People> list;
    LayoutInflater inflater;

    public MyGridViewAdapter(Context context, List<People> list) {
        this.context = context;
        this.list = list;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
      ViewHolder viewHolder;
        if(view==null){
            view = inflater.inflate(R.layout.grid_view,null);
            viewHolder = new ViewHolder();
            viewHolder.iconImg = (ImageView) view.findViewById(R.id.iconImg);
            viewHolder.iconName = (TextView) view.findViewById(R.id.iconName);
            view.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder)view.getTag();
        }

        viewHolder.iconImg.setImageResource(list.get(i).getIconImg());
        viewHolder.iconName.setText(list.get(i).getIconName());

        return view;
    }

    class ViewHolder{
        ImageView iconImg;
        TextView iconName;
    }
}
