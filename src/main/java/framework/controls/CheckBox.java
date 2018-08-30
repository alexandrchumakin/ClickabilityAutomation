package framework.controls;

import framework.common.WebDriverHelper;
import framework.interfaces.IValuable;

public class CheckBox extends BaseControl implements IValuable {

    public CheckBox(String pageName, String controlLabel){
        super(pageName, controlLabel);
    }

    public void setValue(String value) {
        if(value.toLowerCase().equals("check")) {
            if (getValue().equals("unchecked"))
                WebDriverHelper.findElement(byLocator, 1).click();
        }
        else if(value.toLowerCase().equals("uncheck")) {
            if (getValue().equals("checked"))
                WebDriverHelper.findElement(byLocator, 1).click();
        }
        else
            System.out.println(String.format("\r\nDEBUG: cannot set value '%1$s' to '%2$s'", value, controlLabel));

    }

    public String getValue() {
        return  WebDriverHelper.findElement(byLocator, 5).isSelected() ? "checked" : "unchecked";
    }

    public boolean isHighlighted(){
        return false; //??
    }
}
