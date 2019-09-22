package com.okanserdaroglu.shoppingapp.viewmodel;

import android.graphics.Color;
import android.view.View;

import androidx.lifecycle.ViewModel;

import com.okanserdaroglu.shoppingapp.R;
import com.okanserdaroglu.shoppingapp.helper.OnOrderClickListener;
import com.okanserdaroglu.shoppingapp.helper.StringHelper;
import com.okanserdaroglu.shoppingapp.model.Order;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class ProductItemViewModel extends ViewModel {

    private int position;
    private Order order;
    private boolean isExpanded;
    private boolean isExpandedAnimate;
    private OnOrderClickListener onOrderClickListener;

    private final String STATE_ON_WAY = "Yolda";
    private final String STATE_PREPARE = "Hazırlanıyor";
    private final String STATE_WAIT = "Onay Bekliyor";


    public int getPosition() {
        return position;
    }

    void setPosition(int position) {
        this.position = position;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
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

    private String getPrice(double price) {
        return "" + price + StringHelper.getString(R.string.currency);

    }

    public String getProductPrice() {
        return (order != null) ? getPrice(order.getProductPrice()) : "";
    }

    public String getProductDetailPrice() {
        return (order != null && order.getProductDetail() != null) ? getPrice(order.getProductDetail().getSummaryPrice()) : "";
    }

    public void setOnOrderClickListener(OnOrderClickListener onOrderClickListener) {
        this.onOrderClickListener = onOrderClickListener;
    }

    public boolean isExpanded() {
        return isExpanded;
    }

    public boolean isExpandedAnimate() {
        return isExpandedAnimate;
    }

    public void onClickOrder(View view) {
        if (onOrderClickListener != null) {
            isExpanded = !isExpanded;
            isExpandedAnimate = true;
            onOrderClickListener.onOrderClick((Integer) view.getTag());
        }
    }
}
