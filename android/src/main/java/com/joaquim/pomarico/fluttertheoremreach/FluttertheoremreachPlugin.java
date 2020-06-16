package com.joaquim.pomarico.fluttertheoremreach;

import android.app.Activity;

import androidx.annotation.NonNull;

import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import theoremreach.com.theoremreach.TheoremReach;

/** FluttertheoremreachPlugin */
public class FluttertheoremreachPlugin implements FlutterPlugin, MethodCallHandler, ActivityAware {
  /// The MethodChannel that will the communication between Flutter and native Android
  ///
  /// This local reference serves to register the plugin with the Flutter Engine and unregister it
  /// when the Flutter Engine is detached from the Activity
  private MethodChannel channel;
  private Activity activity;

  @Override
  public void onAttachedToEngine(@NonNull FlutterPluginBinding flutterPluginBinding) {
    channel = new MethodChannel(flutterPluginBinding.getFlutterEngine().getDartExecutor(), "theoremreach");
    channel.setMethodCallHandler(this);
  }

  private void extractTheoremReachParams(MethodCall call, Result result){
    String api_token = null;
    if(call.argument("api_token")!=null){
      api_token = call.argument("api_token");
    }else{
      result.error("no_api_token", "a null api token was provided", null);
      return;
    }
    String user_id = null;
    if(call.argument("user_id")!=null){
      user_id = call.argument("user_id");
    }
    TheoremReach.initWithApiKeyAndUserIdAndActivityContext(api_token,user_id,activity);
  }

  @Override
  public void onMethodCall(@NonNull MethodCall call, @NonNull Result result) {
    if (call.method.equals("init")) {
      extractTheoremReachParams(call,result);
    } else if (call.method.equals("show")) {
      TheoremReach.getInstance().showRewardCenter();
    }else if(call.method.equals("setNavBarText")){
      String text = call.argument("text");
      TheoremReach.getInstance().setNavigationBarText(text);
    }else if(call.method.equals("setNavBarColor")){
      String color = call.argument("color");
      TheoremReach.getInstance().setNavigationBarColor(color);
    }else if(call.method.equals("setNavBarTextColor")){
      String textColor = call.argument("text_color");
      TheoremReach.getInstance().setNavigationBarTextColor(textColor);
    }
    else {
      result.notImplemented();
    }
  }

  @Override
  public void onDetachedFromEngine(@NonNull FlutterPluginBinding binding) {
    channel.setMethodCallHandler(null);
  }

  @Override
  public void onAttachedToActivity(@NonNull ActivityPluginBinding activityPluginBinding) {
    activity = activityPluginBinding.getActivity();
  }

  @Override
  public void onDetachedFromActivityForConfigChanges() {

  }

  @Override
  public void onReattachedToActivityForConfigChanges(@NonNull ActivityPluginBinding activityPluginBinding) {

  }

  @Override
  public void onDetachedFromActivity() {

  }
}
