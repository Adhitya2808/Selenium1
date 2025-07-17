package com.Tohsaka.ecom.utils;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;

public class ExcelUtils {
    private static XSSFWorkbook workbook;
    private static XSSFSheet sheet;

    public ExcelUtils(String excelPath, String sheetName) {
        try {
            FileInputStream file = new FileInputStream(excelPath);
            workbook = new XSSFWorkbook(file);
            sheet = workbook.getSheet(sheetName);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public int getRowCount(){
        return sheet.getPhysicalNumberOfRows();
    }

    public int getColumnCount(){
        return sheet.getRow(0).getPhysicalNumberOfCells();
    }

    public String getCellValue(int row, int col){
        DataFormatter formatter = new DataFormatter();
        return formatter.formatCellValue(sheet.getRow(row).getCell(col));
    }
}
