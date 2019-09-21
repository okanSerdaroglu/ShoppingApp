package com.okanserdaroglu.shoppingapp.model;


public class Order {

    private String date;
    private String month;
    private String marketName;
    private String orderName;
    private double productPrice;
    private String productState;
    private ProductDetail productDetail;

    public String getDate() {
        return date;
    }

    public String getMonth() {
        return month;
    }

    public String getMarketName() {
        return marketName;
    }

    public String getOrderName() {
        return orderName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public String getProductState() {
        return productState;
    }

    public ProductDetail getProductDetail() {
        return productDetail;
    }

}
