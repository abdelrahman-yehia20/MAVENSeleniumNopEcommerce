import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class P04_CurrencyPage {

    WebDriver driver;
    Select select;
    By currencyDrp = By.id("customerCurrency");
    By products = By.cssSelector("span[class=\"price actual-price\"]");

    public P04_CurrencyPage(WebDriver driver) {
        this.driver = driver;
    }


    public P04_CurrencyPage SelectEuro() {
        select = new Select(driver.findElement(currencyDrp));
        select.selectByVisibleText("Euro");
        return this;
    }

    public List<WebElement> CurrencyResult() {
        return driver.findElements(By.cssSelector("span[class=\"price actual-price\"]"));
    }

}
