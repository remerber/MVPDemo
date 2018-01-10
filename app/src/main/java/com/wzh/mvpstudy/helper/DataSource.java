package com.wzh.mvpstudy.helper;

import android.support.annotation.StringRes;

/**
 * Created by HP on 2018/1/5.
 *
 * @author by wangWei
 */

public interface DataSource {

    interface SucceedCallback<T> {

        void onDataLoad(T t);
    }

    interface FailedCallback {

        void onDataNotAvailable(@StringRes int strRes);

    }

    interface Callback<T> extends SucceedCallback<T>, FailedCallback {

    }


}
