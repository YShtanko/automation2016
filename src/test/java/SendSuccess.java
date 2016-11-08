import myPage.ContactPage;
import myPage.CustomerPage;
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
public class SendSuccess extends TestBase{
    private CustomerPage customerPage;
    private ContactPage contactPage;

    @BeforeMethod
    public void setup() {

        super.setup();

        contactPage = new ContactPage(driver);
    }


    @Test
    @TestCaseId("E-1")
    @Features("Send")
    public void sendSuccess() {
       customerPage = contactPage.send();

        Assert.assertEquals(customerPage.testMessage(), "Your message has been successfully sent to our team.");

   }
   @Test
   @TestCaseId("E-2")
   @Features("Send")
    public void sendFailed() {
       customerPage = contactPage.sendUnMes();

       Assert.assertTrue(contactPage.testMessage(), "Сообщение об ошибке не отображается!");

   }
}
