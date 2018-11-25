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


public class TabSmartPKLFragment extends Fragment {
    private static final String TAG = "TabSmartPKLFragment";

    //floating action button w/ counter
    //https://github.com/andremion/CounterFab
    //Apache License v2

    private ArrayList<Promo> promos = new ArrayList<>();
    private ArrayList<Outlet> outlets = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView: started.");
        View view = inflater.inflate(R.layout.fragment_tab_smartpkl,container,false);
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
        inputData();




        RecyclerView recyclerView = view.findViewById(R.id.rvHomeTop);
        RecycleViewAdapterPromo adapter = new RecycleViewAdapterPromo(promos,getActivity());
        recyclerView.setAdapter(adapter);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);



        RecyclerView recyclerView1 = view.findViewById(R.id.rvHomeBot);
        RecycleViewAdapterOutlet adapter1 = new RecycleViewAdapterOutlet(getActivity(),outlets);
        //RecycleViewAdapterPromo adapter1 = new RecycleViewAdapterPromo(promos,getActivity());
        recyclerView1.setAdapter(adapter1);
        final LinearLayoutManager layoutManager1 = new LinearLayoutManager(getActivity());
        layoutManager1.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView1.setLayoutManager(layoutManager1);


    }
    public void inputData(){
        //Outlet Sate
        //Aneka Sate
        //default image = http://gunungkidulpost.com/wp-content/plugins/kentooz-socializer/images/default.jpg
        Product sate1 = new Product("Sate Bumbu Kacang",20000,"Sate Dengan Bumbu Kacang Racikan Sendiri","http://gunungkidulpost.com/wp-content/plugins/kentooz-socializer/images/default.jpg");
        Product sate2 = new Product("Sate Bumbu Kuning",15000,"Sate Dengan Bumbu Kuning","http://gunungkidulpost.com/wp-content/plugins/kentooz-socializer/images/default.jpg");
        Product sate3 = new Product("Sate Bumbu Merah",18000,"Sate Bumbu Merah khas Indonesia","http://gunungkidulpost.com/wp-content/plugins/kentooz-socializer/images/default.jpg");
        ArrayList<Product> sates = new ArrayList<>();
        sates.add(sate1);
        sates.add(sate2);
        sates.add(sate3);
        ProductType sate = new ProductType("Aneka Sate",sates);
        //Aneka Nasi

        Product nasi1 = new Product("Nasi Putih",5000,"","http://gunungkidulpost.com/wp-content/plugins/kentooz-socializer/images/default.jpg");
        Product nasi2 = new Product("Nasi Goreng",12000,"","http://gunungkidulpost.com/wp-content/plugins/kentooz-socializer/images/default.jpg");
        Product nasi3 = new Product("Nasi Merah",7000,"","http://gunungkidulpost.com/wp-content/plugins/kentooz-socializer/images/default.jpg");
        ArrayList<Product> nasis = new ArrayList<>();
        nasis.add(nasi1);
        nasis.add(nasi2);
        nasis.add(nasi3);
        ProductType nasi = new ProductType("Aneka Nasi",nasis);


        //Minuman
        Product minum1 = new Product("Es Teh",4000,"","http://gunungkidulpost.com/wp-content/plugins/kentooz-socializer/images/default.jpg");
        Product minum2 = new Product("Es Jeruk",5000,"","http://gunungkidulpost.com/wp-content/plugins/kentooz-socializer/images/default.jpg");
        Product minum3 = new Product("Teh Hangat",3000,"","http://gunungkidulpost.com/wp-content/plugins/kentooz-socializer/images/default.jpg");
        ArrayList<Product> minums = new ArrayList<>();
        minums.add(minum1);
        minums.add(minum2);
        minums.add(minum3);
        ProductType minum = new ProductType("Aneka Minuman",minums);

        //Cemilan
        Product cemilan1 = new Product("Kitkat",6000,"","http://gunungkidulpost.com/wp-content/plugins/kentooz-socializer/images/default.jpg");
        Product cemilan2= new Product("Biskuat",1000,"","http://gunungkidulpost.com/wp-content/plugins/kentooz-socializer/images/default.jpg");
        Product cemilan3 = new Product("Manisan Apel",2000,"","http://gunungkidulpost.com/wp-content/plugins/kentooz-socializer/images/default.jpg");
        ArrayList<Product> cemils = new ArrayList<>();
        cemils.add(cemilan1);
        cemils.add(cemilan2);
        cemils.add(cemilan3);
        ProductType cemilan = new ProductType("Aneka Sate",cemils);

        //Gorengan
        Product gorengan1 = new Product("Tempe Goreng",500,"","http://gunungkidulpost.com/wp-content/plugins/kentooz-socializer/images/default.jpg");
        Product gorengan2 = new Product("Tahu Goreng",1000,"","http://gunungkidulpost.com/wp-content/plugins/kentooz-socializer/images/default.jpg");
        Product gorengan3 = new Product("Sosis Goreng",1500,"","http://gunungkidulpost.com/wp-content/plugins/kentooz-socializer/images/default.jpg");
        ArrayList<Product> gorengs = new ArrayList<>();
        gorengs.add(gorengan1);
        gorengs.add(gorengan2);
        gorengs.add(gorengan3);
        ProductType gorengan = new ProductType("Aneka Gorengan",gorengs);

        ArrayList<ProductType> types = new ArrayList<>();
        types.add(sate);
        types.add(minum);
        types.add(cemilan);
        types.add(gorengan);
        types.add(nasi);

        ArrayList<Integer> days = new ArrayList<>();
        days.add(1);
        days.add(2);
        days.add(4);
        days.add(6);

        Outlet outlet = new Outlet("Sate Shop","Jl. Tukad Balian",0,360,days,types,"http://poskotanews.com/cms/wp-content/uploads/2012/10/bakar-sate-massal2610.jpg");
        outlets.add(outlet);
        outlets.add(outlet);
        outlets.add(outlet);


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        promos.clear();
        outlets.clear();
    }


}
