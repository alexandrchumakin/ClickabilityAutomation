package framework.controls;

import framework.common.Driver;
import framework.common.Synchronization;
import framework.common.WebDriverHelper;
import framework.interfaces.IClickable;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Button extends BaseControl implements IClickable {

    public Button(String pageName, String controlLabel){
        super(pageName, controlLabel);
    }

    public void click() {
        WebDriverHelper.findElement(byLocator, 5).click();
        Synchronization.waitPageSource();
    }

    public void doubleClick() {
        Actions actions = new Actions(Driver.CurrentDriver);
        WebElement button = WebDriverHelper.findElement(byLocator, 5);
        actions.moveToElement(button).release().perform();
        Synchronization.wait(1);
        actions.doubleClick(button).release().perform();
        Synchronization.waitPageSource();
    }

}
