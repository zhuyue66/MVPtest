package com.example.mvptest.util;

import android.app.Application;
import android.content.Context;

/**
 * @author zhuyue66
 * @date 2017/12/5
 */

public class MyApplication extends Application {
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }

    public static Context getContext(){
        return context;
    }
}
