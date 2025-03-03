package com.example.retrofittask.view;

import com.example.retrofittask.model.db.ProductPojo;

import java.util.List;

public interface AllProductView {
    void setAllProduct(List<ProductPojo> productPojoList);
    void setErrorMessage (String errorMessage);
}
