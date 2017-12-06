package com.example.mvptest.Model;

import com.example.mvptest.Listener.onLoginListener;
import com.example.mvptest.bean.UserBean;

/**
 * @author zhuyue66
 * @date 2017/11/22
 * 接口IUserBiz的实现类
 */

public class UserBiz implements IUserBiz {

    @Override
    public void ModelLogin(final String name, final String password, final onLoginListener loginListener) {
        //模拟子线程耗时操作
        new Thread(){
            @Override
            public void run() {
                try{
                    Thread.sleep(2000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                //模拟登录成功
                if(name.equals("123") && password.equals("123")){
                    UserBean userBean = new UserBean();//数据的存储
                    userBean.setName(name);
                    userBean.setPassword(password);
                    loginListener.loginSuccess(userBean);//回调loginSuccess()方法
                }else {
                    loginListener.loginFailed();//回调loginFailed()方法
                }
            }
        }.start();
    }

}
