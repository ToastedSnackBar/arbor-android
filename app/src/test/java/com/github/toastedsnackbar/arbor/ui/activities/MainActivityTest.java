package com.github.toastedsnackbar.arbor.ui.activities;

import android.widget.TextView;

import com.github.toastedsnackbar.arbor.ArborTestRunner;
import com.github.toastedsnackbar.arbor.R;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.util.ActivityController;

import static org.assertj.android.api.Assertions.assertThat;

@RunWith(ArborTestRunner.class)
public class MainActivityTest {

    private MainActivity mActivity;
    private ActivityController<MainActivity> mActivityController;

    @Before
    public void setup() {
        mActivityController = Robolectric.buildActivity(MainActivity.class);
        mActivity = mActivityController.create().start().resume().visible().get();
    }

    @After
    public void teardown() {
        mActivityController.pause().stop().destroy();
        mActivityController = null;
        mActivity = null;
    }

    @Test
    public void onCreate_textViewShouldSayHelloWorld() {
        TextView textView = (TextView) mActivity.findViewById(R.id.text_view);
        assertThat(textView).hasText(R.string.hello_world);
    }
}
