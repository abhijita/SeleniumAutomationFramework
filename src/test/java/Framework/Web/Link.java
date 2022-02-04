package Framework.Web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Link extends BaseBrowser{

    public Link(By elementLocator) {
        super();
        super.setLocator(elementLocator);
    }

    public void click(){
        super.performClick();
    }


}
