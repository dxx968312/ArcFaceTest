package com.arcsoft.sdk_demo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ListViewPersonActivity extends Activity {

    ListView listView;
    List<Person> list = new ArrayList<Person>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_person);

        listView = (ListView)findViewById(R.id.listView);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(ListViewPersonActivity.this,  list.get(i).getName() + "," +list.get(i).getSong() +"," + list.get(i).getBorth() , Toast.LENGTH_SHORT).show();
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

        list.add(person);
        list.add(person_1);
        list.add(person_2);
        list.add(person_3);
        list.add(person_4);

        //绑定BaseAdapter
        MyPersonAdapter myPersonAdapter = new MyPersonAdapter(ListViewPersonActivity.this,list);
        listView.setAdapter(myPersonAdapter);

    }
}
