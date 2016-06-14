package com.kimson.framedemo.receiver;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;

import java.util.List;

/**
 * Created by zhujianheng on 6/1/16.
 */
public class JPushReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

    }


    public static boolean isForeground(Context context) {
        ActivityManager am = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningTaskInfo> tasks = am.getRunningTasks(1);
        if (!tasks.isEmpty()) {
            ComponentName topActivity = tasks.get(0).topActivity;
            if (topActivity.getPackageName().equals(context.getPackageName())) {
                return true;
            }
        }
        return false;
    }
}
