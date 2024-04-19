import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class D09_WishTest {

    WebDriver driver ;
    P09_WishPage wish;



    @BeforeTest
    public void openChrome() throws InterruptedException {

        //1
        System.setProperty("webdriver.chrome.driver", "D:\\testing\\EGFWD\\chromedriver-win64\\chromedriver.exe");

        //2 Create new object from driver
        driver = new ChromeDriver();

        //3 Navigate to google website, maxmize screen, and sleep
        driver.navigate().to("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();
        Thread.sleep(3000);

        //4 create new objects
        wish = new P09_WishPage(driver);

    }

    @Test
    public void AddHtcMobileToWishlist()
    {
        driver.findElements(By.xpath("//div[@class=\"buttons\"]/button[3]")).get(2).click();
        WebElement barNot = driver.findElement(By.id("bar-notification"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(barNot));
        String expectedTest = "The product has been added to your wishlist";
        String actualText = driver.findElement(By.cssSelector("div[id=\"bar-notification\"] div ")).getText();
        System.out.println("expectedTest: "+ expectedTest);
        System.out.println("actualResult: "+ actualText);
        Assert.assertTrue(expectedTest.contains(actualText));

    }
@Test
    public void buildTouOwnComputer()
    {
        driver.findElements(By.xpath("//div[@class=\"buttons\"]/button[3]")).get(0).click();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlContains("https://demo.nopcommerce.com/build-your-own-computer"));
        System.out.println(driver.getCurrentUrl());

        //RAM drp
        WebElement drpRAM = driver.findElement(By.id("product_attribute_2"));
        Select select = new Select(drpRAM);
        select.selectByValue("4");

        //HDD 320GB
        driver.findElement(By.id("product_attribute_3_6")).click();

        //Click on wishlist
        driver.findElement(By.id("add-to-wishlist-button-1")).click();


        //Assertions
        WebElement barNot = driver.findElement(By.id("bar-notification"));
        wait.until(ExpectedConditions.visibilityOf(barNot));
        String expectedTest = "The product has been added to your wishlist";
        String actualText = driver.findElement(By.cssSelector("div[id=\"bar-notification\"] div ")).getText();
        System.out.println("expectedTest: "+ expectedTest);
        System.out.println("actualResult: "+ actualText);
        Assert.assertTrue(expectedTest.contains(actualText));


    }



    @AfterTest
    public void closeDriver() throws InterruptedException {

        Thread.sleep(3000);
        // 5 driver close
        driver.quit();
    }
}
