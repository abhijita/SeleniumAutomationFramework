package Framework.WebDriver;

import Framework.Web.Browser;
import com.microsoft.edge.seleniumtools.EdgeDriver;
import com.microsoft.edge.seleniumtools.EdgeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import Utility.propertyReader;
import org.testng.Assert;

public class DriverFactory {
	


	public DriverFactory(){

	}
	
	public static Browser getBrowserInstance() {
		 WebDriver driver;
		propertyReader reader= new propertyReader();
		String browser = reader.getBrwoserType();
		if(browser.equalsIgnoreCase("safari")){
			driver = getSafariDriver();
		}else if(browser.equalsIgnoreCase("chrome")){
			driver = getChromeDriver();
		}else if(browser.equalsIgnoreCase("firefox")){
			driver = getFirefoxDriver();
		}else{
			/*WebDriverManager.edgedriver().arch32().setup();
			EdgeOptions edgeOptions = new EdgeOptions();
			edgeOptions.addArguments("headless");
				edgeOptions.addArguments("disable-gpu");
			driver = new EdgeDriver(edgeOptions);*/

			driver = getFirefoxDriver();
		}
		Browser b=null;
		try{
			b= new Browser(driver);
		}catch (Exception e){
			Assert.fail("#WebDriver Instance Error occured while creating Browser instance. "+e.getMessage()+e.getStackTrace());
		}
		BrowserManager.setBrowser(b);
		return b;
	}



	protected static WebDriver getFirefoxDriver(){
		WebDriverManager.firefoxdriver().setup();
		return new FirefoxDriver();
	}
	
	protected static WebDriver getChromeDriver(){
		WebDriverManager.chromedriver().arch32().setup();
	return new ChromeDriver();
	}
	
	protected static WebDriver getSafariDriver(){
		WebDriverManager.safaridriver().arch32().setup();
		return new SafariDriver();
	}

}
