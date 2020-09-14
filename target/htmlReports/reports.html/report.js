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
  "duration": 54000550,
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
  "comments": [
    {
      "line": 5,
      "value": "# Given launches the application in \"chrome\""
    }
  ],
  "line": 6,
  "name": "launches the application",
  "keyword": "Given "
});
formatter.step({
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
  "location": "LandingSteps.launch_browser()"
});
formatter.result({
  "duration": 15842060109,
  "status": "passed"
});
formatter.match({
  "location": "LandingSteps.visiblitity_of_logo()"
});
formatter.result({
  "duration": 10477443,
  "error_message": "org.openqa.selenium.NoSuchSessionException: Session ID is null. Using WebDriver after calling quit()?\nBuild info: version: \u00273.12.0\u0027, revision: \u00277c6e0b3\u0027, time: \u00272018-05-08T14:04:26.12Z\u0027\nSystem info: host: \u0027WKMIN8949685\u0027, ip: \u00272405:201:5c0b:b828:797d:105b:57e9:75b2%en0\u0027, os.name: \u0027Mac OS X\u0027, os.arch: \u0027x86_64\u0027, os.version: \u002710.14.6\u0027, java.version: \u002714.0.2\u0027\nDriver info: driver.version: RemoteWebDriver\n\tat org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:125)\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:543)\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:317)\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElementByClassName(RemoteWebDriver.java:403)\n\tat org.openqa.selenium.By$ByClassName.findElement(By.java:389)\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:309)\n\tat org.openqa.selenium.support.pagefactory.DefaultElementLocator.findElement(DefaultElementLocator.java:69)\n\tat org.openqa.selenium.support.pagefactory.internal.LocatingElementHandler.invoke(LocatingElementHandler.java:38)\n\tat com.sun.proxy.$Proxy22.isDisplayed(Unknown Source)\n\tat Pages.LandingPage.verifyLogo(LandingPage.java:56)\n\tat StepDefinations.LandingSteps.visiblitity_of_logo(LandingSteps.java:41)\n\tat ✽.Then user verifies visiblitity of logo(applicationlanding.feature:7)\n",
  "status": "failed"
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
  "duration": 772207,
  "status": "passed"
});
});