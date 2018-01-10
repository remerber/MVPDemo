package com.wzh.mvpstudy.helper;

import com.google.gson.Gson;
import com.wzh.mvpstudy.R;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by HP on 2018/1/5.
 *
 * @author by wangWei
 */

public class NewsHelper {


    public static void refresh(final DataSource.Callback<List<NewsModel.ResultBean.ListBean>> callback) {

//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("http://v.juhe.cn")
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//
//        ApiService apiService = retrofit.create(ApiService.class);
//        Call<List<NewsModel.ResultBean.ListBean>> call = apiService.getList( );
//        call.enqueue(new Callback<List<NewsModel.ResultBean.ListBean>>() {
//            @Override
//            public void onResponse(Call<List<NewsModel.ResultBean.ListBean>> call, Response<List<NewsModel.ResultBean.ListBean>> response) {
//                if (response.isSuccessful()) {
//                    callback.onDataLoad(response.body());
//                }
//            }
//
//            @Override
//            public void onFailure(Call<List<NewsModel.ResultBean.ListBean>> call, Throwable t) {
//                callback.onDataNotAvailable(R.string.data_network_error);
//            }
//        });
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url("http://v.juhe.cn/weixin/query?key=872852dca0fc7526e61f82f8e210fd5b")
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                NewsModel model = new NewsModel();
                String json = response.body().string();
                Gson gson = new Gson();
                model = gson.fromJson(json, NewsModel.class);
                callback.onDataLoad(model.getResult().getList());

            }

            @Override
            public void onFailure(Call call, IOException e) {
                callback.onDataNotAvailable(R.string.data_network_error);
            }


        });

    }
}
