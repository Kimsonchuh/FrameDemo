package com.kimson.framedemo.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.kimson.framedemo.R;
import com.kimson.framedemo.ui.TabActivity;
import com.kimson.framedemo.ui.base.BaseFragment;
import com.kimson.framedemo.util.ActivityUtils;

/**
 * Created by zhujianheng on 6/3/16.
 */
public class HomeTabMeFragment extends BaseFragment{

    public static final String TAG = HomeTabMeFragment.class.getSimpleName();

    private Button mTabBtn;


    public static HomeTabMeFragment newInstance() {
        HomeTabMeFragment fragment = new HomeTabMeFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.e(TAG, ">>>onCreateView");
        View view = inflater.inflate(R.layout.fragment_home_me, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Log.e(TAG, ">>>onViewCreated");
        super.onViewCreated(view, savedInstanceState);
        mTabBtn = (Button) view.findViewById(R.id.tab_btn);
        mTabBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityUtils.startActivity(getActivity(), TabActivity.class);
            }
        });
    }
}
