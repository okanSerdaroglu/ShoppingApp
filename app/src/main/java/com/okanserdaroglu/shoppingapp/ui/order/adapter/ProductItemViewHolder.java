package com.okanserdaroglu.shoppingapp.ui.order.adapter;

import androidx.databinding.ViewDataBinding;

import com.okanserdaroglu.shoppingapp.databinding.AdapterProductListBinding;
import com.okanserdaroglu.shoppingapp.ui.Base.BaseViewHolder;
import com.okanserdaroglu.shoppingapp.viewmodel.ProductItemViewModel;

public class ProductItemViewHolder extends BaseViewHolder<ProductItemViewModel> {

    private AdapterProductListBinding adapterProductListBinding;

    ProductItemViewHolder(ViewDataBinding binding) {
        super(binding);
        adapterProductListBinding = (AdapterProductListBinding) binding;
    }

    @Override
    protected void bind(ProductItemViewModel model) {
        super.bind(model);
        adapterProductListBinding.setProductItemViewModel(model);
    }
}
