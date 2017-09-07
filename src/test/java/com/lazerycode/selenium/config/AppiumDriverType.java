package com.lazerycode.selenium.config;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public enum AppiumDriverType implements AppiumDriverSetup {

    ANDROID {
        public DesiredCapabilities getDesiredCapabilities(String pathToAppFile, boolean debug) {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability(MobileCapabilityType.TAKES_SCREENSHOT, true);
            capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.APPIUM);
            capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
            capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7.1");
            capabilities.setCapability(MobileCapabilityType.UDID, System.getProperty("device.id", "DEFAULT_ANDROID_DEVICE_ID"));
            capabilities.setCapability(MobileCapabilityType.APP, pathToAppFile);

            if (debug) {
                capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "3600");
            }

            return capabilities;
        }

        public RemoteWebDriver getWebDriverObject(URL appiumServerURL, DesiredCapabilities capabilities) {

            return new AndroidDriver<>(appiumServerURL, capabilities);
        }
    },
    IPHONE {
        public DesiredCapabilities getDesiredCapabilities(String pathToAppFile, boolean debug) {
            DesiredCapabilities capabilities = DesiredCapabilities.iphone();
            capabilities.setCapability(MobileCapabilityType.TAKES_SCREENSHOT, true);
            capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
            capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.IOS);
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 7");
            capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.1");
            capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
            capabilities.setCapability(MobileCapabilityType.UDID, System.getProperty("device.id", "DEFAULT_IPHONE_DEVICE_ID"));
            capabilities.setCapability(MobileCapabilityType.APP, pathToAppFile);
            capabilities.setCapability(IOSMobileCapabilityType.AUTO_ACCEPT_ALERTS, true);
            capabilities.setCapability(IOSMobileCapabilityType.NATIVE_WEB_TAP, true);
            capabilities.setCapability(IOSMobileCapabilityType.BUNDLE_ID, System.getProperty("bundleID", "BUNDLE_ID"));
            capabilities.setCapability("realDeviceLogger", realDeviceLogger);
            capabilities.setCapability("xcodeConfigFile", getClass().getResource("/appium.xcconfig").getFile());

            if (debug) {
                capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "3600");
            }

            return capabilities;
        }

        public RemoteWebDriver getWebDriverObject(URL appiumServerURL, DesiredCapabilities capabilities) {

            return new IOSDriver<>(appiumServerURL, capabilities);
        }
    },
    IPAD {
        public DesiredCapabilities getDesiredCapabilities(String pathToAppFile, boolean debug) {
            DesiredCapabilities capabilities = DesiredCapabilities.ipad();
            capabilities.setCapability(MobileCapabilityType.TAKES_SCREENSHOT, true);
            capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
            capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.IOS);
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPad");
            capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.1");
            capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
            capabilities.setCapability(MobileCapabilityType.UDID, System.getProperty("device.id", "DEFAULT_IPAD_DEVICE_ID"));
            capabilities.setCapability(MobileCapabilityType.APP, pathToAppFile);
            capabilities.setCapability(IOSMobileCapabilityType.AUTO_ACCEPT_ALERTS, true);
            capabilities.setCapability(IOSMobileCapabilityType.NATIVE_WEB_TAP, true);
            capabilities.setCapability(IOSMobileCapabilityType.BUNDLE_ID, System.getProperty("bundleID", "BUNDLE_ID"));
            capabilities.setCapability("realDeviceLogger", realDeviceLogger);
            capabilities.setCapability("xcodeConfigFile", getClass().getResource("/appium.xcconfig").getFile());

            if (debug) {
                capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "3600");
            }

            return capabilities;
        }

        public RemoteWebDriver getWebDriverObject(URL appiumServerURL, DesiredCapabilities capabilities) {
            return new IOSDriver<>(appiumServerURL, capabilities);
        }
    },
    WINDOWS {
        public DesiredCapabilities getDesiredCapabilities(String pathToAppFile, boolean debug) {
            DesiredCapabilities capabilities = DesiredCapabilities.ipad();
            capabilities.setCapability(MobileCapabilityType.TAKES_SCREENSHOT, true);
            capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.WINDOWS);
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Windows_PC");
            capabilities.setCapability(MobileCapabilityType.APP, pathToAppFile);

            if (debug) {
                capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "3600");
            }

            return capabilities;
        }

        public RemoteWebDriver getWebDriverObject(URL appiumServerURL, DesiredCapabilities capabilities) {
            return new RemoteWebDriver(appiumServerURL, capabilities);
        }
    }
}