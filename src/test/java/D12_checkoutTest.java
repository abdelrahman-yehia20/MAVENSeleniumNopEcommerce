import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class D12_checkoutTest extends TestBase {


    JavascriptExecutor executor ;

    @Test
    public void AddCheckout() throws InterruptedException {

        new P02_LoginPage(driver).openLoginPage().AddLoginCredentials("test@exampled1.com","12345678");
        new P11_AddToCartPage(driver).addToCart();
        Thread.sleep(2000);
        executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", driver.findElement(new P11_AddToCartPage(driver).xIcon) );
        new P11_AddToCartPage(driver).openCartPage();
        new P12_CheckOutPage(driver).clickOnTermsBox().clickOnCheckoutBtn();
        Thread.sleep(2000);
        String actualURL =  driver.getCurrentUrl();
        String expectedURL = "https://demo.nopcommerce.com/onepagecheckout#opc-billing";
        Assert.assertEquals(actualURL,expectedURL);
    }
}
