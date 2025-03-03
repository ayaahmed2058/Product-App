package com.example.retrofittask.model.db;

import android.content.Context;

import androidx.lifecycle.LiveData;

import java.util.List;

public class ProductLocalDataSourceImp implements  ProductLocalDataSourceInterface{
    private final ProductDAO productDAO;
    private static ProductLocalDataSourceImp instance = null;


    private ProductLocalDataSourceImp(Context context){
        AppDB appDB = AppDB.getInstance(context);
        productDAO = appDB.getProductDAO();

    }

    public static ProductLocalDataSourceImp getInstance(Context context){
        if(instance == null){
            instance = new ProductLocalDataSourceImp(context);
        }
        return instance;
    }

    @Override
    public void addProduct (ProductPojo productPojo){
        new Thread(){
            @Override
            public void run() {
                productDAO.insertProduct(productPojo);
            }
        }.start();
    }

    @Override
    public LiveData<List<ProductPojo>> getProducts (){
        return productDAO.getAllProduct();
    }

    @Override
    public  void  deleteProduct (ProductPojo productPojo){
        new Thread(){
            @Override
            public void run() {
                productDAO.deleteProduct(productPojo);
            }
        }.start();
    }
}
