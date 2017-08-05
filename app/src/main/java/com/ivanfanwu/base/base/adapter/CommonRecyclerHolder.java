package com.ivanfanwu.base.base.adapter;

import android.support.annotation.IdRes;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;
import android.widget.TextView;

/**
 * Created by ivanfanwu on 2017/8/5.
 */

public class CommonRecyclerHolder extends RecyclerView.ViewHolder {

    public View mConvertView;
    public int mPosition;
    private SparseArray<View> mViews;

    public CommonRecyclerHolder(View itemView) {
        super(itemView);
        this.mConvertView = itemView;
        this.mViews = new SparseArray<>();
    }

    public <T extends View> T getView(@IdRes int viewId) {
        View view = mViews.get(viewId);
        if (view == null) {
            view = mConvertView.findViewById(viewId);
            mViews.put(viewId, view);
        }
        return (T) view;
    }

    public CommonRecyclerHolder setTextViewText(@IdRes int textViewId,String text){
        TextView tv = getView(textViewId);
        if(text!=null && !text.isEmpty()){
            tv.setText(text);
        }else{
            tv.setText(" ");
        }
        return this;
    }

    public CommonRecyclerHolder setOnClickListener(ListenerWithPosition.OnClickWithPositionListener clickListener, @IdRes int... viewIds) {
        ListenerWithPosition listener = new ListenerWithPosition(mPosition, this);
        listener.setOnClickListener(clickListener);
        for (int id : viewIds) {
            View v = getView(id);
            v.setOnClickListener(listener);
        }
        return this;
    }

}
