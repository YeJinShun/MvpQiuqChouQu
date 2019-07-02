package com.example.dell.mvpqiuqchouqu.bean;

public abstract class BasePresenter<M extends BaseModel,V extends BaseView> {
    public M model;
    public V view;

    public void setModel(M model) {
        this.model = model;
    }

    public void setView(V view) {
        this.view = view;
    }
}
