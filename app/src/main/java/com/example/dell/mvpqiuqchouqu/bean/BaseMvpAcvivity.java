package com.example.dell.mvpqiuqchouqu.bean;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.dell.mvpqiuqchouqu.R;

import butterknife.ButterKnife;

public abstract class BaseMvpAcvivity<P extends BasePresenter,M extends BaseModel,V extends BaseView>extends AppCompatActivity {
    protected P presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        presenter=initMvpPresenter();
        if (presenter!=null){
            presenter.setModel(initMvpModel());
            presenter.setView(initMvpView());
        }
    }

    protected abstract V initMvpView();

    protected abstract M initMvpModel();

    protected abstract P initMvpPresenter();

    protected abstract int getLayoutId();


}
