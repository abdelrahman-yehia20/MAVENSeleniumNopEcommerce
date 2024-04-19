import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class D03_ForgetPasswordTest extends TestBase{



    @Test
    public void forgetPasswordHappyScenario() throws InterruptedException {
        new P02_LoginPage(driver).openLoginPage();
        new P03_ForgetPasswordPage(driver).
                openForgetPage().
                addEmail("test@exampled1.com").
                clickOnRcoverBtn();
        Thread.sleep(1000);
        Assert.assertTrue(new P03_ForgetPasswordPage(driver).emailPopUp());

    }

}
