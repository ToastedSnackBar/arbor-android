package com.github.toastedsnackbar.arbor.net.gson;

import com.github.toastedsnackbar.arbor.net.responses.ActorResponse;
import com.github.toastedsnackbar.arbor.net.responses.OrganizationResponse;
import com.github.toastedsnackbar.arbor.net.responses.RepoResponse;
import com.github.toastedsnackbar.arbor.net.responses.events.EventPayloadResponse;
import com.github.toastedsnackbar.arbor.net.responses.events.EventResponse;
import com.github.toastedsnackbar.arbor.net.responses.events.EventType;
import com.github.toastedsnackbar.arbor.net.responses.events.PullRequestEventPayloadResponse;
import com.github.toastedsnackbar.arbor.net.responses.events.PushEventPayloadResponse;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

public class EventTypeAdapter implements JsonDeserializer<EventResponse> {

    @Override
    public EventResponse deserialize(JsonElement json, Type typeOfT,
                                     JsonDeserializationContext context)
            throws JsonParseException {
        JsonObject eventJsonObject = (JsonObject) json;

        String id = eventJsonObject.get("id").getAsString();
        EventType eventType = context.deserialize(eventJsonObject.get("type"), EventType.class);
        boolean isPublic = eventJsonObject.get("public").getAsBoolean();
        JsonElement payloadJsonElement = eventJsonObject.get("payload");
        RepoResponse repo = context.deserialize(eventJsonObject.get("repo"), RepoResponse.class);
        ActorResponse actor = context.deserialize(eventJsonObject.get("actor"),
                ActorResponse.class);
        OrganizationResponse org = context.deserialize(eventJsonObject.get("org"),
                OrganizationResponse.class);
        String createdAt = eventJsonObject.get("created_at").getAsString();

        Class<? extends EventPayloadResponse> payloadClass;
        switch (eventType) {
            case PUSH:
                payloadClass = PushEventPayloadResponse.class;
                break;

            case PULL_REQUEST:
                payloadClass = PullRequestEventPayloadResponse.class;
                break;

            default:
                return null;
        }

        EventPayloadResponse payload = context.deserialize(payloadJsonElement, payloadClass);

        return new EventResponse(id, eventType, isPublic, payload, repo, actor, org, createdAt);
    }
}
