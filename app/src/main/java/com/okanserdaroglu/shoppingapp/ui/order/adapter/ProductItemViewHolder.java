package com.okanserdaroglu.shoppingapp.ui.order.adapter;

import androidx.databinding.ViewDataBinding;

import com.okanserdaroglu.shoppingapp.databinding.AdapterProductListBinding;
import com.okanserdaroglu.shoppingapp.helper.OnOrderClickListener;
import com.okanserdaroglu.shoppingapp.ui.Base.BaseViewHolder;
import com.okanserdaroglu.shoppingapp.viewmodel.ProductItemViewModel;

public class ProductItemViewHolder extends BaseViewHolder<ProductItemViewModel> implements OnOrderClickListener {

    private AdapterProductListBinding adapterProductListBinding;
    private OnOrderClickListener onOrderClickListener;

    ProductItemViewHolder(ViewDataBinding binding, OnOrderClickListener onOrderClickListener) {
        super(binding);
        adapterProductListBinding = (AdapterProductListBinding) binding;
        this.onOrderClickListener = onOrderClickListener;
    }

    @Override
    protected void bind(ProductItemViewModel model) {
        super.bind(model);
        model.setOnOrderClickListener(this);
        adapterProductListBinding.setProductItemViewModel(model);
    }

    @Override
    public void onOrderClick(int position) {
        if (onOrderClickListener != null) {
            onOrderClickListener.onOrderClick(position);
        }
    }
}
