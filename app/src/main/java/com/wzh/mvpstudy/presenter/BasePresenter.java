package com.wzh.mvpstudy.presenter;

/**
 * Created by HP on 2018/1/4.
 *
 * @author by wangWei
 */

public class BasePresenter<T extends BaseContract.View> implements BaseContract.Presenter {

    private T mView;


    public BasePresenter(T view) {
        setView(view);
    }

    private void setView(T view) {
        this.mView = view;
        this.mView.setPresenter(this);
    }

    @Override
    public void start() {
        T view = mView;
        if (view != null) {
            view.showLoading();
        }

    }

    @Override
    public void destroy() {
        T view = mView;
        mView = null;
        if (view != null) {
            mView.setPresenter(null);
        }

    }

    protected final T getView() {
        return mView;
    }
}
