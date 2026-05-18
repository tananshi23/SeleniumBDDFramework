package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions (
        features = "C:\\Users\\ADMIN\\OneDrive\\Desktop\\Test Framework\\Automation Framework Allure\\SeleniumBDDFramework\\src\\test\\resources\\appFeatures",
        glue = {"stepDefs", "hooks"},
        tags = "@smoke",
        plugin ={
                "rerun:target/failedTC.txt",
                "pretty",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm" //connects allure with cucumber
        },
        monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests {


}
/*
1: To open Allure Report type the below in the cmd of Framework folder post execution from intelliJ
allure serve target/allure-results

2: Or run from cmd of root folder of framework
mvn clean test
allure generate target/allure-results -o target/allure-report --clean //report will be generated
allure open target/allure-report - report will be opened in browser
*/
 