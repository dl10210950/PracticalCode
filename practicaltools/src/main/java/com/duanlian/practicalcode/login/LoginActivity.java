package com.duanlian.practicalcode.login;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.duanlian.practicalcode.R;
import com.duanlian.practicalcode.base.BaseActivity;

public class LoginActivity extends BaseActivity implements LoginContract.View {
    private Button btnLogin;


    private EditText etUserName;
    private EditText etPwd;
    private String userName;
    private String pwd;
    private LoginPresenter mPresenter;


    @Override
    public void initContentView() {
        setContentView(R.layout.activity_login);
    }

    @Override
    public void initView() {
        btnLogin = findViewById(R.id.btn_login);
        etUserName = findViewById(R.id.et_user_name);
        etPwd = findViewById(R.id.et_password);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userName = etUserName.getText().toString().trim();
                pwd = etPwd.getText().toString().trim();
                mPresenter.toLogin(userName,pwd);
            }
        });

    }

    @Override
    public void initPresenter() {
        mPresenter = new LoginPresenter(this);
    }


    @Override
    public void showLoginError(String errorMsg) {
        showToast(errorMsg);
    }

    @Override
    public void showLoginSuccess(String token) {

        try {
            LoginManager.getInstance().setToken(token);
            finish();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

