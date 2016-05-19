package com.github.toastedsnackbar.arbor.util;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
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
        Glide.with(mContext).load(url).override(width, height).centerCrop().into(imageView);
    }

    public void resumeRequests() {
        Glide.with(mContext).resumeRequests();
    }

    public void pauseRequests() {
        Glide.with(mContext).pauseRequests();
    }

    public static class GlideOnScrollListener extends OnScrollListener {

        public GlideHelper mGlideHelper;

        public GlideOnScrollListener(GlideHelper glideHelper) {
            mGlideHelper = glideHelper;
        }

        @Override
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            if (RecyclerView.SCROLL_STATE_IDLE == newState) {
                mGlideHelper.resumeRequests();
            } else if (RecyclerView.SCROLL_STATE_DRAGGING == newState) {
                mGlideHelper.pauseRequests();
            }
        }
    }
}
