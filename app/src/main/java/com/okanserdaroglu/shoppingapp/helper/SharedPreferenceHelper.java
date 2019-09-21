package com.okanserdaroglu.shoppingapp.helper;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import com.okanserdaroglu.shoppingapp.ui.Base.ShoppingApplication;

/** Shared preferences singleton */

public class SharedPreferenceHelper {
    private static SharedPreferenceHelper sharedPreferenceHelper;
    private static SharedPreferences sharedPreferences;
    private static SharedPreferences.Editor editor;

    private static final String IS_LOGIN = "is_login";
    private static final String IS_REMEMBER = "is_remember";
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";

    private SharedPreferenceHelper() {}

    public static SharedPreferenceHelper getInstance() {
        if (sharedPreferenceHelper == null) {
            sharedPreferenceHelper = new SharedPreferenceHelper();
            if (sharedPreferences == null) {
                Context context = ShoppingApplication.getShoppingApplication().getApplicationContext();
                sharedPreferences = context.getSharedPreferences(context.getPackageName(), Activity.MODE_PRIVATE);
            }
        }
        return sharedPreferenceHelper;
    }

    public void saveBoolean(String key, boolean value) {
        editor = sharedPreferences.edit();
        editor.putBoolean(key, value);
        editor.apply();
    }

    public boolean getBoolean(String key) {
        return sharedPreferences.getBoolean(key, false);
    }


    public void saveString(String key, String value) {
        editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.apply();
    }

    public String getString(String key) {
        return sharedPreferences.getString(key, "");
    }

    public void removePlaceObj(String key) {
        editor.remove(key);
        editor.commit();
    }

    public void clearAll() {
        editor.clear();
        editor.commit();
    }

}
