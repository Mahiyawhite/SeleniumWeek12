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
    public void selectMyAccountLogin(String option){
        WebElement dropDown1 = driver.findElement(By.xpath("//div[@id='top-links']/ul/li[2]/a"));
        dropDown1.click();
        List<WebElement> optionsAccount = driver.findElements(By.xpath("//div[@id='top-links']/ul/li[2]/ul/li[2]/a"));

        for (WebElement opt : optionsAccount){
            if (opt.getText().equalsIgnoreCase("Login")){
                System.out.println(opt.getText());
                opt.click();
            }
        }
    }
    public void selectMyAccountLogout(String option){
        WebElement Logout =driver.findElement(By.xpath("//aside[@id='column-right']/div/a[13]"));
        Logout.click();
    }
    /*1. Test name verifyUserShouldNavigateToRegisterPageSuccessfully()
      1.1 Click on My Account Link.
      1.2 Call the method “selectMyAccountOptions” method and pass the parameter “Register”
      1.3 Verify the text “Register Account”.*/
    @Test
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() {
        selectMyAccountOptions("Register");

        String actualRegisterMsg = driver.findElement(By.xpath("//div[@id='content']/h1")).getText();
        String expectingRegisterMsg = "Register Account";
        Assert.assertEquals(actualRegisterMsg,expectingRegisterMsg,"Register Account");

    }
    /*2. Test name verifyUserShouldNavigateToLoginPageSuccessfully()
      2.1 Click on My Account Link.
      2.2 Call the method “selectMyAccountOptions” method and pass the parameter“Login”*/
    @Test
    public void verifyUserShouldNavigateToLoginPageSuccessfully(){
        selectMyAccountLogin("Login");
        /*2.3 Verify the text “Returning Customer”*/
        String actualReturningCustomerText = driver.findElement(By.xpath("//h2[text()='Returning Customer']")).getText();
        String expectedReturningCustomerText = "Returning Customer";
        Assert.assertEquals(actualReturningCustomerText,expectedReturningCustomerText);
    }
    /*3. Test name verifyThatUserRegisterAccountSuccessfully()*/
    @Test
    public void verifyThatUserRegisterAccountSuccessfully(){
        /*3.1 Click on My Account Link.
        3.2 Call the method “selectMyAccountOptions” method and pass the parameter “Register”*/
        selectMyAccountOptions("Register");

        /*3.3 Enter First Name*/
        driver.findElement(By.id("input-firstname")).sendKeys("Aman");

        /*3.4 Enter Last Name*/
        driver.findElement(By.id("input-lastname")).sendKeys("Joshi");

        /*3.5 Enter Email*/
        driver.findElement(By.id("input-email")).sendKeys("aman.joshi@gmail.com");

        /*3.6 Enter Telephone*/
        driver.findElement(By.id("input-telephone")).sendKeys("07569941515");

        /*3.7 Enter Password*/
        driver.findElement(By.id("input-password")).sendKeys("aman123");

        /*3.8 Enter Password Confirm*/
        driver.findElement(By.id("input-confirm")).sendKeys("aman123");

        /*3.9 Select Subscribe Yes radio button*/
        driver.findElement(By.xpath("//label[@class='radio-inline']/input")).click();

        /*3.10 Click on Privacy Policy check box*/
        driver.findElement(By.name("agree")).click();

        /*3.11 Click on Continue button*/
        driver.findElement(By.xpath("//*[@id='content']/form/div/div/input[2]")).click();

        /*3.12 Verify the message “Your Account Has Been Created!”*/
        String actualAccountCreatedMsg = driver.findElement(By.cssSelector("div[id='content']>h1")).getText();
        String expectedAccountCreatedMsg = "Your Account Has Been Created!";
        Assert.assertEquals(actualAccountCreatedMsg,expectedAccountCreatedMsg);

        /*3.13 Click on Continue button*/
        driver.findElement(By.cssSelector("div[class='pull-right']>a")).click();

        /*3.14 Click on My Account Link.*/
        driver.findElement(By.cssSelector("div[id='content']>h2")).click();

        /*3.15 Call the method “selectMyAccountOptions” method and pass the parameter “Logout”*/
        selectMyAccountLogout("Logout");

        /*3.16 Verify the text “Account Logout”*/
        String actualLogoutMsg = driver.findElement(By.cssSelector("div[id='content']>h1")).getText();
        String expectLogoutMsg = "Account Logout";
        Assert.assertEquals(actualLogoutMsg,expectLogoutMsg);

        /*3.17 Click on Continue button*/
        driver.findElement(By.cssSelector("div[class='pull-right']>a")).click();
    }
    /*4. Test name verifyThatUserShouldLoginAndLogoutSuccessfully()*/
    @Test
    public void verifyThatUserShouldLoginAndLogoutSuccessfully(){
        /*4.1 Click on My Account Link.
          4.2 Call the method “selectMyAccountOptions” method and pass the parameter “Login”*/
        selectMyAccountLogin("Login");

        /*4.3 Enter Email address*/
        driver.findElement(By.cssSelector("input[id='input-email']")).sendKeys("aman.joshi@gmail.com");

        /*4.4 Enter Last Name*/

        /*4.5 Enter Password*/
        driver.findElement(By.cssSelector("input[id='input-password']")).sendKeys("aman123");

        /*4.6 Click on Login button*/
        driver.findElement(By.xpath("//div[@id='content']/div/div[2]/div/form/input")).click();

        /*4.7 Verify text “My Account”*/
        String actualMyAccountText = driver.findElement(By.cssSelector("div[id='content']>h2")).getText();
        String expectedMyAccountText = "My Account";
        Assert.assertEquals(actualMyAccountText,expectedMyAccountText);

        /*4.8 Click on My Account Link.*/
        driver.findElement(By.xpath("//div[@class='list-group']/a[1]")).click();

        /*4.9 Call the method “selectMyAccountOptions” method and pass the parameter “Logout”*/
        selectMyAccountLogout("Logout");

        /*4.10 Verify the text “Account Logout”*/
        String actualLogoutMsg = driver.findElement(By.cssSelector("div[id='content']>h1")).getText();
        String expectLogoutMsg = "Account Logout";
        Assert.assertEquals(actualLogoutMsg,expectLogoutMsg);

        /*4.11 Click on Continue button*/
        driver.findElement(By.cssSelector("div[class='pull-right']>a")).click();
    }
    @After
        public void closeBrowser () {
            // driver.quit();
        }
    }
