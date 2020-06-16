import 'dart:async';

import 'package:flutter/services.dart';

class FlutterTheoremreach {
  static const MethodChannel _channel =
  const MethodChannel('theoremreach');

  Future<void> init({String apiToken, String userId}) async {
    assert(apiToken != null && apiToken.isNotEmpty);
    return _channel.invokeMethod("init", <String, dynamic>{
      "api_token": apiToken,
      "user_id": userId
    });
  }

  Future<void> show() {
    return _channel.invokeMethod("show");
  }

  Future<void> setNavBarText({String text}) {
    return _channel.invokeMethod('setNavBarText', <String, dynamic>{
      'text': text
    });
  }

  Future<void> setNavBarColor({String color}) {
    return _channel.invokeMethod('setNavBarColor', <String, dynamic>{
      'color': color
    });
  }

  Future<void> setNavBarTextColor({String textColor}) {
    return _channel.invokeMethod('setNavBarTextColor', <String, dynamic>{
      'text_color': textColor
    });
  }
}
