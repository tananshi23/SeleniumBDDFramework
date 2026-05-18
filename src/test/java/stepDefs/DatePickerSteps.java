//package stepDefs;
//
//import driver.DriverFactory;
//import io.cucumber.java.en.*;
//import org.openqa.selenium.WebDriver;
//import org.testng.Assert;
//import pageObjects.DatePicker;
//
//public class DatePickerSteps {
//
//    WebDriver driver;
//    DatePicker datePickerPage;
//
//    /**
//     * Constructor
//     */
//    public DatePickerSteps() {
//        this.driver = DriverFactory.getDriver();
//        this.datePickerPage = new DatePicker(driver);
//    }
//
//    @Given("user opens the browser")
//    public void user_opens_the_browser() {
//        // Browser is initialized in Hooks
//        System.out.println("Browser opened successfully");
//    }
//
//    @And("user navigates to {string}")
//    public void user_navigates_to(String url) {
//        driver.navigate().to(url);
//        System.out.println("Navigated to URL: " + url);
//    }
//
//    @When("user navigates to Widgets menu")
//    public void user_navigates_to_widgets_menu() {
//        datePickerPage.navigateToWidgetsMenu();
//        System.out.println("Navigated to Widgets menu");
//    }
//
//    @And("user clicks on DatePicker option")
//    public void user_clicks_on_datepicker_option() {
//        datePickerPage.clickOnDatePickerOption();
//        System.out.println("Clicked on DatePicker option");
//    }
//
//    @Then("user verifies DatePicker page is displayed")
//    public void user_verifies_datepicker_page_displayed() {
//        boolean isDisplayed = datePickerPage.isDatePickerPageDisplayed();
//        Assert.assertTrue(isDisplayed, "DatePicker page is not displayed");
//        System.out.println("DatePicker page is displayed successfully");
//    }
//
//    @When("user clicks on Select Date input field")
//    public void user_clicks_on_select_date_field() {
//        datePickerPage.clickOnSelectDateField();
//        System.out.println("Clicked on Select Date input field");
//    }
//
//    @And("user selects date {string} from the calendar")
//    public void user_selects_date_from_calendar(String date) {
//        datePickerPage.selectDateFromCalendar(date);
//        System.out.println("Selected date: " + date + " from the calendar");
//    }
//
//    @Then("user verifies selected date is displayed in Select Date field")
//    public void user_verifies_selected_date_displayed() {
//        boolean isSelected = datePickerPage.isDateSelected();
//        Assert.assertTrue(isSelected, "Date was not selected");
//        String selectedDate = datePickerPage.getSelectedDate();
//        System.out.println("Selected date displayed: " + selectedDate);
//    }
//
//    @When("user clicks on Select Date and Time input field")
//    public void user_clicks_on_select_date_time_field() {
//        datePickerPage.clickOnSelectDateTimeField();
//        System.out.println("Clicked on Select Date and Time input field");
//    }
//
//    @And("user selects date {string} and time {string} from the date time picker")
//    public void user_selects_date_and_time(String date, String time) {
//        datePickerPage.selectDateAndTime(date, time);
//        System.out.println("Selected date: " + date + " and time: " + time);
//    }
//
//    @Then("user verifies selected date and time is displayed in Select Date and Time field")
//    public void user_verifies_selected_date_time_displayed() {
//        boolean isSelected = datePickerPage.isDateTimeSelected();
//        Assert.assertTrue(isSelected, "Date and time was not selected");
//        String selectedDateTime = datePickerPage.getSelectedDateTime();
//        System.out.println("Selected date and time displayed: " + selectedDateTime);
//    }
//
//    @And("user navigates to next month in calendar")
//    public void user_navigates_to_next_month() {
//        datePickerPage.navigateToNextMonth();
//        System.out.println("Navigated to next month in calendar");
//    }
//
//    @Then("user verifies selected date with next month is displayed in Select Date field")
//    public void user_verifies_selected_date_with_next_month() {
//        boolean isSelected = datePickerPage.isDateSelected();
//        Assert.assertTrue(isSelected, "Date was not selected");
//        String selectedDate = datePickerPage.getSelectedDate();
//        System.out.println("Selected date with next month displayed: " + selectedDate);
//    }
//
//    @Then("user verifies selected date with future date is displayed in Select Date field")
//    public void user_verifies_selected_date_with_future_date() {
//        boolean isSelected = datePickerPage.isDateSelected();
//        Assert.assertTrue(isSelected, "Date was not selected");
//        String selectedDate = datePickerPage.getSelectedDate();
//        System.out.println("Selected date with future date displayed: " + selectedDate);
//    }
//
//    @Then("user verifies selected date from past month is displayed in Select Date field")
//    public void user_verifies_selected_date_from_past_month() {
//        boolean isSelected = datePickerPage.isDateSelected();
//        Assert.assertTrue(isSelected, "Date was not selected");
//        String selectedDate = datePickerPage.getSelectedDate();
//        System.out.println("Selected date from past month displayed: " + selectedDate);
//    }
//}
//
