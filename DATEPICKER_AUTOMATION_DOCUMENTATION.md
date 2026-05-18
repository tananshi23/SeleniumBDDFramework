# DatePicker Automation - Documentation

## Overview
This documentation covers the DatePicker widget automation for the TutorialsPoint Selenium Practice website. The automation includes navigating to the DatePicker widget and testing both "Select Date" and "Select Date and Time" functionalities.

---

## Files Created

### 1. Feature File: `DatePicker.feature`
**Location:** `src/test/resources/appFeatures/DatePicker.feature`

Contains 4 test scenarios:
- **Scenario 1:** Navigate to DatePicker widget and verify page is displayed
- **Scenario 2:** Select date from the Select Date picker
- **Scenario 3:** Select date and time from the Date and Time picker
- **Scenario 4:** Navigate through months in the calendar and select date

All scenarios are tagged with `@Regression` and `@smoke` for easy test execution.

### 2. Page Object Class: `DatePicker.java`
**Location:** `src/main/java/pageObjects/DatePicker.java`

#### Key Components:

**XPaths and Locators:**
- `widgetsMenu` - Locates the Widgets menu item
- `datePickerOption` - Locates the DatePicker option in Widgets
- `selectDateInput` - Select Date input field (ID: datePickerMonthYearInput)
- `selectDateTimeInput` - Select Date and Time input field (ID: dateTimePickerInput)
- `calendarNextButton` - Calendar next month navigation button
- `calendarPrevButton` - Calendar previous month navigation button
- Time input fields for hours and minutes

**Key Methods:**

1. **`navigateToWidgetsMenu()`**
   - Clicks on the Widgets menu item on the main page
   - Uses WebDriverWait with ExpectedConditions.elementToBeClickable()

2. **`clickOnDatePickerOption()`**
   - Clicks on the DatePicker option within Widgets menu

3. **`isDatePickerPageDisplayed()`**
   - Verifies both Select Date and Select Date & Time input fields are visible
   - Returns boolean value

4. **`clickOnSelectDateField()`**
   - Opens the Select Date calendar picker

5. **`clickOnSelectDateTimeField()`**
   - Opens the Select Date and Time calendar picker

6. **`selectDateFromCalendar(String date)`**
   - Selects a specific date from the calendar
   - Parameter: date number (e.g., "25")
   - Handles disabled and outside-month dates

7. **`selectDateAndTime(String date, String time)`**
   - Selects both date and time
   - Parameters: 
     - date: Day number (e.g., "20")
     - time: Time in HH:mm format (e.g., "14:30")
   - Handles fallback for different time input implementations

8. **`navigateToNextMonth()`**
   - Clicks the next month button in the calendar
   - Includes wait for calendar to update

9. **`navigateToPreviousMonth()`**
   - Clicks the previous month button in the calendar

10. **`getSelectedDate()`**
    - Returns the value of the Select Date field as string
    - Used for assertions

11. **`getSelectedDateTime()`**
    - Returns the value of the Select Date and Time field as string

12. **`isDateSelected()` and `isDateTimeSelected()`**
    - Verify if date/datetime was successfully selected
    - Returns boolean

#### Features:
- Implements WebDriverWait with 10-second timeout for all interactions
- Uses explicit waits instead of implicit waits
- Includes try-catch blocks for error handling
- Thread.sleep() included where calendar animations occur
- Handles multiple time input implementations

### 3. Step Definitions: `DatePickerSteps.java`
**Location:** `src/test/java/stepDefs/DatePickerSteps.java`

#### Implemented Step Definitions:

1. **`@Given("user opens the browser")`**
   - Browser initialization is handled by Hooks
   - Simply logs that browser is opened

2. **`@And("user navigates to {string}")`**
   - Takes URL as parameter
   - Uses driver.navigate().to(url)

3. **`@When("user navigates to Widgets menu")`**
   - Calls datePickerPage.navigateToWidgetsMenu()

4. **`@And("user clicks on DatePicker option")`**
   - Calls datePickerPage.clickOnDatePickerOption()

5. **`@Then("user verifies DatePicker page is displayed")`**
   - Asserts DatePicker page is displayed
   - Throws AssertionError if page not found

6. **`@When("user clicks on Select Date input field")`**
   - Opens the Select Date picker

7. **`@And("user selects date {string} from the calendar")`**
   - Takes date as parameter and selects it

8. **`@Then("user verifies selected date is displayed in Select Date field")`**
   - Asserts that a date was selected
   - Retrieves and logs the selected date

9. **`@When("user clicks on Select Date and Time input field")`**
   - Opens the Date and Time picker

10. **`@And("user selects date {string} and time {string} from the date time picker")`**
    - Takes date and time as parameters
    - Example: date="20", time="14:30"

11. **`@Then("user verifies selected date and time is displayed in Select Date and Time field")`**
    - Asserts date and time were selected
    - Logs the selected datetime value

12. **`@And("user navigates to next month in calendar")`**
    - Navigates to the next month

13. **`@Then("user verifies selected date with next month is displayed in Select Date field")`**
    - Verifies date selection works across month navigation

---

## Test Execution

### Run All DatePicker Tests:
```bash
mvn test -Dcucumber.filter.tags="@DatePicker"
```

### Run Only Smoke Tests:
```bash
mvn test -Dcucumber.filter.tags="@smoke"
```

### Run Via TestRunner:
Update `TestRunner.java` tags property:
```java
tags = "@smoke" // This will include DatePicker tests if they have @smoke tag
```

### Run Specific Scenario:
```bash
mvn test -Dcucumber.filter.tags="@Regression and @smoke"
```

---

## Integration with Existing Framework

The DatePicker automation is fully integrated with the existing framework:

1. **Hooks Integration:**
   - Uses existing `Hooks.java` for browser initialization (@Before)
   - Screenshot capture on failure (@After)

2. **DriverFactory Integration:**
   - Uses `DriverFactory.getDriver()` to get the WebDriver instance
   - Follows singleton pattern for driver management

3. **Allure Reporting:**
   - Tests are automatically captured in Allure reports
   - TestNG integration through AbstractTestNGCucumberTests

4. **Test Data:**
   - Can be extended to read test data from Excel using ExcelUtil if needed
   - Currently uses hardcoded dates/times in feature file

---

## How to Run Tests

### Prerequisites:
- ChromeDriver should be available in PATH or configured in WebDriver settings
- Firefox/other browsers can be configured in DriverFactory if needed

### Steps:
1. Navigate to project root directory
2. Run command: `mvn test`
3. Allure report will be generated in `target/site/allure-report/`

### View Allure Report:
```bash
mvn allure:serve
```

---

## XPath Details

The XPaths used are based on React DatePicker component structure. If the website updates its HTML structure, the following XPaths may need adjustment:

- **Widgets Menu:** `//span[contains(text(),'Widgets')]`
- **DatePicker Option:** `//a//span[contains(text(),'DatePicker')]`
- **Calendar Date Cells:** `//div[contains(@class, 'react-datepicker__day')]`
- **Navigation Buttons:** `//button[contains(@class, 'react-datepicker__navigation')]`

### Tips for XPath Updates:
1. Inspect the website using browser DevTools (F12)
2. Locate the element
3. Right-click → Copy → Copy XPath
4. Adjust if needed and update in DatePicker.java

---

## Troubleshooting

### Issue: "Element not found" exception
**Solution:** 
- Increase WebDriverWait timeout in DatePicker constructor
- Verify the XPaths match current website structure
- Add explicit waits between navigation steps

### Issue: "Date not selected"
**Solution:**
- Check if calendar picker opened successfully
- Verify date is not disabled (outside current month)
- Add logging to debug calendar state

### Issue: "Time selection not working"
**Solution:**
- Verify time input field locators match website structure
- The code supports multiple time input implementations
- Check if time picker requires specific format

### Issue: "Month navigation not working"
**Solution:**
- Verify calendar is fully loaded before clicking navigation
- Increase Thread.sleep() duration if needed
- Check if navigation buttons are enabled for that month

---

## Future Enhancements

1. **Excel Data Integration:**
   - Add method to read date/time test data from Excel
   - Create data-driven tests with multiple date scenarios

2. **Date Range Selection:**
   - Add functionality to select date ranges
   - Implement multiple date selections

3. **Keyboard Navigation:**
   - Support date selection via keyboard arrows
   - Support date input via keyboard typing

4. **Custom Assertions:**
   - Add methods to verify correct month/year displayed
   - Validate date formats in different locales

5. **Performance Testing:**
   - Measure date picker load time
   - Test calendar performance with large date ranges

---

## Support and Maintenance

For any issues or questions:
1. Check the troubleshooting section above
2. Review Allure report for failure screenshots
3. Check console logs for step execution details
4. Verify XPaths using browser DevTools

---

## Summary

✅ **Created Files:**
- DatePicker.feature (4 test scenarios)
- DatePicker.java (Page Object with 13+ methods)
- DatePickerSteps.java (13+ step definitions)

✅ **Features Implemented:**
- Navigate to Widgets menu
- Access DatePicker widget
- Select dates from calendar
- Select date and time
- Navigate through calendar months
- Proper wait strategies and error handling
- Full integration with existing framework

✅ **Best Practices:**
- POM (Page Object Model) design pattern
- Explicit waits using WebDriverWait
- BDD style with Gherkin language
- Comprehensive documentation
- Error handling and logging

