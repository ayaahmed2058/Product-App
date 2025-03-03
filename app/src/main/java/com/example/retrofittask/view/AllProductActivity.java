package com.example.retrofittask.view;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofittask.model.Network.ProductRemoteDataSourceImp;
import com.example.retrofittask.R;
import com.example.retrofittask.model.ProductRepository;
import com.example.retrofittask.model.db.ProductPojo;
import com.example.retrofittask.model.db.ProductLocalDataSourceImp;
import com.example.retrofittask.presenter.AllProductPresenter;

import java.util.ArrayList;
import java.util.List;

public class AllProductActivity extends AppCompatActivity implements OnFavClickListener, AllProductView {

    private ProductAdapter productAdapter;
    private static final String TAG = "AllProductActivity";
    AllProductPresenter allProductPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all);

        RecyclerView recyclerView = findViewById(R.id.recycler_product);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        productAdapter = new ProductAdapter(AllProductActivity.this, new ArrayList<>() , this);

        allProductPresenter  = new AllProductPresenter(this ,
                ProductRepository.getInstance(ProductLocalDataSourceImp.getInstance(AllProductActivity.this),
                        ProductRemoteDataSourceImp.getInstance()));

        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(productAdapter);

        allProductPresenter.getAllProduct();

    }


    @Override
    public void addToFav(ProductPojo productPojo) {
        allProductPresenter.addToFav(productPojo);
        productAdapter.notifyDataSetChanged();
        Toast.makeText(AllProductActivity.this , "Product is Added successfully" , Toast.LENGTH_LONG).show();
    }

    @Override
    public void setAllProduct(List<ProductPojo> productPojoList) {
        productAdapter.updateData(productPojoList);
        productAdapter.notifyDataSetChanged();

    }

    @Override
    public void setErrorMessage(String errorMessage) {
        Toast.makeText(AllProductActivity.this , errorMessage , Toast.LENGTH_LONG).show();

    }
}