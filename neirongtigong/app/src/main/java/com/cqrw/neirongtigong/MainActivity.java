package com.cqrw.neirongtigong;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    MyDbdao dbdao;
    ListView lv;
    List<Map<String,String>> list=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbdao= new MyDbdao(MainActivity.this);
        lv = findViewById(R.id.lv);
        list =  dbdao.select();
        lv.setAdapter(new MyAdapter());
    }

    public void insert(View view){
        dbdao.insert();
    }
    public void select(View view){
        list =  dbdao.select();
        lv.setAdapter(new MyAdapter());

    }

    private class MyAdapter extends  BaseAdapter{

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            if(view==null){
                view = View.inflate(MainActivity.this,R.layout.layout,null);
            }
            TextView name = view.findViewById(R.id.name);
            Map<String ,String> map = list.get(i);
            name.setText(map.get("name"));
            TextView age = view.findViewById(R.id.age);
            age.setText(map.get("age"));
            return view;
        }
    }

}