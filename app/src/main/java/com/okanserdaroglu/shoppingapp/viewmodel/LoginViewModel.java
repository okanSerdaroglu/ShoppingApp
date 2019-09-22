package com.okanserdaroglu.shoppingapp.viewmodel;

import android.text.TextUtils;
import android.view.View;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.okanserdaroglu.shoppingapp.R;
import com.okanserdaroglu.shoppingapp.helper.SharedPreferenceHelper;
import com.okanserdaroglu.shoppingapp.helper.StringHelper;
import com.okanserdaroglu.shoppingapp.model.User;


public class LoginViewModel extends ViewModel {

    private MutableLiveData<String> username = new MutableLiveData<>();
    private MutableLiveData<String> password = new MutableLiveData<>();

    private MutableLiveData<Boolean> isUsernameError = new MutableLiveData<>();
    private MutableLiveData<Boolean> isPasswordError = new MutableLiveData<>();
    private MutableLiveData<String> errorMessage = new MutableLiveData<>();

    /**
     * fragment observes this variable
     */
    private MutableLiveData<User> mutableUser = new MutableLiveData<>();

    private boolean isRemember;

    public void setUsername(MutableLiveData<String> username) {
        this.username = username;
    }

    public void setPassword(MutableLiveData<String> password) {
        this.password = password;
    }

    public void setRemember(boolean remember) {
        isRemember = remember;
    }

    public MutableLiveData<String> getUsername() {
        return username;
    }

    public MutableLiveData<String> getPassword() {
        return password;
    }

    public MutableLiveData<String> getErrorMessage() {
        return errorMessage;
    }

    public MutableLiveData<Boolean> getIsUsernameError() {
        return isUsernameError;
    }

    public MutableLiveData<Boolean> getIsPasswordError() {
        return isPasswordError;
    }

    /**
     * checks this variable and save user info if it is true
     */
    public boolean isRemember() {
        return isRemember;
    }

    public MutableLiveData<User> getMutableUser() {
        return mutableUser;
    }

    /**
     * button login Click. Check username and password
     */
    public void onLoginButtonClick(View view) {
        isUsernameError.setValue(false);
        isPasswordError.setValue(false);

        if (TextUtils.isEmpty(username.getValue())
                || !username.getValue().equals(StringHelper.getString(R.string.username_value))) {
            isUsernameError.setValue(true);
            errorMessage.setValue(StringHelper.getString(R.string.username_error));
            return;
        } else {
            isUsernameError.setValue(false);
        }

        if (TextUtils.isEmpty(password.getValue())
                || !password.getValue().equals(StringHelper.getString(R.string.password_value))) {
            isPasswordError.setValue(true);
            errorMessage.setValue(StringHelper.getString(R.string.password_error));
            return;
        } else {
            isPasswordError.setValue(false);
        }

        User user = new User();
        user.setUsername(username.getValue());
        user.setPassword(password.getValue());
        mutableUser.setValue(user);
    }

    /**
     * save user info shared preferences if isRemember is true
     */
    public void saveUserInSharedPreferences() {
        SharedPreferenceHelper.getInstance().saveBoolean(SharedPreferenceHelper.IS_LOGIN, true);
        SharedPreferenceHelper.getInstance().saveBoolean(SharedPreferenceHelper.IS_REMEMBER, isRemember);
        if (isRemember) {
            SharedPreferenceHelper.getInstance().saveString(SharedPreferenceHelper.USERNAME, username.getValue());
            SharedPreferenceHelper.getInstance().saveString(SharedPreferenceHelper.PASSWORD, password.getValue());
        }
    }

    public void getUserInSharedPreference() {
        isRemember = SharedPreferenceHelper.getInstance().getBoolean(SharedPreferenceHelper.IS_REMEMBER);
        if (SharedPreferenceHelper.getInstance().getBoolean(SharedPreferenceHelper.IS_REMEMBER)) {
            username.setValue(SharedPreferenceHelper.getInstance().getString(SharedPreferenceHelper.USERNAME));
            password.setValue(SharedPreferenceHelper.getInstance().getString(SharedPreferenceHelper.PASSWORD));
        }
    }
}
