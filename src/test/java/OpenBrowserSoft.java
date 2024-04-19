import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class OpenBrowserSoft {


     WebDriver driver ;

    @BeforeTest
    public void openChrome() throws InterruptedException {

        //1
        System.setProperty("webdriver.chrome.driver", "D:\\testing\\EGFWD\\chromedriver-win64\\chromedriver.exe");

        //2 Create new object from driver
         driver = new ChromeDriver();

        //3 Navigate to google website, maxmize screen, and sleep
        driver.navigate().to("https://the-internet.herokuapp.com/login");
        driver.manage().window().maximize();
        Thread.sleep(3000);

    }


    @Test
    public void validData() throws InterruptedException {
        // 4 Enter username and password
        //driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        Thread.sleep(3000);
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");
        Thread.sleep(3000);
        driver.findElement(By.className("radius")).click();
        //driver.findElement(By.cssSelector("form button[type=\"submit\"]")).click();
        //driver.findElement(By.xpath("//form[@id=\"login\"]//button[@type=\"submit\"]")).click();


        Thread.sleep(3000);
        //Soft Assertion

        SoftAssert soft = new SoftAssert();
        // First Assertion
        String expectedResult = "You logged into a secure area!" ;
        String actualResult = driver.findElement(By.id("flash")).getText();
        soft.assertEquals(actualResult.contains(expectedResult), true,"First Assertion");

        // Second Assertion
        soft.assertFalse(driver.findElement(By.cssSelector("a[href=\"/logout\"]")).isDisplayed(),"Second Assertion");


        // third assertion
        soft.assertEquals(driver.getCurrentUrl(),"https://the-internet.herokuapp.com/secure","Third assertion");

        //Assert all
        soft.assertAll();


    }

    @Test
    public void inValidData() throws InterruptedException {
        driver.navigate().to("https://the-internet.herokuapp.com/login");
        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys("tomsmi");
        Thread.sleep(3000);
        driver.findElement(By.name("password")).sendKeys("SuperSecret");
        Thread.sleep(3000);
        driver.findElement(By.name("password")).sendKeys(Keys.ENTER);
        String expectedResult = "Your username is invalid!" ;
        String actualResult = driver.findElement(By.id("flash")).getText();
        Assert.assertTrue(actualResult.contains(expectedResult),"wrong message");
    }

    @AfterTest
    public void closeDriver() throws InterruptedException {

        Thread.sleep(3000);
        // 5 driver close
        driver.quit();
    }

}
