package com.xiongxh.cryptocoin;

import android.app.Application;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.xiongxh.cryptocoin.coindetails.CoinDetailActivity;
import com.xiongxh.cryptocoin.coins.CoinsActivity;


import timber.log.Timber;


import com.firebase.client.Firebase;
public class CryptoCoinApp extends Application {



    @Override
    public void onCreate() {
        super.onCreate();

        Firebase.setAndroidContext(this);

        if (BuildConfig.DEBUG) {
            Timber.uprootAll();
            Timber.plant(new Timber.DebugTree());
        }

    }



}
