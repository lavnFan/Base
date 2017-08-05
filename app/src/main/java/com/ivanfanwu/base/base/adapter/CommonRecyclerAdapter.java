package com.ivanfanwu.base.base.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by ivanfanwu on 2017/8/5.
 */

public abstract class CommonRecyclerAdapter<T> extends RecyclerView.Adapter {

    private Context mContext;
    private List<T> mData;
    private int mLayoutId;
    private View mView;

    public CommonRecyclerAdapter(Context context, List<T> data, int layoutId) {
        this.mContext = context;
        this.mData = data;
        this.mLayoutId = layoutId;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mView = inflater.inflate(mLayoutId, parent, false);
        return new CommonRecyclerHolder(mView);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof CommonRecyclerHolder) {
            CommonRecyclerHolder commonRecyclerHolder = (CommonRecyclerHolder) holder;
            commonRecyclerHolder.mPosition = position;
            convert(commonRecyclerHolder, mData.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return (mData != null) ? mData.size() : 0;
    }

    public void addData(List<T> data) {
        if (data != null) {
            mData.addAll(data);
        }
        notifyDataSetChanged();
    }

    public void setData(List<T> data) {
        mData.clear();
        mData = data;
    }

    public abstract void convert(CommonRecyclerHolder holder, T t);
}
