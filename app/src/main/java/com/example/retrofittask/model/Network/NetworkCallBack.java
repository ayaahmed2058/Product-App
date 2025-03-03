package com.example.retrofittask.model.Network;


import com.example.retrofittask.model.db.ProductPojo;

import java.util.List;

public interface NetworkCallBack {

    void onSuccessResult (List<ProductPojo> productList);
    void onFailureResult (String errorMessage);
}
