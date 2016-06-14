package com.kimson.framedemo;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import com.kimson.library.util.PreferenceUtils;

/**
 * Created by zhujianheng on 6/1/16.
 */
public class AppConfig extends PreferenceUtils{


    public static PackageInfo getPackageInfo() {
        PackageInfo info = null;
        try {
            info = getContext().getPackageManager().getPackageInfo(getContext().getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace(System.err);
        }
        if (info == null)
            info = new PackageInfo();
        return info;
    }

    public static boolean isFirstStart() {
        String key = String.format("first_start_ver_%d", getPackageInfo().versionCode);
        boolean isFirstStart = getBoolean(key, true);
        putBoolean(key, false);
        return isFirstStart;
    }
}
