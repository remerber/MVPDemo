package com.wzh.mvpstudy.news;

import android.os.Handler;
import android.os.Message;
import android.support.annotation.StringRes;

import com.wzh.mvpstudy.helper.DataSource;
import com.wzh.mvpstudy.helper.NewsHelper;
import com.wzh.mvpstudy.helper.NewsModel;
import com.wzh.mvpstudy.presenter.BaseRecyclerPresenter;

import java.util.List;

/**
 * Created by HP on 2018/1/5.
 *
 * @author by wangWei
 */

public class NewsPresenter extends BaseRecyclerPresenter<NewsModel.ResultBean.ListBean, NewsContract.View>
        implements DataSource.Callback<List<NewsModel.ResultBean.ListBean>>, NewsContract.Presenter {

    private List<NewsModel.ResultBean.ListBean> mNewsModels;
    private NewsContract.View mView;
    private int mStrRes;
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0:

                    mView.onSearchDone(mNewsModels);
                    break;
                case 1:
                    mView.showError(mStrRes);
                    break;
                default:

                    break;
            }

        }
    };


    public NewsPresenter(NewsContract.View view) {
        super(view);
    }

    @Override
    public void start() {
        super.start();
        //Todo 请求网络  延迟请求 看Loading效果
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                NewsHelper.refresh(NewsPresenter.this);
            }
        }, 2000);


    }

    @Override
    public void onDataLoad(List<NewsModel.ResultBean.ListBean> newsModels) {
        NewsContract.View view = getView();
        if (view == null) {
            return;
        }
        mNewsModels = newsModels;
        mView = view;
        mHandler.sendEmptyMessage(0);

    }

    @Override
    public void onDataNotAvailable(@StringRes int strRes) {
        NewsContract.View view = getView();
        if (view == null) {
            return;
        }
        mView = view;
        mHandler.sendEmptyMessage(1);
        mStrRes = strRes;

    }
}
