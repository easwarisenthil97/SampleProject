package com.dataprovider.excel;

import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ReadExcel {
	@DataProvider(name = "excelData")
    public Object[][] excelDataProvider() throws IOException {
        Object[][] arrObj = getExcelData(
               "C:\\Users\\Ganesh Ram\\Desktop\\JavaSelenium - Easwari\\Maven Project\\Nov1TestNG\\src\\test\\resources\\TestData.xlsx","Sheet1");
        return arrObj;
}
 
    public String[][] getExcelData(String loc, String sheetName) throws IOException {
        String[][] data = null;
        try {
            XSSFWorkbook workbook = new XSSFWorkbook(loc);
            XSSFSheet sheet = workbook.getSheet(sheetName);
            XSSFRow row = sheet.getRow(0);
            int noOfRows = sheet.getPhysicalNumberOfRows();
            int noOfCols = row.getLastCellNum();
            Cell cell;
            data = new String[noOfRows - 1][noOfCols];
 
            for (int i = 1; i < noOfRows; i++) {
                for (int j = 0; j < noOfCols; j++) {
                    row = sheet.getRow(i);
                    cell = row.getCell(j);
                    data[i - 1][j] = cell.getStringCellValue();
                }
            }
        } catch (Exception e) {
            System.out.println("The exception is: " + e.getMessage());
        }
        return data;
    }

}
