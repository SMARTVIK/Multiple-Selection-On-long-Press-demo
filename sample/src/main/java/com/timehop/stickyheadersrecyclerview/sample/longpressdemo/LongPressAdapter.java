package com.timehop.stickyheadersrecyclerview.sample.longpressdemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.timehop.stickyheadersrecyclerview.sample.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by vik on 29/9/16.
 */
public class LongPressAdapter extends RecyclerView.Adapter<LongPressAdapter.ViewHolder> {
    private final Context context;
    private ArrayList<String> list;

    public LongPressAdapter(Context context, ArrayList<String> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_items,parent,false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.textView.setText(list.get(position));
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            textView  = (TextView) itemView.findViewById(R.id.textview);
        }
    }
}
