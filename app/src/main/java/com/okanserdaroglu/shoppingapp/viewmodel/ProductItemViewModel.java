package com.okanserdaroglu.shoppingapp.viewmodel;

import android.graphics.Color;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.okanserdaroglu.shoppingapp.R;
import com.okanserdaroglu.shoppingapp.helper.StringHelper;
import com.okanserdaroglu.shoppingapp.model.Order;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class ProductItemViewModel extends ViewModel {

    private Order order;
    private MutableLiveData<Boolean> isExpanded;
    private final String STATE_ON_WAY = "Yolda";
    private final String STATE_PREPARE = "Hazırlanıyor";
    private final String STATE_WAIT = "Onay Bekliyor";

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

    public String getMonthName() {

        if (order != null) {
            try {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM", Locale.getDefault());
                Date date = simpleDateFormat.parse(order.getMonth());
                return new SimpleDateFormat("MMMM", Locale.getDefault()).format(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return "";
    }

    public int getOrderStateColor() {

        switch (order.getProductState()) {

            case STATE_ON_WAY:
                return R.color.colorGreenOnWay;
            case STATE_WAIT:
                return R.color.colorRedWait;
            case STATE_PREPARE:
                return R.color.colorOrangePrepare;
            default:
                return Color.BLACK;

        }
    }

    private String getPrice (double price){
        return "" + price + StringHelper.getString(R.string.currency);

    }

    public String getProductPrice (){
        return (order != null) ? getPrice(order.getProductPrice()) : "";
    }

    public String getProductDetailPrice (){
        return (order != null && order.getProductDetail() != null) ? getPrice(order.getProductDetail().getSummaryPrice()) : "";
    }


}
