package com.github.toastedsnackbar.arbor.content;

import com.github.toastedsnackbar.arbor.ArborTestRunner;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(ArborTestRunner.class)
public class ArborPreferencesTest {

    @Test
    public void username_shouldPersistValue() {
        ArborPreferences.setUsername("username");
        assertThat(ArborPreferences.getUsername()).isEqualTo("username");
    }

    @Test
    public void accessToken_shouldPersistValue() {
        ArborPreferences.setAccessToken("access_token");
        assertThat(ArborPreferences.getAccessToken()).isEqualTo("access_token");
    }
}