package com.duanlian.practicalcode.login;

import com.duanlian.practicalcode.base.IBaseView;

/**
 * Created by duanlian on 2018/1/30.
 */

public interface LoginContract {
    interface View extends IBaseView{
        void showLoginError(String errorMsg);

        void showLoginSuccess(String token);
    }
    interface Presenter {
        void toLogin(String userName, String pwd);

    }
}
