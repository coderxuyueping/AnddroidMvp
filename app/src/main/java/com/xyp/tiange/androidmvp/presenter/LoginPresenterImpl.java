package com.xyp.tiange.androidmvp.presenter;

import android.os.Handler;

import com.xyp.tiange.androidmvp.model.IUser;
import com.xyp.tiange.androidmvp.model.UserModelImpl;
import com.xyp.tiange.androidmvp.view.ILoginView;


/**
 * User: xyp
 * Date: 2017/11/8
 * Time: 15:10
 */

public class LoginPresenterImpl implements ILoginPresenter {
    private ILoginView loginView;
    private IUser user;
    private Handler handler;
    public LoginPresenterImpl(ILoginView loginView, String name, String passWord){
        this.loginView = loginView;
        user = new UserModelImpl(name, passWord);
        handler = new Handler();
    }
    @Override
    public void login() {
        if(user.checkData() == -1)
            loginView.showToast(-1);
        else{
            loginView.showProgress(1);
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    loginView.showToast(0);
                    loginView.showProgress(0);
                }
            }, 2000);
        }
    }

    @Override
    public void onDestroy() {
        //释放view
        loginView = null;
    }
}
