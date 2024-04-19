import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Random;

public class P14_ShippingPage {

    WebDriver driver;
    Random random;
    By shippingMetthodList = By.xpath("//div[@class=\"method-name\"]/input");
    By contiueBtn = By.cssSelector("button[class=\"button-1 shipping-method-next-step-button\"]");

    public P14_ShippingPage(WebDriver driver){
        this.driver = driver;
    }

    public P14_ShippingPage chooseRandomShippingMethod(){
        random =new Random();
        int i = random.nextInt(2);
        driver.findElements(shippingMetthodList).get(i).click();
        return this;
    }

    public P14_ShippingPage ClickOnContinueBtn(){
        driver.findElement(contiueBtn).click();
        return this;
    }


}
