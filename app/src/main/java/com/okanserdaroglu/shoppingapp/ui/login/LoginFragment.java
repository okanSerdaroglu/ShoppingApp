package com.okanserdaroglu.shoppingapp.ui.login;


import android.os.Bundle;

import com.okanserdaroglu.shoppingapp.R;
import com.okanserdaroglu.shoppingapp.databinding.FragmentLoginBinding;
import com.okanserdaroglu.shoppingapp.model.User;
import com.okanserdaroglu.shoppingapp.ui.Base.BaseFragment;
import com.okanserdaroglu.shoppingapp.viewmodel.LoginViewModel;

import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.fragment.NavHostFragment;


public class LoginFragment extends BaseFragment {

    private LoginViewModel loginViewModel;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_login;
    }

    /**
     * create viewModel instance and set binding
     */
    @Override
    protected void onBind(ViewDataBinding binding, Bundle bundle) {
        loginViewModel = ViewModelProviders.of(this).get(LoginViewModel.class);
        FragmentLoginBinding fragmentLoginBinding = (FragmentLoginBinding) binding;
        fragmentLoginBinding.setLifecycleOwner(this);
        loginViewModel.getUserInSharedPreference();
        fragmentLoginBinding.setLoginViewModel(loginViewModel);
        initLoginLiveData();
    }

    /**
     * subscribe to viewModel.
     * Login is successful when user received
     */
    private void initLoginLiveData() {
        loginViewModel.getMutableUser().observe(this, new Observer<User>() {
            @Override
            public void onChanged(User user) {
                loginViewModel.saveUserInSharedPreferences();
                NavHostFragment.findNavController(LoginFragment.this)
                        .navigate(R.id.action_loginFragment_to_productListFragment);
            }
        });

    }

}
