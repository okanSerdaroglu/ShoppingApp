package com.okanserdaroglu.shoppingapp.ui.Base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;

public abstract class BaseFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(getLayoutId(),container,false);

        ViewDataBinding binding = DataBindingUtil.bind(view);
        onBind(binding,getArguments());

        return view;
    }

    protected abstract int getLayoutId();

    protected abstract void onBind(ViewDataBinding binding,Bundle bundle);

}
