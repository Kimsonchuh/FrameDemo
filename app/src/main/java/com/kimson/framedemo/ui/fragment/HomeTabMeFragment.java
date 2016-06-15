package com.kimson.framedemo.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kimson.framedemo.R;
import com.kimson.framedemo.ui.base.BaseFragment;

/**
 * Created by zhujianheng on 6/3/16.
 */
public class HomeTabMeFragment extends BaseFragment{

    public static final String TAG = HomeTabMeFragment.class.getSimpleName();

    private String content;
    private TextView mMessage;


    public static HomeTabMeFragment newInstance(String content) {
        HomeTabMeFragment fragment = new HomeTabMeFragment();
        fragment.content = content;
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
        mMessage = (TextView) view.findViewById(R.id.messageView);
        mMessage.setText(content);
    }
}
