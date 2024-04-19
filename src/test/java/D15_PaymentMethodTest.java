import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class D15_PaymentMethodTest extends TestBase{

    JavascriptExecutor executor ;
    WebDriverWait wait;

    @Test
    public void paymentMethod() throws InterruptedException {

        new P02_LoginPage(driver).openLoginPage().AddLoginCredentials("test@example99.com","12345678");
        new P11_AddToCartPage(driver).addToCart();
        Thread.sleep(2000);
        executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", driver.findElement(new P11_AddToCartPage(driver).xIcon) );
        new P11_AddToCartPage(driver).openCartPage();
        new P12_CheckOutPage(driver).clickOnTermsBox().clickOnCheckoutBtn();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("https://demo.nopcommerce.com/onepagecheckout#opc-billing"));
        //Thread.sleep(5000);
        new P13_BillingAddressPage(driver)
                .addCompany("test")
                .selectCountry("Egypt")
                .addCity("Alx")
                .addAddress1("12 Ali omar street, Gleem")
                .addAddress2(" 4 behnid elmool cafe, Ganaklis ")
                .addPostalCode("4225253")
                .addPhoneNumber("0122363658")
                .addFaxNum("969655565")
                .clickOnContinueBtn();
        wait.until(ExpectedConditions.urlContains("https://demo.nopcommerce.com/onepagecheckout#opc-shipping_method"));
        new P14_ShippingPage(driver)
                .chooseRandomShippingMethod()
                .ClickOnContinueBtn();
        wait.until(ExpectedConditions.urlContains("https://demo.nopcommerce.com/onepagecheckout#opc-payment_method"));
       new P15_PaymentMethod(driver)
               .ChooseCreditCard()
               .clickOnContinueBtn();
        wait.until(ExpectedConditions.urlContains("https://demo.nopcommerce.com/onepagecheckout#opc-payment_info"));
        String actualURL =  driver.getCurrentUrl();
        String expectedURL = "https://demo.nopcommerce.com/onepagecheckout#opc-payment_info";
        Assert.assertEquals(actualURL,expectedURL);
    }
}
