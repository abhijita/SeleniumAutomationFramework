package Framework.Web;

import Framework.FrameworkConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.logging.Logger;


public abstract class BaseBrowser {

    protected WebDriver driver;
    protected FrameworkConstants constants=FrameworkConstants.getInstance();


    protected   void click(By locator){
        this.waitFor().waitForElementToVisible(locator);
        driver.findElement(locator).click();
    }

    protected void set(By locator,String message){
        //driver.findElement(locator).clear();
        waitFor().waitForElementToVisible(locator);
        driver.findElement(locator).sendKeys(message);
    }

    protected Synchronizations waitFor(){
        return new Synchronizations(driver);
    }
}
