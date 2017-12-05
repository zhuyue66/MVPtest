package com.example.mvptest.view;

import com.example.mvptest.bean.User;

/**
 * @author zhuyue66
 * @date 2017/11/22
 */

public interface IUserLoginView {

    String getUserName();

    String getPassword();

    void clearUserName();

    void clearPassword();

    void showLoading();

    void hideLoading();

    void showSuccess(User user);

    void showFailedError();

}
