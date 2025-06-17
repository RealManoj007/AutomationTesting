package org.automation.dataDriven;


import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

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
public class WritingDataInSpecificRowAndCell {
    public static void main(String[] args) throws IOException {
        String filePath= System.getProperty("user.dir")+"\\testdata\\dynamicData.xlsx";
        FileOutputStream fos = new FileOutputStream(filePath);
        XSSFWorkbook workbook = new XSSFWorkbook(); // Will create a new workbook
        XSSFSheet dynamicSheet = workbook.createSheet("DynamicSheet"); // Create a new sheet named "DynamicSheet"
        XSSFRow sheetRow = dynamicSheet.createRow(1);
        XSSFCell rowCell = sheetRow.createCell(1);
        rowCell.setCellValue("Java");

        workbook.write(fos);  // Write the data to the file
        System.out.println("Data written successfully to " + filePath);
        try {
            fos.close(); // Close the file output stream
            workbook.close(); // Close the workbook
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
