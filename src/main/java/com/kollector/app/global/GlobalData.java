package com.kollector.app.global;

import com.kollector.app.model.ProductSell;

import java.util.ArrayList;
import java.util.List;

public class GlobalData {
    public static List<ProductSell> cart;
    static {
        cart = new ArrayList<ProductSell>();
    }
}
