package Framework;

import Framework.Web.Browser;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import Utility.propertyReader;

public class DriverFactory {
	
	public WebDriver driver;

	public DriverFactory(){

	}
	
	public Browser getBrowserInstance() throws Exception {
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
			WebDriverManager.chromedriver().arch32().setup();
			driver = new ChromeDriver();
		}
		return new Browser(driver);
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public WebDriver getFirefoxDriver(){
		if(driver == null){
		driver = new FirefoxDriver();
		}
		return driver;
	}
	
	public WebDriver getChromeDriver(){
		if(driver == null){
			driver = new ChromeDriver();
		}
		return driver;
	}
	
	public WebDriver getSafariDriver(){
		if(driver == null){
			driver = new SafariDriver();
		}
		return driver;
	}

}
