package com.mvpexample.app.Login.async;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.util.Log;

import com.mvpexample.app.Login.contract.LoginInteractor;

/**
 * Created by Santander on 27/06/16.
 */
public class AsyncAuth extends AsyncTask<String, String, String> {
    private ProgressDialog pd;
    private Activity activity;
    private LoginInteractor ti;

    public AsyncAuth(Activity activity, LoginInteractor ti){
        this.activity = activity;
        this.ti = ti;
    }

    @Override
    protected void onPreExecute() {
        //---Inicia a espera do progresso---
        pd = ProgressDialog.show(activity, "Validar Dispositivo", "Autenticando...");
    }

    @Override
    protected String doInBackground(String... params) {
        //---Executa a Requisi��o
        String jsonResponse = "";
        try{
            Thread.sleep(5000);
            //RequestAuth requestAuth = new RequestAuth();
            //jsonResponse = requestAuth.ObterAuth(params[0]);
            jsonResponse = "SUCCES";
        }
        catch (Exception ex){
            Log.e("ERROR ASYNCAUTH", ex.getMessage());
            return null;
        }
        return jsonResponse;
    }

    @Override
    protected void onPostExecute(String result)
    {
        //---Executa a Pos-Requisi��o
        ti.responseAsyncAuth(result);
        this.pd.dismiss();
    }
}

