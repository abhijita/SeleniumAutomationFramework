package Pages.SearchPage;

import Pages.pattern.BasePage;
import org.openqa.selenium.By;

import Framework.Web.Browser;

public class SearchPage extends BasePage<SearchPageElementMap,SearchPageValidator> {

	protected SearchPageElementMap elements;
	protected SearchPageValidator verify;


	public SearchPageValidator validate(){
		return new SearchPageValidator(elements);
	}

	 public  SearchPage(){
		elements = new SearchPageElementMap();
		verify = new SearchPageValidator(elements);
	}
	
	public void searchfor(String query){
		elements.searchQuery().waitFor().waitForElementToVisible();
		elements.searchQuery().sendKeys(query);
		elements.searchBtn().click();

	}
	
	

}
