package com.ivanfanwu.base.net;

import android.content.Context;

import com.ivanfanwu.base.util.PreferenceUtil;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ivanfanwu on 2017/8/5.
 */

public class ApiManager {

    public static final String BASE_URL = "https://api.github.com/";
    private static Retrofit mRetrofit;
    private static ApiService mService;

    private ApiManager() {
    }

    private static Retrofit getRetrofit(final Context context) {
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request newRequest = chain.request().newBuilder().addHeader(PreferenceUtil.Key.ACCESS_TOKEN, PreferenceUtil.getString(context, PreferenceUtil.Key.ACCESS_TOKEN)).build();
                return chain.proceed(newRequest);
            }
        }).build();
        mRetrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
//                .client(client)   //与后台联调时加上此client的拦截器，目前抓取的包是GitHub的个人账号信息
                .build();
        return mRetrofit;
    }

    private static void initApiService(Context context) {
        if (mService == null) {
            synchronized (ApiManager.class) {
                if (mService == null) {
                    mService = getRetrofit(context).create(ApiService.class);
                }
            }
        }
    }

    public static ApiService getService(Context context) {
        initApiService(context);
        return mService;
    }

    public static void clear() {
        mService = null;
        mRetrofit = null;
    }

}
