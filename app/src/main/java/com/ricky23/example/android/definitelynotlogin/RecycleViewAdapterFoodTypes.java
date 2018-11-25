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

public class RecycleViewAdapterFoodTypes extends RecyclerView.Adapter<RecycleViewAdapterFoodTypes.ViewHolder> {

    private static final String TAG = "RecycleViewAdapterCatal";

    private Context mContext;
    private ArrayList<String> mImage = new ArrayList<>();
    private ArrayList<String> mTitle = new ArrayList<>();

    public RecycleViewAdapterFoodTypes(Context mContext, ArrayList<String> mImage, ArrayList<String> mTitle) {
        this.mContext = mContext;
        this.mImage = mImage;
        this.mTitle = mTitle;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.z_catalog_list,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
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

        /*

        LinearLayout linearItem;

        ArrayList<Makanan> idMakanan=new ArrayList<>();
        for(int i=0;i<idMakanan.size();i++)
        {
            LinearLayout linearLayout=new LinearLayout(mContext);
            linearLayout.setOrientation(LinearLayout.HORIZONTAL);

            //sudah di set valuenya
            TextView title=new TextView(mContext);
            title.setText(idMakanan.get(i).title());
            TextView jumlah=new TextView(mContext);
            //style param
            LinearLayout.LayoutParams par=new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT,1);
            jumlah.setLayoutParams(par);
            TextView harga=new TextView(mContext);

            //penambah wadah
            linearLayout.addView(title);
            linearLayout.addView(jumlah);
            linearLayout.addView(harga);

            linearItem.addView(linearLayout);
        }
        */
    }

    @Override
    public int getItemCount() {
        return mTitle.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView categoryImage;
        TextView categoryName;
        ConstraintLayout categoryCSL;


        public ViewHolder(View itemView) {
            super(itemView);
            categoryImage = itemView.findViewById(R.id.ivCategoryImage);
            categoryName = itemView.findViewById(R.id.tvCategoryName);
            categoryCSL = itemView.findViewById(R.id.cslCategory);
        }
    }
}
