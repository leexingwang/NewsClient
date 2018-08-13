package com.chaychan.bottombarlayout;

import android.content.Context;

import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool;
import com.bumptech.glide.load.engine.cache.LruResourceCache;
import com.bumptech.glide.module.GlideModule;

/**
 * Created by lixingwang on 2018/4/25.
 * com.yicai.news.utils.loaderimageutils
 */
public class GlideConfiguration implements GlideModule {
    @Override
    public void applyOptions(Context context, GlideBuilder builder) {
        builder.setDecodeFormat(DecodeFormat.PREFER_ARGB_8888);
        builder.setMemoryCache(new LruResourceCache(10*1024*1024));
        builder.setBitmapPool(new LruBitmapPool(20*1024*1024));
    }

    @Override
    public void registerComponents(Context context, Glide glide) {

    }
}