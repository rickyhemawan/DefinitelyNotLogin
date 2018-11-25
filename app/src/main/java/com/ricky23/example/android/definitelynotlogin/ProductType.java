package com.ricky23.example.android.definitelynotlogin;

import java.io.Serializable;
import java.util.ArrayList;

public class ProductType implements Serializable {
    private String typeName;
    private ArrayList<Product> products;

    public ProductType(String typeName, ArrayList<Product> products) {
        this.typeName = typeName;
        this.products = products;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }
}
