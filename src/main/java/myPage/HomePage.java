package myPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Юля on 06.11.2016.
 */
public class HomePage {
    private static final By SEARCH_INPUT = By.id("search_query_top");
    private static final By SEARCH_BUTTON = By.cssSelector(".btn.btn-default.button-search");
    private static final By BLOUSE_ITEM = By.xpath(".//*[@id='center_column']/ul/li/div//h5/a");
    private static final By WOMEN_BUTTON = By.xpath(".//a[text()='Women']");
    private static final By T_SHIRTS_LINK = By.xpath(".//ul[@style='display: none;']//a[@title='T-shirts']");
    private static final By T_SHIRTS_ITEM = By.xpath(".//*[@id='center_column']/ul/li/div//h5/a");
    private static final By T_SHIRTS_CONTAINER = By.xpath(".//*[@id='center_column']/ul/li/div");
    private static final By ADD_TO_CART_BUTTON = By.xpath(".//*[@class='button ajax_add_to_cart_button btn btn-default']");
    private static final By CHECKOUT_BUTTON = By.xpath(".//*[@class='btn btn-default button button-medium']");
    private static final String ITEM = "Blouse";
    private WebDriver driver;


    public HomePage(WebDriver driver) {
        this.driver = driver;
    }


//    public boolean DisplayedItemBlouse() {
//        driver.findElement(SEARCH_INPUT).sendKeys(ITEM);
//        driver.findElement(SEARCH_BUTTON).click();
//        return driver.findElement(BLOUSE_ITEM).isDisplayed();
//
//
//    }
    public String ContentItemBlouse() {
        driver.findElement(SEARCH_INPUT).sendKeys(ITEM);
        driver.findElement(SEARCH_BUTTON).click();
        return driver.findElement(BLOUSE_ITEM).getText();
    }

    public CartPage addToCart() {
        Actions actions = new Actions(driver);
        WebElement contshirts = driver.findElement(T_SHIRTS_CONTAINER);
        actions.moveToElement(contshirts).build().perform();
        new WebDriverWait(driver, 15).until(ExpectedConditions.elementToBeClickable(ADD_TO_CART_BUTTON));
        WebElement addcart = driver.findElement(ADD_TO_CART_BUTTON);
        actions.moveToElement(addcart).click().build().perform();
        driver.findElement(CHECKOUT_BUTTON).click();

        return new CartPage(driver);
    }

    public boolean tshirts() {
        Actions actions = new Actions(driver);
        WebElement women = driver.findElement(WOMEN_BUTTON);
        actions.moveToElement(women).build().perform();;
        new WebDriverWait(driver, 15).until(ExpectedConditions.elementToBeClickable(T_SHIRTS_LINK));
        WebElement shirts = driver.findElement(T_SHIRTS_LINK);
        actions.moveToElement(shirts).click().build().perform();;
        return driver.findElement(T_SHIRTS_ITEM).isDisplayed();
    }
}
