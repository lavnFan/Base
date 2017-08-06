package com.ivanfanwu.base.base.mvp;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.ivanfanwu.base.R;

import butterknife.ButterKnife;

/**
 * Created by ivanfanwu on 2017/8/5.
 */

public abstract class BaseMvpActivity<P extends Presenter<V>, V extends BaseView> extends AppCompatActivity implements BaseView, LoaderManager.LoaderCallbacks<P> {

    private static final int BASE_LOADER_ID = 1000;//loader的id值
    private ProgressDialog mProgressDialog;//登录进度条
    protected P mPresenter;

    public abstract int getContentViewLayoutId();

    protected abstract void initView(Bundle saveInstanceState);

    protected void beforeInit() {
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
        if (getContentViewLayoutId() != 0) {
            setContentView(getContentViewLayoutId());
            initView(savedInstanceState);
        }
        mProgressDialog = new ProgressDialog(this);
        getSupportLoaderManager().initLoader(BASE_LOADER_ID, null, this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mPresenter.attachView((V) this);//presenter与view断开连接
    }

    @Override
    public void showLoading(String msg) {
        mProgressDialog.setMessage(msg);
        if (!mProgressDialog.isShowing())
            mProgressDialog.show();
    }

    @Override
    public void hideLoading() {
        if (mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }
    }

    @Override
    public void showNetworkErr() {
        Toast.makeText(this, getString(R.string.none_network), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showErr(String err) {
        Toast.makeText(this, err, Toast.LENGTH_SHORT).show();
    }

    @Override
    public Loader<P> onCreateLoader(int id, Bundle args) {
        return null;
    }

    @Override
    public void onLoadFinished(Loader<P> loader, P data) {
        mPresenter = data;
    }

    @Override
    public void onLoaderReset(Loader<P> loader) {
        mPresenter = null;
    }

    @Override
    protected void onDestroy() {
        mPresenter.detachView();
        super.onDestroy();
    }

}
