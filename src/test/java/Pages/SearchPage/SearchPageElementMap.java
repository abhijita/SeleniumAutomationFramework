package Pages.SearchPage;

import Framework.Web.Button;
import Framework.Web.Link;
import Framework.Web.TextBox;
import Pages.BasePageElementMap;
import org.openqa.selenium.By;

public class SearchPageElementMap extends BasePageElementMap {
    private By searchQuery = By.name("q");
    private By searchbtn= By.name("btnK");
    private By queryResultBlock=By.xpath("//div[@class='g tF2Cxc']/div/div/div/a");

    public SearchPageElementMap() {

    }

    public TextBox searchQuery(){
        return browser().textBox(searchQuery);
    }

    public Button searchBtn(){
        return this.browser().button(searchbtn);
    }

    public Link result(){return this.browser().link(queryResultBlock);}

}
