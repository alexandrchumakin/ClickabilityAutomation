package framework.common;

import com.google.common.base.Predicate;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Synchronization {
    public static void waitPageSource(){
        for(int i = 0; i < 15; i++) {
            String currentSource = Driver.CurrentDriver.getPageSource();
            wait(1);
            String newSource = Driver.CurrentDriver.getPageSource();
            if (currentSource.equals(newSource))
                break;
            else
                wait(1);
        }
    }

    public static void wait(int sec){
        try{
            Thread.sleep(sec*1000);
        }catch(Exception ex){}
    }

    public static void waitPageReadyState(){
        WebDriverWait wait = new WebDriverWait(Driver.CurrentDriver, 30);
        wait.until( new Predicate<WebDriver>() {
                        public boolean apply(WebDriver arg0) {
                            return ((JavascriptExecutor)Driver.CurrentDriver).executeScript("return document.readyState").equals("complete");
                        }
                    }
        );
    }
}
