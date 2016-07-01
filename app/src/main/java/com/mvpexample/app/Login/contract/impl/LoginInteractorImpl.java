package com.mvpexample.app.Login.contract.impl;

import android.app.Activity;
import android.util.Log;

import com.mvpexample.app.Login.async.AsyncAuth;
import com.mvpexample.app.Login.contract.LoginInteractor;

public class LoginInteractorImpl implements LoginInteractor {

    private Activity activity;
    private OnLoginFinishedListener onLoginFinishedListener;

    public LoginInteractorImpl(Activity activity, OnLoginFinishedListener onLoginFinishedListener) {
        this.activity = activity;
        this.onLoginFinishedListener = onLoginFinishedListener;
    }

    @Override
    public void login(final String username, final String password) {
        new AsyncAuth(this.activity,this).execute(username);
    }

    @Override
    public void responseAsyncAuth(String json) {
        Log.d("SUCCES",json);

        if(json != null)
            onLoginFinishedListener.onSuccess();
        else
            onLoginFinishedListener.onError();


    }
}
