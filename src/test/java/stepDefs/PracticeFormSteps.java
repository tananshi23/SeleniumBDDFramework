package stepDefs;

import driver.DriverFactory;
import io.cucumber.java.en.*;
import org.testng.Assert;
import pageObjects.PracticeForm;
import testUtils.ExcelUtil;
import testUtils.ExcelUtil_withoutDF;
import java.util.Map;


public class PracticeFormSteps {

    //WebDriver driver = new ChromeDriver();
    PracticeForm pf = new PracticeForm(DriverFactory.getDriver());
    Map<String, String> testData;


//    @Given("user opens the browser")
//    public void user_opens_the_browser() {
//        // Write code here that turns the phrase above into concrete actions
//        DriverFactory.initDriver();
//
//    }
    @Given("user navigates to {string}")
    public void user_navigates_to(String url) {
         DriverFactory.getDriver().get(url);
         Assert.assertEquals(DriverFactory.getDriver().getCurrentUrl(), url, "Navigation to URL failed");
        // Write code here that turns the phrase above into concrete actions

    }
    @When("user reads test data from excel {string}")
    public void user_reads_data(String testCaseName) {
        testData = ExcelUtil.getTestData(testCaseName);
    }

    @When("user enters first name")
    public void user_enters_first_name() {
        pf.enterName(testData.get("Name"));
        //uncheck below for failure
        //Assert.assertEquals(pf.getName(), testData.get("Name"), "First name entry failed");
        //Add assertion - post learning
        //throw new io.cucumber.java.PendingException();
    }

    @When("user enters email")
    public void user_enters_email() {
        pf.enterEmail(testData.get("Email"));
    }

    @When("user selects gender")
    public void user_selects_gender() {
        pf.enterGender(testData.get("Gender"));
    }

    @When("user enters mobile number")
    public void user_enters_mobile_number() {
        pf.enterPhone(testData.get("PhoneNo"));
    }

//    @When("user selects date of birth {string}")
//    public void user_selects_date_of_birth(String string) {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }
    @When("user enters subject {string}")
    public void user_enters_subject(String s_Subject) {
        // Write code here that turns the phrase above into concrete actions
        pf.enterSubject(s_Subject);
    }
    @When("user selects hobby {string}")
    public void user_selects_hobby(String s_Hobby) {
        // Write code here that turns the phrase above into concrete actions
        pf.enterHobbies(s_Hobby);
    }
    @When("user uploads picture {string}")
    public void user_uploads_picture(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("user enters current address {string}")
    public void user_enters_current_address(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("user selects state {string}")
    public void user_selects_state(String s_State) {
        // Write code here that turns the phrase above into concrete actions
        pf.enterState(s_State);
        throw new io.cucumber.java.PendingException();
    }
    @When("user selects city {string}")
    public void user_selects_city(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("user clicks submit button")
    public void user_clicks_submit_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }


}
