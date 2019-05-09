package com.filipe.malachias.tabexperiment;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 1. setup toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        // 2. setup tab layout
        TabLayout tabLayout = findViewById(R.id.tab_layout);
        // add 3 tabs
        tabLayout.addTab(tabLayout.newTab().setText("Top Stories"));
        tabLayout.addTab(tabLayout.newTab().setText("Tech News"));
        tabLayout.addTab(tabLayout.newTab().setText("Cooking News"));
        // set the tabs ti fill the entire layout
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        // 3. set the PagerAdapter to manage page views in fragments
        final ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(new PagerAdapter(getSupportFragmentManager()));

        // slider
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        // click change
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                // start the process
                viewPager.setCurrentItem(tab.getPosition());

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                // when new tab is selected
                // background servicer....continue download

                Log.d("MainActivity", "TabUnselected.");

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                // refreshing the page, restart

                Log.d("MainActivity", "TabReselected.");

            }
        });

    }
}
