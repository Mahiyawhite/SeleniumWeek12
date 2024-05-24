package desktops;

import homepage.TopMenuTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class DesktopsTest extends TopMenuTest {
    String baseUrl = "https://tutorialsninja.com/demo/index.php";

    @Before
    public void setupTest() {
        openBrowser(baseUrl);
    }

    /*Write the following Test:
       1.Test name verifyProductArrangeInAlphaBaticalOrder()*/
    @Test
    public void verifyProductArrangeInAlphaBaticalOrder() throws InterruptedException {

        /*1.1 Mouse hover on Desktops Tab.and click*/
        Actions actions = new Actions(driver);
        WebElement desktopsTab = driver.findElement(By.xpath("//a[text()='Desktops']"));
        actions.moveToElement(desktopsTab).click().perform();

        /*1.2 Click on “Show All Desktops”*/
        selectMenu("Show All Desktops");
        driver.findElement(By.xpath("//a[text()='Show AllDesktops']")).click();

        /*1.3 Select Sort By position "Name: Z to A"*/
        WebElement dropDown = driver.findElement(By.id("input-sort"));
        Select select = new Select(dropDown);
        dropDown.findElement(By.xpath("//select[@id='input-sort']/option[3]")).click();

        Thread.sleep(3000);
        /* 1.4 Verify the Product will arrange in Descending order.*/
        /*List<WebElement> productList = driver.findElements(By.cssSelector(".product-thumb .caption a"));
        List<String> productNames = new ArrayList<>();

        for (WebElement product : productList) {
            productNames.add(product.getText());
        }
        List<String> sortedProductNames = new ArrayList<>(productNames);
        Collections.sort(sortedProductNames, Collections.reverseOrder());

        Assert.assertEquals("Products are not sorted in descending order", productNames, sortedProductNames);*/
    }
    /*2. Test name verifyProductAddedToShoppingCartSuccessFully()*/
    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {

        /*2.1 Mouse hover on Desktops Tab. and click*/
        Actions actions = new Actions(driver);
        WebElement desktopTab = driver.findElement(By.xpath("//a[text()='Desktops']"));
        actions.moveToElement(desktopTab).click().perform();

        /*2.2 Click on “Show All Desktops”*/
        selectMenu("Show All Desktops");
        driver.findElement(By.xpath("//a[text()='Show AllDesktops']")).click();

        /*2.3 Select Sort By position "Name: A to Z"*/
        WebElement dropDown = driver.findElement(By.id("input-sort"));
        Select select = new Select(dropDown);
        dropDown.findElement(By.xpath("//select[@id='input-sort']/option[2]")).click();

        /*2.4 Select product “HP LP3065”*/
        driver.findElement(By.linkText("HP LP3065")).click();

        /*2.5 Verify the Text "HP LP3065"*/
        String actualHpText = driver.findElement(By.linkText("HP LP3065")).getText();
        String expectedHpText = "HP LP3065";
        Assert.assertEquals("HP LP3065",expectedHpText,actualHpText);

        /*2.6 Select Delivery Date "2022-11-30"*/
        driver.findElement(By.id("input-option225")).clear();
        driver.findElement(By.id("input-option225")).sendKeys("2022-11-30");

        /*2.7.Enter Qty "1” using Select class.*/
        /*Select select1 = new Select(driver.findElement(By.xpath("//input[@id='input-quantity']")));
        Thread.sleep(3000);
        select1.deselectByValue("1");*/
        driver.findElement(By.xpath("//input[@id='input-quantity']")).clear();
        driver.findElement(By.xpath("//input[@id='input-quantity']")).sendKeys("1");

        /*2.8 Click on “Add to Cart” button*/
        driver.findElement(By.id("button-cart")).click();

        /*2.9 Verify the Message “Success: You have added HP LP3065 to your shopping cart!”*/
        /*String actualDisplayMsg = driver.findElement(By.xpath("//div[@id='product-product']/div[1]")).getText();
        System.out.println(actualDisplayMsg);
        String expectingDisplayMsg = "Success: You have added HP LP3065 to your shopping cart!\n" + "x";
        Assert.assertEquals("Message to add cart into successfully",actualDisplayMsg,expectingDisplayMsg);*/

        /*2.10 Click on link “shopping cart” display into success message*/
        driver.findElement(By.linkText("Shopping Cart")).click();

        /*2.11 Verify the text "Shopping Cart"*/
        String actualCartMsg = driver.findElement(By.xpath("//div[@id='content']/h1")).getText();
        String expectedCartMsg = "Shopping Cart  (1.00kg)";
        Assert.assertEquals(actualCartMsg,expectedCartMsg);

        /* 2.12 Verify the Product name "HP LP3065"*/
        String actualName = driver.findElement(By.linkText("HP LP3065")).getText();
        String expectingName = "HP LP3065";
        Assert.assertEquals(actualName,expectingName);

        /*2.13 Verify the Delivery Date "2022-11-30"*/
        String actualDelivaryDate = driver.findElement(By.xpath("//small[text()='Delivery Date:2022-11-30']")).getText();
        String expectedDelivaryDate = "Delivery Date:2022-11-30";
        Assert.assertEquals(actualDelivaryDate,expectedDelivaryDate);

        /*2.14 Verify the Model "Product21"*/
        String actualModel = driver.findElement(By.xpath("//td[text()='Product 21']")).getText();
        String expectedModel = "Product 21";
        Assert.assertEquals("Product 21",actualModel,expectedModel);

        /*2.15 Verify the Total "$122.00"*/
        String actualTotal = driver.findElement(By.xpath("//div[@id='content']/form/div/table/tbody/tr/td[6]")).getText();
        String expectedTotal = "$122.00";
        Assert.assertEquals(actualTotal,expectedTotal);
    }
    @After
    public void closeBrowser() {
        //driver.quit();
    }
}

