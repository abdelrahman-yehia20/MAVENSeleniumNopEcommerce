import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class D07_SliderTest extends TestBase{
    P07_SliderPage slider = new P07_SliderPage(driver);;

    @Test
    public void Slider1()
    {
        slider.sliders("1").click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

       // Boolean Check = wait.until(ExpectedConditions.urlContains("https://demo.nopcommerce.com/iphone-14-pro"));
       // Assert.assertTrue(Check);

        String actualURL= driver.getCurrentUrl();
        String expectedURL = "https://demo.nopcommerce.com/iphone-14-pro";
        Assert.assertEquals(actualURL,expectedURL);
    }


    @Test
    public void slider2()
    {
        slider.sliders("2").click();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        boolean check2 = wait.until(ExpectedConditions.urlContains("https://demo.nopcommerce.com/galaxy-s22-ultra"));

        Assert.assertTrue(check2);
    }
}
