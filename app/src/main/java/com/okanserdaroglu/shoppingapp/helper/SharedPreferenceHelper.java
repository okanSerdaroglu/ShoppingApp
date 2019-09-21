package com.okanserdaroglu.shoppingapp.helper;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferenceHelper {
    private static SharedPreferenceHelper sharedPreferenceHelper;
    private static SharedPreferences sharedPreferences;
    private static SharedPreferences.Editor editor;

    private static final String IS_LOGIN = "is_login";
    private static final String IS_REMEMBER = "is_remember";
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";



    private SharedPreferenceHelper() {
    } //prevent creating multiple instances by making the constructor private

    //The context passed into the getInstance should be application level context.
    public static SharedPreferenceHelper getInstance(Context context) {
        if (sharedPreferenceHelper == null) {
            sharedPreferenceHelper = new SharedPreferenceHelper();
            if (sharedPreferences == null) {
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
