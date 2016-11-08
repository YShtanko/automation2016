package myPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Юля on 06.11.2016.
 */
public class ContactPage {
    private static final By CONTACT_US_BUTTON = By.cssSelector("#contact-link>a");
    private static final By SUBJECT_HEADING_SELECT = By.id("id_contact");
    private static final By EMAIL_INPUT = By.id("email");
    private static final By ORDER_REFERENCE_INPUT = By.id("id_order");
//    private static final By ATTACH_FILE = By.id("fileUpload");
    private static final By SEND_BUTTON = By.id("submitMessage");
    private static final By MESSAGE_INPUT = By.id("message");
    private static final By ERROR_MESSAGE = By.cssSelector(".alert.alert-danger>ol>li");
    private WebDriver driver;

    public ContactPage(WebDriver driver) {
        this.driver = driver;
    }

    public CustomerPage send() {
        driver.findElement(CONTACT_US_BUTTON).click();
        driver.findElement(SUBJECT_HEADING_SELECT).sendKeys("Webmaster");
        driver.findElement(EMAIL_INPUT).sendKeys("yu.shtanko@gmail.com");
        driver.findElement(ORDER_REFERENCE_INPUT).sendKeys("123yul");
//        driver.findElement(ATTACH_FILE).click();
//        Robot robot = new Robot();
//        robot.keyPress(KeyEvent.VK_F);
//        robot.keyRelease(KeyEvent.VK_F);
//        robot.keyPress(KeyEvent.VK_I);
//        robot.keyRelease(KeyEvent.VK_I);
//        robot.keyPress(KeyEvent.VK_N);
//        robot.keyRelease(KeyEvent.VK_N);
//        robot.keyPress(KeyEvent.VK_A);
//        robot.keyRelease(KeyEvent.VK_A);
//        robot.keyPress(KeyEvent.VK_L);
//        robot.keyRelease(KeyEvent.VK_L);
        driver.findElement(MESSAGE_INPUT).sendKeys("Some message");
        driver.findElement(SEND_BUTTON).click();

        return new CustomerPage(driver);
    }

    public CustomerPage sendUnMes() {
        driver.findElement(CONTACT_US_BUTTON).click();
        driver.findElement(SUBJECT_HEADING_SELECT).sendKeys("Webmaster");
        driver.findElement(EMAIL_INPUT).sendKeys("yu.shtanko@gmail.com");
        driver.findElement(ORDER_REFERENCE_INPUT).sendKeys("123yul");
        driver.findElement(SEND_BUTTON).click();

        return new CustomerPage(driver);
    }

    public boolean testMessage() {
        return driver.findElement(ERROR_MESSAGE).isDisplayed();
    }
}
