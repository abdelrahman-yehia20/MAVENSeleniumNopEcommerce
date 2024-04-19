import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class P02_LoginPage {

    WebDriver driver ;

    By loginBtn = By.className("ico-login");
    By email = By.id("Email");
    By password = By.id("Password");
    By logOutBtn = By.className("ico-logout");
        public P02_LoginPage(WebDriver driver)
        {
            this.driver= driver;
        }




        public P02_LoginPage openLoginPage(){
            driver.findElement(loginBtn).click();
            return this;
        }

    public void AddLoginCredentials(String email, String password) throws InterruptedException {
        driver.findElement(this.email).sendKeys(email);
        Thread.sleep(3000);
        driver.findElement(this.password).sendKeys(password);
        driver.findElement(this.password).sendKeys(Keys.ENTER);
    }

    public Boolean validateLogOutBtnAppear(){
          return  driver.findElement(logOutBtn).isDisplayed();
    }




}
