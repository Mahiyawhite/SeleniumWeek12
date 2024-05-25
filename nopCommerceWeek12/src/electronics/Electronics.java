package electronics;

import browserTesting.BaseClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Electronics extends BaseClass {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setupTest() {
        openBrowser(baseUrl);
    }

    /*1. Test name verifyUserShouldNavigateToCellPhonesPageSuccessfully()
      1.1 Mouse Hover on “Electronics” Tab
      1.2 Mouse Hover on “Cell phones” and click
      1.3 Verify the text “Cell phones”*/
    @Test
    public void verifyUserShouldNavigateToCellPhonesPageSuccessfully() {
        Actions actions = new Actions(driver);
        driver.findElement(By.xpath("/html/body/div[6]/div[2]/ul[1]/li[2]/a")).click();
        driver.findElement(By.xpath("//a[text()=' Cell phones ']")).click();

        String actualCellphoneMsg = driver.findElement(By.xpath("//div[@id=\"main\"]/div/div[3]/div/div[1]/h1")).getText();
        String expectingCellphoneMsg = "Cell phones";
        Assert.assertEquals(actualCellphoneMsg, expectingCellphoneMsg);
    }

    /*2. Test name verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully()*/
    @Test
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws InterruptedException {
        Actions actions = new Actions(driver);

        /*2.1 Mouse Hover on “Electronics” Tab*/
        driver.findElement(By.xpath("//a[text()='Electronics ']")).click();

        /*2.2 Mouse Hover on “Cell phones” and click*/
        driver.findElement(By.xpath("//a[text()=' Cell phones ']")).click();

        /*2.3 Verify the text “Cell phones”*/
        String actualCellphoneMsg = driver.findElement(By.xpath("//*[@id='main']/div/div[3]/div/div[1]/h1")).getText();
        String expectingCellphoneMsg = "Cell phones";
        Assert.assertEquals(actualCellphoneMsg, expectingCellphoneMsg);

        /*2.4 Click on List View Tab*/
        driver.findElement(By.xpath("//*[@id='main']/div/div[3]/div/div[2]/div[1]/div[1]/a[2]")).click();

        /*2.5 Click on product name “Nokia Lumia 1020” link*/
        /*((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 500);");
        driver.findElement(By.xpath("//*[@id='main']/div/div[3]/div/div[2]/div[2]/div[2]/div/div/div[3]/div/div[2]/h2/a")).click();*/
        WebElement button= driver.findElement(By.xpath("//*[text()='Nokia Lumia 1020']"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(button));
        Thread.sleep(2000);

        driver.findElement(By.xpath("//*[text()='Nokia Lumia 1020']")).click();

        /* 2.6 Verify the text “Nokia Lumia 1020”*/
        String actualNokiaText = driver.findElement(By.xpath("//*[@id='product-details-form']/div/div[1]/div[2]/div[1]/h1")).getText();
        String expectedNokiaText = "Nokia Lumia 1020";
        Assert.assertEquals(actualNokiaText, expectedNokiaText);

        /* 2.7 Verify the price “$349.00”*/
        String actualPrice = driver.findElement(By.xpath("//span[@id='price-value-20']")).getText();
        String expectedPrice = "$349.00";
        Assert.assertEquals(actualPrice, expectedPrice);

        /*2.8 Change quantity to 2*/
        driver.findElement(By.xpath("//input[@id='product_enteredQuantity_20']")).clear();
        driver.findElement(By.xpath("//input[@id='product_enteredQuantity_20']")).sendKeys("2");

        /*2.9 Click on “ADD TO CART” tab*/
        /*WebElement button = driver.findElement(By.xpath("//*[@id=\"main\"]/div/div[3]/div/div[2]/div[2]/div[2]/div/div/div[3]/div/div[2]/div[3]/div[2]/button[1]"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(button));
        Thread.sleep(2000);*/
        driver.findElement(By.xpath("//button[@id='add-to-cart-button-20']")).click();

        /*2.10 Verify the Message "The product has been added to your shopping cart" on Top green Bar*/
        String actualDisplayMsg = driver.findElement(By.xpath("//*[@id='bar-notification']/div/p")).getText();
        String expectedDisplayMsg = "The product has been added to your shopping cart";
        Assert.assertEquals(actualDisplayMsg,expectedDisplayMsg);

        /*After that close the bar clicking on the cross button.*/
        driver.findElement(By.xpath("//*[@id='bar-notification']/div/span")).click();

        /*2.11 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.*/
        Actions actions1 = new Actions(driver);
        driver.findElement(By.linkText("Shopping cart")).click();

        /*2.12 Verify the message "Shopping cart"*/
        String actualShoppingCartMsg = driver.findElement(By.xpath("//h1[text()='Shopping cart']")).getText();
        String expectedShoppingCartMsg = "Shopping cart";
        Assert.assertEquals(actualShoppingCartMsg,expectedShoppingCartMsg);

        /*2.13 Verify the quantity is 2*/
        String actualQuantity = driver.findElement(By.xpath("//div[@class='product-quantity']/input")).getText();
        String expectedQuantity = "";
        Assert.assertEquals(actualQuantity,expectedQuantity);

        /*2.14 Verify the Total $698.00*/
        String actualAmount = driver.findElement(By.xpath("//span[text()='$698.00']")).getText();
        String expectedAmount = "$698.00";
        Assert.assertEquals(actualAmount,expectedAmount);

        /*2.15 click on checkbox “I agree with the terms of service”*/
        driver.findElement(By.xpath("//input[@id='termsofservice']")).click();

        /*2.16 Click on “CHECKOUT”*/
        driver.findElement(By.xpath("//button[@id='checkout']")).click();

        /*2.17 Verify the Text “Welcome, Please Sign In!”*/
        String actualwelcomeMsg = driver.findElement(By.xpath("//h1[text()='Welcome, Please Sign In!']")).getText();
        String expectedWelcomeMsg = "Welcome, Please Sign In!";
        Assert.assertEquals(actualwelcomeMsg,expectedWelcomeMsg);

        /*2.18 Click on “REGISTER” tab*/
        driver.findElement(By.xpath("//button[@class='button-1 register-button']")).click();

        /*2.19 Verify the text “Register”*/
        String actualRegMsg = driver.findElement(By.xpath("//div[@class='page-title']/h1")).getText();
        String expectedRegMsg = "Register";
        Assert.assertEquals(actualRegMsg,expectedRegMsg);

        /*2.20 Fill the mandatory fields*/
        driver.findElement(By.id("FirstName")).sendKeys("Diya");

        driver.findElement(By.id("LastName")).sendKeys("Oza");

        driver.findElement(By.id("Email")).sendKeys("diya.oza@gmail.com");

        driver.findElement(By.name("Password")).sendKeys("Diya123");

        driver.findElement(By.id("ConfirmPassword")).sendKeys("Diya123");

        driver.findElement(By.id("register-button")).click();

        String actualRegText = driver.findElement(By.xpath("//div[@class='result']")).getText();
        String expectedRegText = "Your registration completed";
        Assert.assertEquals("Your registration completed",expectedRegText,actualRegText);
    }

}





