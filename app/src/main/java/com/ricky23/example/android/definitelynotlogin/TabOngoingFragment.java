package com.ricky23.example.android.definitelynotlogin;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;


public class TabOngoingFragment extends Fragment {

    private ArrayList<Order> orders = new ArrayList<>();


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab_history,container,false);

        return view;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //Dummy Product
        Product aqua = new Product("Aqua",4000,"Air Mineral","https://s4.bukalapak.com/img/9659898502/w-1000/aqua.jpg");
        Product tehkotak = new Product("Teh Kotak",5000,"Cuma Teh Kotak Biasa","http://www.ultrajaya.co.id/images/product_tehkotak_thumb.jpg");
        Product klepon = new Product("Klepon",3000,"Balinese Cuisine","https://img-global.cpcdn.com/003_recipes/4c8ecc475b5463ff/1200x630cq70/photo.jpg");

        //Insert Orders Here

        //Order 1
        ArrayList<Product> product1 = new ArrayList<>();
        ArrayList<Integer> qty1 = new ArrayList<>();

        product1.add(aqua);
        qty1.add(2);
        product1.add(klepon);
        qty1.add(1);
        Order order1 = new Order(product1,qty1);

        //Order 2
        ArrayList<Product> product2 = new ArrayList<>();
        ArrayList<Integer> qty2 = new ArrayList<>();

        product2.add(tehkotak);
        qty2.add(2);
        product2.add(klepon);
        qty2.add(1);
        Order order2 = new Order(product2,qty2);

        //Order 3
        ArrayList<Product> product3 = new ArrayList<>();
        ArrayList<Integer> qty3 = new ArrayList<>();

        product3.add(aqua);
        product3.add(klepon);
        product3.add(tehkotak);
        qty3.add(1);
        qty3.add(2);
        qty3.add(1);
        Order order3 = new Order(product3,qty3);

        orders.add(order1);
        orders.add(order2);
        orders.add(order3);


        RecyclerView recyclerView = view.findViewById(R.id.rv_history);
        RecycleViewAdapterHistory adapterHistory = new RecycleViewAdapterHistory(orders,getActivity());
        recyclerView.setAdapter(adapterHistory);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);


    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        orders.clear();
    }
}
