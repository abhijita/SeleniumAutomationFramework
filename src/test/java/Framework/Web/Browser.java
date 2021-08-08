package Framework.Web;

import Framework.FrameworkConstants;
import Framework.Web.Synchronizations;
import Framework.Web.TextBox;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class Browser {
	private  WebDriver driver;
	private  FrameworkConstants constants;

	public Browser(WebDriver driver) throws Exception {
		this.driver = driver;
		constants = FrameworkConstants.getInstance();
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
	
	public void openURL(String url){
		driver.get(url);
	}

	public TextBox textBox(By locator){
		return new TextBox(driver,locator);
	}

	public Synchronizations waitFor(){
		return new Synchronizations(driver);
	}
	
	public void closeInstance(){
		driver.quit();
	}

	public Button button(By locator){
		return new Button(driver, locator);
	}
}
