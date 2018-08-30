package framework.controls;

import framework.common.WebDriverHelper;
import framework.interfaces.IGrid;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GridHistory extends Grid implements IGrid {

    public GridHistory(String pageName, String controlLabel){
        super(pageName, controlLabel);
    }

    @Override
    protected WebElement getGridTable(){
        return WebDriverHelper.findElement(byLocator, 5);
    }

    @Override
    protected List<WebElement> getAllRows(){
        return getGridTable().findElements(By.xpath("./tbody/tr"));
    }

}
