package com.okanserdaroglu.shoppingapp.ui.Base;

import android.app.Application;

import com.okanserdaroglu.shoppingapp.helper.SharedPreferenceHelper;
import com.okanserdaroglu.shoppingapp.remote.NetworkInstance;
import com.okanserdaroglu.shoppingapp.remote.NetworkService;

public class ShoppingApplication extends Application {

    private SharedPreferenceHelper sharedPreferenceHelper;
    private NetworkService networkService;
    private static ShoppingApplication shoppingApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        shoppingApplication = this;
        sharedPreferenceHelper = SharedPreferenceHelper.getInstance();
        networkService = NetworkInstance.getInstance().getNetworkService();
    }

    public static ShoppingApplication getShoppingApplication() {
        return shoppingApplication;
    }

}
