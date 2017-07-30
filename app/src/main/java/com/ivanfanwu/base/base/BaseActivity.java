package com.ivanfanwu.base.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * Created by ivanfanwu on 2017/7/30.
 */

public abstract class BaseActivity extends AppCompatActivity{

    public abstract int getContentViewLayoutId();
    protected abstract void initView(Bundle saveInstanceState);

    protected void beforeInit(){

    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
        ButterKnife.bind(this);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        beforeInit();
        if(getContentViewLayoutId()!= 0){
            setContentView(getContentViewLayoutId());
            initView(savedInstanceState);
        }
    }
}
