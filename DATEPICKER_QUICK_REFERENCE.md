# DatePicker Automation - Quick Reference Guide

## 📁 Files Created

### 1. Feature File
- **Path:** `src/test/resources/appFeatures/DatePicker.feature`
- **Contains:** 4 BDD test scenarios
- **Tags:** @Regression, @smoke

### 2. Page Object Class
- **Path:** `src/main/java/pageObjects/DatePicker.java`
- **Contains:** 
  - XPath locators for all UI elements
  - 13+ methods for DatePicker interactions
  - WebDriverWait for explicit waits
  - Error handling

### 3. Step Definitions
- **Path:** `src/test/java/stepDefs/DatePickerSteps.java`
- **Contains:** 13+ Cucumber step definitions
- **Maps:** Gherkin steps to Java code

---

## 🚀 Quick Start

### Run All DatePicker Tests:
```bash
cd "C:\Users\ADMIN\OneDrive\Desktop\Test Framework\Automation Framework Allure\SeleniumBDDFramework"
mvn test -Dcucumber.filter.tags="@smoke"
```

### Run Specific Scenario:
```bash
mvn test -Dcucumber.filter.tags="@Regression"
```

### View Test Results:
```bash
mvn allure:serve
```

---

## 📝 Test Scenarios

| Scenario | Steps | Tags |
|----------|-------|------|
| Navigate to DatePicker | 1. Open Browser 2. Navigate URL 3. Click Widgets 4. Click DatePicker | @smoke, @Regression |
| Select Date | All above + Select Date from calendar | @smoke, @Regression |
| Select Date & Time | Navigate to DatePicker + Select Date & Time | @smoke, @Regression |
| Navigate Months | Navigate to DatePicker + Navigate months + Select Date | @smoke, @Regression |

---

## 🛠️ Page Object Methods

### Navigation Methods:
```java
datePickerPage.navigateToWidgetsMenu();
datePickerPage.clickOnDatePickerOption();
```

### Date Selection Methods:
```java
datePickerPage.clickOnSelectDateField();
datePickerPage.selectDateFromCalendar("25");
datePickerPage.clickOnSelectDateTimeField();
datePickerPage.selectDateAndTime("20", "14:30");
```

### Month Navigation:
```java
datePickerPage.navigateToNextMonth();
datePickerPage.navigateToPreviousMonth();
```

### Verification Methods:
```java
datePickerPage.isDatePickerPageDisplayed();
datePickerPage.isDateSelected();
datePickerPage.isDateTimeSelected();
datePickerPage.getSelectedDate();
datePickerPage.getSelectedDateTime();
```

---

## 📍 XPath Locators Used

```java
widgetsMenu = "//span[contains(text(),'Widgets')]"
datePickerOption = "//a//span[contains(text(),'DatePicker')]"
selectDateInput = "//input[@id='datePickerMonthYearInput']"
selectDateTimeInput = "//input[@id='dateTimePickerInput']"
calendarNextButton = "//button[contains(@class, 'react-datepicker__navigation--next')]"
calendarPrevButton = "//button[contains(@class, 'react-datepicker__navigation--previous')]"
dateCell = "//div[contains(@class, 'react-datepicker__day')]"
```

---

## 🔧 Step Definition Examples

### Given Steps:
```gherkin
Given user opens the browser
```

### When/And Steps:
```gherkin
When user navigates to "https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php"
When user navigates to Widgets menu
And user clicks on DatePicker option
And user clicks on Select Date input field
And user selects date "25" from the calendar
And user selects date "20" and time "14:30" from the date time picker
And user navigates to next month in calendar
```

### Then Steps:
```gherkin
Then user verifies DatePicker page is displayed
Then user verifies selected date is displayed in Select Date field
Then user verifies selected date and time is displayed in Select Date and Time field
Then user verifies selected date with next month is displayed in Select Date field
```

---

## 🎯 Integration Points

- **Hooks:** Uses existing `Hooks.java` for @Before/@After
- **DriverFactory:** Uses singleton pattern for WebDriver
- **Allure Reports:** Automatically captured in test execution
- **Framework:** Fully compatible with existing POM architecture

---

## ⚠️ Important Notes

1. **Date Format:** Use date day numbers only (e.g., "25" not "25-04-2026")
2. **Time Format:** Use 24-hour HH:mm format (e.g., "14:30")
3. **Waits:** All operations use 10-second explicit waits
4. **Calendar:** Automatically handles month navigation and disabled dates
5. **Errors:** Check console logs and Allure screenshots for failures

---

## 📊 Test Coverage

✅ Widget Navigation  
✅ Date Picker Page Load  
✅ Date Selection from Calendar  
✅ Date & Time Selection  
✅ Month Navigation (Next/Previous)  
✅ Calendar UI Verification  
✅ Multiple Date Selections  

---

## 🐛 Troubleshooting

| Issue | Solution |
|-------|----------|
| Element not found | Update XPaths - website may have changed |
| Date not selecting | Check if date is disabled or in another month |
| Time not setting | Verify time format is HH:mm (e.g., "14:30") |
| Month nav not working | Increase wait time or verify button is clickable |

---

## 📚 Documentation

For detailed documentation, see: `DATEPICKER_AUTOMATION_DOCUMENTATION.md`

---

## ✅ Verification Checklist

- [x] Feature file created with 4 scenarios
- [x] Page Object class with proper locators
- [x] Step definitions mapped to Gherkin steps
- [x] Project compiles without errors
- [x] Integrated with existing framework
- [x] Documentation provided
- [x] Best practices followed (POM pattern)
- [x] Explicit waits implemented
- [x] Error handling included
- [x] Ready for test execution

