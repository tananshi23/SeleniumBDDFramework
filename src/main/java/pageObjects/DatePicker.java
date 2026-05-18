package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class DatePicker {

    WebDriver driver;
    WebDriverWait wait;

    public DatePicker(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // XPaths for navigation
    private final By widgetsMenu = By.xpath("//span[contains(text(),'Widgets')]");
    private final By datePickerOption = By.xpath("//a//span[contains(text(),'DatePicker')]");

    // XPaths for DatePicker elements
    private final By selectDateInput = By.id("datePickerMonthYearInput");
    private final By selectDateTimeInput = By.id("dateTimePickerInput");
    
    // Calendar navigation
    private final By calendarNextButton = By.xpath("//button[contains(@class, 'react-datepicker__navigation--next')]");
    private final By calendarPrevButton = By.xpath("//button[contains(@class, 'react-datepicker__navigation--previous')]");
    private final By monthYearDisplay = By.xpath("//div[contains(@class, 'react-datepicker__current-month')]");
    
    // Time picker elements
    private final By timeInput = By.xpath("//input[contains(@class, 'react-datepicker__time-input')]");
    private final By hoursInput = By.xpath("//input[contains(@placeholder, 'Heure')]");
    private final By minutesInput = By.xpath("//input[contains(@placeholder, 'Minutes')]");
    
    // Month name mapping
    private final Map<String, Integer> monthMap = createMonthMap();

    /*
     * Create month name to number mapping
     */
    private Map<String, Integer> createMonthMap() {
        Map<String, Integer> map = new HashMap<>();
        map.put("January", 1);
        map.put("February", 2);
        map.put("March", 3);
        map.put("April", 4);
        map.put("May", 5);
        map.put("June", 6);
        map.put("July", 7);
        map.put("August", 8);
        map.put("September", 9);
        map.put("October", 10);
        map.put("November", 11);
        map.put("December", 12);
        return map;
    }

    /*
     * Parse date string in format "DD-MonthName-YYYY"
     * Example: "25-April-2026"
     * @param dateString - Date in DD-MonthName-YYYY format
     * @return LocalDate object
     */
    public LocalDate parseDateString(String dateString) {
        try {
            String[] parts = dateString.split("-");
            if (parts.length != 3) {
                throw new IllegalArgumentException("Date must be in format DD-MonthName-YYYY, got: " + dateString);
            }
            
            int day = Integer.parseInt(parts[0].trim());
            String monthName = parts[1].trim();
            int year = Integer.parseInt(parts[2].trim());
            
            if (!monthMap.containsKey(monthName)) {
                throw new IllegalArgumentException("Invalid month name: " + monthName);
            }
            
            int month = monthMap.get(monthName);
            return LocalDate.of(year, month, day);
        } catch (Exception e) {
            System.out.println("Error parsing date string '" + dateString + "': " + e.getMessage());
            throw new RuntimeException("Invalid date format. Expected: DD-MonthName-YYYY", e);
        }
    }

    /*
     * Get current month and year from calendar display
     * @return YearMonth object representing current calendar view
     */
    private YearMonth getCurrentCalendarMonth() {
        try {
            WebElement monthYearElement = wait.until(ExpectedConditions.visibilityOfElementLocated(monthYearDisplay));
            String monthYearText = monthYearElement.getText();
            // Expected format: "April 2026" or similar
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM yyyy");
            return YearMonth.parse(monthYearText, formatter);
        } catch (Exception e) {
            System.out.println("Could not parse calendar month/year: " + e.getMessage());
            return null;
        }
    }

    /*
     * Navigate to target month in calendar
     * @param targetDate - The target date
     */
    private void navigateToMonth(LocalDate targetDate) {
        try {
            YearMonth currentMonth = getCurrentCalendarMonth();
            if (currentMonth == null) {
                System.out.println("Could not determine current calendar month");
                return;
            }
            
            YearMonth targetMonth = YearMonth.from(targetDate);
            
            int monthDifference = 0;
            YearMonth tempMonth = currentMonth;
            
            // Calculate if we need to go forward or backward
            if (targetMonth.isAfter(currentMonth)) {
                // Navigate forward
                while (tempMonth.isBefore(targetMonth)) {
                    navigateToNextMonth();
                    tempMonth = tempMonth.plusMonths(1);
                    monthDifference++;
                    Thread.sleep(300); // Wait for calendar to update
                }
                System.out.println("Navigated forward " + monthDifference + " month(s)");
            } else if (targetMonth.isBefore(currentMonth)) {
                // Navigate backward
                while (tempMonth.isAfter(targetMonth)) {
                    navigateToPreviousMonth();
                    tempMonth = tempMonth.minusMonths(1);
                    monthDifference++;
                    Thread.sleep(300); // Wait for calendar to update
                }
                System.out.println("Navigated backward " + monthDifference + " month(s)");
            } else {
                System.out.println("Target month is current month, no navigation needed");
            }
        } catch (Exception e) {
            System.out.println("Error navigating to target month: " + e.getMessage());
        }
    }

    /*
     * Method to navigate to Widgets menu
     */
    public void navigateToWidgetsMenu() {
        WebElement widgets = wait.until(ExpectedConditions.elementToBeClickable(widgetsMenu));
        widgets.click();
    }

    /*
     * Method to click on DatePicker option
     */
    public void clickOnDatePickerOption() {
        WebElement datePicker = wait.until(ExpectedConditions.elementToBeClickable(datePickerOption));
        datePicker.click();
    }

    /*
     * Method to verify DatePicker page is displayed
     */
    public boolean isDatePickerPageDisplayed() {
        try {
            WebElement selectDate = wait.until(ExpectedConditions.visibilityOfElementLocated(selectDateInput));
            WebElement selectDateTime = wait.until(ExpectedConditions.visibilityOfElementLocated(selectDateTimeInput));
            return selectDate.isDisplayed() && selectDateTime.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    /*
     * Method to click on Select Date input field
     */
    public void clickOnSelectDateField() {
        WebElement dateField = wait.until(ExpectedConditions.elementToBeClickable(selectDateInput));
        dateField.click();
    }

    /*
     * Method to click on Select Date and Time input field
     */
    public void clickOnSelectDateTimeField() {
        WebElement dateTimeField = wait.until(ExpectedConditions.elementToBeClickable(selectDateTimeInput));
        dateTimeField.click();
    }

    /*
     * Method to select a specific date using date string format
     * Format: "DD-MonthName-YYYY" (e.g., "25-April-2026")
     * @param dateString - Date in specified format
     */
    public void selectDateFromCalendar(String dateString) {
        try {
            // Parse the date string
            LocalDate targetDate = parseDateString(dateString);
            
            // Wait for calendar to appear
            Thread.sleep(500);
            
            // Navigate to target month if needed
            navigateToMonth(targetDate);
            
            // Select the date
            int day = targetDate.getDayOfMonth();
            By specificDate = By.xpath("//div[contains(@class, 'react-datepicker__day') and " +
                    "not(contains(@class, 'react-datepicker__day--outside-month')) and " +
                    "not(contains(@class, 'react-datepicker__day--disabled')) and text()='" + day + "']");
            
            WebElement dateElement = wait.until(ExpectedConditions.elementToBeClickable(specificDate));
            dateElement.click();
            
            System.out.println("Successfully selected date: " + dateString);
        } catch (Exception e) {
            System.out.println("Error selecting date: " + e.getMessage());
            throw new RuntimeException("Failed to select date: " + dateString, e);
        }
    }

    /*
     * Method to navigate to next month in calendar
     */
    public void navigateToNextMonth() {
        try {
            WebElement nextButton = wait.until(ExpectedConditions.elementToBeClickable(calendarNextButton));
            nextButton.click();
            Thread.sleep(500); // Wait for calendar to update
        } catch (Exception e) {
            System.out.println("Error navigating to next month: " + e.getMessage());
        }
    }

    /*
     * Method to navigate to previous month in calendar
     */
    public void navigateToPreviousMonth() {
        try {
            WebElement prevButton = wait.until(ExpectedConditions.elementToBeClickable(calendarPrevButton));
            prevButton.click();
            Thread.sleep(500); // Wait for calendar to update
        } catch (Exception e) {
            System.out.println("Error navigating to previous month: " + e.getMessage());
        }
    }

    /*
     * Method to select date and time using date string and time
     * Date format: "DD-MonthName-YYYY" (e.g., "20-May-2026")
     * Time format: "HH:mm" (e.g., "14:30")
     * @param dateString - Date in specified format
     * @param time - Time in HH:mm format
     */
    public void selectDateAndTime(String dateString, String time) {
        try {
            // Select the date first
            selectDateFromCalendar(dateString);
            Thread.sleep(500);
            
            // Handle time selection
            String[] timeParts = time.split(":");
            String hours = timeParts[0];
            String minutes = timeParts[1];
            
            // Try to find and fill time inputs
            try {
                WebElement timeInputField = wait.until(ExpectedConditions.presenceOfElementLocated(timeInput));
                timeInputField.clear();
                timeInputField.sendKeys(time);
                System.out.println("Time set to: " + time);
            } catch (Exception e) {
                // Alternative approach - try hours and minutes fields separately
                try {
                    WebElement hoursField = driver.findElement(hoursInput);
                    hoursField.clear();
                    hoursField.sendKeys(hours);
                    
                    WebElement minutesField = driver.findElement(minutesInput);
                    minutesField.clear();
                    minutesField.sendKeys(minutes);
                    System.out.println("Time set to: " + hours + ":" + minutes);
                } catch (Exception ex) {
                    System.out.println("Could not find time input fields");
                }
            }
            
        } catch (Exception e) {
            System.out.println("Error selecting date and time: " + e.getMessage());
            throw new RuntimeException("Failed to select date and time", e);
        }
    }

    /*
     * Method to get the selected date value from Select Date field
     */
    public String getSelectedDate() {
        try {
            WebElement dateField = wait.until(ExpectedConditions.visibilityOfElementLocated(selectDateInput));
            return dateField.getAttribute("value");
        } catch (Exception e) {
            return "";
        }
    }

    /*
     * Method to get the selected date and time value from Select Date and Time field
     */
    public String getSelectedDateTime() {
        try {
            WebElement dateTimeField = wait.until(ExpectedConditions.visibilityOfElementLocated(selectDateTimeInput));
            return dateTimeField.getAttribute("value");
        } catch (Exception e) {
            return "";
        }
    }

    /*
     * Method to verify if selected date is not empty
     */
    public boolean isDateSelected() {
        String selectedDate = getSelectedDate();
        return selectedDate != null && !selectedDate.isEmpty();
    }

    /*
     * Method to verify if selected date and time is not empty
     */
    public boolean isDateTimeSelected() {
        String selectedDateTime = getSelectedDateTime();
        return selectedDateTime != null && !selectedDateTime.isEmpty();
    }

}


