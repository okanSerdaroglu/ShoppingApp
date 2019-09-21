package com.okanserdaroglu.shoppingapp.helper;

import androidx.databinding.BindingAdapter;

import com.google.android.material.textfield.TextInputLayout;

public class TextBindingAdapter {

    @BindingAdapter(value = {"isErrorVisible", "errorMessage"}, requireAll = true)
    public static void setErrorTextInputLayout(TextInputLayout textInputLayout
            , boolean isErrorVisible, String errorMessage) {

        textInputLayout.setErrorEnabled(isErrorVisible);
        textInputLayout.setError(isErrorVisible ? errorMessage : null);
    }

}
