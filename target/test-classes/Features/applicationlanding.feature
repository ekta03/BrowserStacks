@smoketest
@landingPage
Feature: feature to navigate to Canada Roots Webpage
  Scenario: Check if user is able to navigate to Canada roots Webpage
    Given launches the application
    Then user verifies visiblitity of logo
    Then user verifies welcome message present on landing page
    And user clicks on "CANADA ENGLISH" button
    Then user verifies if all menuItems are present
    | NEW FOR MAY | WOMEN | MEN | KIDS | SWEATS | LEATHER | FOOTWEAR | ABOUT US | SALE |
    Then user hovers on "WOMEN" menuItem
    Then user hovers and click on "KIDS" menuItem
    And user close alert popup
    Then user closes the browser