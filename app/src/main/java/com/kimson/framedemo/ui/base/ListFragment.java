package com.kimson.framedemo.ui.base;

import android.support.v7.widget.RecyclerView;

/**
 * Created by zhujianheng on 6/2/16.
 */
public abstract class ListFragment<VH extends RecyclerView.ViewHolder, Item, Result> extends com.kimson.library.ui.fragment.ListFragment<VH, Item, Result> {
    private final String TAG = this.getClass().getSimpleName();

    @Override
    public void onLoadComplete(Result data) {
        mIsLoadingMore = false;
    }
}

