package com.example.retrofittask.model.db;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity (tableName = "product_table")
public class ProductPojo {

    @PrimaryKey
    @NonNull
    private final String title;

    private String price;
    private String brand;
    private String description;
    private float rating;
    private String thumbnail;

    public ProductPojo(@NonNull String title, String price, String brand, String description, float rating, String thumbnail) {
        this.title = title;
        this.price = price;
        this.brand = brand;
        this.description = description;
        this.rating = rating;
        this.thumbnail = thumbnail;
    }

    @NonNull
    public String getTitle() {
        return title;
    }


    public String getPrice() {
        return price;
    }


    public String getBrand() {
        return brand;
    }


    public String getDescription() {
        return description;
    }


    public float getRating() {
        return rating;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    @NonNull
    @Override
    public String toString() {
        return "{ title: " + title + ", price: " + price + ", brand: " + brand + ", description: " + description + ", thumbnail: " + thumbnail +" }";
    }
}

