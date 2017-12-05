package com.example.mvptest.presenter;

import android.os.Handler;

import com.example.mvptest.Model.UserBean;
import com.example.mvptest.Model.IUserBiz;
import com.example.mvptest.Model.UserBiz;
import com.example.mvptest.Listener.onLoginListener;
import com.example.mvptest.view.IUserLoginView;

/**
 * @author zhuyue66
 * @date 2017/11/22
 */

public class UserLoginPresenter {

    private IUserBiz userBiz;//业务逻辑实体类的引用
    private IUserLoginView userLoginView;//view的引用
    private Handler mHandler = new Handler();

    public UserLoginPresenter(IUserLoginView userLoginView) {
        this.userLoginView = userLoginView;
        this.userBiz = new UserBiz();//业务实体类的实例
    }

    public void login() {
        userLoginView.showLoading();
        //对Login方法设置监听
        userBiz.ModelLogin(userLoginView.getUserName(), userLoginView.getPassword(),new MyListener());
    }

    public void clear() {
        userLoginView.clearUserName();
        userLoginView.clearPassword();
    }

    private class MyListener implements onLoginListener {
            @Override
            public void loginSuccess(final UserBean userBean){
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

}
