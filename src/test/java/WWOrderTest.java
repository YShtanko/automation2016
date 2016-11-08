import myPage.CartPage;
import myPage.HomePage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.TestCaseId;

/**
 * Created by Юля on 06.11.2016.
 */
@Listeners(MyListener.class)
public class WWOrderTest extends TestBase {

    private HomePage homePage;
    private CartPage cartPage;


    @BeforeMethod
    public void setup() {

        super.setup();

        homePage = new HomePage(driver);
        cartPage = new CartPage(driver);
    }
    @Test
    @TestCaseId("E-7")
    @Features("Order")
    public void orderTest() {
        homePage.ContentItemBlouse();
        homePage.addToCart();
        cartPage.cartOrder();

        Assert.assertFalse(cartPage.cartOrder(), "В истории нет товара!");

    }
}
