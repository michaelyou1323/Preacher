package com.michaelyou2000.myapp3;

import android.app.Application;

import com.cloudinary.android.MediaManager;

import java.util.HashMap;
import java.util.Map;

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Map<String, String> config = new HashMap<>();
        config.put("cloud_name", "dwgofgamw");
        config.put("api_key", "453621296392954");
        config.put("api_secret", "1eUa4LQ2G7yKirgbOqSKa2VlTY4");
        MediaManager.init(this, config);
    }
}