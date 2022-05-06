package Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class drag {
    public static void main(String[] args) throws Exception {
        WebDriverManager.chromedriver().arch32().setup();
        WebDriver driver = new ChromeDriver();
      //  driver.get("http://marceljuenemann.github.io/angular-drag-and-drop-lists/demo/#/simple");
        driver.get("http://the-internet.herokuapp.com/drag_and_drop");
        Thread.sleep(2000);
       // WebElement source = driver.findElement(By.cssSelector("body > div.container > div.ng-scope > div.simpleDemo.row.ng-scope > div.col-md-8 > div.row > div:nth-child(1) > div > div.panel-body.ng-scope > ul > li:nth-child(1)"));
                //driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div/div[2]/ul/li[1]"));
        //WebElement dest = driver.findElement(By.cssSelector("body > div.container > div.ng-scope > div.simpleDemo.row.ng-scope > div.col-md-8 > div.row > div:nth-child(2) > div > div.panel-body.ng-scope"));
              //  driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/div[1]/div[1]/div[2]/div/div[2]"));
/*
                String sourceElement="div.panel-body.ng-scope > ul > li:nth-child(1)";
               String destination="div[class='row'] div:nth-child(1) div:nth-child(1) div:nth-child(2) ul:nth-child(1) li:nth-child(2)";
                   */
                       //"div.simpleDemo.row.ng-scope  div.row > div:nth-child(2) > div > div.panel-body.ng-scope";
        String sourceElement = "#column-a";
        String destination="#column-b";
       /* Actions a = new Actions(driver);
        a.dragAndDrop(source,dest);*/
        StringBuffer buffer = new StringBuffer();

        String line;
        BufferedReader br = new BufferedReader(new FileReader("src/test/resources/drag_and_drop_helper.js"));
        while((line = br.readLine())!=null)
            buffer.append(line);

        String javaScript = buffer.toString();
        javaScript = javaScript + "$('"+sourceElement+"').simulateDragDrop({ dropTarget: '"+destination+"'});";
        ((JavascriptExecutor)driver).executeScript(javaScript);

    /*    drag d = new drag();
        d.dragAndDropElement(driver.findElement(By.cssSelector(sourceElement)), driver.findElement(By.cssSelector(destination)),0 );
    */
    }

    public void dragAndDropElement(WebElement dragFrom, WebElement dragTo, int xOffset)
            throws Exception {
        //Setup robot
        Robot robot = new Robot();
        robot.setAutoDelay(50);

        //Fullscreen page so selenium coordinates work
        robot.keyPress(KeyEvent.VK_F11);
        Thread.sleep(2000);

        //Get size of elements
        org.openqa.selenium.Dimension fromSize = dragFrom.getSize();
        org.openqa.selenium.Dimension toSize = dragTo.getSize();

        //Get centre distance
        int xCentreFrom = fromSize.width / 2;
        int yCentreFrom = fromSize.height / 2;
        int xCentreTo = toSize.width / 2;
        int yCentreTo = toSize.height / 2;

        //Get x and y of WebElement to drag to
        org.openqa.selenium.Point toLocation = dragTo.getLocation();
        Point fromLocation = dragFrom.getLocation();

        //Make Mouse coordinate centre of element
        toLocation.x += xOffset + xCentreTo;
        toLocation.y += yCentreTo;
        fromLocation.x += xCentreFrom;
        fromLocation.y += yCentreFrom;

        //Move mouse to drag from location
        robot.mouseMove(fromLocation.x, fromLocation.y);

        //Click and drag
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);

        //Drag events require more than one movement to register
        //Just appearing at destination doesn't work so move halfway first
        robot.mouseMove(((toLocation.x - fromLocation.x) / 2) + fromLocation.x, ((toLocation.y
                - fromLocation.y) / 2) + fromLocation.y);

        //Move to final position
        robot.mouseMove(toLocation.x, toLocation.y);

        //Drop
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    }
}
