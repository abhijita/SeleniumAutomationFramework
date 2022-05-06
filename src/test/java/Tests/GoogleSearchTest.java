package Tests;

import Framework.WebDriver.BrowserManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Framework.Web.Browser;
import Framework.WebDriver.DriverFactory;
import Pages.SearchPage.SearchPage;

public class GoogleSearchTest {

	
	@BeforeMethod
	public void setUp() throws Exception {
		BrowserManager.getBrowser();
	}
	
	@AfterMethod
	public void tearDown(){
		BrowserManager.cleanup();
	}

	public Browser browser(){
		return BrowserManager.getBrowser();
	}
	
	@Test(description = "google test",enabled = false)
	public void searchTest(){
		 By searchQuery = By.name("q");
		 By searchbtn= By.name("btnK");
		browser().openURL("http://google.com");
		//SearchPage s = new SearchPage(browser);
	//	s.searchfor("moto 3 ");
		browser().textBox(searchQuery).sendKeys("edge headless test");
		browser().button(searchbtn).click();

	}

	@Test(description = "validating the search result")
	public void validateSearch(){
		browser().openURL("http://google.com");
		SearchPage search = new SearchPage();
		search.searchfor("Selenium WebDriver");
		Assert.assertTrue(search.validate().verifySearchResult(),"Validate Search Result");
	}

	@Test(description = "validating the search result1")
	public void validateSearchanother(){
		browser().openURL("http://google.com");
		SearchPage search = new SearchPage();
		search.searchfor("Selenium bidi");
		Assert.assertTrue(search.validate().verifySearchResult(),"Validate Search Result");
	}

	@Test(description = "check drag and drop")
	public void testDragandDrop(){

	}
}
