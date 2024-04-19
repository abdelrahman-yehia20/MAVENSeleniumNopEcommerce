import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class D02_LoginPageTest extends TestBase{



    @Test
    public void ValidData() throws InterruptedException {
        new P02_LoginPage(driver).openLoginPage().AddLoginCredentials("test@exampled1.com","12345678");
        SoftAssert soft = new SoftAssert();
        soft.assertTrue(new P02_LoginPage(driver).validateLogOutBtnAppear());
        soft.assertAll();
    }




}
