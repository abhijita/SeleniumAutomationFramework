package Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.BufferedReader;
import java.io.FileReader;

public class nFlowsTest {

    public static void main(String[] args) throws Exception {
        String url ="";
        String uname="";
        String pwd="";
        WebDriverManager.firefoxdriver().arch32().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get(url);

        Thread.sleep(5000);

        driver.findElement(By.cssSelector("#uname")).sendKeys(uname);
        driver.findElement(By.cssSelector("#password")).sendKeys(pwd);
        driver.findElement(By.cssSelector(".btn.btn-login.loginSubmit")).click();

        Thread.sleep(10000);
        driver.findElement(By.cssSelector("#nav-icon1")).click();
         driver.findElement(By.cssSelector("body > menu-headers:nth-child(1) > div:nth-child(16) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(5) > div:nth-child(1) > ul:nth-child(1) > li:nth-child(1) > a:nth-child(1)")).click();
         driver.findElement(By.cssSelector("li[class='ng-scope active'] li:nth-child(1) a:nth-child(1)")).click();
         Thread.sleep(1000);

         driver.findElement(By.cssSelector("button[title='New Entity Definition']")).click();
         Thread.sleep(5000);

        WebElement sourceE = driver.findElement(By.cssSelector("#fields > div.accordion-scroll.mouse-scroll > ul > li:nth-child(1) > div > span"));
        WebElement targetE = driver.findElement(By.cssSelector("#accordSDF_DGP_EntityFieldInformation > div > div:nth-child(1) > div > ul"));
    Thread.sleep(5000);
        String source = "#fields > div.accordion-scroll.mouse-scroll > ul > li:nth-child(1) > div > span";
        String target = "#accordSDF_DGP_EntityFieldInformation > div > div:nth-child(1) > div > ul";

        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor. executeScript("arguments[0]. setAttribute('style', 'border:2px solid red; background:yellow')", driver.findElement(By.cssSelector(target)));
        jsExecutor. executeScript("arguments[0]. setAttribute('class', 'dndDragover')", driver.findElement(By.cssSelector(target)));

        String line;
        StringBuffer buffer = new StringBuffer();
        BufferedReader br = new BufferedReader(new FileReader("src/test/resources/drag_and_drop_helper.js"));
        while((line = br.readLine())!=null)
            buffer.append(line);

        String javaScript = buffer.toString();
        javaScript = javaScript + "$('"+source +"').simulateDragDrop({ dropTarget: '"+target+"'});";
        ((JavascriptExecutor)driver).executeScript(javaScript);

        Actions a = new Actions(driver);
        a.dragAndDropBy(driver.findElement(By.cssSelector(source)), driver.findElement(By.cssSelector(target)).getLocation().getX()+2
        , driver.findElement(By.cssSelector(target)).getLocation().getY()+5);

            drag d = new drag();
            d.dragAndDropElement(driver.findElement(By.cssSelector(source)), driver.findElement(By.cssSelector(target)),10 );
    }
}
