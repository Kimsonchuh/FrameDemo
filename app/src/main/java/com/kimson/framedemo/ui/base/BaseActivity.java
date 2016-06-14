package com.kimson.framedemo.ui.base;

import android.app.ProgressDialog;
import android.content.pm.ActivityInfo;
import android.os.Bundle;

import com.kimson.framedemo.util.ActivityUtils;

/**
 * Created by zhujianheng on 6/1/16.
 */
public class BaseActivity extends com.kimson.library.ui.BaseActivity {
    private final String TAG = this.getClass().getSimpleName();

    protected ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityUtils.addActivity(this);
        // 禁止横屏
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    protected void showProgressDialog(int resId) {
        showProgressDialog(getString(resId));
    }

    protected void showProgressDialog(String message) {
        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(this);
        }
        mProgressDialog.setCancelable(false);
        mProgressDialog.setMessage(message);
        mProgressDialog.show();
    }

    protected void dismissProgressDialog() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }
    }

}
