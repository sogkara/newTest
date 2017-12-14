import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.LoginPage;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

public class LoginTest {
    private ChromeDriver driver;
    private LoginPage loginPage;


    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Studentb\\Desktop\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        loginPage.login("tomsmith", "SuperSecretPassword!");
    }


    @Test
    public void worngLogin() throws InterruptedException {
        loginPage = new LoginPage(driver);
        loginPage.login("tomsmith1", "SuperSecretPassword!");
        Thread.sleep(3000);
         assertTrue("ddddd",loginPage.isErrorDisplayed());
         String message= loginPage.getErrorMesssage();
        assertTrue(message.contains("Your username is invalid!"));
        System.out.print(message);
    }

    @AfterMethod
    public void tearDown (){
        driver.close();
        driver.quit();
    }

}
