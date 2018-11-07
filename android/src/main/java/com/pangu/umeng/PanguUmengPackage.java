package com.pangu.umeng;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.JavaScriptModule;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class PanguUmengPackage implements ReactPackage {
    public PanguUmengModule panguUmengModule ;
    @Override
    public List<NativeModule> createNativeModules(ReactApplicationContext reactContext) {
        panguUmengModule = new PanguUmengModule(reactContext);
        List<NativeModule> list = new ArrayList<>();
        list.add(panguUmengModule);
        return list;
    }

    public List<Class<? extends JavaScriptModule>> createJSModules() {
        return Collections.emptyList();
    }

    @Override
    public List<ViewManager> createViewManagers(ReactApplicationContext reactContext) {
        return Collections.emptyList();
    }
}
