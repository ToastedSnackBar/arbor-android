package com.github.toastedsnackbar.arbor.net.gson;

import com.github.toastedsnackbar.arbor.net.responses.UserListResponse;
import com.github.toastedsnackbar.arbor.net.responses.UserResponse;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class UserListTypeAdapter implements JsonDeserializer<UserListResponse> {

    @Override
    public UserListResponse deserialize(JsonElement json, Type typeOfT,
                                        JsonDeserializationContext context)
            throws JsonParseException {
        List<UserResponse> users = context.deserialize(json,
                new TypeToken<List<UserResponse>>(){}.getType());

        return new UserListResponse(users);
    }
}
