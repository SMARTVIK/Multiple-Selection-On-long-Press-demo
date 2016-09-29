package com.timehop.stickyheadersrecyclerview.sample.longpressdemo;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.app.Activity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.timehop.stickyheadersrecyclerview.sample.R;

import java.util.ArrayList;

public class RecyclerLongPressDemo extends Activity implements RecyclerItemClickListener.OnItemClickListener {

    private boolean longPressEnabled;
    ArrayList<String> selectedList = new ArrayList<>();
    private ArrayList<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_long_press_demo);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        LongPressAdapter longPressAdaper = new LongPressAdapter(this,getList());
        recyclerView.setAdapter(longPressAdaper);
        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this,this));
    }

    private ArrayList<String> getList() {
        ArrayList<String> strings = new ArrayList<>();
        for (int i=0;i<100;i++){
            strings.add("this is item number "+(i+1));
        }
        list = strings;
        return strings;
    }



    @Override
    public void onItemClick(View childView, int position) {
        if (longPressEnabled){
            if (!selectedList.contains(list.get(position))){
                selectedList.add(list.get(position));
            }else{
                selectedList.remove(list.get(position));
            }
        }
        Toast.makeText(this,selectedList.size(),Toast.LENGTH_SHORT).show();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onItemLongPress(View childView, int position) {
        longPressEnabled = true;
        if (childView.getBackground()!=null){
            childView.setBackground(getDrawable(R.drawable.simple));
        }else{
            childView.setBackground(getDrawable(R.drawable.text_view_selector));
        }
    }
}
