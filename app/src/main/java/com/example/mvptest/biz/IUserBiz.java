package com.example.mvptest.biz;

/**
 * @author zhuyue66
 * @date 2017/11/22
 */

public interface IUserBiz {
    void login(String name,String password,onLoginListener loginListener);
}
