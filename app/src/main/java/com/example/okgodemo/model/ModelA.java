package com.example.okgodemo.model;

/**
 * Created by ZhangXinmin on 2017/9/20.
 * Copyright (c) 2017 . All rights reserved.
 */

public class ModelA {
    public int code;
    public String msg;
    public UserInfo data;

    @Override
    public String toString() {
        return "ModelA:{" + '\n' +
                "\tcode=" + code + '\n' +
                "\tmsg='" + msg + '\n' +
                "\t" + data.toString() + '\n' +
                '}';
    }
}
