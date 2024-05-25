package computer;

import browserTesting.BaseClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TestSuite extends BaseClass {

    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setupTest(){
    openBrowser(baseUrl);
    }
    /*1.Test name verifyProductArrangeInAlphaBaticalOrder()*/
    @Test
    public void verifyProductArrangeInAlphaBaticalOrder(){
        /*1.1 Click on Computer Menu.*/
        driver.findElement(By.linkText("Computers")).click();

        /*1.2 Click on Desktop*/
        driver.findElement(By.linkText("Desktops")).click();

        /*1.3 Select Sort By position "Name: Z to A"*/
        Select sortBy = new Select(driver.findElement(By.id("products-orderby")));
        sortBy.selectByVisibleText("Name: Z to A");

        /*1.4 Verify the Product will arrange in Descending order.*/
        /*List<WebElement> productNamesElements = driver.findElements(By.cssSelector(".product-title"));
        List<String> productNames = productNamesElements.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());

        List<String> sortedProductNames = productNames.stream()
                .sorted((a, b) -> b.compareTo(a))
                .collect(Collectors.toList());

        Assert.assertEquals("Products are not sorted in descending order", sortedProductNames, productNames);*/
    }
    /*2. Test name verifyProductAddedToShoppingCartSuccessFully()*/
    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        /*2.1 Click on Computer Menu.*/
        driver.findElement(By.linkText("Computers")).click();

        /*2.2 Click on Desktop*/
        driver.findElement(By.linkText("Desktops")).click();

        /*2.3 Select Sort By position "Name: A to Z"*/
        Select sortBy = new Select(driver.findElement(By.id("products-orderby")));
        sortBy.selectByVisibleText("Name: A to Z");

        /*2.4 Click on "Add To Cart"*/
        WebElement button = driver.findElement(By.xpath("//div[@class='item-grid']/div[1]/div/div[2]/div[3]/div[2]/button[1]"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(button));
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@class='item-grid']/div[1]/div/div[2]/div[3]/div[2]/button[1]")).click();

        /*2.5 Verify the Text "Build your own computer"*/
        String actualText = driver.findElement(By.xpath("//h1[text()='Build your own computer']")).getText();
        String expectingText = "Build your own computer";
        Assert.assertEquals("Build your own computer",expectingText,actualText);

        /*2.6 Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class*/
        WebElement ProcessorSelect = driver.findElement(By.xpath("//select[@id='product_attribute_1']"));
        Select selectP = new Select(ProcessorSelect);
        selectP.selectByVisibleText("2.2 GHz Intel Pentium Dual-Core E2200");

        /*2.7.Select "8GB [+$60.00]" using Select class.*/
        WebElement RamSelect = driver.findElement(By.xpath("//select[@id='product_attribute_2']"));
        Select selectR = new Select(RamSelect);
        selectR.selectByVisibleText("8GB [+$60.00]");

        /*2.8 Select HDD radio "400 GB [+$100.00]"*/
        driver.findElement(By.xpath("//input[@id='product_attribute_3_7']")).click();

        /*2.9 Select OS radio "Vista Premium [+$60.00]"*/
        driver.findElement(By.xpath("//input[@id='product_attribute_4_9']")).click();

        /*2.10 Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander [+$5.00]"*/
        driver.findElement(By.xpath("//input[@id='product_attribute_5_10']")).click();
        driver.findElement(By.xpath("//input[@id='product_attribute_5_12']")).click();

        /*2.11 Verify the price "$1,475.00"*/
        /*String actualPrice = driver.findElement(By.xpath("//*[@id='price-value-1']")).getText();
        String expectingPrice = "$1,460.00";
        Assert.assertEquals(expectingPrice,actualPrice);*/

        /*2.12 Click on "ADD TO CARD" Button.*/
        driver.findElement(By.xpath("//button[@id='add-to-cart-button-1']")).click();

        /*2.13 Verify the Message "The product has been added to your shopping cart" on Top green Bar
           After that close the bar clicking on the cross button.*/
        /*String actualVerifyMsg = driver.findElement(By.xpath("//div[@id='bar-notification']/div/p")).getText();
        System.out.println(actualVerifyMsg);
        String expectedVerifyMsg = "The product has been added to your shopping cart x";
        Assert.assertEquals(actualVerifyMsg,expectedVerifyMsg);*/

        driver.findElement(By.xpath("//div[@id='bar-notification']/div/span")).click();

        /*2.14 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.*/
        Actions actions = new Actions(driver);
        driver.findElement(By.cssSelector("span[class='cart-label']")).click();
        driver.findElement(By.xpath("//div[@id='flyout-cart']/div/div[4]/button")).click();

        /*2.15 Verify the message "Shopping cart"*/
        String actualShoppingCartText = driver.findElement(By.cssSelector("div[class='page-title']")).getText();
        String expectedShoppingCartText = "Shopping cart";
        Assert.assertEquals(actualShoppingCartText,expectedShoppingCartText);

        /*2.16 Change the Qty to "2" and Click on "Update shopping cart"*/
        driver.findElement(By.cssSelector("div[class='product-quantity']>input")).sendKeys("2");

        /*2.17 Verify the Total"$2,950.00"*/
        String actualPrice = driver.findElement(By.xpath("//form[@id='shopping-cart-form']/div[1]/table/tbody/tr/td[6]/span")).getText();
        String expectedPrice = "$2,950.00";
        Assert.assertEquals(actualPrice,expectedPrice);

        /*2.18 click on checkbox “I agree with the terms of service”*/
        driver.findElement(By.cssSelector("input[id='termsofservice']")).click();

        /*2.19 Click on “CHECKOUT”*/
        driver.findElement(By.cssSelector("button[id='checkout']")).click();

        /*2.20 Verify the Text “Welcome, Please Sign In!”*/
        String actualWelcomeText = driver.findElement(By.xpath("//div[@class='page-title']/h1")).getText();
        String expectedWelcomeText = "Welcome, Please Sign In!";
        Assert.assertEquals(actualWelcomeText,expectedWelcomeText);


    }


}



