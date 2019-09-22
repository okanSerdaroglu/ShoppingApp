package com.okanserdaroglu.shoppingapp.viewmodel;

import android.view.View;

import androidx.annotation.Nullable;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.okanserdaroglu.shoppingapp.helper.OnOrderClickListener;
import com.okanserdaroglu.shoppingapp.model.Order;
import com.okanserdaroglu.shoppingapp.remote.NetworkInstance;
import com.okanserdaroglu.shoppingapp.ui.order.adapter.ProductListAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductListViewModel extends ViewModel implements OnOrderClickListener {

    private MutableLiveData<List<ProductItemViewModel>> productViewModels = new MutableLiveData<>();
    private MutableLiveData<Integer> notifyItemPosition = new MutableLiveData<>();

    private MutableLiveData<Boolean> isLogOutButtonClicked = new MutableLiveData<>();

    private ProductListAdapter productListAdapter = new ProductListAdapter();

    /**
     * retrofit ile datayı çek. Sonra gelen orderList i productViewModel a dönüştür.
     */
    public void getOrderList() {

        Call<List<Order>> orderCall = NetworkInstance.getInstance().getNetworkService().getOrderList();
        orderCall.enqueue(new Callback<List<Order>>() {
            @Override
            public void onResponse(@Nullable Call<List<Order>> call, @Nullable Response<List<Order>> response) {
                if (response != null
                        && response.body() != null) {
                    getViewModel(response.body());
                }
            }

            @Override
            public void onFailure(@Nullable Call<List<Order>> call, @Nullable Throwable t) {

            }
        });
    }

    private void getViewModel(List<Order> orders) {
        List<ProductItemViewModel> productItemViewModels = new ArrayList<>();
        int position = 0;
        for (Order order : orders) {
            ProductItemViewModel productItemViewModel = new ProductItemViewModel();
            productItemViewModel.setOrder(order);
            productItemViewModel.setPosition(position);
            productItemViewModels.add(productItemViewModel);
            position++;
        }
        productViewModels.setValue(productItemViewModels);
    }

    public void setAdapter() {
        productListAdapter.setItems(productViewModels);
        productListAdapter.setOnOrderClickListener(this);
    }

    public MutableLiveData<List<ProductItemViewModel>> getProductViewModels() {
        return productViewModels;
    }

    public ProductListAdapter getProductListAdapter() {
        return productListAdapter;
    }

    public MutableLiveData<Boolean> getIsLogOutButtonClicked() {
        return isLogOutButtonClicked;
    }

    @Override
    public void onOrderClick(int position) {
        notifyItemPosition.setValue(position);
        productListAdapter.notifyItemChanged(position);
    }

    public void onOrdersButtonClick(View view) {
        getOrderList();
    }

    public void onExitButtonClick(View view) {
        isLogOutButtonClicked.setValue(true);
    }
}
