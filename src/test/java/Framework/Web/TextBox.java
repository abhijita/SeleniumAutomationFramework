package Framework.Web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TextBox extends BaseBrowser{
    protected  By locator;

    public TextBox(WebDriver webDriver,By elementLocator){
        super.driver=webDriver;
        locator = elementLocator;
    }

    public void sendKeys(String value){
        super.set(locator,value);
    }

    public Synchronizations waitFor(){
        return new Synchronizations(driver);
    }

}
