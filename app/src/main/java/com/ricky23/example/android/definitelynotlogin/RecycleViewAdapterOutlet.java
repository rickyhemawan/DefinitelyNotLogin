package com.ricky23.example.android.definitelynotlogin;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import static android.content.Intent.FLAG_ACTIVITY_CLEAR_TOP;

public class RecycleViewAdapterOutlet extends RecyclerView.Adapter<RecycleViewAdapterOutlet.ViewHolder> {
    private Context context;
    private ArrayList<Outlet> outlets;

    public RecycleViewAdapterOutlet(Context context, ArrayList<Outlet> outlets) {
        this.context = context;
        this.outlets = outlets;
    }

    @NonNull
    @Override
    public RecycleViewAdapterOutlet.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.z_outlet_card,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecycleViewAdapterOutlet.ViewHolder holder, final int position) {

        Glide.with(context)
                .load(outlets.get(position).getImgUrl())
                .into(holder.imageView);
        holder.outletName.setText(outlets.get(position).getOutletName());
        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,OutletActivity.class);
                intent.putExtra("outlet_data",outlets.get(position));
                intent.setFlags(FLAG_ACTIVITY_CLEAR_TOP| Intent.FLAG_ACTIVITY_SINGLE_TOP);
                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return outlets.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView outletName;
        LinearLayout parentLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.outletImage);
            outletName = itemView.findViewById(R.id.tv_outletName);
            parentLayout = itemView.findViewById(R.id.ll_outletCard);

        }
    }
}
