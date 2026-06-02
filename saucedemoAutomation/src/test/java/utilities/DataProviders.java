package utilities;

import org.testng.annotations.DataProvider;

import java.io.IOException;

public class DataProviders {

    @DataProvider(name = "LoginData")
    public String[][] getData() throws IOException {
        String path = ".//testData/SauceDemo Login Data.xlsx";

        ExcelUtility excelUtility = new ExcelUtility(path);
        int totalRows = excelUtility.getRowCount("Sheet1");
        int totalCols = excelUtility.getCellCount("Sheet1",1);

        String[][] loginData = new String[totalRows][totalCols];

        for (int i=1;i<=totalRows;i++){
            for(int j=0;j<totalCols;j++){
                loginData[i-1][j] = excelUtility.getCellData("Sheet1",i,j);
            }
        }
        return loginData;
    }
}
