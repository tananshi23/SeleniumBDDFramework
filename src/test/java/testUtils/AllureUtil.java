package testUtils;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class AllureUtil {

    public static void attachScreenshot(WebDriver driver, String name) {
        byte[] screenshot = ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.BYTES);

        Allure.getLifecycle().addAttachment(
                "Screenshot",
                "image/png",
                "png",
                screenshot
        );
    }
}