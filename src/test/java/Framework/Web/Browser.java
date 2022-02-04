package Framework.Web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class Browser {
	private  WebDriver driver;

	public Browser(WebDriver driver) {
		this.driver = driver;
	}

	public WebDriver getDriver() {
		return driver;
	}
	
	public void openURL(String url){
		driver.get(url);
	}

	public TextBox textBox(By locator){
		return new TextBox(locator);
	}

	public synchronized Synchronizations waitFor(By locator){
		return new Synchronizations(locator);
	}
	
	public void closeInstance(){
		driver.quit();
	}

	public synchronized Button button(By locator){
		return new Button(locator);
	}

	public synchronized Link link(By locator) {
		return new Link(locator);
	}
}
