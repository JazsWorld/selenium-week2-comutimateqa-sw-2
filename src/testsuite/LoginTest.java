package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

/**
 * 2. Create the package ‘testsuite’ and create the following class inside the ‘testsuite’ package.
 * 1. LoginTest
 * 3. Write down the following test into ‘LoginTest’ class
 * 1. userShouldNavigateToLoginPageSuccessfully
 * * click on the ‘Sign In’ link
 * * Verify the text ‘Welcome Back!’
 * 2. verifyTheErrorMessage
 * * click on the ‘Sign In’ link
 * * Enter invalid username
 * * Enter invalid password
 * * Click on Login button
 * * Verify the error message ‘Invalid email or password.’
 */
public class LoginTest extends BaseTest {
    //BaseUrl
    String baseUrl = "https://courses.ultimateqa.com/";

    //calling openBrowser method from parentclass BaseTest
    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }

   // 1. userShouldNavigateToLoginPageSuccessfully
    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {
        //* * click on the ‘Sign In’ link
        driver.findElement(By.linkText("Sign In")).click();

        //* * Verify the text ‘Welcome Back!’
        String expectedText = "Welcome Back!";
        String actualText = driver.findElement(By.xpath("//h2[@class='page__heading']")).getText();
        Assert.assertEquals("User is not navigated to sign in page.", expectedText, actualText);
    }

    //* 2. verifyTheErrorMessage
    // * * click on the ‘Sign In’ link
    // * * Enter invalid username
    // * * Enter invalid password
    // * * Click on Login button
    // * * Verify the error message ‘Invalid email or password.’

    @Test
    public void verifyTheErrorMessage(){
        // * * click on the ‘Sign In’ link
        driver.findElement(By.linkText("Sign In")).click();

        // * * Enter invalid username
        driver.findElement(By.id("user[email]")).sendKeys("prime123@gmail.com");

        //* * Enter invalid password
        driver.findElement(By.id("user[password]")).sendKeys("prime123");

        // * * Click on Login button
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        //* * Verify the error message ‘Invalid email or password.’
        String expectedText = "Invalid email or password.";
        String actualText = driver.findElement(By.xpath("//li[@class='form-error__list-item']")).getText();
        Assert.assertEquals("User not able to login with invalid data.", expectedText, actualText);
    }
    @After
    public void tearDown() {
        closeBrowser();
    }
}
