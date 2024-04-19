import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Random;

public class D08_FollowUsTest extends TestBase {
    P08_FollowUsPage follow = new P08_FollowUsPage(driver); ;



    @Test
    public void FacebookIcon() throws InterruptedException {
        driver.findElement(By.cssSelector("a[href=\"http://www.facebook.com/nopCommerce\"]")).click();
        Thread.sleep(3000);
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.facebook.com/nopCommerce");
    }

    @Test
    public void twitterIcon()
    {
        follow.twitter().click();
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        Assert.assertEquals(driver.getCurrentUrl(),"https://twitter.com/nopCommerce");
    }

    @Test
    public void rss()
    {
        follow.rss().click();
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        Assert.assertEquals(driver.getCurrentUrl(),"https://demo.nopcommerce.com/new-online-store-is-open");
    }

    @Test
    public void youtube() throws InterruptedException {
        follow.youtube().click();
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        Thread.sleep(3000);
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.youtube.com/user/nopCommerce");
    }


    @Test
    public void randomChoice()
    {
        int random = new Random().nextInt(4);
        follow.locat().get(random).click();
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        String actualURL = driver.getCurrentUrl();
        if(random ==0)
        {
            Assert.assertEquals(actualURL,"https://www.facebook.com/nopCommerce");
        }

        else if (random ==1)
        {
            Assert.assertEquals(actualURL,"https://twitter.com/nopCommerce");
        }

        else if (random ==2)
        {
            Assert.assertEquals(actualURL,"https://demo.nopcommerce.com/new-online-store-is-open");
        }

        else if (random ==3)
        {
            Assert.assertEquals(actualURL,"https://www.youtube.com/user/nopCommerce");
        }

        else
        {
            driver.close();
        }


    }



    @AfterTest
    public void closeDriver() throws InterruptedException {

        Thread.sleep(3000);
        // 5 driver close
        driver.quit();
    }
}
