package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {
    String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";

    @Before
    public void setupTest() {
        openBrowser(baseUrl);
    }


    @Test
    public void loginPage() {
        /*1.userShouldLoginSuccessfullyWithValidCredentials
         Enter valid username
         Enter valid password
         Click on ‘LOGIN’ button
         Verify the ‘Accounts Overview’ text is display*/

        driver.findElement(By.xpath("//div[@class='login']/input")).sendKeys("Milkybar");
        driver.findElement(By.xpath("//div[@id='loginPanel']/form/div[2]/input")).sendKeys("Chocolate123");
        driver.findElement(By.xpath("//div[@id='loginPanel']/form/div[3]/input")).click();

        String actualAccountText = driver.findElement(By.xpath("//div[@id='showOverview']/h1")).getText();
        String expectedAccountText = "Accounts Overview";
        Assert.assertEquals(actualAccountText, expectedAccountText);

        /*2.verifyTheErrorMessage Enter invalid username
         Enter invalid password
         Click on Login button
         Verify the error message ‘The username and password could not be verified.’*/

        driver.findElement(By.xpath("//div[@class='login']/input")).sendKeys("Monkybar");
        driver.findElement(By.xpath("//div[@id='loginPanel']/form/div[2]/input")).sendKeys("Chocolate1");
        driver.findElement(By.xpath("//div[@id='loginPanel']/form/div[3]/input")).click();

        String actualErrorMsg = driver.findElement(By.xpath("//div[@id='rightPanel']/p")).getText();
        String expectedErrorMsg = "The username and password could not be verified.";
        Assert.assertEquals(actualErrorMsg, expectedErrorMsg);


        /*3.userShouldLogOutSuccessfully
        * Enter valid username
        * Enter valid password
        * Click on ‘LOGIN’ button
        * Click on ‘Log Out’ link
        * Verify the text ‘Customer Login’*/

        driver.findElement(By.xpath("//div[@class='login']/input")).sendKeys("Milkybar");
        driver.findElement(By.xpath("//div[@id='loginPanel']/form/div[2]/input")).sendKeys("Chocolate123");
        driver.findElement(By.xpath("//div[@id='loginPanel']/form/div[3]/input")).click();
        driver.findElement(By.xpath("//a[text()='Log Out']")).click();

       String actualLoginMsg = driver.findElement(By.xpath("//h2[text()='Customer Login']")).getText();
       String expectingLoginMsg = "Customer Login";
       Assert.assertEquals(actualLoginMsg,expectingLoginMsg);
    }
    @After
    public void closeBrowser(){
        // driver.quit();
    }
}

