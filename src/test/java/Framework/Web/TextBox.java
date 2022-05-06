package Framework.Web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TextBox extends BaseBrowser{
    public TextBox(By elementLocator){
        super.setLocator(elementLocator);
    }

    public void sendKeys(String value){
        super.performSet(locator,value);
    }

    public void clear(){
        driver().findElement(super.locator).clear();
    }

}
