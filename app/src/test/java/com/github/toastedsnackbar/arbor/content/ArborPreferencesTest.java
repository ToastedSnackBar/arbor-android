package com.github.toastedsnackbar.arbor.content;

import com.github.toastedsnackbar.arbor.ArborTestRunner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(ArborTestRunner.class)
public class ArborPreferencesTest {

    private ArborPreferences mPreferences;

    @Before
    public void setup() {
        mPreferences = ArborPreferences.getInstance();
    }

    @After
    public void teardown() {
        mPreferences = null;
    }

    @Test
    public void username_shouldPersistValue() {
        mPreferences.setUsername("username");
        assertThat(mPreferences.getUsername()).isEqualTo("username");
    }

    @Test
    public void accessToken_shouldPersistValue() {
        mPreferences.setAccessToken("access_token");
        assertThat(mPreferences.getAccessToken()).isEqualTo("access_token");
    }
}