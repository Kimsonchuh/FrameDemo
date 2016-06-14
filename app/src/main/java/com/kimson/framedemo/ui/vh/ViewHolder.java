package com.kimson.framedemo.ui.vh;


import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.kimson.library.bind.Bind;

/**
 * Created by zhujianheng on 6/2/16.
 */
public class ViewHolder extends RecyclerView.ViewHolder {
    public ViewHolder(View itemView) {
        super(itemView);
        Bind.inject(this, itemView);
    }
}
