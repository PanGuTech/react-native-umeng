package com.demo;

import android.app.Application;
import android.util.Log;

import com.facebook.react.ReactApplication;
import com.pangu.umeng.PanguUmengPackage;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.ReactPackage;
import com.facebook.react.shell.MainReactPackage;
import com.facebook.soloader.SoLoader;
import com.umeng.commonsdk.UMConfigure;

import java.util.Arrays;
import java.util.List;

import static android.content.ContentValues.TAG;

public class MainApplication extends Application implements ReactApplication {
  private static final PanguUmengPackage panguUmengPackage = new PanguUmengPackage();
  public static PanguUmengPackage getPanguUmengPackage(){
    return panguUmengPackage;
  }
  private String appKey = "5be261d9b465f54cd0000212";
  private String channel = "android";
  private String secret = null;

  private final ReactNativeHost mReactNativeHost = new ReactNativeHost(this) {
    @Override
    public boolean getUseDeveloperSupport() {
      return BuildConfig.DEBUG;
    }

    @Override
    protected List<ReactPackage> getPackages() {
      return Arrays.<ReactPackage>asList(
          new MainReactPackage(),
              panguUmengPackage
      );
    }

    @Override
    protected String getJSMainModuleName() {
      return "index";
    }
  };

  @Override
  public ReactNativeHost getReactNativeHost() {
    return mReactNativeHost;
  }

  @Override
  public void onCreate() {
    super.onCreate();

    SoLoader.init(this, /* native exopackage */ false);

    initUmengCommon(appKey,channel,secret);
    setLogEnabled(true);

  }

  /**
   * 初始化common库
   * 参数1:上下文，不能为空
   * 参数2:友盟 app key，非必须参数，如果Manifest文件中已配置app key，该参数可以传空，则使用Manifest中配置的app key，否则该参数必须传入
   * 参数3:友盟 channel，非必须参数，如果Manifest文件中已配置channel，该参数可以传空，则使用Manifest中配置的channel，否则该参数必须传入，channel命名请详见channel渠道命名规范
   * 参数4:设备类型，UMConfigure.DEVICE_TYPE_PHONE为手机、UMConfigure.DEVICE_TYPE_BOX为盒子，默认为手机
   * 参数5:Push推送业务的secret，需要集成Push功能时必须传入Push的secret，否则传空
   */
  public void initUmengCommon(String appKey,String channel,String secret){
    UMConfigure.init(this, appKey, channel, UMConfigure.DEVICE_TYPE_PHONE, secret);
  }
  /**
   * 设置组件化的Log开关
   * 参数: boolean 默认为false，如需查看LOG设置为true
   */
  public void setLogEnabled(boolean logEnabled){
    UMConfigure.setLogEnabled(logEnabled);
  }
}
