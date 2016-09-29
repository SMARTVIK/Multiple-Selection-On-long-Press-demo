package com.timehop.stickyheadersrecyclerview.sample.pojo;

import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;

import java.util.ArrayList;

/**
 * Created by vik on 15/9/16.
 */
public class ExpandAndCollapseAdapter implements ListAdapter {


    public ExpandAndCollapseAdapter(ExpandAndCollapseActivity expandAndCollapseActivity, ExpandAndCollapseActivity expandAndCollapseActivity1, ArrayList<String> groups, String[] groupA, String[] groupB, String[] groupC, String[] groupD) {

    }

    @Override
    public boolean areAllItemsEnabled() {
        return false;
    }

    @Override
    public boolean isEnabled(int i) {
        return false;
    }

    @Override
    public void registerDataSetObserver(DataSetObserver dataSetObserver) {

    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {

    }

    @Override
    public int getCount() {
        return 0;
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
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {


        } else {

        }
        return convertView;
    }

    @Override
    public int getItemViewType(int i) {
        return 0;
    }

    @Override
    public int getViewTypeCount() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }
}
