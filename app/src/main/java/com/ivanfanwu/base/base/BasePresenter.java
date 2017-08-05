package com.ivanfanwu.base.base;

/**
 * Created by ivanfanwu on 2017/8/5.
 */

public class BasePresenter<V extends BaseView> implements Presenter<V> {

    private V mView;

    @Override
    public void attachView(V view) {
        this.mView = view;
    }

    @Override
    public void detachView() {
        mView = null;
    }

    /**
     * 判断 view是否为空
     */
    public  boolean isAttachView(){
        return mView != null;
    }

    /**
     * 返回目标view
     */
    public  V getView(){
        return mView;
    }

    /**
     * 检查view和presenter是否连接
     */
    public void checkViewAttach(){
        if(! isAttachView()){
            throw  new ViewNotAttachedException();
        }
    }

    /**
     * 自定义异常
     */
    public static   class  ViewNotAttachedException extends RuntimeException{
        public  ViewNotAttachedException(){
            super("请求数据前请先调用 attachView(view) 方法与View建立连接");
        }
    }
}
