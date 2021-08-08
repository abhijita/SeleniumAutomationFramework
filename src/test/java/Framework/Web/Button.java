package Framework.Web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Button extends  BaseBrowser{
    protected By locator;

    public Button(WebDriver webDriver,By elementLocator){
        super.driver=webDriver;
        locator = elementLocator;
    }

    public void click(){
        super.click(locator);
    }
}
