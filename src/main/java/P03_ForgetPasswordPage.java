import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class P03_ForgetPasswordPage {

    WebDriver driver;

    By forgetpassBtn = By.cssSelector("a[href=\"/passwordrecovery\"]");
    By email = By.id("Email");
    By recoverBtn = By.name("send-email");
    By successPopUp = By.cssSelector("p[class=\"content\"]");

    public P03_ForgetPasswordPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public P03_ForgetPasswordPage openForgetPage(){
        driver.findElement(forgetpassBtn).click();
        return this;
    }

    public P03_ForgetPasswordPage addEmail(String email){
        driver.findElement(this.email).sendKeys(email);
        return this;
    }

    public P03_ForgetPasswordPage clickOnRcoverBtn(){
        driver.findElement(recoverBtn).click();
        return this;
    }

    public Boolean emailPopUp(){
        return driver.findElement(this.successPopUp).isDisplayed();
    }



}
