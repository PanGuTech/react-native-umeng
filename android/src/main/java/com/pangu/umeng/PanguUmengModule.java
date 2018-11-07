package com.pangu.umeng;

import android.content.Context;
import android.util.Log;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.umeng.analytics.MobclickAgent;

import static android.content.ContentValues.TAG;

public class PanguUmengModule extends ReactContextBaseJavaModule {
    private Context context;
    public PanguUmengModule(ReactApplicationContext reactContext) {
        super(reactContext);
        this.context = reactContext.getBaseContext();
    }

    @Override
    public String getName() {
        return "PanguUmengModule";
    }


    @ReactMethod
    public void onResume(){
        MobclickAgent.onResume(context);
    }

    @ReactMethod
    public void onPause(){
        MobclickAgent.onPause(context);
    }


    @ReactMethod
    public void test(String msg){
        Log.i(TAG, "test: 测试数据会不会出来"+msg);
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
