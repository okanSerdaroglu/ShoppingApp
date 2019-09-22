package com.okanserdaroglu.shoppingapp.ui.order;

import android.os.Bundle;

import com.okanserdaroglu.shoppingapp.R;
import com.okanserdaroglu.shoppingapp.databinding.FragmentProductListBinding;
import com.okanserdaroglu.shoppingapp.ui.Base.BaseFragment;
import com.okanserdaroglu.shoppingapp.viewmodel.ProductItemViewModel;
import com.okanserdaroglu.shoppingapp.viewmodel.ProductListViewModel;

import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import java.util.List;

public class ProductListFragment extends BaseFragment {

    private ProductListViewModel productListViewModel;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_product_list;
    }

    @Override
    protected void onBind(ViewDataBinding binding, Bundle bundle) {
        productListViewModel = ViewModelProviders.of(this).get(ProductListViewModel.class);
        FragmentProductListBinding fragmentProductListBinding =
                (FragmentProductListBinding) binding;
        fragmentProductListBinding.setLifecycleOwner(this);
        fragmentProductListBinding.setProductListViewModel(productListViewModel);
        productListViewModel.getOrderList();

        initProductListLiveData();
    }

    private void initProductListLiveData() {

        productListViewModel.getProductViewModels().observe(this, new Observer<List<ProductItemViewModel>>() {
            @Override
            public void onChanged(List<ProductItemViewModel> productItemViewModels) {
                productListViewModel.setAdapter();
            }
        });

    }
}
