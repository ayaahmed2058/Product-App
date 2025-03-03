package com.example.retrofittask.model.db;

import androidx.lifecycle.LiveData;

import java.util.List;

public interface ProductLocalDataSourceInterface {
    void addProduct(ProductPojo productPojo);

    LiveData<List<ProductPojo>> getProducts();

    void deleteProduct(ProductPojo productPojo);
}
