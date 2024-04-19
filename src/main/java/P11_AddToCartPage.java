import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.Assertion;


public class P11_AddToCartPage {

    WebDriver driver;
    By addToCartBtn= By.xpath("//div[@class=\"product-grid home-page-product-grid\"]/div[2]/div[3]/div[1]/div[2]/div[3]/div[2]/button[1]");
    By successMessage = By.cssSelector("p.content");
    By xIcon = By.cssSelector("span.close");
    By shoppingCart = By.xpath("//a[@class=\"ico-cart\"]");

    public P11_AddToCartPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public P11_AddToCartPage addToCart(){
        driver.findElement(this.addToCartBtn).click();
        return this;
    }

    public P11_AddToCartPage successMessageIsDisplayed(){
        Assert.assertTrue(driver.findElement(successMessage).isDisplayed());
        return this;
    }
    public P11_AddToCartPage clickOnXicon(){
        driver.findElement(xIcon).click();
        return this;
    }

    public P11_AddToCartPage openCartPage(){
        driver.findElement(shoppingCart).click();
        return this;
    }
}

