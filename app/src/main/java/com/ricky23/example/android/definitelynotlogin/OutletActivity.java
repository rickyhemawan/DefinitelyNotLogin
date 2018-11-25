package com.ricky23.example.android.definitelynotlogin;

import android.app.Fragment;
import android.content.Intent;
import android.nfc.Tag;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.io.Serializable;
import java.util.ArrayList;

public class OutletActivity extends AppCompatActivity implements Serializable {
    private static final String TAG = "OutletActivity";
    private Outlet outlet;
    private ViewPager vp;
    private SectionsPagerAdapter sectionsPageAdapter;
    private TextView name;
    private ImageView img;

    public Outlet getOutlet() {
        return outlet;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_outlet);
        /*Product aqua = new Product("Aqua",5000,"Mineral Water","https://i1.wp.com/idamanexpress.com/wp-content/uploads/2018/02/aqua_botol_1500ml.jpg?fit=1000%2C1000");
        ArrayList<Product> manyAqua = new ArrayList<>();
        manyAqua.add(aqua);
        manyAqua.add(aqua);
        manyAqua.add(aqua);

        ProductType mineral = new ProductType("Mineral",manyAqua);
        ProductType water = new ProductType("Water", manyAqua);
        ProductType ready = new ProductType("Ready",manyAqua);

        ArrayList<Integer> days = new ArrayList<>();
        days.add(2);
        days.add(3);
        days.add(4);

        ArrayList<ProductType> hehe3x = new ArrayList<>();
        hehe3x.add(mineral);
        hehe3x.add(water);
        hehe3x.add(ready);
        hehe3x.add(mineral);
        hehe3x.add(water);
        hehe3x.add(ready);
        outlet = new Outlet("Water Seller", "Water Street",0,60,days,hehe3x,"https://i1.wp.com/idamanexpress.com/wp-content/uploads/2018/02/aqua_botol_1500ml.jpg?fit=1000%2C1000");
        */
        //getIncomingIntent();
        Intent intent = getIntent();
        outlet = (Outlet) intent.getSerializableExtra("outlet_data");



        name = (TextView)findViewById(R.id.tv_outletName);
        name.setText(outlet.getOutletName());
        img = (ImageView)findViewById(R.id.bigOutletImage);
        Glide.with(this)
                .asBitmap()
                .load(outlet.getImgUrl())
                .into(img);




        sectionsPageAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        //Setup View Pager
        vp = (ViewPager) findViewById(R.id.vp_typeFoods);
        setupViewPager(vp);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs_typeName);
        tabLayout.setupWithViewPager(vp);
        if(outlet.getTypes().size()<4){
            tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        }else {
            tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        }
        for (int i = 0; i<outlet.getTypes().size();i++){
            String product = outlet.getTypes().get(i).getTypeName();
            tabLayout.getTabAt(i).setText(product);
            ArrayList<Product> arrayList = outlet.getTypes().get(i).getProducts();
            //Bundle bundle = new Bundle();
            ///bundle.putParcelableArrayList("arraylist",arrayList);
            //TabMenuFragment fragment = new TabMenuFragment();
            //fragment.setArguments(bundle);

        }



    }

    private void setupViewPager(ViewPager viewPager) {

        for (int i = 0; i<outlet.getTypes().size();i++){
            String product = outlet.getTypes().get(i).getTypeName();
            TabMenuFragment tempFragment=new TabMenuFragment();
            tempFragment.setProducts(outlet.getTypes().get(i).getProducts());

            Function.test="ganti value";
            sectionsPageAdapter.addFragment(tempFragment,product,i);
        }

        viewPager.setOffscreenPageLimit(3);
        viewPager.setAdapter(sectionsPageAdapter);
    }

    private void getIncomingIntent(){

        Log.d(TAG, "getIncomingIntent: checking for incoming intents");
        if(getIntent().hasExtra("outlet_data")){
            Log.d(TAG, "getIncomingIntent: found intent extras");
            Intent intent = getIntent();
            Outlet outlet = (Outlet) intent.getSerializableExtra("outlet_data");
        }
    }
}
