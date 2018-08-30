package framework.controls;

import framework.common.WebDriverHelper;
import framework.interfaces.IValuable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class RadioButtonList extends BaseControl implements IValuable {

    public RadioButtonList(String pageName, String controlLabel){
        super(pageName, controlLabel);
    }

    private List<WebElement> getAllRadios(){
        WebElement mainDiv = WebDriverHelper.findElement(byLocator, 5);
        return mainDiv.findElements(By.xpath("./label[@class='radio inline']"));
    }

    public void setValue(String value) {
        List<WebElement> radios = getAllRadios();
        for(WebElement radio : radios){
            if(radio.getText().toLowerCase().contains(value.toLowerCase())) {
                radio.findElement(By.tagName("input")).click();
                return;
            }
        }
        System.out.println(String.format("\r\nDEBUG: cannot select '%1$s' value from '%2$s' radio button list", value, controlLabel));
    }

    public String getValue() {
        List<WebElement> radios = getAllRadios();
        for(WebElement radio : radios){
            if(radio.findElement(By.tagName("input")).isSelected()){
                return radio.getText().trim();
            }
        }
        System.out.println(String.format("\r\nDEBUG: cannot find selected radio in '%1$s' radio button list", controlLabel));
        return null;
    }

    public boolean isHighlighted(){
        return false;
    }
}
