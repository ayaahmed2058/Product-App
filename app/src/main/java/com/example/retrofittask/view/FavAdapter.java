package com.example.retrofittask.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.retrofittask.R;
import com.example.retrofittask.model.db.ProductPojo;

import java.util.List;


public class FavAdapter extends RecyclerView.Adapter<FavAdapter.FavViewHolder> {
    private Context context;
    private List<ProductPojo> productList;
    private OnDeleteClickListener onDeleteClickListener;

    public FavAdapter(Context context, List<ProductPojo> productList, OnDeleteClickListener onDeleteClickListener) {
        this.context = context;
        this.productList = productList;
        this.onDeleteClickListener = onDeleteClickListener;
    }

    @NonNull
    @Override
    public FavViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.fav_product_item, parent, false);
        return new FavViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FavViewHolder holder, int position) {
        ProductPojo product = productList.get(position);
        holder.title.setText(product.getTitle());
        holder.price.setText(product.getPrice());
        holder.brand.setText(product.getBrand());
        holder.description.setText(product.getDescription());
        holder.rating.setRating(product.getRating());

        Glide.with(context)
                .load(product.getThumbnail()).apply(new RequestOptions().override(200,200))
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_foreground)
                .into(holder.image);

        holder.deleteFromFav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onDeleteClickListener.deleteFromFav(product);
            }
        });
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public void setList(List<ProductPojo> productPojoList){
        this.productList = productPojoList;
        notifyDataSetChanged();
    }

    public static class FavViewHolder extends RecyclerView.ViewHolder {
        TextView title, price, brand, description;
        RatingBar rating;
        ImageView image;
        Button deleteFromFav;

        public FavViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.tv_title);
            price = itemView.findViewById(R.id.tv_price);
            brand = itemView.findViewById(R.id.tv_brand);
            description = itemView.findViewById(R.id.tv_description);
            rating = itemView.findViewById(R.id.tv_rating);
            image = itemView.findViewById(R.id.JSON_img);
            deleteFromFav = itemView.findViewById(R.id.button);
        }
    }
}
