package com.okanserdaroglu.shoppingapp.remote;

import com.okanserdaroglu.shoppingapp.model.Order;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface NetworkService {

    @GET(".")
    Observable<List<Order>> getOrderList();

}
