package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

/**
 *              Project-5 - ProjectName : com-utimateqa-sw-2
 * BaseUrl = https://courses.ultimateqa.com/
 * 1. Create the package ‘browserfactory’ and create the class with the name ‘BaseTest’ inside the
 * ‘browserfactory’ package. And write the browser setup code inside the class ‘Base Test’.
 * 2. Create the package ‘testsuite’ and create the following class inside the ‘testsuite’ package.
 * 1. LoginTest
 * 3. Write down the following test into ‘LoginTest’ class
 * 1. userShouldNavigateToLoginPageSuccessfully * click on the ‘Sign In’ link
 * * Verify the text ‘Welcome Back!’
 * 2. verifyTheErrorMessage
 * * click on the ‘Sign In’ link
 * * Enter invalid username
 * * Enter invalid password
 * * Click on Login button
 * * Verify the error message ‘Invalid email or password.’
 */
public class BaseTest {
     //1. Create the package ‘browserfactory’ and create the class with the name ‘BaseTest’ inside the
    // ‘browserfactory’ package. And write the browser setup code inside the class ‘Base Test’.

    public static WebDriver driver;

    public void openBrowser(String baseUrl){

        //the browser setup code inside the class ‘Base Test’.

        driver = new ChromeDriver();
        driver.get(baseUrl);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }
    public void closeBrowser(){
        driver.quit();
    }

}
