package framework.controls;

import framework.common.WebDriverHelper;
import framework.interfaces.IGrid;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class Grid extends BaseControl implements IGrid {

    public Grid(String pageName, String controlLabel){
        super(pageName, controlLabel);
    }

    protected WebElement getGridTable(){
        return WebDriverHelper.findElement(byLocator, 5).findElement(By.xpath(".//table"));
    }

    protected List<WebElement> getGridHeaderItems(){
        return getGridTable().findElements(By.xpath("./thead/tr/th"));
    }

    protected int getColumnNumberByName(String colName){
        List<WebElement> header = getGridHeaderItems();
        for(int i = 0; i < header.size(); i++){
            if(header.get(i).getText().toLowerCase().replace("    ", " ").contains(colName.toLowerCase())) //replace - to change ' d    s    p' to 'd s p'
                return i;
        }
        System.out.println(String.format("\r\nDEBUG: cannot find column in grid '%1$s' with name '%2$s'", controlLabel, colName));
        return -1;
    }

    protected List<WebElement> getAllRows(){
        return getGridTable().findElements(By.xpath(".//tbody/tr"));
    }

    private List<WebElement> getAllCellsInColumn(int colNum, int startRow){
        List<WebElement> cellsInColumn = new ArrayList<WebElement>();
        List<WebElement> rows =  getAllRows();
        for(int i = startRow; i < rows.size(); i++){
            cellsInColumn.add(rows.get(i).findElement(By.xpath(".//td[" + (colNum+1) + "]")));
        }
        return cellsInColumn;
    }

    private List<WebElement> getAllCellsInColumn(int colNum){
        return getAllCellsInColumn(colNum, 1);
    }

    public int getRowsNumber() {
        return getAllRows().size();
    }

    public boolean hasColumn(String colName) {
        return getColumnNumberByName(colName) != -1;
    }

    public boolean hasCellInColumn(String cellData, String colName){
        int colNumber = getColumnNumberByName(colName);
        List<WebElement> cellsInCol = getAllCellsInColumn(colNumber);
        for(WebElement cell : cellsInCol){
            if(cell.getText().toLowerCase().contains(cellData.toLowerCase()))
                return true;
        }
        return false;
    }

    public void clickOnRow(int rowNumber) {
        WebElement cellWithText = getAllRows().get(rowNumber - 1).findElement(By.xpath("./td[normalize-space()]"));
        cellWithText.click();
    }

    public void clickOnRow(String value, String colName) {
        int colNumber = getColumnNumberByName(colName);
        List<WebElement> cellsInCol = getAllCellsInColumn(colNumber, 0);
        int rowNumber = -1;
        for(int i = 0; i < cellsInCol.size(); i++){
            if(cellsInCol.get(i).getText().toLowerCase().trim().equals(value.toLowerCase())){
                rowNumber = i;
                break;
            }
        }
        if(rowNumber == -1) System.out.println(String.format("\r\nDEBUG: cannot find row with '%1$s' value in '%2$s' column", value, colName));
        WebElement cellWithoutText = getAllRows().get(rowNumber).findElement(By.xpath("./td[normalize-space()]"));
        cellWithoutText.click();
    }

    public void selectRow(int rowNumber) {
        WebElement cellWithoutText = getAllRows().get(rowNumber - 1).findElement(By.xpath("./td[not(text())]//input"));
        cellWithoutText.click();
    }

    public void selectRow(String value, String colName) {
        int colNumber = getColumnNumberByName(colName);
        List<WebElement> cellsInCol = getAllCellsInColumn(colNumber, 0);
        int rowNumber = -1;
        for(int i = 0; i < cellsInCol.size(); i++){
            if(cellsInCol.get(i).getText().toLowerCase().trim().equals(value.toLowerCase())){
                rowNumber = i;
                break;
            }
        }
        if(rowNumber == -1) System.out.println(String.format("\r\nDEBUG: cannot find row with '%1$s' value in '%2$s' column", value, colName));
        WebElement cellWithoutText = getAllRows().get(rowNumber).findElement(By.xpath("./td[not(text())]//input"));
        cellWithoutText.click();
    }

    public String getDataInColumn(int rowNumber, int colNumber) {
        WebElement cell = getAllRows().get(rowNumber).findElement(By.xpath("td["+ (colNumber+1) + "]"));
        return cell.getText().trim();
    }

    public String getDataInColumn(int rowNumber, String colName) {
        int colNumb = getColumnNumberByName(colName);
        WebElement cell = getAllRows().get(rowNumber).findElement(By.xpath("td["+ (colNumb+1) + "]"));
        if(colName.toLowerCase().equals("d s p")){
            List<WebElement> indicators = cell.findElements(By.xpath("./span/ul/li"));
            String actValue="";
            for(WebElement indicator: indicators){
                actValue+= (indicator.getAttribute("class") != null && indicator.getAttribute("class").equals("cm-indicator-on")) ? "on " : "off ";
            }
            return actValue.trim();
        }
        else
            return cell.getText().trim();
    }

}
