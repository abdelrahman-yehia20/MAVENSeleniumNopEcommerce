import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P18_ConfirmOrderPage {
    WebDriver driver;
    By confirmBtn = By.xpath("//div[@id=\"confirm-order-buttons-container\"]/button");
    By orderSuccessMessage = By.xpath("//div[@class=\"section order-completed\"]/div[@class=\"title\"]/strong");
    public P18_ConfirmOrderPage(WebDriver driver){
        this.driver = driver;
    }

    public P18_ConfirmOrderPage clickOnConfirmBtn(){
        driver.findElement(confirmBtn).click();
        return this;
    }

    public String OrderSuccessMessage(){
        return driver.findElement(orderSuccessMessage).getText();
    }

}
