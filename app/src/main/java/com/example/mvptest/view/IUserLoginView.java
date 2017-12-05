package com.example.mvptest.view;

import com.example.mvptest.Model.UserBean;

/**
 * @author zhuyue66
 * @date 2017/11/22
 */

public interface IUserLoginView {

    //从用户名EditText中获取用户名
    String getUserName();

    //从密码EditText中获取密码
    String getPassword();

    //清空用户名EditText中的用户名
    void clearUserName();

    //清空密码EditText中的密码
    void clearPassword();

    //显示loading
    void showLoading();

    //隐藏loading
    void hideLoading();

    //从Model中获取用户名之后弹登录成功的Toast
    /**
     * 此处涉及View和Model的少量数据交换
     * */
    void showSuccess(UserBean userBean);

    //弹登录失败的Toast
    void showFailedError();

}
