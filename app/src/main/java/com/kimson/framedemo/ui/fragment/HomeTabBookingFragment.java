package com.kimson.framedemo.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.kimson.framedemo.ui.CustomizeViewActivity;
import com.kimson.framedemo.ui.NewComActivity;
import com.kimson.framedemo.ui.base.BaseFragment;

import com.kimson.framedemo.R;
import com.kimson.framedemo.util.ActivityUtils;

/**
 * Created by zhujianheng on 6/3/16.
 */
public class HomeTabBookingFragment extends BaseFragment {

    public static final String TAG = HomeTabBookingFragment.class.getSimpleName();

    private Button mNewComp;
    private Button mCustumize;


    public static HomeTabBookingFragment newInstance() {
        HomeTabBookingFragment fragment = new HomeTabBookingFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.e(TAG, ">>>onCreateView");
        View view = inflater.inflate(R.layout.fragment_home_booking, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Log.e(TAG, ">>>onViewCreated");
        super.onViewCreated(view, savedInstanceState);
        mNewComp = (Button) view.findViewById(R.id.new_componone);
        mCustumize = (Button) view.findViewById(R.id.customize_recycleview);
        mNewComp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Jump to new Component activity
                ActivityUtils.startActivity(getActivity(), NewComActivity.class);
            }
        });

        mCustumize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityUtils.startActivity(getActivity(), CustomizeViewActivity.class);
            }
        });
    }
}
