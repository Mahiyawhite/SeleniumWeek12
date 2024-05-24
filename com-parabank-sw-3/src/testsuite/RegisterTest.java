package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class RegisterTest extends BaseTest {
    String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";

    @Before
    public void setupTest(){
        openBrowser(baseUrl);
    }

    /*1.verifyThatSigningUpPageDisplay
     * click on the ‘Register’ link
     * Verify the text ‘Signing up is easy!’*/
    @Test
    public void register(){
        driver.findElement(By.xpath("//a[text()='Register']")).click();

        String actualSignupMsg = driver.findElement(By.xpath("//h1[text()='Signing up is easy!']")).getText();
        String expectedSignupMsg = "Signing up is easy!";
        Assert.assertEquals("Signing up is easy!",expectedSignupMsg,actualSignupMsg);
    }
    @Test
    public void registerPage(){
        driver.findElement(By.xpath("//a[text()='Register']")).click();

        driver.findElement(By.id("customer.firstName")).sendKeys("Amitab");

        driver.findElement(By.id("customer.lastName")).sendKeys("Vyas");

        driver.findElement(By.id("customer.address.street")).sendKeys("32,pluto Road");

        driver.findElement(By.id("customer.address.city")).sendKeys("GandhiNagar");

        driver.findElement(By.id("customer.address.state")).sendKeys("India");

        driver.findElement(By.id("customer.address.zipCode")).sendKeys("hs8 9pt");

        driver.findElement(By.id("customer.phoneNumber")).sendKeys("07545121414");

        driver.findElement(By.id("customer.ssn")).sendKeys("51");

        driver.findElement(By.id("customer.username")).sendKeys("Milkybar");

        driver.findElement(By.id("customer.password")).sendKeys("Chocolate123");

        driver.findElement(By.id("repeatedPassword")).sendKeys("Chocolate123");

        driver.findElement(By.xpath("//*[@id='customerForm']/table/tbody/tr[13]/td[2]/input")).click();

        String actualWelcomeMsg = driver.findElement(By.xpath("//p[text()='Your account was created successfully. You are now logged in.']")).getText();
        String expectedWelcomeMsg = "Your account was created successfully. You are now logged in.";
        Assert.assertEquals("Your account was created successfully. You are now logged in.",expectedWelcomeMsg,actualWelcomeMsg);
    }
    @After
    public void closeBrowser(){
       // driver.quit();
    }
}
