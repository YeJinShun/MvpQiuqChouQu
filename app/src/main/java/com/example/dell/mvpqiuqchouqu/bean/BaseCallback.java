package com.example.dell.mvpqiuqchouqu.bean;

public interface BaseCallback <M,T> {
    void onSueecss(M m);
    void onFail(T t);
}
