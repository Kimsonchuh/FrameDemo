package com.kimson.framedemo;

import com.facebook.stetho.Stetho;
import com.kimson.library.Application;

/**
 * Created by zhujianheng on 6/1/16.
 */
public class AppContext extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        // Stetho
        Stetho.initializeWithDefaults(getApplicationContext());
    }
}
