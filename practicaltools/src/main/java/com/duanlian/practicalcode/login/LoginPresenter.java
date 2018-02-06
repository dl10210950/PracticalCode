package com.duanlian.practicalcode.login;

import com.duanlian.practicalcode.base.BasePresenter;

/**
 * Created by duanlian on 2018/1/30.
 */

public class LoginPresenter extends BasePresenter implements LoginContract.Presenter {
    private LoginContract.View mView;

    public LoginPresenter(LoginContract.View view) {
        this.mView = view;
    }

    @Override
    public void toLogin(String userName, String pwd) {
        if (userName.isEmpty() || pwd.isEmpty()) {
            mView.showLoginError("用户名和密码不能为空！");
        } else {
            if (userName.equals("admin") && pwd.equals("123")) {
                mView.showLoginSuccess("111");
            } else {

                mView.showLoginError("用户名和密码错误！");
            }
        }
    }
}
