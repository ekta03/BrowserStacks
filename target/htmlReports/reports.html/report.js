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
  "duration": 78505366,
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
  "name": "launches the application",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "user verifies visiblitity of logo",
  "keyword": "Then "
});
formatter.step({
  "line": 7,
  "name": "user verifies welcome message present on landing page",
  "keyword": "Then "
});
formatter.step({
  "line": 8,
  "name": "user clicks on \"CANADA ENGLISH\" button",
  "keyword": "And "
});
formatter.step({
  "line": 9,
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
      "line": 10
    }
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 11,
  "name": "user hovers on \"WOMEN\" menuItem",
  "keyword": "Then "
});
formatter.step({
  "line": 12,
  "name": "user hovers and click on \"KIDS\" menuItem",
  "keyword": "Then "
});
formatter.step({
  "line": 13,
  "name": "user close alert popup",
  "keyword": "And "
});
formatter.step({
  "line": 14,
  "name": "user closes the browser",
  "keyword": "Then "
});
formatter.match({
  "location": "LandingSteps.launch_browser()"
});
formatter.result({
  "duration": 12516477227,
  "status": "passed"
});
formatter.match({
  "location": "LandingSteps.visiblitity_of_logo()"
});
formatter.result({
  "duration": 44779421,
  "status": "passed"
});
formatter.match({
  "location": "LandingSteps.validate_welcomeMessage()"
});
formatter.result({
  "duration": 21455135,
  "status": "passed"
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
  "duration": 7591841031,
  "status": "passed"
});
formatter.match({
  "location": "LandingSteps.selectMenuItem(String\u003e\u003e)"
});
formatter.result({
  "duration": 963967570,
  "status": "passed"
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
  "duration": 383235129,
  "status": "passed"
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
  "duration": 9619950764,
  "status": "passed"
});
formatter.match({
  "location": "LandingSteps.cancelPopup()"
});
formatter.result({
  "duration": 961401540,
  "status": "passed"
});
formatter.match({
  "location": "LandingSteps.closeBrowser()"
});
formatter.result({
  "duration": 140060990,
  "status": "passed"
});
formatter.after({
  "duration": 444323,
  "status": "passed"
});
});