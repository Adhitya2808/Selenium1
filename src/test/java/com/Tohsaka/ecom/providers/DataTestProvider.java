package com.Tohsaka.ecom.providers;

import com.Tohsaka.ecom.utils.ExcelUtils;
import org.testng.annotations.DataProvider;

public class DataTestProvider {

    @DataProvider(name = "logindataprovider")
    public Object[][] loginDataProvider(){
        String excelPath = "src/test/resources/DataTestProvider.xlsx";
        ExcelUtils excel = new ExcelUtils(excelPath,"sheet1");
        int rowCount = excel.getRowCount();
        int colCount = excel.getColumnCount();

        Object[][] data = new Object[rowCount-1][colCount];
        for (int i = 1; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                data[i-1][j] = excel.getCellValue(i,j);
            }
        } return data;
    }
}
