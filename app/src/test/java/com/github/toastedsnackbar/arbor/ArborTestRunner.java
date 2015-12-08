package com.github.toastedsnackbar.arbor;

import android.support.design.widget.Snackbar;

import org.junit.runners.model.InitializationError;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.internal.bytecode.InstrumentationConfiguration;
import org.robolectric.internal.bytecode.ShadowMap;
import org.robolectric.manifest.AndroidManifest;
import org.robolectric.res.Fs;

import java.io.File;
import java.io.IOException;

public class ArborTestRunner extends RobolectricGradleTestRunner {

    private static final int MAX_SDK_LEVEL = 21;

    private static final String PROJECT_DIR = getProjectDirectory();
    private static final String MANIFEST_DIR = PROJECT_DIR + "src/main/AndroidManifest.xml";
    private static final String RES_DIR = PROJECT_DIR + "build/intermediates/res/merged/debug";
    private static final String ASSETS_DIR = PROJECT_DIR + "build/intermediates/assets/debug";

    public ArborTestRunner(Class<?> c) throws InitializationError {
        super(c);
    }

    @Override
    protected AndroidManifest getAppManifest(Config config) {
        return getAppManifest();
    }

    @Override
    public InstrumentationConfiguration createClassLoaderConfig() {
        InstrumentationConfiguration.Builder builder = InstrumentationConfiguration.newBuilder();
        builder.addInstrumentedClass(Snackbar.class.getName());

        return builder.build();
    }

    private static String getProjectDirectory() {
        String path = "";

        try {
            File file = new File("..");
            path = file.getCanonicalPath();
            path += "/app/";
        } catch (IOException e) {
            e.printStackTrace();
        }

        return path;
    }

    private static AndroidManifest getAppManifest() {
        return new AndroidManifest(Fs.fileFromPath(MANIFEST_DIR), Fs.fileFromPath(RES_DIR),
                Fs.fileFromPath(ASSETS_DIR)) {

            @Override
            public int getTargetSdkVersion() {
                return MAX_SDK_LEVEL;
            }
        };
    }
}
