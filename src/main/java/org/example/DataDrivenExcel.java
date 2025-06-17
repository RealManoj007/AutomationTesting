package org.example;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.IOException;

public class DataDrivenExcel  {
    public static void main( String[] args ) throws InterruptedException, IOException {

        //open file
        FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\testdata\\Employee Sample Data.xlsx");

        //open workbbok from Excel file
        XSSFWorkbook workbook = new XSSFWorkbook(file);

        //Workbook have sheet, open sheet (Sheet name is at the bottom)
        XSSFSheet sheet = workbook.getSheet("Data");

        int totalRow = sheet.getLastRowNum(); //total no of rows in the sheet
        int totalCellNum = sheet.getRow(1).getLastCellNum(); //total no of cells in the sheet

        System.out.println("Total Rows: " + totalRow);
        System.out.println("Total Cells: " + totalCellNum);

        for(int row=0; row<=totalRow; row++) {
            XSSFRow sheetRow = sheet.getRow(row);  //get row from sheet
            for(int cell=0; cell<totalCellNum; cell++) {
                XSSFCell rowCell = sheetRow.getCell(cell); //get cell from row
                String rowCellValue = (rowCell.toString().trim().isEmpty()) ? "null" : rowCell.toString();
                System.out.print(rowCellValue + " | ");
            }
            System.out.println();
        }
        workbook.close();
        file.close();
    }
}
