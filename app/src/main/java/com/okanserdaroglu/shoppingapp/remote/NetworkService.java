package com.okanserdaroglu.shoppingapp.remote;

import com.okanserdaroglu.shoppingapp.model.Order;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface NetworkService {

    @GET(".")
    Call<List<Order>> getOrderList();

}
