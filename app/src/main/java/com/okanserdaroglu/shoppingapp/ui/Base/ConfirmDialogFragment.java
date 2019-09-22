package com.okanserdaroglu.shoppingapp.ui.Base;

import android.os.Bundle;

import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.Observer;
import androidx.navigation.fragment.NavHostFragment;

import com.okanserdaroglu.shoppingapp.R;
import com.okanserdaroglu.shoppingapp.databinding.FragmentDialogConfirmBinding;
import com.okanserdaroglu.shoppingapp.helper.SharedPreferenceHelper;
import com.okanserdaroglu.shoppingapp.viewmodel.DialogViewModel;

public class ConfirmDialogFragment extends BaseDialogFragment {

    private FragmentDialogConfirmBinding fragmentDialogConfirmBinding;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_dialog_confirm;
    }

    @Override
    protected void onBind(ViewDataBinding binding, Bundle bundle) {
        fragmentDialogConfirmBinding = (FragmentDialogConfirmBinding) binding;

        DialogViewModel dialogViewModel = new DialogViewModel();

        fragmentDialogConfirmBinding.setLifecycleOwner(this);
        fragmentDialogConfirmBinding.setDialogViewModel(dialogViewModel);

        // This close dialog
        dialogViewModel.getIsCancel().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                NavHostFragment.findNavController(ConfirmDialogFragment.this)
                        .navigate(R.id.action_confirmDialogFragment_to_productListFragment);
            }
        });

        // This logout user and close dialog
        dialogViewModel.getIsConfirm().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                SharedPreferenceHelper.getInstance().saveBoolean(SharedPreferenceHelper.IS_LOGIN, false);
                NavHostFragment.findNavController(ConfirmDialogFragment.this)
                        .navigate(R.id.action_confirmDialogFragment_to_loginFragment);
            }
        });
    }
}
