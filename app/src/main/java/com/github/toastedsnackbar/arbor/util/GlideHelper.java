package com.github.toastedsnackbar.arbor.util;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class GlideHelper {

    private Context mContext;

    public GlideHelper(Context context) {
        mContext = context;
    }

    public void load(String url, ImageView imageView) {
        Glide.with(mContext).load(url).into(imageView);
    }

    public void load(String url, int width, int height, ImageView imageView) {
        Glide.with(mContext).load(url).override(width, height).centerCrop().crossFade()
                .into(imageView);
    }

    public void resumeRequests() {
        Glide.with(mContext).resumeRequests();
    }

    public void pauseRequests() {
        Glide.with(mContext).pauseRequests();
    }
}
