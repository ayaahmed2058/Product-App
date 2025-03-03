package com.example.retrofittask.view;

import com.example.retrofittask.model.db.ProductPojo;

public interface OnDeleteClickListener {
    void deleteFromFav(ProductPojo productPojo);
}
