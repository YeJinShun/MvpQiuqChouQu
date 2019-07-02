package com.example.dell.mvpqiuqchouqu.api;

import com.example.dell.mvpqiuqchouqu.base.FlBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface FlService {

    //https://gank.io/api/data/%E7%A6%8F%E5%88%A9/20/1
    String fl = "https://gank.io/api/data/%E7%A6%8F%E5%88%A9/20/";
    @GET("1")
    Observable<FlBean> getData();
}
