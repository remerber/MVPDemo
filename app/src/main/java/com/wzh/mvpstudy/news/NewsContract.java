package com.wzh.mvpstudy.news;

import com.wzh.mvpstudy.helper.NewsModel;
import com.wzh.mvpstudy.presenter.BaseContract;

import java.util.List;

/**
 * Created by HP on 2018/1/5.
 *
 * @author by wangWei
 */

public interface NewsContract {

    interface  Presenter extends BaseContract.Presenter{

    }
    interface  View extends  BaseContract.RecyclerView<NewsModel.ResultBean.ListBean,Presenter>{
        void onSearchDone(List<NewsModel.ResultBean.ListBean> model);
    }
    //只是一个显示列表，没有什么操作，在基类中已经实现

}
