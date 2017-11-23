package com.example.mvptest.presenter;

import android.os.Handler;
import com.example.mvptest.bean.User;
import com.example.mvptest.biz.IUserBiz;
import com.example.mvptest.biz.UserBiz;
import com.example.mvptest.biz.onLoginListener;
import com.example.mvptest.view.IUserLoginView;

/**
 * @author zhuyue66
 * @date 2017/11/22
 */

public class UserLoginPresenter {

    private IUserBiz userBiz;
    private IUserLoginView userLoginView;
    private Handler mHandler = new Handler();

    public UserLoginPresenter(IUserLoginView userLoginView) {
        this.userLoginView = userLoginView;
        this.userBiz = new UserBiz();
    }

    public void login() {
        userLoginView.showLoading();
        userBiz.login(userLoginView.getUserName(), userLoginView.getPassword(), new onLoginListener() {
            @Override
            public void loginSuccess(final User user){
                //需要在UI线程执行
                mHandler.post(new Runnable(){
                    @Override
                    public void run(){
                        userLoginView.toMainActivity(user);
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
        });
    }

    public void clear() {
        userLoginView.clearUserName();
        userLoginView.clearPassword();
    }
}
