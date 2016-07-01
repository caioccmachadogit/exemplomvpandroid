/*
 *
 *  * Copyright (C) 2014 Antonio Leiva Gordillo.
 *  *
 *  * Licensed under the Apache License, Version 2.0 (the "License");
 *  * you may not use this file except in compliance with the License.
 *  * You may obtain a copy of the License at
 *  *
 *  *      http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  * Unless required by applicable law or agreed to in writing, software
 *  * distributed under the License is distributed on an "AS IS" BASIS,
 *  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  * See the License for the specific language governing permissions and
 *  * limitations under the License.
 *
 */

package com.mvpexample.app.Login.contract.impl;

import android.app.Activity;
import android.text.TextUtils;

import com.mvpexample.app.Login.contract.LoginInteractor;
import com.mvpexample.app.Login.contract.LoginPresenter;
import com.mvpexample.app.Login.contract.LoginView;

public class LoginPresenterImpl implements LoginPresenter, LoginInteractor.OnLoginFinishedListener {

    private LoginView loginView;
    private LoginInteractor loginInteractor;
    private Activity activity;

    public LoginPresenterImpl(LoginView loginView) {
        this.loginView = loginView;
        this.activity = (Activity) loginView;
        this.loginInteractor = new LoginInteractorImpl(this.activity, this);
    }

    @Override public void validateCredentials(String username, String password) {
        boolean error = false;

        if (loginView != null) {
            loginView.showProgress();
        }
        if (TextUtils.isEmpty(username)){
            onUsernameError();
            error = true;
        }
        if (TextUtils.isEmpty(password)){
            onPasswordError();
            error = true;
        }

        if(!error)
            loginInteractor.login(username, password);
    }

    @Override public void onDestroy() {
        loginView = null;
    }

    @Override public void onUsernameError() {
        if (loginView != null) {
            loginView.setUsernameError();
            loginView.hideProgress();
        }
    }

    @Override public void onPasswordError() {
        if (loginView != null) {
            loginView.setPasswordError();
            loginView.hideProgress();
        }
    }

    @Override public void onSuccess() {
        if (loginView != null) {
            loginView.navigateToHome();
        }
    }

    @Override
    public void onError() {

    }
}
