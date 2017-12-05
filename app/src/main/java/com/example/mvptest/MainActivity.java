package com.example.mvptest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.mvptest.bean.User;
import com.example.mvptest.biz.onLoginListener;
import com.example.mvptest.presenter.UserLoginPresenter;
import com.example.mvptest.view.IUserLoginView;

/**
 * The type Main activity.
 */
public class MainActivity extends AppCompatActivity implements IUserLoginView {


    private EditText mEtUsername, mEtPassword;
    private Button mBtnLogin, mBtnClear;
    private ProgressBar mPbLoading;

    private UserLoginPresenter mUserLoginPresenter = new UserLoginPresenter(MainActivity.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    private void initViews() {
        mEtUsername = findViewById(R.id.UserName);
        mEtPassword = findViewById(R.id.UserPassword);
        mBtnClear = findViewById(R.id.clear);
        mBtnLogin = findViewById(R.id.login);
        mPbLoading = findViewById(R.id.progressBar);

        mBtnLogin.setOnClickListener(new MyListener());
        mBtnClear.setOnClickListener(new MyListener());
        /*mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mUserLoginPresenter.login();
            }
        });

        mBtnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mUserLoginPresenter.clear();
            }
        });*/

    }

    @Override
    public String getUserName()
    {
        return mEtUsername.getText().toString();
    }

    @Override
    public String getPassword()
    {
        return mEtPassword.getText().toString();
    }

    @Override
    public void clearUserName() {
        mEtUsername.setText("");
    }

    @Override
    public void clearPassword()
    {
        mEtPassword.setText("");
    }

    @Override
    public void showLoading()
    {
        mPbLoading.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading()
    {
        mPbLoading.setVisibility(View.GONE);
    }

    @Override
    public void showSuccess(User user) {
        Toast.makeText(this, user.getName() + " login success ", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showFailedError() {
        Toast.makeText(this, "login failed", Toast.LENGTH_SHORT).show();
    }

    class MyListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.login ){
                mUserLoginPresenter.login();
            } else if (v.getId() == R.id.clear) {
                mUserLoginPresenter.clear();
            }
        }
    }
}
