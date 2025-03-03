package com.example.retrofittask.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.retrofittask.R;

public class MainActivity extends AppCompatActivity {
    Button btnAll , btnFav , btnExit;
    Intent outIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAll = findViewById(R.id.btn_allProduct);
        btnFav = findViewById(R.id.btn_favProduct);
        btnExit = findViewById(R.id.btn_exit);

        btnAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                outIntent = new Intent(MainActivity.this , AllProductActivity.class);
                startActivity(outIntent);
            }
        });

        btnFav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                outIntent = new Intent(MainActivity.this , FavActivity.class);
                startActivity(outIntent);
            }
        });

        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}