package Framework.WebDriver;

import Framework.Web.Browser;
import org.openqa.selenium.WebDriver;

import java.sql.Driver;

public class BrowserManager {
    protected static ThreadLocal<Browser> _browser = new ThreadLocal<Browser>();

    public static Browser getBrowser(){
        if(_browser.get()==null){
           DriverFactory.getBrowserInstance();
        }
        return _browser.get();
    }

    public static void setBrowser(Browser browser){
        _browser.set(browser);
    }

    public static void cleanup(){
        _browser.get().getDriver().quit();
        _browser.remove();
    }
}
