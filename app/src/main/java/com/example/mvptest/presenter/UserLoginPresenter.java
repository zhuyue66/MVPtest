package com.example.mvptest.presenter;

import android.os.Handler;

import com.example.mvptest.bean.UserBean;
import com.example.mvptest.Model.IUserBiz;
import com.example.mvptest.Model.UserBiz;
import com.example.mvptest.Listener.onLoginListener;
import com.example.mvptest.contract.UserLoginContract;

/**
 * @author zhuyue66
 * @date 2017/11/22
 */

public class UserLoginPresenter implements UserLoginContract.UserLoginPresenter {

    private IUserBiz userBiz;//业务逻辑实体类的引用
    private UserLoginContract.IUserLoginView userLoginView;//view的引用
    private Handler mHandler = new Handler();

    public UserLoginPresenter(UserLoginContract.IUserLoginView userLoginView) {
        this.userLoginView = userLoginView;
        this.userBiz = new UserBiz(this);//业务实体类的实例
    }

    @Override
    public void login() {
        userLoginView.showLoading();
        //对Login方法设置监听
        userBiz.ModelLogin(userLoginView.getUserName(), userLoginView.getPassword());
    }

    @Override
    public void clear() {
        userLoginView.clearUserName();
        userLoginView.clearPassword();
    }

    @Override
    public void loginSuccess(final UserBean userBean) {
        //需要在UI线程执行
        mHandler.post(new Runnable(){
            @Override
            public void run(){
                userLoginView.showSuccess(userBean);
                userLoginView.hideLoading();
            }
        });
    }

    @Override
    public void loginFailed() {
        //需要在UI线程执行
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                userLoginView.showFailedError();
                userLoginView.hideLoading();
            }
        });
    }

}
