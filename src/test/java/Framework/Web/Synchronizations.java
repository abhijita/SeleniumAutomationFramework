package Framework.Web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Synchronizations extends BaseBrowser {

    public Synchronizations(WebDriver webdriver){
        super.driver=webdriver;
    }
    public void waitForElementToVisible(By locator){
        WebDriverWait wait = new WebDriverWait(driver,constants.getTimeout());
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(locator)));
    }
}
