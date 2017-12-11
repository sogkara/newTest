import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

public class LoginTest {
    private ChromeDriver driver;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Studentb\\Desktop\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void login() throws InterruptedException {
      driver.get("http://the-internet.herokuapp.com/login");
      driver.findElement(By.id("username")).sendKeys("tomsmith");
      driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
      driver.findElementByCssSelector("#login button").click();
      assertFalse("ddddd",
                driver.findElementByCssSelector(".subheader").isDisplayed());

    }

    @AfterMethod
    public void tearDown (){
        driver.close();
        driver.quit();

    }

}
