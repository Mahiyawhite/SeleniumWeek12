package myaccounts;

import browserTesting.BaseClass;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MyAccountsTest extends BaseClass {

    String baseUrl = "https://tutorialsninja.com/demo/index.php";
    @Before
    public void setupTest(){
        openBrowser(baseUrl);
    }
    /*1.1 create method with name "selectMyAccountOptions" it has one parameter name "option" of type string
      1.2 This method should click on the options whatever name is passed as parameter.
          (Hint: Handle List of Element and Select options)*/
    public void selectMyAccountOptions(String option) {
        WebElement dropDown = driver.findElement(By.xpath("//div[@id='top-links']/ul/li[2]/a"));
        dropDown.click();
        List<WebElement> optionsAccount = driver.findElements(By.xpath("//*[@id='top-links']/ul/li[2]/ul/li[1]/a"));

        for (WebElement opt : optionsAccount) {
            if (opt.getText().equalsIgnoreCase("Register")) {
                System.out.println(opt.getText());
                opt.click();
            }
        }
    }
    /*1. Test name verifyUserShouldNavigateToRegisterPageSuccessfully()
      1.1 Click on My Account Link.
      1.2 Call the method “selectMyAccountOptions” method and pass the parameter “Register”
      1.3 Verify the text “Register Account”.*/
    @Test
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() {
        driver.findElement(By.cssSelector("li[class='dropdown']>a")).click();
        selectMyAccountOptions("Register");

        String actualRegisterMsg = driver.findElement(By.xpath("//div[@id='content']/h1")).getText();
        String expectingRegisterMsg = "Register Account";
        Assert.assertEquals(actualRegisterMsg,expectingRegisterMsg,"Register Account");
        /*String expectedText = "Register Account";
        String actualText = driver.findElement(By.cssSelector("#content h1")).getText();
        Assert.assertEquals(actualText, expectedText, "Register Account");*/
    }
    /*2. Test name verifyUserShouldNavigateToLoginPageSuccessfully()
      2.1 Click on My Account Link.
      2.2 Call the method “selectMyAccountOptions” method and pass the parameter“Login”
      2.3 Verify the text “Returning Customer”.*/
    @Test
    public void verifyUserShouldNavigateToLoginPageSuccessfully(){
        driver.findElement(By.xpath("//a[text()='Login']")).click();
        selectMyAccountOptions("Login");

    }
        @After
        public void closeBrowser () {
            // driver.quit();
        }
    }
