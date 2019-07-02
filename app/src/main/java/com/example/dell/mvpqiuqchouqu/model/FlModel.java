package com.example.dell.mvpqiuqchouqu.model;

import com.example.dell.mvpqiuqchouqu.api.FlService;
import com.example.dell.mvpqiuqchouqu.base.FlBean;
import com.example.dell.mvpqiuqchouqu.bean.BaseCallback;
import com.example.dell.mvpqiuqchouqu.bean.BaseModel;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class FlModel extends BaseModel {
    public void getData(final BaseCallback<FlBean,String>callback){
        Retrofit retrofit = new Retrofit.Builder().baseUrl(FlService.fl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        FlService flService = retrofit.create(FlService.class);
        Observable<FlBean> data = flService.getData();
        data.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<FlBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(FlBean flBean) {
                        callback.onSueecss(flBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onFail("网络错误"+e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
}
