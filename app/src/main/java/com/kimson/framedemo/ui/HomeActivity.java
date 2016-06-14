package com.kimson.framedemo.ui;

import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.kimson.framedemo.ui.fragment.HomeTabHomeFragment;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnMenuTabClickListener;

import com.kimson.framedemo.R;
import com.kimson.framedemo.ui.fragment.HomeTabBookingFragment;
import com.kimson.framedemo.ui.fragment.HomeTabMeFragment;

public class HomeActivity extends AppCompatActivity {
    private BottomBar mBottomBar;
    private TextView mMessageView;


    private HomeTabHomeFragment homeFragment;
    private HomeTabBookingFragment bookingFragment;
    private HomeTabMeFragment meFragment;

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // Necessary to restore the BottomBar's state, otherwise we would
        // lose the current tab on orientation change.

        mBottomBar.onSaveInstanceState(outState);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mMessageView = (TextView) findViewById(R.id.messageView);

        homeFragment = HomeTabHomeFragment.newInstance();
        bookingFragment = HomeTabBookingFragment.newInstance();
        meFragment = HomeTabMeFragment.newInstance();

        mBottomBar = BottomBar.attach(this, savedInstanceState);
        mBottomBar.setItemsFromMenu(R.menu.bottom_bar, new OnMenuTabClickListener() {
            @Override
            public void onMenuTabSelected(@IdRes int menuItemId) {
                mMessageView.setText(getMessage(menuItemId, false));
            }

            @Override
            public void onMenuTabReSelected(@IdRes int menuItemId) {

            }
        });

        mBottomBar.mapColorForTab(1, 0xFF5D4037);
        mBottomBar.mapColorForTab(2, "#7B1FA2");
    }

    private String getMessage(int menuItemId, boolean isReselection) {
        String message = "Content for ";

        switch (menuItemId) {
            case R.id.home_home:
                message += "home";
                break;
            case R.id.home_book:
                message += "book";
                break;
            case R.id.home_me:
                message += "me";
                break;
        }

        if (isReselection) {
            message += " WAS RESELECTED! YAY!";
        }

        return message;
    }


}
