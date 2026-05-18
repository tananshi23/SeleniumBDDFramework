package hooks;

import driver.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import testUtils.AllureUtil;

public class Hooks {

    @Before
    public void setUp() {
        DriverFactory.initDriver();
    }
//    @After
//    public void tearDown(Scenario scenario) {
//        if (scenario.isFailed()) {
//            AllureUtil.attachScreenshot(DriverFactory.getDriver());
//        }
//        DriverFactory.quitDriver();
//    }

    @After
    public void tearDown(Scenario scenario) {

        if (scenario.isFailed()) {
            AllureUtil.attachScreenshot(DriverFactory.getDriver(), "FAILED_" + scenario.getName());
        } else {
            AllureUtil.attachScreenshot(DriverFactory.getDriver(), "PASSED_" + scenario.getName());
        }

        DriverFactory.quitDriver();
    }
}