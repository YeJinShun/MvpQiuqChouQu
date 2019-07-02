package com.example.dell.mvpqiuqchouqu.presenter;

import com.example.dell.mvpqiuqchouqu.base.FlBean;
import com.example.dell.mvpqiuqchouqu.bean.BaseCallback;
import com.example.dell.mvpqiuqchouqu.bean.BasePresenter;
import com.example.dell.mvpqiuqchouqu.bean.BaseView;
import com.example.dell.mvpqiuqchouqu.model.FlModel;

public class FlPresenter extends BasePresenter<FlModel,BaseView>implements BaseCallback<FlBean,String> {

    public void getData(){
        if (model!=null){
            model.getData(this);
        }
    }


    @Override
    public void onSueecss(FlBean flBean) {
        if (view!=null){
            view.onSueecss(flBean);
        }
    }

    @Override
    public void onFail(String s) {
        if (view!=null){
            view.onFail(s);
        }
    }
}
