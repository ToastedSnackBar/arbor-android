package com.github.toastedsnackbar.arbor.net.gson;

import com.github.toastedsnackbar.arbor.net.responses.RepositoryListResponse;
import com.github.toastedsnackbar.arbor.net.responses.RepositoryResponse;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class RepositoryListTypeAdapter implements JsonDeserializer<RepositoryListResponse> {

    @Override
    public RepositoryListResponse deserialize(JsonElement json, Type typeOfT,
                                              JsonDeserializationContext context)
            throws JsonParseException {
        List<RepositoryResponse> repositories = context.deserialize(json,
                new TypeToken<List<RepositoryResponse>>(){}.getType());

        return new RepositoryListResponse(repositories);
    }
}
