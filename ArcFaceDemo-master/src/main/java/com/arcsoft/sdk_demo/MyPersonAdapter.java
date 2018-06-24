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
 * Created by Administrator on 2017/8/31.
 */

public class MyPersonAdapter extends BaseAdapter {

    Context context;
    List<Person> list;
    LayoutInflater inflater;

    public MyPersonAdapter(Context context, List<Person> list) {
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
            view = inflater.inflate(R.layout.list_view_person,null);
            viewHolder = new ViewHolder();
            viewHolder.name = (TextView)view.findViewById(R.id.name);
            viewHolder.borth = (TextView)view.findViewById(R.id.borth);
            viewHolder.home = (TextView)view.findViewById(R.id.home);
            viewHolder.song = (TextView)view.findViewById(R.id.song);
            viewHolder.img = (ImageView)view.findViewById(R.id.img);
            view.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder)view.getTag();
        }

        viewHolder.name.setText(list.get(i).getName());
        viewHolder.borth.setText(list.get(i).getBorth());
        viewHolder.home.setText(list.get(i).getHome());
        viewHolder.song.setText(list.get(i).getSong());
        viewHolder.img.setImageResource(context.getResources().getIdentifier(list.get(i).getImg(),"mipmap",context.getPackageName()));

        return view;
    }

    class ViewHolder{
        TextView name;
        TextView borth;
        TextView home;
        TextView song;
        ImageView img;
    }
}
