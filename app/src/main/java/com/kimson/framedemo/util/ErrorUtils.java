package com.kimson.framedemo.util;

import android.content.Context;
import android.widget.Toast;

import com.kimson.library.util.TextUtils;

/**
 * Created by zhujianheng on 6/2/16.
 */
public class ErrorUtils {

    /**
     * NetWork Connect Error
     * @param context
     * @param messages
     */
    public static void show(Context context, String messages) {
        if (context == null) {
            return;
        }
        if (TextUtils.isEmpty(messages)) {
            return;
        }
        Toast.makeText(context, messages, Toast.LENGTH_SHORT).show();
    }

}
