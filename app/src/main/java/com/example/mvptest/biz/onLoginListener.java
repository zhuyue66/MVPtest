package com.example.mvptest.biz;

import com.example.mvptest.bean.User;

/**
 * @author zhuyue66
 * @date 2017/11/22
 */

public interface onLoginListener {
    void loginSuccess(User user);
    void loginFailed();
}
