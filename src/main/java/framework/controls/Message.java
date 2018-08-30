package framework.controls;

import framework.common.WebDriverHelper;
import framework.interfaces.IReadOnly;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Message extends BaseControl implements IReadOnly {

    public Message(String pageName, String controlLabel){
        super(pageName, controlLabel);
    }

    public String getValue() {
        WebElement fullDiv = WebDriverHelper.findElement(byLocator, 5);
        WebElement innerSpan = WebDriverHelper.findElement(fullDiv, By.xpath(".//span"), 1);
        return (innerSpan!=null) ? innerSpan.getText().trim() : fullDiv.getText().trim();
    }

}
