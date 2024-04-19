import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class P07_SliderPage {

    WebDriver driver;

    public P07_SliderPage(WebDriver driver)
    {
        this.driver = driver;
    }


    public WebElement sliders(String num)
    {
        return driver.findElement(By.cssSelector("a[class=\"nivo-imageLink\"]:nth-child("+num+")"));
    }



}
