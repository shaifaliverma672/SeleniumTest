# Entrata Automation Test Suite

## Overview

This test suite provides basic automation for the Entrata website using Selenium. It includes tests for various functionalities such as navigating to different pages, clicking buttons, and interacting with input fields.

## Prerequisites

- [Java](https://www.oracle.com/java/technologies/javase-downloads.html)
- [JUnit](https://junit.org/junit5/)
- [Selenium WebDriver](https://www.selenium.dev/documentation/en/webdriver/)

## Setup

1. **Clone the Repository:**
   ```bash
   git clone <repository-url>
   cd EntrataAutomationTest
   
## Download ChromeDriver:
Download the appropriate ChromeDriver version from here(https://googlechromelabs.github.io/chrome-for-testing/), 
Set the path in the setUp method of EntrataAutomationTest class.
System.setProperty("webdriver.chrome.driver", "path/to/chromedriver.exe");

## Run Tests:
Execute the tests using your preferred IDE or build tool.

## Test Cases
1. testHomePageTitle
Verifies that the home page title matches the expected title.

2. testClickToWatchDemo
Clicks the "Watch Demo" button and verifies that the resulting page title matches the expected title.

3. testToOpenUpSignInPage
Opens the sign-in page, clicks on "Property Manager Login," and ensures that the page title changes accordingly.

4. testScheduleADemo
Clicks the "Schedule Demo" button, fills in necessary details, and clicks the "Schedule Demo" button on the new page.

5. testToacceptCookies
Checks for the presence of a cookies popup, accepts cookies if present, and verifies the resulting page title.

## Utilities
isCookiesPopupPresent: Checks if the cookies popup is present.
acceptCookies: Accepts cookies by clicking the corresponding button.

## Teardown
The WebDriver is automatically closed after each test case execution.

## Contributors
Shaifali Verma
