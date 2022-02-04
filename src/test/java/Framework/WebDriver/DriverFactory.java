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
			driver = new SafariDriver();
		}else if(browser.equalsIgnoreCase("chrome")){
			WebDriverManager.chromedriver().arch32().setup();
			driver = new ChromeDriver();
		}else if(browser.equalsIgnoreCase("firefox")){
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}else{
			/*WebDriverManager.edgedriver().arch32().setup();
			EdgeOptions edgeOptions = new EdgeOptions();
			edgeOptions.addArguments("headless");
				edgeOptions.addArguments("disable-gpu");
			driver = new EdgeDriver(edgeOptions);*/
			WebDriverManager.chromedriver().arch32().setup();
			driver = new ChromeDriver();
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



	public WebDriver getFirefoxDriver(){
		return new FirefoxDriver();
	}
	
	public WebDriver getChromeDriver(){
	return new ChromeDriver();
	}
	
	public WebDriver getSafariDriver(){
		return new SafariDriver();
	}

}
