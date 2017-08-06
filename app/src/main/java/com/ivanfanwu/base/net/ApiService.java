package com.ivanfanwu.base.net;

import com.ivanfanwu.base.model.entity.Repo;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by ivanfanwu on 2017/8/5.
 */

public interface ApiService {

    @GET("users/{user}/repos")
    Call<List<Repo>> getListRepos(@Path("user") String user);

}
