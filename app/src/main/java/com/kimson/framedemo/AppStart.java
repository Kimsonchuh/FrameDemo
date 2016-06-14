package com.kimson.framedemo;

import android.os.Bundle;
import android.view.animation.Animation;

import com.kimson.framedemo.ui.HomeActivity;
import com.kimson.framedemo.ui.base.StartUpActivity;
import com.kimson.framedemo.util.ActivityUtils;

import com.kimson.framedemo.R;

/**
 * Created by zhujianheng on 6/1/16.
 */
public class AppStart extends StartUpActivity {
    private final boolean isFirstStart = AppConfig.isFirstStart();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_page);

    }
    @Override
    public void onAnimationStart(Animation animation) {
    }

    @Override
    public void onAnimationEnd(Animation animation) {
        ActivityUtils.goHome(this, HomeActivity.class);
    }

}
