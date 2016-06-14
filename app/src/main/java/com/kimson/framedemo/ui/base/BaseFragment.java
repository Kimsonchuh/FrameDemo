package com.kimson.framedemo.ui.base;

import android.app.ProgressDialog;

/**
 * Created by zhujianheng on 6/1/16.
 */
public class BaseFragment extends com.kimson.library.ui.fragment.BaseFragment{
    private final String TAG = this.getClass().getSimpleName();

    protected ProgressDialog mProgressDialog;

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
            mProgressDialog = new ProgressDialog(getActivity());
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
