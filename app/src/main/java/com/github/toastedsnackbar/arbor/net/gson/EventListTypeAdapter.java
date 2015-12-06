package com.github.toastedsnackbar.arbor.net.gson;

import com.github.toastedsnackbar.arbor.net.responses.events.EventListResponse;
import com.github.toastedsnackbar.arbor.net.responses.events.EventResponse;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class EventListTypeAdapter implements JsonDeserializer<EventListResponse> {

    @Override
    public EventListResponse deserialize(JsonElement json, Type typeOfT,
                                         JsonDeserializationContext context)
            throws JsonParseException {
        List<EventResponse> events = context.deserialize(json,
                new TypeToken<List<EventResponse>>(){}.getType());

        long obtainedAt = System.currentTimeMillis();
        for (EventResponse event : events) {
            if (event != null) {
                event.setObtainedAt(obtainedAt);
            }
        }

        return new EventListResponse(events);
    }
}
