package com.wzh.mvpstudy.common;

/**
 * Created by HP on 2017/10/26.
 *
 * @author by wangWei
 */

public interface AdapterCallback<T> {
    void update(T t, RecyclerAdapter.ViewHolder<T> holder);
}
