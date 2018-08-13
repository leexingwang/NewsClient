package com.chaychan.bottombarlayout;

import android.app.Application;

import com.bumptech.glide.Glide;

/**
 * Created by lixingwang on 2018/8/9.
 * com.chaychan.bottombarlayout
 */

public class AppApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        Glide.get(this).clearMemory();
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        if (level == TRIM_MEMORY_UI_HIDDEN) {
            Glide.get(this).clearMemory();
        }
        Glide.get(this).trimMemory(level);
    }
}
