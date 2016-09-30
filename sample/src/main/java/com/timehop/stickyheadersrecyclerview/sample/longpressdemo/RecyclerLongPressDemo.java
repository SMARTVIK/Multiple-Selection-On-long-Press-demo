package com.timehop.stickyheadersrecyclerview.sample.longpressdemo;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.app.Activity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.timehop.stickyheadersrecyclerview.sample.R;

import java.util.ArrayList;
import java.util.HashMap;

public class RecyclerLongPressDemo extends Activity implements RecyclerItemClickListener.OnItemClickListener {

    private boolean longPressEnabled;
    ArrayList<String> selectedList = new ArrayList<>();
    private ArrayList<String> list;
    private RelativeLayout normalView;
    private LinearLayout longPressMode;
    private ImageView doneView;
    private TextView selectedText;
    private RecyclerView recyclerView;
    private LongPressAdapter longPressAdaper;
    private HashMap<Integer,Boolean> checkingStates;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_long_press_demo);
        checkingStates = new HashMap<>();
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        longPressAdaper = new LongPressAdapter(this, getList());
        recyclerView.setAdapter(longPressAdaper);
        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this, this));

        normalView = (RelativeLayout) findViewById(R.id.normal_mode);
        longPressMode = (LinearLayout) findViewById(R.id.long_press_view);

        doneView = (ImageView)findViewById(R.id.done_view);
        selectedText = (TextView) findViewById(R.id.selected_text);

        doneView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (String string : selectedList){
                    list.remove(string);
                    longPressAdaper.notifyDataSetChanged();
                }
                selectedList.clear();
            }
        });
    }

    private ArrayList<String> getList() {
        ArrayList<String> strings = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            strings.add("this is item number " + (i + 1));
        }
        list = strings;
        return strings;
    }

    @Override
    public void onItemClick(View childView, int position) {
        if (longPressEnabled) {
            ImageView imageView = (ImageView) childView.findViewById(R.id.view);
            if (!selectedList.contains(list.get(position))) {
                selectedList.add(list.get(position));
                imageView.setVisibility(View.VISIBLE);
                selectedText.setText(selectedList.size()+" selected");
                checkingStates.put(position,true);
            } else {
                selectedList.remove(list.get(position));
                imageView.setVisibility(View.GONE);
                selectedText.setText(selectedList.size()+" selected");
                checkingStates.put(position,false);
            }
        } else {
            Toast.makeText(this, selectedList.size(), Toast.LENGTH_SHORT).show();
        }
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onItemLongPress(View childView, int position) {
        longPressEnabled = true;
        ImageView imageView = (ImageView) childView.findViewById(R.id.view);
        normalView.setVisibility(View.GONE);
        longPressMode.setVisibility(View.VISIBLE);
        if (selectedList.contains(list.get(position))) {
            selectedList.remove(list.get(position));
            imageView.setVisibility(View.GONE);
            selectedText.setText(selectedList.size()+" selected");
            checkingStates.put(position,false);
        } else {
            selectedList.add(list.get(position));
            imageView.setVisibility(View.VISIBLE);
            selectedText.setText(selectedList.size()+" selected");
            checkingStates.put(position,true);
        }
    }


    @Override
    public void onBackPressed() {
        if (longPressEnabled) {
            if (selectedList.size() > 0) {
                for (int i = 0; i < checkingStates.keySet().size(); i++) {
                    //TODO code needs to write to remove selected view of chidls fromthe list
                }
            }
            longPressEnabled = false;
            normalView.setVisibility(View.VISIBLE);
            longPressMode.setVisibility(View.GONE);
            recyclerView.invalidate();

        } else {
            super.onBackPressed();
        }
    }
}
