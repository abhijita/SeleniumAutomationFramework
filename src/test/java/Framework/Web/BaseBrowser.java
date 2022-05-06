package Framework.Web;

import Framework.FrameworkConstants;
import Framework.WebDriver.BrowserManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
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
        this.waitFor().waitForElementToVisible();
        driver().findElement(locator).click();
    }

    protected void performSet(By locator, String message){
        //driver.findElement(locator).clear();
        waitFor().waitForElementToVisible();
        driver().findElement(locator).sendKeys(message);
        System.out.println("setting value to text box. Value : "+message);
    }

    public Synchronizations waitFor(){
        return new Synchronizations(locator);
    }

    public boolean isDisplayed(){
        return driver().findElement(locator).isDisplayed();
    }

    public boolean isEnabled(){
        return driver().findElement(locator).isEnabled();
    }

    public boolean isSelected(){
        return driver().findElement(locator).isSelected();
    }

    public String getText(){
        return driver().findElement(locator).getText();
    }

    public String getAttribute(String attribute){
        return driver().findElement(locator).getAttribute(attribute);
    }

    public List<WebElement> getList(){
        return driver().findElements(locator);
    }
}
