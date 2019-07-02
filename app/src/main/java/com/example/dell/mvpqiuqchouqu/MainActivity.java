package com.example.dell.mvpqiuqchouqu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.dell.mvpqiuqchouqu.base.FlBean;
import com.example.dell.mvpqiuqchouqu.bean.BaseCallback;
import com.example.dell.mvpqiuqchouqu.bean.BaseMvpAcvivity;
import com.example.dell.mvpqiuqchouqu.bean.BaseView;
import com.example.dell.mvpqiuqchouqu.model.FlModel;
import com.example.dell.mvpqiuqchouqu.presenter.FlPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseMvpAcvivity<FlPresenter,FlModel,BaseView<FlBean,String>>implements BaseView<FlBean,String>{

    @BindView(R.id.btn_fu)
    Button btnFu;
    @BindView(R.id.img)
    ImageView img;


    @OnClick(R.id.btn_fu)
    public void onViewClicked() {
        presenter.getData();
    }


    @Override
    protected BaseView<FlBean, String> initMvpView() {
        return this;
    }

    @Override
    protected FlModel initMvpModel() {
        return new FlModel();
    }

    @Override
    protected FlPresenter initMvpPresenter() {
        return new FlPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void onSueecss(FlBean flBean) {
        String url = flBean.getResults().get(0).getUrl();
        Glide.with(this).load(url).into(img);
    }

    @Override
    public void onFail(String s) {

    }
}
