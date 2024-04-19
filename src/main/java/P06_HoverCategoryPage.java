import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class P06_HoverCategoryPage {


    WebDriver driver;
    By mainCategory = By.xpath("//ul[@class=\"top-menu notmobile\"]/li/a");

    public P06_HoverCategoryPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public List<WebElement> mainCategory()
    {
        return driver.findElements(mainCategory);
    }

    public List<WebElement> subCategory(String num)
    {
        return driver.findElements(By.xpath("//ul[@class=\"top-menu notmobile\"]/li["+num+"]/ul/li"));
    }

}
