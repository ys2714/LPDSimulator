# Liquid Presence Detect Dialog Simulator

provide a way to simulate liquid presence detect dialog for test

## How to use

1. install the LPDSimulator app
2. open your app
3. run following ADB command to trigger dialog
4. debug your app behavior
```
adb shell am start -n com.zebra.lpdsimulator/.FullscreenActivity
```

## Why I need this ?

- depends on how the LPD dialog is implemented, we don't know whether it's pop-up will affect underlying app, we are not sure whether onPause and onResume will be called. If you don't test this rare case, it may cause bugs of your app.
- put water into USB-C port will bring risk of broke the device, and also if you want to test it repeatedly, you have to wait the USB-C port dry out.