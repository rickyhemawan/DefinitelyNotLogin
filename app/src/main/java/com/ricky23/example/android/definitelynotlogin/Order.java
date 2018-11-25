package com.ricky23.example.android.definitelynotlogin;


import java.util.ArrayList;

public class Order {
    private ArrayList<Product> orderProduct;
    private ArrayList<Integer> qty;

    public Order(ArrayList<Product> orderProduct, ArrayList<Integer> qty) {
        this.orderProduct = orderProduct;
        this.qty = qty;
    }

    public ArrayList<Product> getOrderProduct() {
        return orderProduct;
    }

    public void setOrderProduct(ArrayList<Product> orderProduct) {
        this.orderProduct = orderProduct;
    }

    public ArrayList<Integer> getQty() {
        return qty;
    }

    public void setQty(ArrayList<Integer> qty) {
        this.qty = qty;
    }
}
