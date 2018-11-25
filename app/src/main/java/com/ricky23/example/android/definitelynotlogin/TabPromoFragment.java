package com.ricky23.example.android.definitelynotlogin;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class TabPromoFragment extends Fragment {
    private static final String TAG = "TabPromoFragment";

    private ArrayList<Promo> promos = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView: started.");
        View view = inflater.inflate(R.layout.fragment_tab_promo,container,false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d(TAG, "initImage: preparing card");
        Promo sushi = new Promo("Sushi","Sushi is a Japanese dish of specially prepared vinegared rice , usually with some sugar and salt, combined with a variety of ingredients, such as seafood, vegetables, and occasionally tropical fruits.","Rp.20000  R̶p̶.̶3̶0̶0̶0̶0", "https://img.grouponcdn.com/deal/fmPws6o2uTweCftZu7yj/p4-2048x1229/v1/c700x420.jpg");
        promos.add(sushi);
        promos.add(sushi);
        promos.add(sushi);




        RecyclerView recyclerView = view.findViewById(R.id.rvPromo);
        RecycleViewAdapterPromo adapter = new RecycleViewAdapterPromo(promos,getActivity());
        recyclerView.setAdapter(adapter);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);


    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        promos.clear();
    }


}