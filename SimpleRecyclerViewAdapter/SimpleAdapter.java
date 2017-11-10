package com.example.pankaj.cricket;

import android.databinding.BindingAdapter;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by pankaj on 10/11/17.
 */

public abstract class SimpleAdapter<T> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    ArrayList<T> list;

    public SimpleAdapter(ArrayList<T> list) {
        this.list = list;
    }

    @Override
    public abstract SimpleViewHolder onCreateViewHolder(ViewGroup parent, int viewType);

    @Override
    public final void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((SimpleViewHolder) holder).bind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    abstract class SimpleViewHolder extends RecyclerView.ViewHolder {

        public SimpleViewHolder(ViewGroup parent, int res) {
            super(LayoutInflater.from(parent.getContext()).inflate(res, parent, false));
            create(itemView);
        }

        public abstract void create(View view);

        public abstract void bind(T t);
    }

    @BindingAdapter("simpleAdapter")
    public static void setAdapter(RecyclerView recyclerView, SimpleAdapter simpleAdapter) {
        recyclerView.setAdapter(simpleAdapter);
    }
}
