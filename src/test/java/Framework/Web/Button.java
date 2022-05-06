package Framework.Web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Button extends  BaseBrowser{



    public Button(By elementLocator){
        super.setLocator(elementLocator);
    }

    public void click(){
        super.performClick();
    }


}
