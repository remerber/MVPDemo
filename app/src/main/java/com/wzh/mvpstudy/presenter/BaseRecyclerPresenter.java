package com.wzh.mvpstudy.presenter;

import com.wzh.mvpstudy.common.RecyclerAdapter;

import java.util.List;

/**
 * Created by HP on 2018/1/4.
 *
 * @author by wangWei
 */

public class BaseRecyclerPresenter<ViewModel, View extends BaseContract.RecyclerView>

        extends BasePresenter<View> {


    public BaseRecyclerPresenter(View view) {
        super(view);
    }

    /**
     * 刷新数据
     *
     * @param datalist
     */
    protected void refreshData(List<ViewModel> datalist) {
        View view = getView();
        if (view == null) {
            return;
        }
        RecyclerAdapter<ViewModel> adapter = view.getRecyclerAdapter();
        adapter.replace(datalist);


    }
}
