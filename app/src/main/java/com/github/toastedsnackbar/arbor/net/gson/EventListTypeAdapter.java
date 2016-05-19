package com.github.toastedsnackbar.arbor.net.gson;

import com.github.toastedsnackbar.arbor.net.responses.events.EventListResponse;
import com.github.toastedsnackbar.arbor.net.responses.events.EventResponse;
import com.github.toastedsnackbar.arbor.net.responses.events.EventType;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventListTypeAdapter implements JsonDeserializer<EventListResponse> {

    private static final Map<String, Boolean> SUPPORTED_EVENT_TYPES;

    static {
        Map<String, Boolean> supportedEventTypes = new HashMap<>();
        supportedEventTypes.put(EventType.PUSH.name, true);
        supportedEventTypes.put(EventType.PULL_REQUEST.name, true);
        supportedEventTypes.put(EventType.GOLLUM.name, true);
        SUPPORTED_EVENT_TYPES = Collections.unmodifiableMap(supportedEventTypes);
    }

    @Override
    public EventListResponse deserialize(JsonElement json, Type typeOfT,
                                         JsonDeserializationContext context)
            throws JsonParseException {
        List<EventResponse> events = new ArrayList<>();

        JsonArray eventJsonArray = json.getAsJsonArray();
        for (JsonElement eventJsonElement : eventJsonArray) {
            String eventTypeString = ((JsonObject) eventJsonElement).get("type").getAsString();
            Boolean isSupported = SUPPORTED_EVENT_TYPES.get(eventTypeString);
            if (isSupported != null && isSupported) {
                EventResponse event = context.deserialize(eventJsonElement, EventResponse.class);
                events.add(event);
            }
        }

        long obtainedAt = System.currentTimeMillis();
        for (EventResponse event : events) {
            if (event != null) {
                event.setObtainedAt(obtainedAt);
            }
        }

        return new EventListResponse(events);
    }
}
