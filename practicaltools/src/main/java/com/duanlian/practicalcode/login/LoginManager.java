package com.duanlian.practicalcode.login;

import android.content.Context;
import android.content.Intent;

import com.duanlian.practicalcode.utils.SPUtils;

/**
 * Created by duanlian on 2018/1/30.
 */

public class LoginManager {
    private static LoginManager mInstance;
    private boolean isLogin;
    private Context mContext;

    private LoginManager() {
    }

    public static LoginManager getInstance() {
        if (mInstance == null) {
            synchronized (LoginManager.class) {
                if (mInstance == null) {
                    mInstance = new LoginManager();
                }

            }
        }
        return mInstance;
    }

    public void init(Context context) {
        this.mContext = context;
        try {
            isLogin();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean isLogin() throws Exception {

        if (mContext == null) {
            throw new Exception("请先初始化LoginManager");
        } else {
            String token = (String) SPUtils.get(mContext, "token", "");
            if (token.isEmpty() || token == null) {
                isLogin = false;
            } else {
                isLogin = true;
            }

        }


        return isLogin;
    }

    public void setToken(String token) throws Exception {
        if (mContext == null) {
            throw new Exception("请先初始化LoginManager");
        } else {
            SPUtils.put(mContext, "token", token);
        }
    }

    public void checkLoginState() throws Exception {
        if (isLogin) {
            // TODO: 2018/1/30  do something  after login success

        } else {
            if (mContext == null) {
                throw new Exception("请先初始化LoginManager");
            } else {
                Intent intent = new Intent();
                intent.setClass(mContext,com.duanlian.practicalcode.login.LoginActivity.class);
                mContext.startActivity(intent);

            }
        }
    }
}
