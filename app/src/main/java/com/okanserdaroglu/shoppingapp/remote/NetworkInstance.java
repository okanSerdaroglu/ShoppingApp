package com.okanserdaroglu.shoppingapp.remote;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/** This class includes retrofit singleton.
 * When you need a network call only get instance of this class
 * */

public class NetworkInstance {

    private static NetworkInstance instance = null;
    private static final String BASE_URL = "http://kariyertechchallenge.mockable.io";

    private NetworkService networkService;

    public static NetworkInstance getInstance() {
        if (instance == null) {
            instance = new NetworkInstance();
        }

        return instance;
    }

    private NetworkInstance() {
        buildRetrofit();
    }

    private void buildRetrofit() {
         Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        this.networkService = retrofit.create(NetworkService.class);
    }

    public NetworkService getNetworkService() {
        return this.networkService;
    }

}
