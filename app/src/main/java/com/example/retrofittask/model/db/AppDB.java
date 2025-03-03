package com.example.retrofittask.model.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {ProductPojo.class}, version = 1)
public abstract class AppDB extends RoomDatabase {
    private static AppDB instance = null;
    public abstract ProductDAO getProductDAO();

    public static synchronized AppDB getInstance(Context context){
        if (instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(),AppDB.class, "product_db").build();
        }
        return instance;
    }

}
