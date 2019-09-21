package com.okanserdaroglu.shoppingapp.ui.login;

import android.os.Bundle;

import com.okanserdaroglu.shoppingapp.R;
import com.okanserdaroglu.shoppingapp.helper.SharedPreferenceHelper;
import com.okanserdaroglu.shoppingapp.ui.Base.BaseFragment;

import androidx.databinding.ViewDataBinding;
import androidx.navigation.fragment.NavHostFragment;

public class SplashFragment extends BaseFragment {

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_splash;
    }

    @Override
    protected void onBind(ViewDataBinding binding, Bundle bundle) {
        if (SharedPreferenceHelper.getInstance().getBoolean(SharedPreferenceHelper.IS_LOGIN)) {
            NavHostFragment.findNavController(this).navigate(R.id.action_splashFragment_to_productListFragment);
        } else {
            NavHostFragment.findNavController(this).navigate(R.id.action_splashFragment_to_loginFragment);
        }
    }
}
