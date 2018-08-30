package framework.interfaces;

public interface IGrid extends IControl {
    boolean hasColumn(String colName);
    boolean hasCellInColumn(String cellData, String colName);
    void clickOnRow(int rowNumber);
    void clickOnRow(String value, String colName);
    void selectRow(int rowNumber);
    String getDataInColumn(int rowNumber, String colName);
    String getDataInColumn(int rowNumber, int colNumber);
    int getRowsNumber();
    void selectRow(String value, String colName);
}
