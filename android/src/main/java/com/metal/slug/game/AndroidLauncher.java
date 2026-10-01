package com.metal.slug.game;

import android.os.Bundle;
import android.util.Log;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;

public class AndroidLauncher extends AndroidApplication {
    private static final String TAG = "MetalSlugAndroidLauncher";
    
    @Override
    protected void onCreate (Bundle savedInstanceState) {
        Log.d(TAG, "Starting Metal Slug Game Android Launcher");
        try {
            AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
            config.useGL30 = false;
            Log.d(TAG, "About to initialize Game class");
            initialize(new Game(), config);
            Log.d(TAG, "Game initialized successfully");
        } catch (Exception e) {
            Log.e(TAG, "Error during initialization: " + e.getMessage(), e);
            throw new RuntimeException("Failed to initialize Metal Slug Game", e);
        }
    }
}