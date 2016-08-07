package com.kimson.framedemo.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

import com.kimson.framedemo.R;
import com.kimson.framedemo.ui.base.BaseActivity;
import com.kimson.framedemo.ui.widget.UberRecycleView;
import com.kimson.framedemo.util.THKeybordUtils;
import com.kimson.library.bind.ViewById;
import com.kimson.library.util.Keyboard;

/**
 * Created by zhujianheng on 8/5/16.
 */
public class CustomizeViewActivity extends BaseActivity {
    public static final String TAG = CustomizeViewActivity.class.getSimpleName();

    @ViewById(R.id.list_view)
    private UberRecycleView uberRecycleView;
    @ViewById(R.id.page_container)
    private FrameLayout mPageContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customize_view);
        uberRecycleView.initView(this);

        mPageContainer.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.e(TAG, ">>>onTouch");
                if (isShouldDismiss(uberRecycleView, event)) {
                    Log.e(TAG, ">>>isShouldDismiss");
                    uberRecycleView.touchToOrigin();
                }
                return false;
            }
        });

    }


    public static boolean isShouldDismiss(View v, MotionEvent event) {
        if (v != null) {
            int[] l = {0, 0};
            v.getLocationInWindow(l);
            int left = l[0], top = l[1], bottom = top + v.getHeight(), right = left
                    + v.getWidth();
            if (event.getX() > left && event.getX() < right
                    && event.getY() > top && event.getY() < bottom) {
                // 点击EditText的事件，忽略它。
                return false;
            } else {
                return true;
            }
        }
        // 如果焦点不是EditText则忽略，这个发生在视图刚绘制完，第一个焦点不在EditView上，和用户用轨迹球选择其他的焦点
        return false;
    }
}
