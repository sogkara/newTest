package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver driver; //reuse anelu ahamr e enq grum
    private By usernameLocator=By.id("username");
    private By passwordLocator =By.id("password");
    private By subbmitLocator = By.cssSelector("#login button");
    private  By succsecLocator =By.cssSelector(".flash.success");
    private  By errorLocator =By.cssSelector(".flash.error");
    private By LoginUrl = By.cssSelector(".flash.error");

    public LoginPage(WebDriver webdriver)
    {
        this.driver=webdriver;
        this.driver.get("http://the-internet.herokuapp.com/login");
    }



    public String getUrll() {
        return  driver.getCurrentUrl();
    }

    public String getErrorMesssage()
    {
        return driver.findElement(errorLocator).getText();
    }

    public void login (String username, String password)
    {

        driver.get("http://the-internet.herokuapp.com/login");
        driver.findElement(usernameLocator).sendKeys(username);
        driver.findElement(passwordLocator).sendKeys(password);
        driver.findElement(subbmitLocator).click();
    }

    public boolean isErrorDisplayed()
    {
        return driver.findElement(errorLocator).isDisplayed();
    }
    
}
