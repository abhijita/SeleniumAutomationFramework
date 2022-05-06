package Framework.Web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Synchronizations extends BaseBrowser {


    public Synchronizations(By locator){
          super.setLocator(locator);
    }

    private WebDriverWait webDriverWait(){
        return  new WebDriverWait(driver(),constants.getTimeout());
    }

    public void waitForElementToVisible(){
        webDriverWait().until(ExpectedConditions.visibilityOf(driver().findElement(locator)));
    }

    public void waitForElementToBeInvisible(){
        webDriverWait().until(ExpectedConditions.invisibilityOf(driver().findElement(locator)));
    }
}
