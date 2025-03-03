package com.example.retrofittask.presenter;

import androidx.lifecycle.LiveData;

import com.example.retrofittask.model.ProductRepository;
import com.example.retrofittask.model.db.ProductPojo;

import java.util.List;

public class FavProductPresenter   {
    private ProductRepository productRepository;

    public FavProductPresenter (ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public LiveData<List<ProductPojo>> getStoredProduct(){
       return productRepository.getStoredProduct();
    }

    public void deleteFromFav (ProductPojo productPojo){
        productRepository.deleteProduct(productPojo);
    }

}
