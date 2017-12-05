package com.example.mvptest.biz;

import com.example.mvptest.bean.User;

/**
 * @author zhuyue66
 * @date 2017/11/22
 * 接口IUserBiz的实现类
 */

public class UserBiz implements IUserBiz {

    @Override
    public void login(final String name, final String password, final onLoginListener loginListener) {
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
                    User user = new User();
                    user.setName(name);
                    user.setPassword(password);
                    loginListener.loginSuccess(user);
                }else {
                    loginListener.loginFailed();
                }
            }
        }.start();
    }

}
