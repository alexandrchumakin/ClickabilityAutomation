package Tests;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.common.*;
import framework.controls.Canvas;
import framework.interfaces.*;
import org.junit.Assert;

import java.util.Map;

public class BaseDefinition {

    @Before
    public void createConn() throws Exception{
        Driver.InitDriver();
        RepositoryParser.ParseXML();
    }

    @After
    public void delConn() throws Exception {
        Driver.CloseDriver();
    }

    @Given("^I am logged into site$")
    public void I_am_logged_into_site() throws Throwable {
        LoginPage.Login();
    }

    @Given("^Login as QA Clone customer into \"([^\"]*)\"$")
    public void Login_as_QA_Clone_customer_into(String URL) throws Throwable {
        LoginPage.Login(URL);
    }

    @When("^I am on page \"([^\"]*)\"$")
    public void I_am_on_page(String pageLabel) throws Throwable {
        Page.currentPageLabel = pageLabel;
        Synchronization.waitPageSource();
    }

    @When("^I fill in \"([^\"]*)\" with \"([^\"]*)\"$")
    public void I_fill_in_with(String controlLabel, String value) throws Throwable {
        IValuable field = Factory.CreateControl(controlLabel);
        field.setValue(value);
    }

    @When("^I (check|uncheck) \"([^\"]*)\"$")
    public void I_check(String checkOrUncheck, String controlLabel) throws Throwable {
        IValuable field = Factory.CreateControl(controlLabel);
        field.setValue(checkOrUncheck);
    }

    @When("^I select \"([^\"]*)\" from \"([^\"]*)\"$")
    public void I_select_from(String value, String controlLabel) throws Throwable {
        IValuable field = Factory.CreateControl(controlLabel);
        field.setValue(value);
    }

    @When("^I click on \"([^\"]*)\"$")
    public void I_click_on(String label) throws Throwable {
        IClickable clickableElement = Factory.CreateControl(label);
        clickableElement.click();
    }

    @When("^I double click on \"([^\"]*)\"$")
    public void I_double_click_on(String label) throws Throwable {
        IClickable clickableElement = Factory.CreateControl(label);
        clickableElement.doubleClick();
    }

    @When("^I click on row (\\d+) in grid \"([^\"]*)\"$")
    public void I_click_on_row_in_grid(int rowNumber, String gridName) throws Throwable {
        IGrid grid = Factory.CreateControl(gridName);
        grid.clickOnRow(rowNumber);
    }

    @When("^I select row (\\d+) in grid \"([^\"]*)\"$")
    public void I_select_row_in_grid(int rowNumber, String gridName) throws Throwable {
        IGrid grid = Factory.CreateControl(gridName);
        grid.selectRow(rowNumber);
    }

    @When("^I click on row with \"([^\"]*)\" in column \"([^\"]*)\" in grid \"([^\"]*)\"$")
    public void I_click_on_row_with_in_column_in_grid(String value, String colName, String gridName) throws Throwable {
        IGrid grid = Factory.CreateControl(gridName);
        grid.clickOnRow(value, colName);
    }

    @When("^I select row with \"([^\"]*)\" in column \"([^\"]*)\" in grid \"([^\"]*)\"$")
    public void I_select_row_with_in_column_in_grid(String value, String colName, String gridName) throws Throwable {
        IGrid grid = Factory.CreateControl(gridName);
        grid.selectRow(value, colName);
    }

    @Then("^I should see grid \"([^\"]*)\" with \"([^\"]*)\" column$")
    public void I_should_see_grid_with_column(String gridName, String colName) throws Throwable {
        IGrid grid = Factory.CreateControl(gridName);
        Assert.assertTrue(grid.hasColumn(colName));
    }

    @Then("^I should see grid \"([^\"]*)\" with \"([^\"]*)\" in column \"([^\"]*)\"$")
    public void I_should_see_grid_with_in_column(String gridName, String cellData, String colName) throws Throwable {
        IGrid grid = Factory.CreateControl(gridName);
        Assert.assertTrue(grid.hasCellInColumn(cellData, colName));
    }

    @Then("^I should not see grid \"([^\"]*)\" with \"([^\"]*)\" in column \"([^\"]*)\"$")
    public void I_should_not_see_grid_with_in_column(String gridName, String cellData, String colName) throws Throwable {
        IGrid grid = Factory.CreateControl(gridName);
        Assert.assertFalse(grid.hasCellInColumn(cellData, colName));
    }

    @Then("^I should see \"([^\"]*)\" with \"([^\"]*)\"$")
    public void I_should_see_with(String controlLabel, String expValue) throws Throwable {
        IReadOnly field = Factory.CreateControl(controlLabel);
        String actValue = field.getValue();
        Assert.assertEquals(String.format("\r\nDEBUG: expected values is '%1$s', but actually got '%2$s'", expValue, actValue), actValue, expValue);
    }

    @Then("^I should see \"([^\"]*)\" highlighted$")
    public void I_should_see_highlighted(String controlLabel) throws Throwable {
        IValuable field = Factory.CreateControl(controlLabel);
        Assert.assertTrue(field.isHighlighted());
    }

    @Then("^I should see \"([^\"]*)\" enabled")
    public void I_should_see_enabled(String controlLabel) throws Throwable {
        IControl field = Factory.CreateControl(controlLabel);
        Assert.assertTrue(field.isEnabled());
    }

    @Then("^I should see row (\\d+) in grid \"([^\"]*)\" with$")
    public void I_should_see_row_in_grid_with(int rowNumber, String gridName, DataTable tableData) throws Throwable {
        String err= "";
        IGrid grid = Factory.CreateControl(gridName);
        TableHelper table = new TableHelper(tableData.asMaps());
        Map<String, String> aloneRow = table.tableData.get(0);
        for(int i = 0; i < aloneRow.size(); i++){
            String colName = aloneRow.keySet().toArray()[0].toString();
            String expCellData = aloneRow.values().toArray()[0].toString();
            String actCellData = grid.getDataInColumn(rowNumber - 1, colName);
            if(!actCellData.contains(expCellData))
                err += String.format("\r\n DEBUG: grid '%1$s', row '%2$s', column name '%3$s': expected value is '%4$s', but actually got '%5$s' ",gridName, rowNumber, colName, expCellData, actCellData);
        }

        Assert.assertTrue(err.equals(""));
    }

    @Then("^I should see grid \"([^\"]*)\" (empty|not empty)$")
    public void I_should_see_grid_not_empty(String gridName, String emptyOrNot) throws Throwable {
        IGrid grid = Factory.CreateControl(gridName);
        int rowsCount = grid.getRowsNumber();
        Assert.assertTrue(String.format("\r\n DEBUG: grid '%1$s' is empty", gridName),(emptyOrNot.contains("not")) ?  rowsCount > 0 : rowsCount == 0);
    }

    @Then("^I should see grid \"([^\"]*)\" with \"([^\"]*)\" in row (\\d+) column (\\d+)$")
    public void I_should_see_grid_with_in_row_column(String gridName, String expValue, int rowNumber, int colNumber) throws Throwable {
        IGrid grid = Factory.CreateControl(gridName);
        String actValue = grid.getDataInColumn(rowNumber - 1, colNumber);
        Assert.assertEquals(String.format("\r\n DEBUG: grid '%1$s', row '%2$s' column '%3$s': expected value is '%4$s', but actually got '%5$s'", gridName, rowNumber, colNumber, expValue, actValue), expValue, actValue);
    }

    // canvas
    @When("^I click \"([^\"]*)\" icon for span in row (\\d+) column (\\d+) in canvas$")
    public void I_click_icon_for_span_in_row_column_in_canvas(String iconName, int rowNumber, int colNumber) throws Throwable {
        Canvas canvas = new Canvas();
        canvas.clickIcon(iconName, rowNumber - 1, colNumber - 1);
    }


    @When("^I drag \"([^\"]*)\" to row (\\d+) cell (\\d+) of canvas$")
    public void I_drag_to_row_cell_of_canvas(String elemToDrag, int canvasRow, int canvasCell) throws Throwable {

    }

    @When("^I drag \"([^\"]*)\" to row (\\d+) of canvas$")
    public void I_drag_to_row_of_canvas(String elemToDrag, int canvasRow) throws Throwable {
        (new Canvas(elemToDrag)).dragElementToCanvasRow(canvasRow);
    }

    @When("^I fill in grid span attribute \"([^\"]*)\" with \"([^\"]*)\"$")
    public void I_fill_in_grid_span_attribute_with(String attrName, String value) throws Throwable {
        Canvas canvas = new Canvas();
        canvas.setGridSpanAttribute(attrName, value);
    }

    @When("^I close grid span$")
    public void I_close_grid_span() throws Throwable {
        (new Canvas()).closeGridSpan();
    }

    @Then("^I should see grid span attribute \"([^\"]*)\" with \"([^\"]*)\"$")
    public void I_should_see_grid_span_attribute_with(String attrName, String expValue) throws Throwable {
        Canvas canvas = new Canvas();
        String actValue = canvas.getGridSpanAttribute(attrName);
        Assert.assertEquals(String.format("\r\n DEBUG: grid span attribute is '%1$s': expected value is '%2$s', but actually got '%3$s'", attrName, expValue, actValue), expValue, actValue);
    }

    @Then("^Canvas contains text \"([^\"]*)\"$")
    public void Canvas_contains_text(String expText) throws Throwable {
        Canvas canvas = new Canvas();
        Assert.assertTrue(canvas.canvasContainsText(expText));
    }

    @Then("^Canvas contains image$")
    public void Canvas_contains_image() throws Throwable {
        Canvas canvas = new Canvas();
        Assert.assertTrue(canvas.canvasContainsImage());
    }

    @Then("^Canvas contains audio$")
    public void Canvas_contains_audio$() throws Throwable {
        Canvas canvas = new Canvas();
        Assert.assertTrue(canvas.canvasContainsAudio());
    }

    @Then("^Canvas contains video")
    public void Canvas_contains_video$() throws Throwable {
        Canvas canvas = new Canvas();
        Assert.assertTrue(canvas.canvasContainsVideo());
    }

    @Then("^Canvas contains widgets \"([^\"]*)\"$")
    public void Canvas_contains_widgets(String widgets) throws Throwable {
        Canvas canvas = new Canvas();
        Assert.assertTrue(canvas.canvasContainsWidgets(widgets));
    }


    @Then("^Canvas is not empty$")
    public void Canvas_is_not_empty() throws Throwable {
        Canvas canvas = new Canvas();
        Assert.assertTrue(canvas.canvasIsNotEmpty());
    }
//    the end of canvas statements

    @When("^I refresh current page$")
    public void I_refresh_current_page() throws Throwable {
        Driver.refreshPage();
    }


}
