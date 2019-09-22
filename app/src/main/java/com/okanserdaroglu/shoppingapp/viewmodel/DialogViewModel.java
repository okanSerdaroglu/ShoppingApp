package com.okanserdaroglu.shoppingapp.viewmodel;

import android.view.View;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DialogViewModel extends ViewModel {

    private MutableLiveData<Boolean> isConfirm = new MutableLiveData<>();
    private MutableLiveData<Boolean> isCancel = new MutableLiveData<>();
    private String contetMessage;

    public String getContetMessage() {
        return contetMessage;
    }

    public MutableLiveData<Boolean> getIsConfirm() {
        return isConfirm;
    }

    public MutableLiveData<Boolean> getIsCancel() {
        return isCancel;
    }

    public void onConfirmClick(View view) {
        isConfirm.setValue(true);
    }

    public void onCancelClick(View view) {
        isCancel.setValue(true);
    }
}
