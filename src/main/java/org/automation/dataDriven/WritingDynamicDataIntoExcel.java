package org.automation.dataDriven;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Scanner;

public class WritingDynamicDataIntoExcel {
    /*

Data Driven Testing
-------------------

To read data from Excel file :-   Excel  file --> Workbook --> Sheets --> Rows --> Cells

Classes needed :-
To Read in Excel  : FileInputStream
To Write in Excel : FileOutputStream
WorkBook--------->: XSSFWorkbook
Sheet------------>: XSSFSheet
Row ------------->: XSSFRow
Cell------------->: XSSFCell

*/
    public static void main(String[] args) throws FileNotFoundException {
        // This class is intended to write dynamic data into an Excel file.
        String filePath= System.getProperty("user.dir")+"\\testdata\\dynamicData.xlsx";
        FileOutputStream fos = new FileOutputStream(filePath); // If file does not exist, it will create a new one.
        XSSFWorkbook workbook = new XSSFWorkbook(); // Will create a new workbook
        XSSFSheet dynamicSheet = workbook.createSheet("DynamicSheet"); // Create a new sheet named "DynamicSheet"

        // Create a Scanner object to read user input
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of rows you want to create:");
        int numberOfRows = sc.nextInt();

        System.out.println("Enter the number of cells you want in each row:");
        int numberOfCells = sc.nextInt();

        for (int i = 0; i < numberOfRows; i++) {
            XSSFRow row = dynamicSheet.createRow(i);
            for (int j = 0; j < numberOfCells; j++) {
                System.out.println("Enter value for cell (" + i + ", " + j + "):");
                XSSFCell rowCell = row.createCell(j); // Create a cell in the row
                String cellValue = sc.next();         // Read user input for the cell value
                rowCell.setCellValue(cellValue);      // Set the cell value
            }
        }

        // Write the workbook to the file
        try {
            workbook.write(fos);  // Write the data to the file
            System.out.println("Data written successfully to " + filePath);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the file output stream and workbook
            try {
                fos.close();
                workbook.close();
                sc.close(); // Close the scanner
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
