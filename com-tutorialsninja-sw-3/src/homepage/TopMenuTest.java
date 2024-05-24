package homepage;

import browserTesting.BaseClass;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class TopMenuTest extends BaseClass {

    String baseUrl = "https://tutorialsninja.com/demo/index.php";
    @Before
    public void setupTest() {
        openBrowser(baseUrl);
    }
    /*1.1 create method with name "selectMenu"*/
    public void selectMenu(String menu){
        driver.findElement(By.xpath("//a[text()='Show AllDesktops']")).getText();
        driver.findElement(By.xpath("//a[text()='Show AllLaptops & Notebooks']")).getText();
        driver.findElement(By.xpath("//a[text()='Show AllComponents']")).getText();
    }
    /*1. verifyUserShouldNavigateToDesktopsPageSuccessfully()*/
    @Test
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() {

        /*1.1 Mouse hover on “Desktops” Tab and click*/
        Actions actions = new Actions(driver);
        WebElement desktopsTab = driver.findElement(By.xpath("//a[text()='Desktops']"));
        actions.moveToElement(desktopsTab).click().perform();

        /*1.2 call selectMenu method and pass the menu = “Show All Desktops”*/
        selectMenu("Show All Desktops");
        driver.findElement(By.xpath("//a[text()='Show AllDesktops']")).click();

        /*1.3 Verify the text ‘Desktops’*/
        WebElement desktopsHeaderText = driver.findElement(By.xpath("//div[@id='content']/h2"));
        Assert.assertTrue("Desktops page is not displayed", desktopsHeaderText.isDisplayed());
    }

    /*2. verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully() */
    @Test
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully() {

        /*2.1 Mouse hover on “Laptops & Notebooks” Tab and click*/
        Actions actions = new Actions(driver);
        WebElement laptopsAndNotebooksTab = driver.findElement(By.xpath("//a[contains(text(),'Laptops & Notebooks')]"));
        actions.moveToElement(laptopsAndNotebooksTab).click().perform();

        /*2.2 call selectMenu method and pass the menu = “Show All Laptops & Notebooks”*/
        selectMenu("Show All Laptops & Notebooks");
        driver.findElement(By.xpath("//a[text()='Show AllLaptops & Notebooks']")).click();

        /*2.3 Verify the text ‘Laptops & Notebooks’*/
        WebElement laptopsAndNotebooksHeaderText = driver.findElement(By.xpath("//h2[contains(text(),'Laptops & Notebooks')]"));
        Assert.assertTrue("Laptops & Notebooks page is not displayed", laptopsAndNotebooksHeaderText.isDisplayed());
    }
        /*3. verifyUserShouldNavigateToComponentsPageSuccessfully()*/
    @Test
        public void verifyUserShouldNavigateToComponentsPageSuccessfully() {

        /*3.1 Mouse hover on “Components” Tab and click*/
        Actions actions = new Actions(driver);
        WebElement componentsTab = driver.findElement(By.xpath("//a[contains(text(),'Components')]"));
        actions.moveToElement(componentsTab).click().perform();

        /*3.2 call selectMenu method and pass the menu = “Show All Components”*/
        selectMenu("Show All Components");
        driver.findElement(By.xpath("//a[text()='Show AllComponents']")).click();

        /*3.3 Verify the text ‘Components’*/
        WebElement componentsHeaderText = driver.findElement(By.xpath("//h2[contains(text(),'Components')]"));
        Assert.assertTrue("Components page is not displayed", componentsHeaderText.isDisplayed());
    }
    @After
    public void closeBrowser(){
        //driver.quit();
    }
}


