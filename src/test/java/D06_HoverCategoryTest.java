import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Random;

public class D06_HoverCategoryTest extends TestBase {
    P06_HoverCategoryPage category;


    @Test
    public void Category()
    {

        category = new P06_HoverCategoryPage(driver);
        //1- Generate a random number from zero to the number of main category
        int randomNum = new Random().nextInt(6);

        //2- Hover on the main category
        Actions actions = new Actions(driver);
        actions.moveToElement(category.mainCategory().get(randomNum)).perform();

        // Select a random subcategory if found
        // locate sub category that belongs to the selected main category
        String randomNubString = String.valueOf(randomNum+1);


        if(category.subCategory(randomNubString).size()==0)
        {
            category.mainCategory().get(randomNum).click();
        }

        else
        {
            int randomSub = new Random().nextInt(3);
            category.subCategory(randomNubString).get(randomSub).click();
        }



        /*
        The original code

        //1- Generate a random number from zero to the number of main category
        int randomNum = new Random().nextInt(3);

        //2- Hover on the main category
        Actions actions = new Actions(driver);
        actions.moveToElement(category.mainCategory().get(randomNum)).perform();

        // Select a random subcategory if found
        // locate sub category that belongs to the selected main category
        String randomNubString = String.valueOf(randomNum+1);

        int randomSub = new Random().nextInt(3);
        category.subCategory(randomNubString).get(randomSub).click();
        */
    }

}
