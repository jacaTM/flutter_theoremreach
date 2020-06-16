# fluttertheoremreach

Non-official Flutter plugin for Theorem Reach.
Feel free to help :)

## Getting Started
Initialize the TheoremReach plugin with a API token and a User ID.

```dart
FlutterTheoremreach().init(apiToken: 'yourtoken', userId: 'youruserid');
```
## Show Panel

```dart
FlutterTheoremreach().show();
```
## Customize Panel

Set Navigation Bar text
```dart
FlutterTheoremreach().setNavBarText(text: 'yourtext');
```
Set Navigation Bar color
```dart
FlutterTheoremreach().setNavBarColor(color: 'hexcolor');
```
Set Navigation Bar text color
```dart
FlutterTheoremreach().setNavBarTextColor(textColor: 'hexcolor');
```