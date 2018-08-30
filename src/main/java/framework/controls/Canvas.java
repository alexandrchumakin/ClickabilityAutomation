package framework.controls;

import framework.common.Driver;
import framework.common.Synchronization;
import framework.common.WebDriverHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import java.util.AbstractMap;
import java.util.List;
import java.util.Map;

public class Canvas {
    private static Pattern elemToDrag;
    private static WebElement elemToClick;

    public Canvas(String element) throws Exception {
        if (element.equals("Grid Row")) {
            elemToDrag = new Pattern("images/gridRow.png").targetOffset(-5, -2);
            elemToClick = WebDriverHelper.findElement(By.xpath("//div[text()='Grid Row']"), 5);
        }else if (element.equals("Set")) {
            elemToDrag = new Pattern("images/Set.png");
            elemToClick = WebDriverHelper.findElement(By.xpath("//div[text()='Set']"), 5);
        }else if (element.equals("02 Track 2")) {
            elemToDrag = new Pattern("images/02Track2.png").targetOffset(-20,0);
            elemToClick = WebDriverHelper.findElement(By.xpath("//div[text()='02 Track 2']"), 5);
        }else if (element.equals("ROUND1")) {
            elemToDrag = new Pattern("images/ROUND1.png").targetOffset(-20,0);
            elemToClick = WebDriverHelper.findElement(By.xpath("//div[text()='ROUND1']"), 5);
        }else if (element.equals("UX sub template")) {
            elemToDrag = new Pattern("images/UXSubTemplate.png");
            elemToClick = WebDriverHelper.findElement(By.xpath("//div[text()='UX sub template']"), 5);
        }else if (element.equals("Button")) {
            elemToDrag = new Pattern("images/Button.png");
            elemToClick = WebDriverHelper.findElement(By.xpath("//div[text()='Button']"), 5);
        }else if (element.equals("Author")) {
            elemToDrag = new Pattern("images/Author.png");
            elemToClick = WebDriverHelper.findElement(By.xpath("//div[text()='Author']"), 5);
        }else if (element.equals("Link")) {
            elemToDrag = new Pattern("images/Link.png");
            elemToClick = WebDriverHelper.findElement(By.xpath("//div[text()='Link']"), 5);
        }else if (element.equals("header_logo")) {
            elemToDrag = new Pattern("images/header_logo.png");
            elemToClick = WebDriverHelper.findElement(By.xpath("//div[text()='header_logo']"), 5);
        }
        else {
            elemToDrag = new Pattern("images/" + element.replace(" ", "") + ".png");
            elemToClick = WebDriverHelper.findElement(By.xpath("//div[text()='" + element + "']"), 5);
        }
    }

    public Canvas(){ }

    private WebElement getCanvasElement(){
        Synchronization.waitPageReadyState();
        Synchronization.waitPageSource();
        Driver.CurrentDriver.switchTo().defaultContent();
        Driver.CurrentDriver.switchTo().frame("document-frame");
        return WebDriverHelper.findElement(By.xpath("//body[contains(@class, 'design') and contains(@class, 'ng-scope')]"), 10);
    }

    private List<WebElement> getAllRows(){
        return getCanvasElement().findElements(By.xpath(".//div[contains(@class, 'row-fluid')]"));
    }

    private List<WebElement> getAllCellsInRow(WebElement row){
        return row.findElements(By.xpath(".//div[@class='span4']"));
    }

    private WebElement getCell(int rowNumber, int colNumber){
        return getAllCellsInRow(getAllRows().get(rowNumber)).get(colNumber);
    }

    public void clickIcon(String iconName, int rowNumber, int colNumber){
        getCell(rowNumber, colNumber).click();
        Driver.CurrentDriver.switchTo().defaultContent();
        Synchronization.waitPageSource();
        WebElement canvasContext = WebDriverHelper.findElement(By.id("context-extras"), 1);
        WebElement icon = canvasContext.findElement(By.xpath(".//a[@title='" + iconName + "' and @rel='tooltip']/div"));
        icon.click();
    }

//    Grid Span
    private WebElement getGridSpan(){
        Driver.CurrentDriver.switchTo().defaultContent();
        return Driver.CurrentDriver.findElement(By.xpath("//div[@class='popover-content']/div[@class='cm-block5']"));
    }

//    public String getGridSpanTitle(){
//        return WebDriverHelper.findElement(getGridSpan(), By.xpath("./div[@class='media']/h4"), 1).getText();
//    }

    public void closeGridSpan(){
        WebDriverHelper.findElement(getGridSpan(), By.xpath(".//i[@class='cm-icon18 cm-icon-close']"), 1).click();
    }

    private WebElement getGridSpanControlByAttr(String attrName){
        WebElement panel = WebDriverHelper.findElement(getGridSpan(), By.id("properties"), 1);
        return panel.findElement(By.xpath(".//label[text()='" + attrName + "']/..//input"));
    }

    public void setGridSpanAttribute(String attrName, String value){
        WebElement control = getGridSpanControlByAttr(attrName);
        control.clear();
        control.sendKeys(value);
    }

    public String getGridSpanAttribute(String attrName){
        WebElement control = getGridSpanControlByAttr(attrName);
        return control.getText().equals("") ?  control.getAttribute("value") : control.getText();
    }

    public boolean canvasContainsText(String expText){
        String error = "";
        Synchronization.waitPageReadyState();
        Synchronization.waitPageSource();
        String[] textArray = expText.split("\\...");
        String actText = getCanvasElement().getText();
        for(String text: textArray){
            if(!actText.contains(text))
                error += String.format("\r\nDEBUG: canvas doesn't contain '%1$s'", text);
        }
        if(error.equals(""))
            return true;
        else{
            System.out.println(error + ".\r\nActual canvas text: " + actText);
            return false;
        }
    }

    public boolean canvasContainsImage(){
        Synchronization.waitPageReadyState();
        Synchronization.waitPageSource();
        return getCanvasElement().findElements(By.tagName("img")).size() != 0;
    }

    public boolean canvasContainsAudio(){
        Synchronization.waitPageReadyState();
        Synchronization.waitPageSource();
        return getCanvasElement().findElements(By.tagName("audio")).size() != 0;
    }

    public boolean canvasContainsVideo(){
        Synchronization.waitPageReadyState();
        Synchronization.waitPageSource();
        return getCanvasElement().findElements(By.tagName("video")).size() != 0;
    }

    public boolean canvasContainsWidgets(String widgets){
        String error = "";
        Synchronization.waitPageReadyState();
        Synchronization.waitPageSource();
        String[] widgetArray = widgets.split("\\,");
        WebElement canva = getCanvasElement();
        for(String text: widgetArray){
            if(canva.findElements(By.xpath(".//div[contains(@class,'" + text.trim() + "')]")).size() == 0)
                error += String.format("\r\nDEBUG: canvas doesn't contain element with class '%1$s'", text.trim());
        }
        if(error.equals(""))
            return true;
        else{
            System.out.println(error);
            return false;
        }
    }

    public boolean canvasIsNotEmpty(){
        try{
            Synchronization.wait(5);
            Synchronization.waitPageReadyState();
            Synchronization.waitPageSource();
            int rowsSize = getAllRows().size();
            return rowsSize > 0;
        }
        catch(Exception ignored){ return false; }
        finally { Driver.CurrentDriver.switchTo().defaultContent(); }
    }
//    private int getMaxCellsCount(){
//        List<WebElement> rows = getAllRows();
//        int cellsNumber = 1;
//        for(WebElement row: rows){
//            int currCellsNumb = getAllCellsInRow(row).size();
//            if(currCellsNumb > cellsNumber) cellsNumber = currCellsNumb;
//        }
//        return cellsNumber;
//    }

//    Sikuli

    private void dragImage(Pattern canvas) throws FindFailed {
//        Screen screen = new Screen();
        try {
            Synchronization.waitPageReadyState();
            if(elemToClick!= null) elemToClick.sendKeys();
//            Synchronization.wait(1);
//            screen.dragDrop(elemToDrag, elemToDrag.targetOffset(1,1));
            Synchronization.wait(1);
            int result = new Screen().dragDrop(elemToDrag, canvas);

//            screen.mouseMove(elemToDrag);
//            Synchronization.wait(1);
//            screen.mouseDown(Button.LEFT);
//            Synchronization.wait(2);
//            System.out.println("\r\nDEBUG:move element to canvas -- start");
//            screen.mouseMove(canvas);
//            Synchronization.wait(2);
//            System.out.println("\r\nDEBUG:move element to canvas -- end");
//            screen.mouseUp(Button.LEFT);
////            screen.dragDrop(elemToDrag.targetOffset(10, 10), canvas);
             Synchronization.wait(2);
        }
        catch(Exception ignored){}
    }

//    private Map.Entry<Integer, Integer> getCoord(int rowNumber, int colNumber){
//        WebElement canvasDiv = WebDriverHelper.findElement(By.id("frame-content"), 5);
////        int xLeng = canvasDiv.getSize().getWidth();    //425 * 2
//        int yLeng = canvasDiv.getSize().getHeight();   //351 * 2
////        int rowsNumber = getAllRows().size();
////        int cellsNumber = getMaxCellsCount();
//         //width of cell = 267 =  133 * 2
//         //height of cell = 90  = 45 * 2
//         //length of all cells ~= 95%
//
////        int x = (colNumber > 1) ?
////        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
//
//        int cellWid = yLeng / 3;
////        if(dim.getWidth() == 1280)
////            cellWid = cellWid / 3;
////        else if (dim.getWidth() < 1280)
////            cellWid = cellWid / 4;
//
////        if(colNumber > 1){
////            int cellsNumber = getAllCellsInRow(getAllRows().get(rowNumber)).size();
////            cellWid = (int)((yLeng * 0.95) / cellsNumber); //???
////        }else{
////            cellWid = yLeng / 3; //????
////        }
//        int cellHeig = 90;
//        int x = cellWid / 2 + ( cellWid * (rowNumber-1) );
//        int y = cellHeig / 2 + ( cellHeig * (colNumber-1) );
//        return new AbstractMap.SimpleEntry<Integer, Integer>(x, y);
//
//    }

    private Map.Entry<Integer, Integer> getCoord(int rowNumber, int colNumber){
        WebElement canvasDiv = WebDriverHelper.findElement(By.id("frame-content"), 5);
        int xLeng = canvasDiv.getSize().getWidth();    //425 * 2
        int yLeng = canvasDiv.getSize().getHeight();   //351 * 2
        int cellWid = yLeng / 3;
        int cellHeig = 90;
//        int x = cellWid / 2 + ( cellWid * (rowNumber-1) );
//        int y = cellHeig / 2 + ( cellHeig * (colNumber-1) );
        int x = (- xLeng / 2 ) +  cellWid / 2 + ( cellWid * (rowNumber-1));
        int y = (- yLeng / 2 ) +  cellHeig / 2 + ( cellHeig * (colNumber-1) );
        return new AbstractMap.SimpleEntry<Integer, Integer>(x, y);
    }

    public void dragElementToCanvasRow(int rowNumber) throws FindFailed {
        Synchronization.waitPageSource();
        //new
        String path = "images/currentCanvas.png";
        WebDriverHelper.getScreenOfElement(WebDriverHelper.findElement(By.id("frame-content"), 5), path);
        //end
        Map.Entry<Integer, Integer> coord = getCoord(1, rowNumber);
//        Map.Entry<Integer, Integer> coord2 = getCoord(1, 2);
        Pattern canvas = new Pattern(path).targetOffset(coord.getKey(), coord.getValue());
//        Pattern canvas = new Pattern("images/upperLeftCorner.png").targetOffset(coord.getKey(), coord.getValue());

//        canvas = canvas.targetOffset(coord.getKey(), coord.getValue());
//
        dragImage(canvas);
//        Driver.CurrentDriver.switchTo().defaultContent();
        Synchronization.wait(1);
    }
//        switch (rowNumber){
//            case 1:
////                canvas = new Pattern("images/subTemplateCanvas.png").targetOffset(-350, -300);
//                canvas = canvas.targetOffset(133, 45 + (6)); // +?
//                break;
//            case 2:
//                canvas = canvas.targetOffset(133, 90 + 45);
//                break;
//            case 3:
//                canvas = canvas.targetOffset(133, 180 + 45);
//                break;
//            case 4:
//                canvas = canvas.targetOffset(133, 270 + 45);
//                break;
//            default:
//                System.out.print("Cannot init canvas row '" + rowNumber + "'. ");
//        }


//
//    public void dragElementToCanvasRow(int rowNumber) throws FindFailed {
////        getXCoord(1);
//        Synchronization.waitPageSource();
//        Pattern canvas = null;
//        switch (rowNumber){
//            case 1:
////                canvas = new Pattern("images/canvas.png").targetOffset(-350, -300);
//                canvas = new Pattern("images/upperLeftCorner.png").targetOffset(133, 45);
//                break;
//            case 2:
//                canvas = new Pattern("images/canvas.png").targetOffset(-350, -210);
//                break;
//            case 3:
//                canvas = new Pattern("images/canvas.png").targetOffset(-350, -120);
//                break;
//            case 4:
//                canvas = new Pattern("images/canvas.png").targetOffset(-350, -30);
//                break;
//            default:
//                System.out.print("Cannot init canvas row '" + rowNumber + "'. ");
//        }
//        dragImage(canvas);
//        Synchronization.waitPageSource();
//    }

    public void dragElementToCanvasCell(int rowNumber, int cellNumber) throws FindFailed {
        Synchronization.waitPageSource();
    }

}
