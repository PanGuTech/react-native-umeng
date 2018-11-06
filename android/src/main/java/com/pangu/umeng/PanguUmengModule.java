package com.pangu.umeng;

import android.util.Log;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

public class PanguUmengModule extends ReactContextBaseJavaModule {
    public PanguUmengModule(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return "PanguUmeng";
    }

    @ReactMethod
    public void setAppkeyAndChannelId(String key,String channelId) {
        Log.i("setAppkeyAndChannelId", key);
    }

    @ReactMethod
    public void beginLogPageView(String pageName) {
        Log.i("beginLogPageView", pageName);
    }

    @ReactMethod
    public void endLogPageView(String pageName) {
        Log.i("endLogPageView", pageName);
    }
}
