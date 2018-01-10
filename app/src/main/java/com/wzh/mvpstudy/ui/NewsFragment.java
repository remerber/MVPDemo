package com.wzh.mvpstudy.ui;


import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.wzh.mvpstudy.R;
import com.wzh.mvpstudy.base.PresenterFragment;
import com.wzh.mvpstudy.common.EmptyView;
import com.wzh.mvpstudy.common.RecyclerAdapter;
import com.wzh.mvpstudy.helper.NewsModel;
import com.wzh.mvpstudy.news.NewsContract;
import com.wzh.mvpstudy.news.NewsPresenter;

import java.util.List;

/**
 * Created by HP on 2018/1/5.
 *
 * @author by wangWei
 */

public class NewsFragment extends PresenterFragment<NewsContract.Presenter> implements NewsContract.View {


    private RecyclerView mRecyclerView;
    private EmptyView mEmptyView;
    private RecyclerAdapter<NewsModel.ResultBean.ListBean> mAdapter;


    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_news;
    }

    @Override
    protected void initWidget(View root) {
        super.initWidget(root);
        mRecyclerView = (RecyclerView) root.findViewById(R.id.recycler);
        mEmptyView = (EmptyView) root.findViewById(R.id.empty);

        mEmptyView.bind(mRecyclerView);
        setPlaceHolderView(mEmptyView);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setAdapter(mAdapter = new RecyclerAdapter<NewsModel.ResultBean.ListBean>() {
            @Override
            protected int getItemViewType(int position, NewsModel.ResultBean.ListBean data) {
                return R.layout.cell_news;
            }

            @Override
            protected ViewHolder<NewsModel.ResultBean.ListBean> onCreateViewHolder(View root, int viewType) {
                return new NewsFragment.ViewHolder(root);
            }
        });
        mEmptyView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initData();
            }
        });

    }

    @Override
    protected void initData() {
        super.initData();
        mPresenter.start();
    }

    @Override
    protected NewsContract.Presenter initPresenter() {
        return new NewsPresenter(this);
    }



    @Override
    public RecyclerAdapter<NewsModel.ResultBean.ListBean> getRecyclerAdapter() {
        return mAdapter;
    }

    @Override
    public void onSearchDone(List<NewsModel.ResultBean.ListBean> model) {
        mAdapter.replace(model);
        mPlaceHolderView.triggerOkOrEmpty(mAdapter.getItemCount() > 0);
    }

    class ViewHolder extends RecyclerAdapter.ViewHolder<NewsModel.ResultBean.ListBean> {

        private TextView text_content, text_url;

        public ViewHolder(View itemView) {
            super(itemView);
            text_content = (TextView) itemView.findViewById(R.id.content);
            text_url = (TextView) itemView.findViewById(R.id.url);
        }

        @Override
        protected void onBind(NewsModel.ResultBean.ListBean data) {
            text_content.setText(data.getTitle());
            text_url.setText(data.getUrl());
        }
    }
}
