package com.xyp.tiange.androidmvp.model;

import android.text.TextUtils;

/**
 * User: xyp
 * Date: 2017/11/8
 * Time: 15:05
 */

public class UserModelImpl implements IUser {
    private String name,passWord;

    public UserModelImpl(String name, String passWord) {
        this.name = name;
        this.passWord = passWord;
    }
    @Override
    public int checkData() {
        if(TextUtils.isEmpty(name) || TextUtils.isEmpty(passWord))
            return -1;
        return 0;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getPassWord() {
        return this.passWord;
    }
}
