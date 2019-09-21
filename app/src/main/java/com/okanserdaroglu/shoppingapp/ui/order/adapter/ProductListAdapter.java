package com.okanserdaroglu.shoppingapp.ui.order.adapter;

import androidx.databinding.ViewDataBinding;

import com.okanserdaroglu.shoppingapp.R;
import com.okanserdaroglu.shoppingapp.ui.Base.BaseRecyclerViewAdapter;
import com.okanserdaroglu.shoppingapp.viewmodel.ProductItemViewModel;

public class ProductListAdapter extends BaseRecyclerViewAdapter
        <ProductItemViewModel, ProductItemViewHolder> {

    public ProductListAdapter() {
    }

    @Override
    protected int getItemLayoutId(int viewType) {
        return R.layout.adapter_product_list;
    }

    @Override
    protected ProductItemViewHolder getViewHolder(ViewDataBinding binding, int viewType) {
        return new ProductItemViewHolder(binding);
    }
}
