package com.ricky23.example.android.definitelynotlogin;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class RecycleViewAdapterCategory extends RecyclerView.Adapter<RecycleViewAdapterCategory.ViewHolder> {

    private static final String TAG = "RecycleViewAdapterCatal";

    private Context mContext;
    private ArrayList<String> mImage = new ArrayList<>();
    private ArrayList<String> mTitle = new ArrayList<>();

    public RecycleViewAdapterCategory(Context mContext, ArrayList<String> mImage, ArrayList<String> mTitle) {
        this.mContext = mContext;
        this.mImage = mImage;
        this.mTitle = mTitle;
    }

    @NonNull
    @Override
    public RecycleViewAdapterCategory.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.z_category_box,parent,false);
        RecycleViewAdapterCategory.ViewHolder holder = new RecycleViewAdapterCategory.ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecycleViewAdapterCategory.ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called.");

        Glide.with(mContext)
                .load(mImage.get(position))
                .into(holder.categoryImage);
        holder.categoryName.setText(mTitle.get(position));
        holder.categoryCSL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: clicked");
                Toast.makeText(mContext, mTitle.get(position) + position, Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    public int getItemCount() {
        return mTitle.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView categoryImage;
        TextView categoryName;
        LinearLayout categoryCSL;


        public ViewHolder(View itemView) {
            super(itemView);
            categoryImage = itemView.findViewById(R.id.round_image);
            categoryName = itemView.findViewById(R.id.tvBoxTitle);
            categoryCSL = itemView.findViewById(R.id.linearItem);
        }
    }
}
