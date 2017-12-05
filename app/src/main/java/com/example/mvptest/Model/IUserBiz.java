package com.example.mvptest.Model;

import com.example.mvptest.Listener.onLoginListener;

/**
 * @author zhuyue66
 * @date 2017/11/22
 */

public interface IUserBiz {
    //登录
    void ModelLogin(String name,String password,onLoginListener loginListener);
}
