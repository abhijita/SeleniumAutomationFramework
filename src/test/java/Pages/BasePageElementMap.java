package Pages;

import Framework.Web.Browser;
import Framework.WebDriver.BrowserManager;

public class BasePageElementMap {

    protected Browser browser(){
        return BrowserManager.getBrowser();
    }

    public BasePageElementMap(){

    }
}
