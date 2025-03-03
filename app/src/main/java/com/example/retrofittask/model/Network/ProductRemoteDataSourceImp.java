package com.example.retrofittask.model.Network;

import android.util.Log;

import com.example.retrofittask.model.ProductResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProductRemoteDataSourceImp implements ProductRemoteDataSourceInterface{
    private static final String TAG = "AllProductClient";
    public static final String URL = "https://dummyjson.com/";
    ProductService productService;
    private static ProductRemoteDataSourceImp productRemoteDataSourceImp = null;

    public static ProductRemoteDataSourceImp getInstance(){
        if(productRemoteDataSourceImp == null){
            productRemoteDataSourceImp = new ProductRemoteDataSourceImp();
        }
        return productRemoteDataSourceImp;
    }

    private ProductRemoteDataSourceImp(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        productService = retrofit.create(ProductService.class);
    }


    @Override
    public void makeNetworkCallBack (NetworkCallBack networkCallBack){

        Call<ProductResponse> call = productService.getProducts();
        call.enqueue(new Callback<ProductResponse>() {
            @Override
            public void onResponse(Call<ProductResponse> call, Response<ProductResponse> response) {
                if (response.isSuccessful()) {
                    Log.i(TAG, "onResponse:CallBack" + response.raw() + response.body());
                    networkCallBack.onSuccessResult(response.body().getProducts());
                }
            }

            @Override
            public void onFailure(Call<ProductResponse> call, Throwable t) {
                Log.i(TAG, "onFailure:CallBack");
                networkCallBack.onFailureResult(t.getMessage());
                t.printStackTrace();

            }
        });

    }
}
