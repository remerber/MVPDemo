package com.wzh.mvpstudy.helper;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by HP on 2018/1/5.
 *
 * @author by wangWei
 */

public interface ApiService {

    @GET("/weixin/query?key=872852dca0fc7526e61f82f8e210fd5b")
    Call<List<NewsModel.ResultBean.ListBean>> getList( );

}
