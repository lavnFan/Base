package com.ivanfanwu.base.base.mvp;

/**
 * Created by ivanfanwu on 2017/8/5.
 */

public interface Presenter<V extends BaseView> {

    /**
     * presenter和对应的view绑定
     * @param view  目标view
     */
    void attachView(V view);

    /**
     * presenter与view解绑
     */
    void detachView();
}
