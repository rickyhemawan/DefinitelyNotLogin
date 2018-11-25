package com.ricky23.example.android.definitelynotlogin;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;

import java.util.ArrayList;


public class TabCategoryFragment extends Fragment {
    private static final String TAG = "TabCategoryFragment";

    private ArrayList<String> title = new ArrayList<>();
    private ArrayList<String> img = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab_category,container,false);



        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String productName;
        Log.d(TAG, "onViewCreated: ");
        productName = getResources().getString(R.string.type_martabak);
        title.add(productName);
        img.add("http://indonesiaexpat.biz/wp-content/uploads/2017/06/image-via-serious-eats-735x400.jpg");
        productName = getResources().getString(R.string.type_rice);
        title.add(productName);
        img.add("https://www.africanahome.ae/store/wp-content/uploads/2017/11/WHITE-RICE.jpg");
        productName = getResources().getString(R.string.type_chicken);
        title.add(productName);
        img.add("https://d2droglu4qf8st.cloudfront.net/2016/03/269629/recipe-24836_ExtraLarge1000_ID-1529534.jpg?v=1529534");
        productName = getResources().getString(R.string.type_snack);
        title.add(productName);
        img.add("https://img-global.cpcdn.com/003_recipes/4c8ecc475b5463ff/1200x630cq70/photo.jpg");
        productName = getResources().getString(R.string.type_pizza_pasta);
        title.add(productName);
        img.add("http://fdprn.com/wp-content/uploads/2017/02/Garlic-Butter-Pizza-Pull-Apart-Bread-5-800x445.jpg");
        productName = getResources().getString(R.string.type_noodles);
        title.add(productName);
        img.add("http://www.foodbysung.com/wp-content/uploads/2017/04/17437644_418595478508056_4193317892688707584_n.jpg");
        productName = getResources().getString(R.string.type_soup);
        title.add(productName);
        img.add("https://postmediacalgaryherald2.files.wordpress.com/2011/10/heirloom-tomato-soup.jpg?quality=80&strip=all&w=624&h=455&crop=1");
        productName = getResources().getString(R.string.type_fast_food);
        title.add(productName);
        img.add("https://i1.wp.com/media.hungryforever.com/wp-content/uploads/2016/05/16131710/junkfood.jpg?ssl=1?w=356&strip=all&quality=80");
        productName = getResources().getString(R.string.type_beverages);
        title.add(productName);
        img.add("https://images.video.snidigital.com/image/upload/h_365,w_721,c_fill/prod/genius/sni1uss-aakamaihdnetScripps_-_Genius_Kitchen30157170921_4177386_Fruit_Infused_Sparkling_Waterjpg.jpg");
        productName = getResources().getString(R.string.type_satay);
        title.add(productName);
        img.add("https://dz01iyojmxk8t.cloudfront.net/wp-content/uploads/2013/11/06104606/steaks.jpg");
        productName = getResources().getString(R.string.type_japanese_cuisine);
        title.add(productName);
        img.add("https://img.grouponcdn.com/deal/fmPws6o2uTweCftZu7yj/p4-2048x1229/v1/c700x420.jpg");
        productName = getResources().getString(R.string.type_dessert);
        title.add(productName);
        img.add("https://recipesbygeorge.files.wordpress.com/2017/01/image4.jpg?w=1000");
        productName = getResources().getString(R.string.type_western_cuisine);
        title.add(productName);
        img.add("https://c1.staticflickr.com/8/7178/27285619604_abf45ddbcf_b.jpg");
        productName = getResources().getString(R.string.type_bread);
        title.add(productName);
        img.add("https://assets.vogue.com/photos/58915f71f88f7c2037365853/master/pass/food-porn-baguettes-07.jpg");
        productName = getResources().getString(R.string.type_seafood);
        title.add(productName);
        img.add("http://4.bp.blogspot.com/-xztEVTLX_qs/UhF7ypBP-hI/AAAAAAAABUE/E6uiujIiGl8/s1600/BarcelonaSeafood1.JPG");
        productName = getResources().getString(R.string.type_chinese_cuisine);
        title.add(productName);
        img.add("https://cdntct.com/tct/pic/china-guide/chinese-cuisine-top2.jpg");
        productName = getResources().getString(R.string.type_korean_cuisine);
        title.add(productName);
        img.add("https://www.sbs.com.au/food/sites/sbs.com.au.food/files/kfms-beef-bibimbap-sml.jpg");
        productName = getResources().getString(R.string.type_indian_cuisine);
        title.add(productName);
        img.add("https://i.imgur.com/R8KYrjH.jpg");
        productName = getResources().getString(R.string.type_middle_east_cuisine);
        title.add(productName);
        img.add("http://www.foodrepublic.com/wp-content/uploads/2014/10/lambpita-983x630.jpg");
        productName = getResources().getString(R.string.type_coffee);
        title.add(productName);
        img.add("https://i2.wp.com/www.thecoffeecompass.com/wp-content/uploads/BowTruss.jpg?ssl=1");
        productName = getResources().getString(R.string.type_thailand_cuisine);
        title.add(productName);
        img.add("https://www.templeofthai.com/images/cooking/isan-thai-food-shutterstock_67694425.jpg");


        RecyclerView recyclerView = view.findViewById(R.id.rvCategory);
        RecycleViewAdapterCategory adapterCategory = new RecycleViewAdapterCategory(getActivity(),img,title);
        recyclerView.setAdapter(adapterCategory);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(GridLayout.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);



        RecyclerView recyclerView1 = view.findViewById(R.id.rvBotCategory);
        RecycleViewAdapterFoodTypes adapterCategory1 = new RecycleViewAdapterFoodTypes(getActivity(),img,title);
        recyclerView1.setAdapter(adapterCategory1);
        final GridLayoutManager layoutManager1 = new GridLayoutManager(getActivity(),2);
        layoutManager1.setOrientation(GridLayout.VERTICAL);
        recyclerView1.setLayoutManager(layoutManager1);



    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        title.clear();
        img.clear();
    }
}