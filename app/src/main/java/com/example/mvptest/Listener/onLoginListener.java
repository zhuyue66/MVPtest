package com.example.mvptest.Listener;

import com.example.mvptest.bean.UserBean;

/**
 * @author zhuyue66
 * @date 2017/11/22
 */

public interface onLoginListener {
    //登录成功的操作
    void loginSuccess(UserBean userBean);
    //登录失败的操作
    void loginFailed();
}
