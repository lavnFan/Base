package com.ivanfanwu.base.presenter.impl;

import android.content.Context;

import com.ivanfanwu.base.base.mvp.BasePresenter;
import com.ivanfanwu.base.model.entity.Repo;
import com.ivanfanwu.base.net.ApiManager;
import com.ivanfanwu.base.presenter.LoginPresenter;
import com.ivanfanwu.base.ui.login.LoginView;
import com.ivanfanwu.base.util.LogUtil;
import com.ivanfanwu.base.util.NetUtil;
import com.ivanfanwu.base.util.StringUtil;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ivanfanwu on 2017/8/5.
 */

public class LoginPresenterImpl extends BasePresenter<LoginView> implements LoginPresenter {

    public static final String TAG = "Login";
    private Context mContext;

    public LoginPresenterImpl(Context context) {
        this.mContext = context;
    }

    @Override
    public void login() {

    }

    @Override
    public void getListRepos(String user) {
        LogUtil.i(TAG, "user:" + user);
        if (NetUtil.isNetworkConnected(mContext)) {
            Call<List<Repo>> call = ApiManager.getService(mContext.getApplicationContext()).getListRepos(user);
            getView().showLoading("正在加载");
            call.enqueue(new Callback<List<Repo>>() {
                @Override
                public void onResponse(Call<List<Repo>> call, Response<List<Repo>> response) {
                    LogUtil.i(TAG, "call:" + call.toString() + ",response:" + response + " body:" + response.body().toString());
                    getView().hideLoading();
                }

                @Override
                public void onFailure(Call<List<Repo>> call, Throwable t) {
                    LogUtil.i(TAG, "call:" + call.toString() + ",Throwable:" + t);
                    getView().hideLoading();
                }
            });
        } else {
            getView().showNetworkErr();
        }
    }
}
