package com.ivanfanwu.base.ui.login;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.content.Loader;

import com.ivanfanwu.base.R;
import com.ivanfanwu.base.base.BaseMvpActivity;
import com.ivanfanwu.base.base.PresenterFactory;
import com.ivanfanwu.base.base.PresenterLoader;
import com.ivanfanwu.base.presenter.impl.LoginPresenterImpl;

/**
 * Created by ivanfanwu on 2017/8/5.
 */

public class LoginActivity extends BaseMvpActivity<LoginPresenterImpl,LoginView> implements LoginView{

    @Override
    public int getContentViewLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView(Bundle saveInstanceState) {

    }

    @Override
    public Loader<LoginPresenterImpl> onCreateLoader(int id, Bundle args) {
        return new PresenterLoader<>(this, new PresenterFactory<LoginPresenterImpl>() {
            @Override
            public LoginPresenterImpl create() {
                return new LoginPresenterImpl(LoginActivity.this);
            }
        });
    }

    @Override
    public void showErr(String err) {
        super.showErr(err);
    }

    @Override
    public void hideLoading() {
        super.hideLoading();
    }

    @Override
    public void showLoading(String msg) {
        super.showLoading(msg);
    }

    @Override
    public void showNetworkErr() {
        super.showNetworkErr();
    }
}
