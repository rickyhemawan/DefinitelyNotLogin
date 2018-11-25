package com.ricky23.example.android.definitelynotlogin;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class CatalogActivity extends AppCompatActivity {
    private static final String TAG = "CatalogActivity";

    private SectionsPageAdapter mSectionsPageAdapter;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalog);

        mSectionsPageAdapter = new SectionsPageAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        setupViewPager(mViewPager);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);


        tabLayout.getTabAt(0).setText(R.string.text_promo);
        tabLayout.getTabAt(1).setText(R.string.text_live_maps);
        tabLayout.getTabAt(2).setText(R.string.text_Category);

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavView_Bar);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(2);
        menuItem.setChecked(true);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.navigation_home :
                        Intent intent0 = new Intent(CatalogActivity.this, HomeActivity.class);
                        intent0.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        //finish();
                        startActivity(intent0);
                        overridePendingTransition(0, 0);
                        break;

                    case R.id.navigation_history:
                        Intent intent1 = new Intent(CatalogActivity.this, OrderActivity.class);
                        intent1.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        //finish();
                        startActivity(intent1);
                        overridePendingTransition(0, 0);
                        break;

                    case R.id.navigation_favorite:
                        //Intent intent2 = new Intent(CatalogActivity.this, CatalogActivity.class);
                        //startActivity(intent2);
                        break;

                    case R.id.navigation_account:
                        Intent intent3 = new Intent(CatalogActivity.this, AccountActivity.class);
                        intent3.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        //finish();
                        startActivity(intent3);
                        overridePendingTransition(0, 0);
                        break;
                }
                return false;
            }
        });
    }
    @Override
    protected void onPause() {
        super.onPause();
        overridePendingTransition(0, 0);
    }
    private void setupViewPager(ViewPager viewPager) {
        SectionsPageAdapter adapter = new SectionsPageAdapter(getSupportFragmentManager());
        adapter.addFragment(new TabPromoFragment());
        adapter.addFragment(new TabLiveMapsFragment());
        adapter.addFragment(new TabCategoryFragment());
        viewPager.setAdapter(adapter);
    }
}
