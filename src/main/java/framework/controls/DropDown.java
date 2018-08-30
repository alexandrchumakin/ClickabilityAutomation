package framework.controls;

import framework.common.WebDriverHelper;
import framework.interfaces.IValuable;
import org.openqa.selenium.support.ui.Select;

public class DropDown extends BaseControl implements IValuable {

    public DropDown(String pageName, String controlLabel){
        super(pageName, controlLabel);
    }

    public void setValue(String value) {
        Select select = new Select(WebDriverHelper.findElement(byLocator, 5));
        int selectValue =  (value.equals("Image")) ? 0 : (value.equals("Audio")) ||(value.equals("Orca")) ||(value.equals("Application")) ||(value.equals("test")) ? 1 : (value.equals("Video")) ? 2 : (value.equals("Standard")) ? 5 : -1;
        select.selectByValue(Integer.toString(selectValue));
    }

    public String getValue() {
        Select select = new Select(WebDriverHelper.findElement(byLocator, 5));
        return select.getFirstSelectedOption().getText();//need to verify
    }

    public boolean isHighlighted(){
        return false;
    }
}
