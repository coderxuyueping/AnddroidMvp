package com.xyp.tiange.androidmvp.view;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.xyp.tiange.androidmvp.R;
import com.xyp.tiange.androidmvp.presenter.ILoginPresenter;
import com.xyp.tiange.androidmvp.presenter.LoginPresenterImpl;

/**
 * User: xyp
 * Date: 2017/11/8
 * Time: 14:41
 * MVP：model：数据
 *      presenter：逻辑处理
 *      view：界面显示
 *
 * view只跟presenter交互，不与model接触。
 */

public class LoginActivity extends Activity implements ILoginView{
    private ProgressBar progressBar;
    private EditText name,password;
    private Button login;
    //只跟presenter打交道，需要什么逻辑操作就new什么
    private ILoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView(){
        progressBar = findViewById(R.id.progressbar);
        name = findViewById(R.id.name);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginPresenter = new LoginPresenterImpl(LoginActivity.this, name.getText().toString(), password.getText().toString());
                loginPresenter.login();
            }
        });
    }
    @Override
    public void showProgress(int visibility) {
        if(visibility == 1)
            progressBar.setVisibility(View.VISIBLE);
        else
            progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showToast(int code) {
        if(code == 0)
            Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
        else if(code == -1)
            Toast.makeText(this, "账号密码格式不对", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        loginPresenter.onDestroy();
    }
}
