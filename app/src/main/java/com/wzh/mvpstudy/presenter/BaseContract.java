package com.wzh.mvpstudy.presenter;

import android.support.annotation.StringRes;

import com.wzh.mvpstudy.common.RecyclerAdapter;

/**
 * Created by HP on 2018/1/4.
 *
 * @author by wangWei
 */

public interface BaseContract {


    interface Presenter {

        void start();

        void destroy();

    }

    interface View<T extends Presenter> {

        void showError(@StringRes int str);

        void showLoading();

        void setPresenter(T presenter);

    }

    interface RecyclerView<ViewModel, T extends Presenter> extends View<T> {



        RecyclerAdapter<ViewModel> getRecyclerAdapter();

    }


}
