package com.example.okgodemo.model;

import java.util.List;

/**
 * Created by ZhangXinmin on 2017/9/20.
 * Copyright (c) 2017 . All rights reserved.
 */

public class ModelB {
    public int code;
    public String msg;
    public List<UserInfo> data;

    @Override
    public String toString() {
        return "ModelB:{" + '\n' +
                "\tcode=" + code + '\n' +
                "\tmsg='" + msg + '\n' +
                "\t1>##" + data.get(0).toString() + '\n' +
                "\t2>##" + data.get(1).toString() + '\n' +
                "\t3>##" + data.get(2).toString() + '\n' +
                '}';
    }
}
