package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PracticeForm {

    WebDriver driver;

    public PracticeForm(WebDriver driver){        // constructor - this property belongs to whole class
        //  driver = new ChromeDriver(); //instance or object
        this.driver = driver; //line no.9 driver = line no.10 driver
        driver.get("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");
    }
        private By name = By.xpath("//input[@placeholder=\"First Name\"]");
        private By email = By.xpath("//input[@placeholder=\"name@example.com\"]");
        String dGender = "Male";
        private By gender = By.xpath("//div[@class=\"d-flex justify-content-start align-center\"]//label[contains(text(),"+dGender+")]");
        private By phone = By.xpath("//input[@placeholder=\"Enter Mobile Number\"]");
        private By dob = By.xpath("//input[@id=\"dob\"]");
        private By subject = By.xpath("//input[@placeholder=\"Enter Subject\"]");
        String hobby = "Sports";
        private By hobbies = By.xpath("//div[@class=\"d-flex justify-content-start align-center\"]//label[contains(text(),"+hobby+")]");
        //private By pictureUploadBtn = ;
        private By address = By.xpath("//textarea[@placeholder=\"Currend Address\"]");
        private By state = By.xpath("//select[@id=\"state\"]") ;
        private By cityClick = By.xpath("//select[@id=\"city\"]");


        public void enterName(String sName){

            driver.findElement(name).sendKeys(sName);
        }

        public void enterEmail(String sEmail){

            driver.findElement(email).sendKeys(sEmail);
        }
        public void enterGender(String sgender){

            driver.findElement(gender).click();
        }
        public void enterPhone(String sPhone){

            driver.findElement(phone).sendKeys(sPhone);
        }
        public void enterSubject(String sSubject){

            driver.findElement(subject).sendKeys(sSubject);
        }
        public void enterHobbies(String sHobby){

            driver.findElement(hobbies).click();
        }
        public void enterAddress(String sAddress){

            driver.findElement(address).sendKeys();
        }
        public void enterState(String sState){
            Select select = new Select(driver.findElement(state));
            select.selectByValue(sState);
        }


//    public byte[] getName() {
//        return driver.findElement(name).getAttribute("value").getBytes();
//
//    }

    public String getName() {
        return driver.findElement(name).getAttribute("value");

    }
}

