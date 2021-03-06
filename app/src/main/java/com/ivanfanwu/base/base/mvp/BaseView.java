package com.ivanfanwu.base.base.mvp;

/**
 * Created by ivanfanwu on 2017/8/5.
 */

public interface BaseView {

    /**
     * 显示进度条
     * @param msg   进度条加载内容
     */
    void showLoading(String msg);

    /**
     * 隐藏进度条
     */
    void hideLoading();

    /**
     * 显示加载错误
     * @param err 错误内容
     */
    void showErr(String err);

    void showNetworkErr();
}
