package com.okanserdaroglu.shoppingapp.ui.Base;

import android.app.Application;

import com.okanserdaroglu.shoppingapp.helper.SharedPreferenceHelper;

public class ShoppingApplication extends Application {

    private SharedPreferenceHelper sharedPreferenceHelper;

    @Override
    public void onCreate() {
        super.onCreate();
        sharedPreferenceHelper = SharedPreferenceHelper.getInstance(this);
    }

    public SharedPreferenceHelper getSharedPreferenceHelper() {
        return sharedPreferenceHelper;
    }

}
