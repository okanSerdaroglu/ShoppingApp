package com.okanserdaroglu.shoppingapp.ui.Base;

import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;


public class BaseViewHolder<T> extends RecyclerView.ViewHolder {

    protected T model;

    public BaseViewHolder(ViewDataBinding binding) {
        super(binding.getRoot());
    }

    protected void bind(T model) {
        this.model = model;
    }
}