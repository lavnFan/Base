package com.ivanfanwu.base.net;

import retrofit2.Retrofit;

/**
 * Created by ivanfanwu on 2017/8/5.
 */

public class RetrofitManager {

    private Retrofit mRetrofit;
    private ApiService mApiService;
    private static RetrofitManager mInstance;

    private RetrofitManager(){

    }

    public static RetrofitManager getInstance(){
        if(mInstance ==null){
            synchronized (RetrofitManager.class){
                mInstance = new RetrofitManager();
            }
        }
        return mInstance;
    }

}
