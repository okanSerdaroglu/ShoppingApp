package com.okanserdaroglu.shoppingapp.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.okanserdaroglu.shoppingapp.model.Order;
import com.okanserdaroglu.shoppingapp.remote.NetworkInstance;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ProductListViewModel extends ViewModel {

    private MutableLiveData<List<ProductItemViewModel>> productViewModels = new MutableLiveData<>();
    private MutableLiveData<Boolean>isOrderButtonClicked = new MutableLiveData<>();
    private MutableLiveData<Boolean>isLogOutButtonClicked = new MutableLiveData<>();


    public void getOrderList() {
        Observable<List<Order>> orderList = NetworkInstance.getInstance().getNetworkService().getOrderList();
       /* Observable.fromArray(orderList)
                .concatMap((Func1<List<Order>, Observable<List<ProductItemViewModel>>>) orderInfo -> Observable.just(getViewModel(orderList)))
                .subscribe(this::setAdapter);*/
    }

    private List<ProductItemViewModel> getViewModel(List<Order> orders){
        List<ProductItemViewModel> productItemViewModels = new ArrayList<>();
        for (Order order : orders) {
            ProductItemViewModel productItemViewModel = new ProductItemViewModel();
            productItemViewModel.setOrder(order);
            productItemViewModels.add(productItemViewModel);
        }
        return productItemViewModels;
    }

    private void setAdapter(List<ProductListViewModel> productListViewModels) {

    }
}
