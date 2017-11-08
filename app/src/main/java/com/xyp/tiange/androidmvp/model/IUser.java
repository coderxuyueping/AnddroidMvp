package com.xyp.tiange.androidmvp.model;

/**
 * User: xyp
 * Date: 2017/11/8
 * Time: 15:02
 * 数据处理层，比如验证登录的数据是否有问题
 */

public interface IUser {
    int checkData();
    String getName();
    String getPassWord();
}
