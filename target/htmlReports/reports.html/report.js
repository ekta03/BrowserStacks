$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("applicationlanding.feature");
formatter.feature({
  "line": 3,
  "name": "feature to navigate to Canada Roots Webpage",
  "description": "",
  "id": "feature-to-navigate-to-canada-roots-webpage",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@smoketest"
    },
    {
      "line": 2,
      "name": "@landingPage"
    }
  ]
});
formatter.before({
  "duration": 54480483,
  "status": "passed"
});
formatter.scenario({
  "line": 4,
  "name": "Check if user is able to navigate to Canada roots Webpage",
  "description": "",
  "id": "feature-to-navigate-to-canada-roots-webpage;check-if-user-is-able-to-navigate-to-canada-roots-webpage",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 5,
  "name": "launches the application in \"chrome\"",
  "keyword": "Given "
});
formatter.step({
  "comments": [
    {
      "line": 6,
      "value": "# Given launches the application"
    }
  ],
  "line": 7,
  "name": "user verifies visiblitity of logo",
  "keyword": "Then "
});
formatter.step({
  "line": 8,
  "name": "user verifies welcome message present on landing page",
  "keyword": "Then "
});
formatter.step({
  "line": 9,
  "name": "user clicks on \"CANADA ENGLISH\" button",
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "user verifies if all menuItems are present",
  "rows": [
    {
      "cells": [
        "NEW FOR MAY",
        "WOMEN",
        "MEN",
        "KIDS",
        "SWEATS",
        "LEATHER",
        "FOOTWEAR",
        "ABOUT US",
        "SALE"
      ],
      "line": 11
    }
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 12,
  "name": "user hovers on \"WOMEN\" menuItem",
  "keyword": "Then "
});
formatter.step({
  "line": 13,
  "name": "user hovers and click on \"KIDS\" menuItem",
  "keyword": "Then "
});
formatter.step({
  "line": 14,
  "name": "user close alert popup",
  "keyword": "And "
});
formatter.step({
  "line": 15,
  "name": "user closes the browser",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "chrome",
      "offset": 29
    }
  ],
  "location": "LandingSteps.launch_browser(String)"
});
formatter.result({
  "duration": 3279269280,
  "error_message": "org.openqa.selenium.WebDriverException: unknown error: cannot determine loading status\nfrom unknown error: cannot determine loading status\nfrom disconnected: Unable to receive message from renderer\n  (Session info: chrome\u003d85.0.4183.102)\nBuild info: version: \u00273.12.0\u0027, revision: \u00277c6e0b3\u0027, time: \u00272018-05-08T14:04:26.12Z\u0027\nSystem info: host: \u0027WKMIN8949685\u0027, ip: \u00272405:201:5c0b:b828:797d:105b:57e9:75b2%en0\u0027, os.name: \u0027Mac OS X\u0027, os.arch: \u0027x86_64\u0027, os.version: \u002710.14.6\u0027, java.version: \u002714.0.2\u0027\nDriver info: org.openqa.selenium.chrome.ChromeDriver\nCapabilities {acceptInsecureCerts: false, browserName: chrome, browserVersion: 85.0.4183.102, chrome: {chromedriverVersion: 84.0.4147.30 (48b3e868b4cc0..., userDataDir: /var/folders/2m/kt9m8w_s6zs...}, goog:chromeOptions: {debuggerAddress: localhost:63167}, javascriptEnabled: true, networkConnectionEnabled: false, pageLoadStrategy: normal, platform: MAC, platformName: MAC, proxy: Proxy(), setWindowRect: true, strictFileInteractability: false, timeouts: {implicit: 0, pageLoad: 300000, script: 30000}, unhandledPromptBehavior: dismiss and notify, webauthn:virtualAuthenticators: true}\nSession ID: 2fd6f293ca7904472b186e2faa286bc6\n\tat java.base/jdk.internal.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\n\tat java.base/jdk.internal.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:62)\n\tat java.base/jdk.internal.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)\n\tat java.base/java.lang.reflect.Constructor.newInstanceWithCaller(Constructor.java:500)\n\tat java.base/java.lang.reflect.Constructor.newInstance(Constructor.java:481)\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.createException(W3CHttpResponseCodec.java:187)\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:122)\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:49)\n\tat org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:158)\n\tat org.openqa.selenium.remote.service.DriverCommandExecutor.execute(DriverCommandExecutor.java:83)\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:543)\n\tat org.openqa.selenium.remote.RemoteWebDriver.get(RemoteWebDriver.java:271)\n\tat org.openqa.selenium.remote.RemoteWebDriver$RemoteNavigation.to(RemoteWebDriver.java:848)\n\tat Pages.BasePage.getDriver(BasePage.java:151)\n\tat StepDefinations.LandingSteps.launch_browser(LandingSteps.java:30)\n\tat ✽.Given launches the application in \"chrome\"(applicationlanding.feature:5)\n",
  "status": "failed"
});
formatter.match({
  "location": "LandingSteps.visiblitity_of_logo()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "LandingSteps.validate_welcomeMessage()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "CANADA ENGLISH",
      "offset": 16
    }
  ],
  "location": "LandingSteps.selectCountry(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "LandingSteps.selectMenuItem(String\u003e\u003e)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "WOMEN",
      "offset": 16
    }
  ],
  "location": "LandingSteps.hoversOnMenuItem(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "KIDS",
      "offset": 26
    }
  ],
  "location": "LandingSteps.hoversandClilckItem(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "LandingSteps.cancelPopup()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "LandingSteps.closeBrowser()"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "duration": 82352916,
  "status": "passed"
});
});