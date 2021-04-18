package com.cathal.iterableproject;

import android.app.Application;
import android.content.res.Configuration;

import com.iterable.iterableapi.IterableApi;
import com.iterable.iterableapi.IterableConfig;

public class MainApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        IterableConfig config = new IterableConfig.Builder().build();
        IterableApi.initialize(this, "349dcc9373c74c6699c5d1204a271695", config);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }
}
