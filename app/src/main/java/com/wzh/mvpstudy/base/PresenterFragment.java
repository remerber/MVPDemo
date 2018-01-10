package com.wzh.mvpstudy.base;

import android.content.Context;
import android.support.annotation.StringRes;
import android.widget.Toast;

import com.wzh.mvpstudy.presenter.BaseContract;

/**
 * Created by HP on 2018/1/4.
 *
 * @author by wangWei
 */

public abstract class PresenterFragment<Presenter extends BaseContract.Presenter>


        extends BaseFragment implements BaseContract.View<Presenter> {

    protected Presenter mPresenter;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        initPresenter();
    }

    /**
     * 初始化Presenter
     *
     * @return
     */
    protected abstract Presenter initPresenter();


    @Override
    public void showError(@StringRes int str) {
        if (mPlaceHolderView != null) {
             //mPlaceHolderView.triggerError(str);
             mPlaceHolderView.triggerNetError();
        } else {
            Toast.makeText(getActivity(), str, Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void showLoading() {
        if (mPlaceHolderView != null) {
            mPlaceHolderView.triggerLoading();
        }
        //还可以显示自己的Dialog

    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.mPresenter = presenter;
    }


}
