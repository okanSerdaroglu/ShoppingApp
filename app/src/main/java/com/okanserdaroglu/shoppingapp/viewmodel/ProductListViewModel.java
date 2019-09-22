package com.okanserdaroglu.shoppingapp.viewmodel;

import androidx.annotation.Nullable;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.okanserdaroglu.shoppingapp.model.Order;
import com.okanserdaroglu.shoppingapp.remote.NetworkInstance;
import com.okanserdaroglu.shoppingapp.ui.order.adapter.ProductListAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductListViewModel extends ViewModel {

    private MutableLiveData<List<ProductItemViewModel>> productViewModels = new MutableLiveData<>();
    private MutableLiveData<Boolean>isOrderButtonClicked = new MutableLiveData<>();
    private MutableLiveData<Boolean>isLogOutButtonClicked = new MutableLiveData<>();

    private ProductListAdapter productListAdapter = new ProductListAdapter();

    /** retrofit ile datayı çek. Sonra gelen orderList i productViewModel a dönüştür.
     *  */
    public void getOrderList() {

        Call<List<Order>> orderCall = NetworkInstance.getInstance().getNetworkService().getOrderList();
        orderCall.enqueue(new Callback<List<Order>>() {
            @Override
            public void onResponse(@Nullable Call<List<Order>> call, @Nullable  Response<List<Order>> response) {
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

    private void getViewModel(List<Order> orders){
        List<ProductItemViewModel> productItemViewModels = new ArrayList<>();
        for (Order order : orders) {
            ProductItemViewModel productItemViewModel = new ProductItemViewModel();
            productItemViewModel.setOrder(order);
            productItemViewModels.add(productItemViewModel);
        }
        productViewModels.setValue(productItemViewModels);
        // TODO: 2019-09-21 fragment buna observe olup set adapter metodunu çağıracak
    }

    public void setAdapter() {
        productListAdapter.setItems(productViewModels);
    }

    public MutableLiveData<List<ProductItemViewModel>> getProductViewModels() {
        return productViewModels;
    }

    public ProductListAdapter getProductListAdapter() {
        return productListAdapter;
    }



}
