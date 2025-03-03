package com.example.retrofittask.presenter;

import com.example.retrofittask.view.AllProductView;
import com.example.retrofittask.model.Network.NetworkCallBack;
import com.example.retrofittask.model.ProductRepository;
import com.example.retrofittask.model.db.ProductPojo;

import java.util.List;

public class AllProductPresenter implements NetworkCallBack {

    private AllProductView allProductView;
    private ProductRepository productRepository;

    public AllProductPresenter (AllProductView allProductView , ProductRepository productRepository){
        this.allProductView = allProductView;
        this.productRepository = productRepository;
    }

    public void getAllProduct (){
        productRepository.getAllProduct(this);
    }

    public void addToFav (ProductPojo productPojo){
        productRepository.insertProduct(productPojo);
    }

    @Override
    public void onSuccessResult(List<ProductPojo> productList) {
        allProductView.setAllProduct(productList);
    }

    @Override
    public void onFailureResult(String errorMessage) {
        allProductView.setErrorMessage(errorMessage);
    }
}
