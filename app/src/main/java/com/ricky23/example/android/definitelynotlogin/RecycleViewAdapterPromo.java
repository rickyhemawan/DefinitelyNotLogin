package com.ricky23.example.android.definitelynotlogin;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class    RecycleViewAdapterPromo extends RecyclerView.Adapter<RecycleViewAdapterPromo.ViewHolder> {
    private static final String TAG = "RecycleViewAdapter";

    /*private ArrayList<String> mPromoTitle = new ArrayList<>();
    private ArrayList<String> mPromoDesc = new ArrayList<>();
    private ArrayList<String> mPromoPrice = new ArrayList<>();
    private ArrayList<String> mImages = new ArrayList<>();*/
    private ArrayList<Promo> mPromo;
    private Context mContext;

    public RecycleViewAdapterPromo(ArrayList<Promo> mPromo, Context mContext) {
        this.mPromo = mPromo;
        this.mContext = mContext;
    }

    /*public RecycleViewAdapter(ArrayList<String> mPromoTitle, ArrayList<String> mPromoDesc, ArrayList<String> mPromoPrice, ArrayList<String> mImages, Context mContext) {
        this.mPromoTitle = mPromoTitle;
        this.mPromoDesc = mPromoDesc;
        this.mPromoPrice = mPromoPrice;
        this.mImages = mImages;
        this.mContext = mContext;
    }*/

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.z_promo_card_view, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called.");


        Glide.with(mContext)
                .load(mPromo.get(position).getPromoImg())
                .into(holder.img);
        holder.titlePromo.setText(mPromo.get(position).getPromoTitle());
        holder.descPromo.setText(mPromo.get(position).getPromoDesc());
        holder.descPrice.setText(mPromo.get(position).getPrice());
        holder.cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: clicked on: " + mPromo.get(position).getPromoTitle() );
                Toast.makeText(mContext, mPromo.get(position).getPromoTitle() + position, Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return mPromo.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView img;
        TextView titlePromo;
        TextView descPromo;
        TextView descPrice;
        CardView cv;


        public ViewHolder(View itemView) {
            super(itemView);
            img = (ImageView) itemView.findViewById(R.id.ivPromoImage);
            titlePromo = (TextView) itemView.findViewById(R.id.tvFoodTitlePromo);
            descPromo = (TextView)itemView.findViewById(R.id.tvPromoDesc);
            descPrice = (TextView)itemView.findViewById(R.id.tvPromoPrice);
            cv = (CardView) itemView.findViewById(R.id.promoLayout);

        }
    }
}
