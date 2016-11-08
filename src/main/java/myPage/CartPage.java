package myPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Юля on 06.11.2016.
 */
public class CartPage {

    private static final By SUMMERY_CHECKOUT_BUTTON = By.xpath(".//*[@class='button btn btn-default standard-checkout button-medium']");
    private static final By EMAIL_INPUT = By.id("email");
    private static final By PASSWORD_INPUT = By.id("passwd");
    private static final By SING_IN_BUTTON = By.id("SubmitLogin");
    private final String EMAIL = "yu.shtanko@gmail.com";
    private final String PASSWORD = "pass123";
    private static final By ADDRESS_CHECKOUT_BUTTON = By.xpath(".//*[@class='button btn btn-default button-medium']");
    private static final By SHIPPING_CHECKOUT_BUTTON = By.xpath(".//*[@class='button btn btn-default standard-checkout button-medium']");
    private static final By I_AGREE_CHECKBOX = By.id("cgv");
    private static final By PAY_BY_CHECK_BUTTON = By.xpath(".//*[@class='cheque']");
    private static final By CONFIRM_ORDER_BUTTON = By.xpath(".//*[@class='button btn btn-default button-medium']");
    private static final By ACCOUNT_BUTTON = By.xpath(".//*[@class='account']");
    private static final By ORDER_HISTORY_BUTTON = By.xpath(".//*[@title='Orders']");
    private static final By LINE_ORDER_REFERENCE = By.xpath(".//*[@id='order-list']/thead/tr");
    private WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

public boolean cartOrder() {
    driver.findElement(SUMMERY_CHECKOUT_BUTTON).click();
    driver.findElement(EMAIL_INPUT).sendKeys(EMAIL);
    driver.findElement(PASSWORD_INPUT).sendKeys(PASSWORD);
    driver.findElement(SING_IN_BUTTON).click();
    driver.findElement(ADDRESS_CHECKOUT_BUTTON).click();
    driver.findElement(I_AGREE_CHECKBOX).click();
    driver.findElement(SHIPPING_CHECKOUT_BUTTON).click();
    driver.findElement(PAY_BY_CHECK_BUTTON).click();
    driver.findElement(CONFIRM_ORDER_BUTTON).click();
    driver.findElement(ACCOUNT_BUTTON).click();
    driver.findElement(ORDER_HISTORY_BUTTON).click();
    return driver.findElements(LINE_ORDER_REFERENCE).isEmpty();
}
}
