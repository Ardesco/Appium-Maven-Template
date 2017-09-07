package com.lazerycode.selenium.config;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public interface AppiumDriverSetup {

    String realDeviceLogger = "src/test/node_modules/deviceconsole/deviceconsole";

    RemoteWebDriver getWebDriverObject(URL appiumServerURL, DesiredCapabilities desiredCapabilities);

    DesiredCapabilities getDesiredCapabilities(String pathToAppFile, boolean debug);
}