package com.okanserdaroglu.shoppingapp.ui.login;


import android.os.Bundle;

import com.okanserdaroglu.shoppingapp.R;
import com.okanserdaroglu.shoppingapp.databinding.FragmentLoginBinding;
import com.okanserdaroglu.shoppingapp.ui.Base.BaseFragment;

import androidx.databinding.ViewDataBinding;


public class LoginFragment extends BaseFragment {

    private FragmentLoginBinding fragmentLoginBinding;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_login;
    }

    @Override
    protected void onBind(ViewDataBinding binding, Bundle bundle) {
        fragmentLoginBinding = (FragmentLoginBinding) binding;
    }
}
