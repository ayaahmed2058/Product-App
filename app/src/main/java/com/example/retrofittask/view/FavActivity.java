package com.example.retrofittask.view;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofittask.R;
import com.example.retrofittask.model.Network.ProductRemoteDataSourceImp;
import com.example.retrofittask.model.ProductRepository;
import com.example.retrofittask.model.db.ProductPojo;
import com.example.retrofittask.model.db.ProductLocalDataSourceImp;
import com.example.retrofittask.presenter.FavProductPresenter;

import java.util.ArrayList;
import java.util.List;

public class FavActivity extends AppCompatActivity implements OnDeleteClickListener, AllProductView {
    private FavAdapter favAdapter;
    private FavProductPresenter favProductPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fav);


        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        favAdapter = new FavAdapter(FavActivity.this, new ArrayList<>(),this);

        recyclerView.setLayoutManager(linearLayoutManager);

        favProductPresenter  = new FavProductPresenter(ProductRepository.getInstance(ProductLocalDataSourceImp.getInstance(FavActivity.this), ProductRemoteDataSourceImp.getInstance()));

        recyclerView.setAdapter(favAdapter);

         favProductPresenter.getStoredProduct().observe(this, new Observer<List<ProductPojo>>() {
             @Override
             public void onChanged(List<ProductPojo> productPojos) {
                 favAdapter.setList(productPojos);
                 favAdapter.notifyDataSetChanged();
             }
         });
    }


    @Override
    public void deleteFromFav(ProductPojo productPojo) {
        favProductPresenter.deleteFromFav(productPojo);
        favAdapter.notifyDataSetChanged();
        Toast.makeText(FavActivity.this , " Product Was deleted successfully" , Toast.LENGTH_LONG).show();
    }

    @Override
    public void setAllProduct(List<ProductPojo> productPojoList) {
        favAdapter.setList(productPojoList);
    }

    @Override
    public void setErrorMessage(String errorMessage) {
        Toast.makeText(FavActivity.this , errorMessage , Toast.LENGTH_LONG).show();

    }
}