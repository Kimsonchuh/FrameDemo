package com.kimson.framedemo.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kimson.framedemo.R;
import com.kimson.framedemo.ui.base.BaseFragment;

/**
 * Created by zhujianheng on 6/3/16.
 */
public class HomeTabMeFragment extends BaseFragment{

    public static HomeTabMeFragment newInstance() {
        HomeTabMeFragment fragment = new HomeTabMeFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_me, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
