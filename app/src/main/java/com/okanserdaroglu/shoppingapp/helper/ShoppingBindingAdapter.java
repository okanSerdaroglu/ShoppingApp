package com.okanserdaroglu.shoppingapp.helper;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textfield.TextInputLayout;
import com.okanserdaroglu.shoppingapp.ui.Base.BaseRecyclerViewAdapter;

import net.cachapa.expandablelayout.ExpandableLayout;

public class ShoppingBindingAdapter {

    @androidx.databinding.BindingAdapter(value = {"isErrorVisible", "errorMessage"}, requireAll = true)
    public static void setErrorTextInputLayout(TextInputLayout textInputLayout
            , boolean isErrorVisible, String errorMessage) {

        textInputLayout.setErrorEnabled(isErrorVisible);
        textInputLayout.setError(isErrorVisible ? errorMessage : null);
    }

    @BindingAdapter("setAdapter")
    public static void setAdapter(RecyclerView recyclerView,
                                  BaseRecyclerViewAdapter baseRecyclerViewAdapter) {

        recyclerView.setAdapter(baseRecyclerViewAdapter);
    }

    @androidx.databinding.BindingAdapter(value = {"isAnimate", "isExpand"}, requireAll = true)
    public static void setExpand(ExpandableLayout expandableLayout, boolean isAnimate, boolean isExpand) {
        if (isExpand) {
            expandableLayout.setExpanded(true, isAnimate);
        } else {
            expandableLayout.setExpanded(false, isAnimate);
        }
    }
}
