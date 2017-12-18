package pageobjects;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class BasePage {
    private WebDriver driver;

    public  BasePage(WebDriver webdriver) {

        this.driver =webdriver;
    }

    public void visit (String url){

        driver.get(url);
    }
    public WebElement find (By locator){
        return driver.findElement(locator);
    }

    public void Clicik(By locator){
            find(locator).click();
    }

    public void Click(WebElement element){

        element.click();
    }

    public void type(By locator, String text){

        type(find(locator), text);
    }

    public void type (WebElement element, String text){

        element.sendKeys(text);
    }

    public WebElement find (String cssSelector){

        return find(By.cssSelector(cssSelector));
    }

    public void click1(String cssSelector){
        Click(find(cssSelector));
    }

    public void typeWithcss( String cssselector , String text){

        type(find(cssselector), text);
    }

    public boolean isDisplay(WebElement element) {
        try {
          return element.isDisplayed();
        } catch (NoSuchElementException e) {

            return false;
        }

    }
    public boolean isDisplay1(By locator){
        return isDisplay(find(locator));
      }

      public boolean isDisplay2 (String cssSelector){
        return isDisplay(find(cssSelector));
      }
}
