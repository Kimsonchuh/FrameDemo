package com.kimson.framedemo.ui.base;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;

import com.kimson.framedemo.ui.vh.ViewHolder;
import com.kimson.framedemo.util.ActivityUtils;

/**
 * Created by zhujianheng on 6/2/16.
 */
public abstract class ListActivity<VH extends ViewHolder, Item, Result> extends com.kimson.library.ui.ListActivity<VH, Item, Result> {
    private final String TAG = this.getClass().getSimpleName();

    private View mLoadingView;
    private View mEmptyView;
    private View mErrorView;

    protected boolean mFirstLoaded = false;
    protected boolean mIsLoadMore = false;
    protected int mLastItemCount = 0;

    private int mListCount = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityUtils.addActivity(this);
        // 禁止横屏
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    @Override
    public void onLoadComplete(Result data) {
        mIsLoadMore = false;
    }
}
