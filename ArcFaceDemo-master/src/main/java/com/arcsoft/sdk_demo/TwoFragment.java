package com.arcsoft.sdk_demo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/8/31.
 */

public class TwoFragment extends Fragment {

    ListView listView;
    List<Person> list = new ArrayList<Person>();

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_two,null);

        listView = (ListView) view.findViewById(R.id.listView);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Toast.makeText(getActivity(),  list.get(i).getName() + "," +list.get(i).getSong() +"," + list.get(i).getBorth() , Toast.LENGTH_SHORT).show();


            }
        });

        //集合填充数据
        Person person=new Person();
        person.setName("夏目贵志");
        person.setBorth("7月1日生");
        person.setHome("京都");
        person.setSong("高中生");
        person.setImg("person");

        Person person_1=new Person();
        person_1.setName("斑/猫咪老师");
        person_1.setBorth("未知");
        person_1.setHome("京都");
        person_1.setSong("妖怪");
        person_1.setImg("person1");

        Person person_2=new Person();
        person_2.setName("名取周一");
        person_2.setBorth("11月12日生");
        person_2.setHome("京都");
        person_2.setSong("人气演员");
        person_2.setImg("person2");

        Person person_3=new Person();
        person_3.setName("夏目玲子");
        person_3.setBorth("5月15日生");
        person_3.setHome("京都");
        person_3.setSong("未知");
        person_3.setImg("person3");


        Person person_4=new Person();
        person_4.setName("田绍要");
        person_4.setBorth("9月17日生");
        person_4.setHome("京都");
        person_4.setSong("高中生");
        person_4.setImg("person4");

        Person person_5=new Person();
        person_5.setName("多轨透");
        person_5.setBorth("5月15日生");
        person_5.setHome("京都");
        person_5.setSong("高中生");
        person_5.setImg("person5");

        Person person_6=new Person();
        person_6.setName("笹田纯");
        person_6.setBorth("9月17日生");
        person_6.setHome("京都");
        person_6.setSong("高中生");
        person_6.setImg("person6");

        Person person_7=new Person();
        person_7.setName("的场静司");
        person_7.setBorth("11月1日生");
        person_7.setHome("京都");
        person_7.setSong("高中生");
        person_7.setImg("person7");

        Person person_8=new Person();
        person_8.setName("西村悟");
        person_8.setBorth("9月17日生");
        person_8.setHome("京都");
        person_8.setSong("高中生");
        person_8.setImg("person8");

        Person person_9=new Person();
        person_9.setName("北本笃史");
        person_9.setBorth("9月17日生");
        person_9.setHome("京都");
        person_9.setSong("高中生");
        person_9.setImg("person9");

        list.add(person);
        list.add(person_1);
        list.add(person_2);
        list.add(person_3);
        list.add(person_4);
        list.add(person_5);
        list.add(person_6);
        list.add(person_7);
        list.add(person_8);
        list.add(person_9);

        //绑定BaseAdapter
        MyPersonAdapter myPersonAdapter = new MyPersonAdapter(getActivity(),list);
        listView.setAdapter(myPersonAdapter);
        return view;
    }
}
