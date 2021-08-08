package Pages;

import org.openqa.selenium.By;

import Framework.Web.Browser;

public class SearchPage {
	private Browser browser;
	private By searchQuery = By.name("q");
	private By searchbtn= By.name("btnK");
	//jd


	public SearchPage(Browser brwoser){
		this.browser = brwoser;
	}
	
	public void searchfor(String query){
		browser.waitFor().waitForElementToVisible(searchQuery);
		browser.textBox(searchQuery).sendKeys(query);
		//brwoser.click(By.xpath("//*[@value='Search']"));
		browser.button(searchbtn).click();
	}
	
	

}
