package com.github.toastedsnackbar.arbor.net.gson;

import com.github.toastedsnackbar.arbor.net.responses.IsFollowingResponse;
import com.github.toastedsnackbar.arbor.net.responses.RepositoryListResponse;
import com.github.toastedsnackbar.arbor.net.responses.UserListResponse;
import com.github.toastedsnackbar.arbor.net.responses.events.EventListResponse;
import com.github.toastedsnackbar.arbor.net.responses.events.EventResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonHelper {

    private static GsonHelper sInstance;
    private Gson mGson;

    public static void init() {
        if (sInstance == null) {
            sInstance = new GsonHelper();
        }
    }

    private GsonHelper() {
        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(EventResponse.class, new EventTypeAdapter());
        builder.registerTypeAdapter(RepositoryListResponse.class, new RepositoryListTypeAdapter());
        builder.registerTypeAdapter(EventListResponse.class, new EventListTypeAdapter());
        builder.registerTypeAdapter(UserListResponse.class, new UserListTypeAdapter());
        builder.registerTypeAdapter(IsFollowingResponse.class, new IsFollowingTypeAdapter());
        mGson = builder.create();
    }

    public static <T> T fromJson(String json, Class<T> typeOfT) {
        if (sInstance == null) {
            throw new IllegalStateException("GsonHelper not initialized!");
        }

        return sInstance.mGson.fromJson(json, typeOfT);
    }

    public static <T> String toJson(T src) {
        if (sInstance == null) {
            throw new IllegalStateException("GsonHelper not initialized!");
        }

        return sInstance.mGson.toJson(src);
    }
}
