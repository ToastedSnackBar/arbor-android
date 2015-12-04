package com.github.toastedsnackbar.arbor.net.responses.events;

import com.github.toastedsnackbar.arbor.ArborTestConstants.MockResponses;
import com.github.toastedsnackbar.arbor.ArborTestRunner;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.typeadapters.RuntimeTypeAdapterFactory;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(ArborTestRunner.class)
public class PushEventResponseTest {

    @Ignore
    @Test
    public void gson_shouldParseCorrectly() {
        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapterFactory(RuntimeTypeAdapterFactory.of(
                EventPayloadResponse.class));
        Gson gson = builder.create();

        EventResponse response = gson.fromJson(MockResponses.EVENT_PUSH, EventResponse.class);

        assertThat(response).isNotNull();
        assertThat(response.getId()).isEqualTo("1");
    }
}
