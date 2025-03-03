package com.example.retrofittask.model;

import androidx.lifecycle.LiveData;

import com.example.retrofittask.model.Network.NetworkCallBack;
import com.example.retrofittask.model.Network.ProductRemoteDataSourceInterface;
import com.example.retrofittask.model.db.ProductLocalDataSourceInterface;
import com.example.retrofittask.model.db.ProductPojo;

import java.util.List;

public class ProductRepository {
    private ProductLocalDataSourceInterface productLocalDataSourceInterface;
    private ProductRemoteDataSourceInterface productRemoteDataSourceInterface;
    private static ProductRepository instance = null;

    private ProductRepository(ProductLocalDataSourceInterface productLocalDataSourceInterface, ProductRemoteDataSourceInterface productRemoteDataSourceInterface) {
        this.productLocalDataSourceInterface = productLocalDataSourceInterface;
        this.productRemoteDataSourceInterface = productRemoteDataSourceInterface;
    }

    public static ProductRepository getInstance (ProductLocalDataSourceInterface productLocalDataSourceInterface, ProductRemoteDataSourceInterface productRemoteDataSourceInterface){
        if(instance == null){
            instance = new ProductRepository(productLocalDataSourceInterface , productRemoteDataSourceInterface);
        }
        return  instance;
    }

    public LiveData<List<ProductPojo>> getStoredProduct (){
        return productLocalDataSourceInterface.getProducts();
    }

    public void getAllProduct (NetworkCallBack networkCallBack){
        productRemoteDataSourceInterface.makeNetworkCallBack(networkCallBack);
    }

    public void insertProduct (ProductPojo productPojo){
        productLocalDataSourceInterface.addProduct(productPojo);
    }

    public void deleteProduct (ProductPojo productPojo){
        productLocalDataSourceInterface.deleteProduct(productPojo);
    }

}
