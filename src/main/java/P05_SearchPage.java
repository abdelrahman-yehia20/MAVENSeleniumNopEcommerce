import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class P05_SearchPage {

    WebDriver driver;
    By searchField = By.id("small-searchterms");
    By productResultList = By.cssSelector("h2[class=\"product-title\"] a[href]");

    public P05_SearchPage(WebDriver driver)
    {
        this.driver = driver;
    }

    P05_SearchPage SearchWithProductName(String productName){
        driver.findElement(searchField).sendKeys(productName);
        driver.findElement(searchField).sendKeys(Keys.ENTER);
        return this;
    }

    public List<WebElement> searchResultList(){
        return driver.findElements(this.productResultList);
    }
}
