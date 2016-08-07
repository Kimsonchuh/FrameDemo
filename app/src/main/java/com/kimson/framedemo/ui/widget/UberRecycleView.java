package com.kimson.framedemo.ui.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Scroller;

import com.kimson.library.util.DensityUtils;

/**
 * Created by zhujianheng on 8/5/16.
 */
public class UberRecycleView extends RecyclerView {
    public static final String TAG = UberRecycleView.class.getSimpleName();


    private Context mContext;
    private ViewGroup mParentView;
    private Scroller mScroller;
    private int downY;
    private int tempY;                          //临时存储X坐标
    private int upY;
    private int mTouchMinDistance;
    private int viewHeight;

    private int offsetDuration;

    private boolean isShowed = false;


    private long startTime;
    private long endTime;

    public UberRecycleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs, 0);
    }

    public UberRecycleView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

    }

    public void initView (Context context) {
        mTouchMinDistance = ViewConfiguration.get(context).getScaledTouchSlop();
        mScroller = new Scroller(context);
        mContext = context;
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        if (changed) {
            mParentView = (ViewGroup) this.getParent();
            viewHeight = this.getHeight();
        }
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.e(TAG, ">>>ACTION_DOWN");
                downY = tempY = (int) event.getRawY();
                startTime = System.currentTimeMillis();
                break;
            case MotionEvent.ACTION_MOVE:
                Log.e(TAG, ">>>ACTION_MOVE");
                int moveY = (int) event.getRawY();
                int deltaY = tempY - moveY;
                tempY = moveY;
                endTime = System.currentTimeMillis();
                if (downY - moveY > 30) {
                    mParentView.scrollBy(0, deltaY);
                }
                break;
            case MotionEvent.ACTION_UP:
                Log.e(TAG, ">>>ACTION_UP");
                upY = (int) event.getRawY();
                endTime = System.currentTimeMillis();
                if (!isShowed) {
                    //TODO:未展开，包含点击，滑动和长按
                    scrollToDestination();
                } else {
                    //TODO:已展开，滑动
                    if (upY - downY > 30) {
                        scrollToOrigin();
                    }
                }


                break;
        }
//        return super.dispatchTouchEvent(event);
        return true;
    }


    /**
     * 滑动到指定位置
     */
    private void scrollToDestination() {
//        final int delta = (viewHeight + mParentView.getScrollY());
        Log.e(TAG, ">>>scrollToDestination");
        final int delta = DensityUtils.dip2px(mContext, 200);
        mScroller.startScroll(0, mParentView.getScrollY(), 0, delta, Math.abs(delta));
        isShowed = true;
        postInvalidate();
    }

    /**
     * 滑动到原始位置
     */
    private void scrollToOrigin() {
        Log.e(TAG, ">>>scrollToOrigin");
        int delta = mParentView.getScrollY();
        mScroller.startScroll(0, mParentView.getScrollY(), 0, -delta, Math.abs(delta));
        isShowed = false;
        postInvalidate();
    }

    /**
     * 外部调用回弹到底部
     */
    public void touchToOrigin() {
        scrollToOrigin();
    }


    /**
     * 滑动到顶部
     */
    private void scrollToTop() {

    }


    @Override
    public void computeScroll() {
        if (mScroller != null) {
            if (mScroller.computeScrollOffset()) {
                mParentView.scrollTo(mScroller.getCurrX(), mScroller.getCurrY());
                postInvalidate();
                if (mScroller.isFinished()) {
                    //TODO:滑动结束
                }
            }
        }

    }
}
