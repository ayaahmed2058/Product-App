package com.example.retrofittask.model;

import com.example.retrofittask.model.db.ProductPojo;

import java.util.List;

public class ProductResponse {

    private List<ProductPojo> products;

    public List<ProductPojo> getProducts() {
        return products;
    }

}

