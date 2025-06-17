package org.automation.dataDriven;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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
public class WriteDataInExcel {
    public static void main(String[] args) throws FileNotFoundException {
        // This class is intended to write data into an Excel file.
        String filePath = System.getProperty("user.dir") + "\\testdata\\myFile.xlsx";
        FileOutputStream fos = new FileOutputStream(filePath); //If file does not exist, it will create a new one.
        XSSFWorkbook workbook = new XSSFWorkbook(); //will createq a new workbook
        XSSFSheet employeeSheet = workbook.createSheet("EmployeeSheet");

        // Create a row at index 0
        XSSFRow row0 = employeeSheet.createRow(0);
        row0.createCell(0).setCellValue("Java");
        row0.createCell(1).setCellValue("Python");
        row0.createCell(2).setCellValue("JavaScript");
        row0.createCell(3).setCellValue("C++");

        // Create a row at index 1
        XSSFRow row1 = employeeSheet.createRow(1);
        row1.createCell(0).setCellValue("Selenium");
        row1.createCell(1).setCellValue("Appium");
        row1.createCell(2).setCellValue("Cucumber");
        row1.createCell(3).setCellValue("TestNG");

        // Write the workbook to the file
        try {
            workbook.write(fos);
            System.out.println("Data written successfully to " + filePath);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the file output stream and workbook
            try {
                fos.close();
                workbook.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
