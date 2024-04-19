import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class P08_FollowUsPage {

    WebDriver driver;

    public P08_FollowUsPage(WebDriver driver)
    {
        this.driver = driver;
    }


    public WebElement twitter()
    {
       return driver.findElement(By.cssSelector("a[href=\"https://twitter.com/nopCommerce\"]"));
    }


    public WebElement rss()
    {
        return driver.findElement(By.cssSelector("a[href=\"/news/rss/1\"]"));

    }

    public WebElement youtube()
    {
        return driver.findElement(By.cssSelector("a[href=\"http://www.youtube.com/user/nopCommerce\"]"));

    }

    public List<WebElement> locat()
    {
        return driver.findElements(By.xpath("//ul[@class=\"networks\"]/li/a"));
    }

}
