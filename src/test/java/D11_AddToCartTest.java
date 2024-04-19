import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;



public class D11_AddToCartTest  {
    public WebDriver driver;

    P11_AddToCartPage cart ;
    Actions actions;
    JavascriptExecutor executor;

    @Test
    public void AddProductToCart() throws InterruptedException {

        new P02_LoginPage(driver).openLoginPage().AddLoginCredentials("test@exampled1.com", "12345678");
        new P11_AddToCartPage(driver).addToCart();
       // actions.scrollByAmount(0, 0);
        Thread.sleep(2000);
        executor.executeScript("arguments[0].click();", driver.findElement(cart.xIcon) );
        new P11_AddToCartPage(driver).openCartPage();
        // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //wait.until(ExpectedConditions.visibilityOf(driver.findElement(cart.successMessage)));
        //cart.clickOnXicon().openCartPage();
        //Assert.assertTrue(new P11_AddToCartPage(driver).successMessageIsDisplayed());
        //new P11_AddToCartPage(driver).openCartPage();


    }




    @BeforeClass
    public void openChrome() throws InterruptedException {

        //1
        //System.setProperty("webdriver.chrome.driver", "D:\\testing\\EGFWD\\chromedriver-win64\\chromedriver.exe");

        //2 Create new object from driver
        driver = new ChromeDriver();

        //3 Navigate to google website, maxmize screen, and sleep
        driver.navigate().to("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();
        Thread.sleep(3000);

         cart = new P11_AddToCartPage(driver);
         actions = new Actions(driver);
        executor = (JavascriptExecutor)driver;
    }



    @AfterClass
    public void closeDriver() throws InterruptedException {

        Thread.sleep(3000);
        // 5 driver close
        driver.quit();
    }

}
