import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

/**
 * Created by Юля on 06.11.2016.
 */
public class TestBase {
    protected static WebDriver driver;
    public static WebDriver getDriver() {
        return driver;
    }


    private static final String URL = "http://automationpractice.com/index.php";

    @BeforeMethod
    public void setup() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(URL);
    }

    @AfterMethod
    public void teardown() {
        driver.close();
    }
}
