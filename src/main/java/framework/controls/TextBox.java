package framework.controls;

import framework.common.WebDriverHelper;
import framework.interfaces.IValuable;
import org.openqa.selenium.WebElement;

public class TextBox extends BaseControl implements IValuable {

    public TextBox(String pageName, String controlLabel){
        super(pageName, controlLabel);
    }

    public void setValue(String value) {
        WebElement field = WebDriverHelper.findElement(byLocator, 5);
        field.clear();
        field.sendKeys(value);
    }

    public String getValue() {
        WebElement field = WebDriverHelper.findElement(byLocator, 5);
        return !field.getText().trim().equals("") ? field.getText().trim() : field.getAttribute("value").trim() ;
    }

    public boolean isHighlighted(){
        return WebDriverHelper.findElement(byLocator, 5).getAttribute("class").contains("ng-invalid");
    }
}
