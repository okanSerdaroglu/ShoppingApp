package com.okanserdaroglu.shoppingapp.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.okanserdaroglu.shoppingapp.model.Order;

public class ProductItemViewModel extends ViewModel {

    private Order order;
    private MutableLiveData<Boolean>isExpanded;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public MutableLiveData<Boolean> getIsExpanded() {
        return isExpanded;
    }

    public void setIsExpanded(MutableLiveData<Boolean> isExpanded) {
        this.isExpanded = isExpanded;
    }


}
