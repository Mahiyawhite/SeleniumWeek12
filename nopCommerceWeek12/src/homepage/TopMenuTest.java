package homepage;

import browserTesting.BaseClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class TopMenuTest extends BaseClass {

    String baseUrl = "https://demo.nopcommerce.com/";
    @Before
    public void setupTest(){
        openBrowser(baseUrl);
    }

    /*1.1 create method with name "selectMenu" it has one parameter name "menu" of type string*/
    public void selectMenu(String menu){
        driver.findElement(By.linkText(menu)).click();
    }
    /*1.3. create the @Test method name verifyPageNavigation.use selectMenu method to
           select the Menu and click on it and verify the page navigation.*/
    @Test
    public void verifyPageNavigation() {
        String menuName = "Computers";
        selectMenu("Computers");

        String expectedTitle = "nopCommerce demo store. Computers";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }
}

