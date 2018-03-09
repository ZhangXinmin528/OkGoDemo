package com.example.okgodemo;

import android.app.Application;

import com.example.okgodemo.utils.HttpClientBuilderCreator;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.cache.CacheEntity;
import com.lzy.okgo.cache.CacheMode;

import okhttp3.OkHttpClient;

/**
 * Created by ZhangXinmin on 2017/9/20.
 * Copyright (c) 2017 . All rights reserved.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        initOkGo();
    }

    private void initOkGo() {
        OkHttpClient.Builder builder =
                HttpClientBuilderCreator.builder()
                        .configLog("Http")
                        .configTimeOut(-1, -1, -1)
                        .create();
        OkGo.getInstance().init(this)
                .setRetryCount(3)
                .setCacheMode(CacheMode.NO_CACHE)
                .setCacheTime(CacheEntity.CACHE_NEVER_EXPIRE)
                .setOkHttpClient(builder.build());
    }
}
