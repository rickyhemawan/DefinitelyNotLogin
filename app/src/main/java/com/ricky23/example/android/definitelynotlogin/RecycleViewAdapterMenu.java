package com.ricky23.example.android.definitelynotlogin;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class RecycleViewAdapterMenu extends RecyclerView.Adapter<RecycleViewAdapterMenu.ViewHolder>{

    private Context mContext;
    private ArrayList<Product> products;

    public RecycleViewAdapterMenu(Context mContext, ArrayList<Product> products) {
        this.mContext = mContext;
        this.products = products;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.z_product_simple,parent,false);
        ViewHolder holder = new  ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        Glide.with(mContext)
                .load(products.get(position).getProductImage())
                .into(holder.img);
        holder.title.setText(products.get(position).getProductName());
        String price = Double.toString(products.get(position).getProductPrice());
        holder.descPrice.setText(price);
        holder.item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, products.get(position).getProductName(), Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    public int getItemCount() {
        return products.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView title;
        TextView descPrice;
        LinearLayout item;

        public ViewHolder(View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.round_food);
            title = itemView.findViewById(R.id.tv_productName);
            descPrice = itemView.findViewById(R.id.tv_productPrice);
            item = itemView.findViewById(R.id.ll_simpleProduct);
        }
    }
}
