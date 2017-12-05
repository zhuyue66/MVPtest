package com.example.mvptest.presenter;

import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

import com.example.mvptest.bean.User;
import com.example.mvptest.biz.IUserBiz;
import com.example.mvptest.biz.UserBiz;
import com.example.mvptest.biz.onLoginListener;
import com.example.mvptest.util.MyApplication;
import com.example.mvptest.view.IUserLoginView;

import static android.content.ContentValues.TAG;

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
        //对Login方法设置监听
        userBiz.login(userLoginView.getUserName(), userLoginView.getPassword(),new MyListener());
    }

    public void clear() {
        userLoginView.clearUserName();
        userLoginView.clearPassword();
    }

    private class MyListener implements onLoginListener {
            @Override
            public void loginSuccess(final User user){
                //需要在UI线程执行
                mHandler.post(new Runnable(){
                    @Override
                    public void run(){
                        userLoginView.showSuccess(user);
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

}
