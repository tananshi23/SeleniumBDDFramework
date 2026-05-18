#Feature: Automate DatePicker Widget Functionality
#
#  @Regression @smoke
#  Scenario: User navigates to DatePicker widget and selects date
#
#    Given user opens the browser
#    And user navigates to "https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php"
#    When user navigates to Widgets menu
#    And user clicks on DatePicker option
#    Then user verifies DatePicker page is displayed
#
#  @Regression @smoke
#  Scenario: User selects date from Select Date picker
#
#    Given user opens the browser
#    And user navigates to "https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php"
#    When user navigates to Widgets menu
#    And user clicks on DatePicker option
#    And user clicks on Select Date input field
#    And user selects date "25-April-2026" from the calendar
#    Then user verifies selected date is displayed in Select Date field
#
#  @Regression @smoke
#  Scenario: User selects date and time from Date and Time picker
#
#    Given user opens the browser
#    And user navigates to "https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php"
#    When user navigates to Widgets menu
#    And user clicks on DatePicker option
#    And user clicks on Select Date and Time input field
#    And user selects date "20-May-2026" and time "14:30" from the date time picker
#    Then user verifies selected date and time is displayed in Select Date and Time field
#
#  @Regression @smoke
#  Scenario: User navigates to future month and selects date from DatePicker
#
#    Given user opens the browser
#    And user navigates to "https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php"
#    When user navigates to Widgets menu
#    And user clicks on DatePicker option
#    And user clicks on Select Date input field
#    And user selects date "15-June-2026" from the calendar
#    Then user verifies selected date with future date is displayed in Select Date field
#
#  @Regression @smoke
#  Scenario: User selects date from previous month in DatePicker
#
#    Given user opens the browser
#    And user navigates to "https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php"
#    When user navigates to Widgets menu
#    And user clicks on DatePicker option
#    And user clicks on Select Date input field
#    And user selects date "10-March-2026" from the calendar
#    Then user verifies selected date from past month is displayed in Select Date field
#
