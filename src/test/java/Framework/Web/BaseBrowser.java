package Framework.Web;

import Framework.FrameworkConstants;
import Framework.WebDriver.BrowserManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.logging.Logger;


public abstract class BaseBrowser {
    protected By locator;

    protected FrameworkConstants constants=FrameworkConstants.getInstance();

    public WebDriver driver(){
        return BrowserManager.getBrowser().getDriver();
    }

    public void setLocator(By elementLocator){
        locator = elementLocator;
    }

    protected  void performClick(){
        this.waitFor(locator).waitForElementToVisible();
        driver().findElement(locator).click();
    }

    protected void performSet(By locator, String message){
        //driver.findElement(locator).clear();
        waitFor(locator).waitForElementToVisible();
        driver().findElement(locator).sendKeys(message);
        System.out.println("setting value to text box. Value : "+message);
    }

    protected Synchronizations waitFor(By locator){
        return new Synchronizations(locator);
    }

    public boolean isDisplayed(){
        return driver().findElement(locator).isDisplayed();
    }
}
