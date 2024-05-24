package laptopsandnotebooks;

import browserTesting.BaseClass;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class LaptopsAndNotebooksTest extends BaseClass {
    String baseUrl = "https://tutorialsninja.com/demo/index.php";
    @Before
    public void setupTest(){
        openBrowser(baseUrl);
    }
    /*1. Test name verifyProductsPriceDisplayHighToLowSuccessfully()*/
    @Test
    public void verifyProductsPriceDisplayHighToLowSuccessfully() {
        /*1.1 Mouse hover on Laptops & Notebooks Tab.and click*/
        Actions actions = new Actions(driver);
        driver.findElement(By.xpath("//a[text()='Laptops & Notebooks']")).click();

        /*1.2 Click on “Show All Laptops & Notebooks”*/
        driver.findElement(By.xpath("//a[text()='Show AllLaptops & Notebooks']")).click();

        /*1.3 Select Sort By "Price (High > Low)"*/
        WebElement dropDown = driver.findElement(By.id("input-sort"));
        Select select = new Select(dropDown);
        dropDown.findElement(By.xpath("//select[@id='input-sort']/option[5]")).click();

        /*1.4 Verify the Product price will arrange in High to Low order.*/



    }
    @Test
    /*2. Test name verifyThatUserPlaceOrderSuccessfully()*/
    public void verifyThatUserPlaceOrderSuccessfully() throws InterruptedException {
        /*2.1 Mouse hover on Laptops & Notebooks Tab and click*/
        Actions actions = new Actions(driver);
        driver.findElement(By.xpath("//a[text()='Laptops & Notebooks']")).click();

        /*2.2 Click on “Show All Laptops & Notebooks”*/
        driver.findElement(By.xpath("//a[text()='Show AllLaptops & Notebooks']")).click();

        /*2.3 Select Sort By "Price (High > Low)"*/
        WebElement dropDown = driver.findElement(By.id("input-sort"));
        Select select = new Select(dropDown);
        dropDown.findElement(By.xpath("//select[@id='input-sort']/option[5]")).click();

        /*2.4 Select Product “MacBook”*/
        driver.findElement(By.linkText("MacBook")).click();

        /*2.5 Verify the text “MacBook”*/
        String actualMacbookText = driver.findElement(By.xpath("//h1[text()='MacBook']")).getText();
        String expectingMacbookText = "MacBook";
        Assert.assertEquals(actualMacbookText,expectingMacbookText);

        driver.findElement(By.xpath("//input[@id='input-quantity']")).clear();
        driver.findElement(By.xpath("//input[@id='input-quantity']")).sendKeys("1");

        /*2.6 Click on ‘Add To Cart’ button*/
        driver.findElement(By.id("button-cart")).click();

        /*2.7 Verify the message “Success: You have added MacBook to your shopping cart!”*/
        String actualSuccessMsg = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")).getText();
        System.out.println(actualSuccessMsg);
        String expectedSuccessMsg = "Success: You have added MacBook to your shopping cart!\n" + "×";
        Assert.assertEquals(expectedSuccessMsg,actualSuccessMsg);

        /*2.8 Click on link “shopping cart” display into success message*/
        driver.findElement(By.xpath("//a[text()='shopping cart']")).click();

        /*2.9 Verify the text "Shopping Cart"*/
        String actualCartMsg = driver.findElement(By.xpath("//div[@id='content']/h1")).getText();
        String expectedCartMsg = "Shopping Cart  (0.00kg)";
        Assert.assertEquals(actualCartMsg,expectedCartMsg);


        /*2.10 Verify the Product name "MacBook"*/
        String actualName = driver.findElement(By.xpath("//*[@id='content']/form/div/table/tbody/tr/td[2]/a")).getText();
        String expectedName = "MacBook ***";
        Assert.assertEquals(actualName,expectedName);

        /*2.11 Change Quantity "2"*/

    }
@After
    public void closeBrowser(){
       // driver.quit();
    }
}
