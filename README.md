Mobile Appium Tests
===================

### What do I need?

This should download everything for you, but the following may be useful anyway:

- Appium Desktop - https://github.com/appium/appium-desktop/releases/latest 
- Android Studio (Allows you to install SDK and Emulators) - https://developer.android.com/studio/index.html
- XCode - https://developer.apple.com/xcode/

### How do I get a device ID?

## Android

Assuming you have downloaded the Android SDK, type ```adb devices``` in your console

## IOS

On iOS you can get your phones UDID by using ios-deploy.  If you want to download ios-deploy globally you will need to have node and NPM installed, then run:

    npm install -g ios-deploy
    
iOS deploy requires an iOS development certificate so it's not pulle down by default.  If you want it to be brought down as part of a build you can add it to the packages.json.  If you do that you can use it with the following command:
    
    ${project.basedir}/src/test/node_modules/ios-deploy/build/Release/ios-deploy -l    

### How do I run tests?

- If you want to start up an appium server as part of the build use the `invokeAppium` switch

        mvn clean verify -DinvokeAppium -Ddevice.id=<DEVICE_ID_NOTED_DOWN_ABOVE>
        
- If you want to connect to an already running appium server running on the default URL/Port you can use
        
        mvn clean verify -Ddevice.id=<DEVICE_ID_NOTED_DOWN_ABOVE>
        
- If you want to specify a specific Appium server you can use:

        mvn clean verify -DappiumServerURL=http://127.0.0.1:4723/wd/hub -Ddevice.id=<DEVICE_ID_NOTED_DOWN_ABOVE>        
        
                
### Anything else?

Yes you can specify which device type to use by using one of the following switches:

- `-Ddevice=iphone`
- `-Ddevice=ipad`
- `-Ddevice=android`
- `-Ddevice=windows`

If the tests fail screenshots will be saved in ${project.basedir}/target/screenshots

# Supported System Properties

- `pathToAppFile` - The location of the .ipa/.apk file to use in testing
- `device.id` - The device ID of a real device to run tests against (If it is an iOS device, this must be registered in your iOS developer account)
- `enableDebugMode` - Will set the Appium timeout to 1 hour so that the server doesn't close down while you are trying to debug your tests

# Selenium Grid support

- `remoteDriver` - Connect to a selenium Grid (e.g. Sauce Labs).
- `gridURL` - URL for the selenium grid you want to connect to.
- `appiumVersion` - The version of Appium required to run the tests

# Additional information for setting up iOS Devices

Read https://github.com/appium/appium-xcuitest-driver for XCUITest support, the brew commands below have been taken from their README.md.

    brew install libimobiledevice --HEAD
    brew install carthage

If things don't work, check https://github.com/appium/appium-xcuitest-driver to see if anything has changed

You will need to place a appium.xcconfig in the `${project.basedir}/src/test/resources` directory.

Devices used for performing tests need to be added to https://developer.apple.com/account/ios/device/
Machines running tests will need to download a test certificate from https://developer.apple.com/account/ios/certificate/development (Do this via Xcode)

In iOS8, devices each have their own setting which enables or disables UIAutomation, It lives in the “Developer” view in the Settings app. You need to verify that UIAutomation is enabled in this view before the simulator or device can be used.