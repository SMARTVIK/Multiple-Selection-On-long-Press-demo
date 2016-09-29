package com.timehop.stickyheadersrecyclerview.sample.pojo;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.timehop.stickyheadersrecyclerview.sample.R;

import java.util.ArrayList;

public class ExpandAndCollapseActivity extends Activity {

    private ExpandableListView expandableListView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.expand_and_collapse);
        expandableListView = (ExpandableListView) findViewById(R.id.ExpandAndCollapseView);
        ArrayList<String> Groups = new ArrayList<String>();
        Groups.add("Group A");
        Groups.add("Group B");
        Groups.add("Group C");
        Groups.add("Group D");

        String[] GroupA = {"Uruguay", "Mexico", "Argentina", "Korea Republic"};
        String[] GroupB = {"England", "USA", "Germany", "Ghana"};
        String[] GroupC = {"Netherlands", "Japan", "Paraguay", "Slovakia"};
        String[] GroupD = {"Brazil", "Portugal", "Spain", "Chile"};

        ExpandAndCollapseAdapter ExpandableAdapter = new ExpandAndCollapseAdapter(this, this, Groups, GroupA, GroupB, GroupC, GroupD);

        expandableListView.setAdapter(ExpandableAdapter);

        setListViewHeight(expandableListView);

        expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {

            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int position, long id) {
                setListViewHeight(parent, position);
                return false;
            }
        });
    }


    private void setListViewHeight(ListView listView) {
        ListAdapter listAdapter = listView.getAdapter();
        int totalHeight = 0;
        for (int i = 0; i < listAdapter.getCount(); i++) {
            View listItem = listAdapter.getView(i, null, listView);
            listItem.measure(0, 0);
            totalHeight += listItem.getMeasuredHeight();
        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight
                + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
        listView.requestLayout();
    }


    private void setListViewHeight(ExpandableListView listView, int group) {
        ExpandableListAdapter listAdapter = listView.getExpandableListAdapter();
        int totalHeight = 0;
        int desiredWidth = View.MeasureSpec.makeMeasureSpec(listView.getWidth(),
                View.MeasureSpec.AT_MOST);
        for (int i = 0; i < listAdapter.getGroupCount(); i++) {
            View groupItem = listAdapter.getGroupView(i, false, null, listView);
            groupItem.measure(desiredWidth, View.MeasureSpec.UNSPECIFIED);
            totalHeight += groupItem.getMeasuredHeight();

            if (((listView.isGroupExpanded(i)) && (i != group))
                    || ((!listView.isGroupExpanded(i)) && (i == group))) {
                for (int j = 0; j < listAdapter.getChildrenCount(i); j++) {
                    View listItem = listAdapter.getChildView(i, j, false, null, listView);
                    listItem.measure(desiredWidth, View.MeasureSpec.UNSPECIFIED);

                    totalHeight += listItem.getMeasuredHeight();
                }
            }
        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();
        int height = totalHeight
                + (listView.getDividerHeight() * (listAdapter.getGroupCount() - 1));
        if (height < 10)
            height = 200;
        params.height = height;
        listView.setLayoutParams(params);
        listView.requestLayout();

    }
}
