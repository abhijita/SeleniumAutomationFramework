package Pages.SearchPage;

import Framework.Web.Browser;

public class SearchPageValidator {

    private SearchPageElementMap elements;


    public SearchPageValidator( SearchPageElementMap searchPageElementMap) {
        elements = searchPageElementMap;
    }

    public boolean verifySearchResult(){
         return elements.result().isDisplayed();
    }
}
