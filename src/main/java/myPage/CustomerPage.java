package myPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Юля on 06.11.2016.
 */
public class CustomerPage {
    private static final By HOME_BUTTON = By.cssSelector("li .btn.btn-default.button.button-small");
    private static final By SUCCESS_MESSAGE = By.cssSelector(".alert.alert-success");
    private WebDriver driver;

    public CustomerPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isHomeButtonDisplayed() {
        return driver.findElement(HOME_BUTTON).isDisplayed();
    }

    public String testMessage() {
      return driver.findElement(SUCCESS_MESSAGE).getText();
    }

    public HomePage logout() {
        driver.findElement(HOME_BUTTON).click();
        return new HomePage(driver);
    }
}
