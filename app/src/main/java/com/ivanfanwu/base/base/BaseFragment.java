package com.ivanfanwu.base.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by ivanfanwu on 2017/7/30.
 */

public abstract class BaseFragment extends Fragment{

    private Unbinder mUnBinder;

    protected abstract int getContentViewLayoutId();
    protected abstract void init();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(getContentViewLayoutId()!=0){
            return inflater.inflate(getContentViewLayoutId(),container,false);
        }else{
            return super.onCreateView(inflater,container,savedInstanceState);
        }
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mUnBinder = ButterKnife.bind(this,view);
        init();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnBinder.unbind();
    }
}
