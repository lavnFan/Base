package com.ivanfanwu.base.base.mvp;

/**
 * Created by ivanfanwu on 2017/8/5.
 */

public interface PresenterFactory<P extends Presenter> {
    P create();
}
