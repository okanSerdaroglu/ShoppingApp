package com.okanserdaroglu.shoppingapp.helper;

import com.okanserdaroglu.shoppingapp.ui.Base.ShoppingApplication;

public class StringHelper {

    public static String getString(int id) {
        return ShoppingApplication.getShoppingApplication().getApplicationContext().getString(id);
    }

}
