package com.kimson.framedemo.ui;

import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.kimson.framedemo.ui.fragment.HomeTabHomeFragment;
import com.kimson.framedemo.ui.widget.BottomBarController;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnMenuTabClickListener;

import com.kimson.framedemo.R;
import com.kimson.framedemo.ui.fragment.HomeTabBookingFragment;
import com.kimson.framedemo.ui.fragment.HomeTabMeFragment;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {
    private BottomBar mBottomBar;
    private BottomBarController bottomBarController;

    private final int INDEX_HOME = BottomBarController.TAB1;
    private final int INDEX_BOOKING = BottomBarController.TAB2;
    private final int INDEX_ME = BottomBarController.TAB3;

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        bottomBarController.onSaveInstanceState(outState);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        List<Fragment> fragments = new ArrayList<>(3);
        fragments.add(HomeTabHomeFragment.newInstance("Home"));
        fragments.add(HomeTabBookingFragment.newInstance("Booking"));
        fragments.add(HomeTabMeFragment.newInstance("Me"));


        bottomBarController = new BottomBarController(savedInstanceState, getSupportFragmentManager(), R.id.container, fragments);
        mBottomBar = BottomBar.attach(this, savedInstanceState);
        mBottomBar.useDarkTheme();
        mBottomBar.setItemsFromMenu(R.menu.bottom_bar, new OnMenuTabClickListener() {
            @Override
            public void onMenuTabSelected(@IdRes int menuItemId) {
                switch (menuItemId) {
                    case R.id.home_home:
                        bottomBarController.switchTab(INDEX_HOME);
                        break;
                    case R.id.home_book:
                        bottomBarController.switchTab(INDEX_BOOKING);
                        break;
                    case R.id.home_me:
                        bottomBarController.switchTab(INDEX_ME);
                        break;
                }
            }

            @Override
            public void onMenuTabReSelected(@IdRes int menuItemId) {
                bottomBarController.clearStack();
            }
        });
    }

}
