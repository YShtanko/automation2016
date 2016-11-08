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
public class WomenTshirts extends TestBase {
    private HomePage homePage;

    @BeforeMethod
    public void setup() {

        super.setup();

        homePage = new HomePage(driver);
    }


    @Test
    @TestCaseId("E-6")
    @Features("Item")
    public void womenTshirtsTest() {
        Assert.assertTrue(homePage.tshirts(), "Товар не отображается!");
    }
}
