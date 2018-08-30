package framework.common;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.Point;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class WebDriverHelper {
    public static void waitFor(By byLocator, int seconds ){
        try{
            WebDriverWait wait = new WebDriverWait(Driver.CurrentDriver, seconds);
            wait.until(ExpectedConditions.visibilityOfElementLocated(byLocator));
        } catch  (Exception ignored) { }
    }

    public static void waitFor(By byLocator){
        waitFor(byLocator, 10);
    }

    public static WebElement findElement(By by, int timeoutInSeconds){
        return findElement(Driver.CurrentDriver, by, timeoutInSeconds);
    }

    public static WebElement findElement(SearchContext el, By by, int timeoutInSeconds) {
        WebDriverWait waiter = new WebDriverWait(Driver.CurrentDriver, timeoutInSeconds);
        waiter.until( ExpectedConditions.presenceOfElementLocated(by) );
        WebElement element = el.findElement(by);
        try{element.sendKeys("");}catch(Exception ignored){} // try to make focus
        return element;
    }

    public static void getScreenOfElement(WebElement element, String path){
        File screenshot = ((TakesScreenshot)Driver.CurrentDriver).getScreenshotAs(OutputType.FILE);
        try {
            BufferedImage img = ImageIO.read(screenshot);
            int height = element.getSize().height;
            int width = element.getSize().width;

            Rectangle rect = new Rectangle(width, height);
            Point p = element.getLocation();
            BufferedImage dest = img.getSubimage(p.getX(), p.getY(), rect.width, rect.height);
            ImageIO.write(dest, "png", screenshot);

            String absPath = new File("").getAbsoluteFile().toString();
            FileUtils.copyFile(screenshot, new File(absPath +"\\" + path.replace("/","\\")));
        }catch(Exception ex){
            System.out.println(String.format("\r\nDEBUG: cannot take screenshot if element with tag '%1&s' by path '%2&s'", element.getTagName(), path));
        }
    }
}
