package com.example.okgodemo.utils;

import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.interceptor.HttpLoggingInterceptor;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import okhttp3.OkHttpClient;

/**
 * Created by ZhangXinmin on 2017/10/6.
 * Copyright (c) 2017 . All rights reserved.
 * init OkHttpClient params and settings
 */

public final class HttpClientBuilderCreator {

    private static final String DEFAULT_TAG = "okgo";
    private static OkHttpClient.Builder BUILDER;

    private HttpClientBuilderCreator() {
    }

    public static HttpClientBuilderCreator builder() {
        return new HttpClientBuilderCreator();
    }

    /**
     * init OkHttpClient Builder
     */
    public static void initOkHttpClientBuilder() {
        if (BUILDER == null)
            BUILDER = new OkHttpClient.Builder();
    }

    /**
     * <p>
     * Config log settings for okgo
     * </p>
     * Using third party library to config log setting is not recommended.
     *
     * @return HttpClientBuilderCreator
     */
    public final HttpClientBuilderCreator configLog() {
        initOkHttpClientBuilder();
        configLog(BUILDER, "");
        return this;
    }

    /**
     * <p>
     * Config log settings for okgo
     * </p>
     * Using third party library to config log setting is not recommended.
     *
     * @param tag the tag for log
     * @return HttpClientBuilderCreator
     */
    public final HttpClientBuilderCreator configLog(@NonNull String tag) {
        initOkHttpClientBuilder();
        configLog(BUILDER, tag);
        return this;
    }

    /**
     * <p>
     * Config log settings for okgo
     * </p>
     * Using third party library to config log setting is not recommended.
     *
     * @param builder OkHttpClient.Builder
     * @param tag     the tag for log
     * @return OkHttpClient.Builder
     */
    public static final OkHttpClient.Builder configLog(@NonNull OkHttpClient.Builder builder,
                                                       @NonNull String tag) {

        if (TextUtils.isEmpty(tag))
            tag = DEFAULT_TAG;
        //init log
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(tag);
        //设置log打印级别，决定log的显示详细程度
        loggingInterceptor.setPrintLevel(HttpLoggingInterceptor.Level.BODY);
        //log颜色级别，决定log在控制台显示的颜色
        loggingInterceptor.setColorLevel(Level.INFO);
        builder.addInterceptor(loggingInterceptor);
        return builder;
    }

    /**
     * <p>
     * Config time out setting for the builder
     * </p>
     *
     * @return HttpClientBuilderCreator
     */
    public final HttpClientBuilderCreator configTimeOut() {
        initOkHttpClientBuilder();
        configTimeOut(BUILDER, -1, -1, -1);
        return this;
    }

    /**
     * <p>
     * Config time out setting for the builder
     * </p>
     *
     * @param readTimeout    if readTimeout == -1,readTimeout = OkGo.DEFAULT_MILLISECONDS;
     * @param writeTimeout   if writeTimeout == -1,writeTimeout = OkGo.DEFAULT_MILLISECONDS;
     * @param connectTimeout if connectTimeout == -1,connectTimeout = OkGo.DEFAULT_MILLISECONDS;
     * @return HttpClientBuilderCreator
     */
    public final HttpClientBuilderCreator configTimeOut(long readTimeout,
                                                        long writeTimeout,
                                                        long connectTimeout) {
        initOkHttpClientBuilder();
        configTimeOut(BUILDER, readTimeout, writeTimeout, connectTimeout);
        return this;
    }

    /**
     * <p>
     * Config time out setting for the builder
     * </p>
     *
     * @param builder        OkHttpClient.Builder
     * @param readTimeout    if readTimeout == -1,readTimeout = OkGo.DEFAULT_MILLISECONDS;
     * @param writeTimeout   if writeTimeout == -1,writeTimeout = OkGo.DEFAULT_MILLISECONDS;
     * @param connectTimeout if connectTimeout == -1,connectTimeout = OkGo.DEFAULT_MILLISECONDS;
     * @return OkHttpClient.Builder
     */
    public static final OkHttpClient.Builder configTimeOut(@NonNull OkHttpClient.Builder builder,
                                                           long readTimeout,
                                                           long writeTimeout,
                                                           long connectTimeout) {
        if (readTimeout == -1) {
            readTimeout = OkGo.DEFAULT_MILLISECONDS;
        }
        if (writeTimeout == -1) {
            writeTimeout = OkGo.DEFAULT_MILLISECONDS;
        }
        if (connectTimeout == -1) {
            connectTimeout = OkGo.DEFAULT_MILLISECONDS;
        }

        builder.readTimeout(readTimeout, TimeUnit.MILLISECONDS)
                .writeTimeout(writeTimeout, TimeUnit.MILLISECONDS)
                .connectTimeout(connectTimeout, TimeUnit.MILLISECONDS);

        return builder;
    }

    public final OkHttpClient.Builder create() {
        initOkHttpClientBuilder();
        return BUILDER;
    }
}
