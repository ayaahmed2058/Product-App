package com.example.retrofittask.model.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ProductDAO {

    @Query("SELECT * from product_table")
    LiveData<List<ProductPojo>> getAllProduct();

    @Insert (onConflict = OnConflictStrategy.IGNORE)
    void insertProduct (ProductPojo productPojo);

    @Delete
    void deleteProduct (ProductPojo productPojo);


}
