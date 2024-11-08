package browserSetup_Login;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelUtils {

    // This method will read data from Excel and return it as a 2D Object array
    public static Object[][] getTestData(String excelFilePath, String sheetName) throws IOException {
        // Open the Excel file
        FileInputStream fis = new FileInputStream(new File(excelFilePath));
        Workbook workbook = new XSSFWorkbook(fis); // Using XSSFWorkbook for .xlsx files
        Sheet sheet = workbook.getSheet(sheetName);

        // Get the number of rows and columns
        int rowCount = sheet.getPhysicalNumberOfRows();
        int colCount = sheet.getRow(0).getPhysicalNumberOfCells();

        // Create an array to hold the data
        Object[][] data = new Object[rowCount - 1][colCount]; // Skip header row

        // Iterate through rows and columns to fill the data array
        for (int i = 1; i < rowCount; i++) { // Starting from 1 to skip header
            Row row = sheet.getRow(i);
            for (int j = 0; j < colCount; j++) {
                data[i - 1][j] = row.getCell(j).toString(); // Read cell value and store it
            }
        }

        // Close the workbook and file input stream
        workbook.close();
        fis.close();
        return data; // Return the 2D array
    }
}
