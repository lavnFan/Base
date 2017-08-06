package com.ivanfanwu.base.ui.login;

import android.os.Bundle;
import android.support.v4.content.Loader;
import android.widget.LinearLayout;

import com.ivanfanwu.base.R;
import com.ivanfanwu.base.base.mvp.BaseMvpActivity;
import com.ivanfanwu.base.base.mvp.PresenterFactory;
import com.ivanfanwu.base.base.mvp.PresenterLoader;
import com.ivanfanwu.base.presenter.impl.LoginPresenterImpl;
import com.ivanfanwu.base.util.LogUtil;

import butterknife.BindView;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by ivanfanwu on 2017/8/5.
 */

public class LoginActivity extends BaseMvpActivity<LoginPresenterImpl, LoginView> implements LoginView {

    public static final String TAG = "LoginActivity";

    @BindView(R.id.login_cv)
    CircleImageView mLoginCv;
    @BindView(R.id.login_ll)
    LinearLayout mLoginLl;

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

    @OnClick(R.id.login_ll)
    void loginClick(){
        LogUtil.i(TAG,"click login");
        mPresenter.getListRepos("lavnFan");
    }
}
