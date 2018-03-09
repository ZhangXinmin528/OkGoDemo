package com.example.okgodemo.model;

/**
 * Created by ZhangXinmin on 2017/9/20.
 * Copyright (c) 2017 . All rights reserved.
 */

public class UserInfo {
    public int id;
    public String name;
    public int age;

    @Override
    public String toString() {
        return "UserInfo:{" + '\n' +
                "\t\t##id=" + id + '\n' +
                "\t\t##name='" + name + '\n' +
                "\t\t##age=" + age + '\n' +
                '}';
    }
}
