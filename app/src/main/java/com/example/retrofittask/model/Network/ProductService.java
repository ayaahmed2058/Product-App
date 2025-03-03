package com.example.retrofittask.model.Network;

import com.example.retrofittask.model.ProductResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ProductService {
    @GET("products")
    Call<ProductResponse> getProducts();
}
