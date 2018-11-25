package com.ricky23.example.android.definitelynotlogin;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;


public class RecycleViewAdapterHistory extends RecyclerView.Adapter<RecycleViewAdapterHistory.ViewHolder> {

    private ArrayList<Order> order;
    private Context mContext;

    public RecycleViewAdapterHistory(ArrayList<Order> order, Context mContext) {
        this.order = order;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public RecycleViewAdapterHistory.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.z_card_order2,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecycleViewAdapterHistory.ViewHolder holder, int position) {
        double totalPrice = 0;
        for (int i = 0; i<order.get(position).getOrderProduct().size();i++){
            //setting value
            Product food = order.get(position).getOrderProduct().get(i);
            String foodName = food.getProductName();
            double foodPrice = food.getProductPrice();
            int qty = order.get(position).getQty().get(i);

            totalPrice = totalPrice + (qty * foodPrice);

            String stringPrice = Double.toString(foodPrice);
            String stringQty = Integer.toString(qty);

            //setting param new Linear Layout
            LinearLayout apple = new LinearLayout(mContext);
            LinearLayout.LayoutParams banana = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            apple.setLayoutParams(banana);
            apple.setOrientation(LinearLayout.HORIZONTAL);
            apple.setWeightSum(5);

            //setting TextView param
            LinearLayout.LayoutParams mango = new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT,2);
            LinearLayout.LayoutParams miniMango = new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT,1);

            //setting TextView for Value
            TextView name = new TextView(mContext);
            name.setText(foodName);
            TextView quantity = new TextView(mContext);
            quantity.setText(stringQty);
            TextView price = new TextView(mContext);
            String stringPriceFix = "Rp. " + stringPrice + "0";
            price.setText(stringPriceFix);

            //setting TextView settings
            name.setLayoutParams(mango);
            quantity.setLayoutParams(miniMango);
            quantity.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            price.setLayoutParams(mango);
            price.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_END);

            //adding mangoes TextView to apple LinearLayout
            apple.addView(name);
            apple.addView(quantity);
            apple.addView(price);

            //adding apple to parent
            holder.parentLayout.addView(apple);

        }
        String stringTotal = "Rp. " + Double.toString(totalPrice) + "0";
        holder.totalOrder.setText(stringTotal);

    }

    @Override
    public int getItemCount() {
        return order.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        LinearLayout parentLayout;
        TextView totalOrder;
        public ViewHolder(View itemView) {
            super(itemView);
            parentLayout = itemView.findViewById(R.id.ll_Tree);
            totalOrder = itemView.findViewById(R.id.tv_totalPrices);
        }
    }
}


