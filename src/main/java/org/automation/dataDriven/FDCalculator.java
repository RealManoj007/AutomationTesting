package org.automation.dataDriven;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.automation.dataDriven.excelUtility.ExcelUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;

public class FDCalculator {
    private static final Logger log = LogManager.getLogger(FDCalculator.class);

    public static void main(String[] args) throws IOException, InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india/fixed-deposit-calculator-SBI-BSB001.html");
        driver.manage().window().maximize();

        String filepath = System.getProperty("user.dir") + "\\testdata\\calculate.xlsx";
        int rowCount = ExcelUtils.getRowCount(filepath, "Sheet1");
        System.out.println("Total number of rows in the sheet: " + rowCount);

        //close the cookie popup if it appears
        driver.findElement(By.xpath("//button[@id=\"wzrk-cancel\"]")).click();

        for (int i=1;i<=rowCount;i++) {
            //read data from excel
            String principal = ExcelUtils.getCellData(filepath, "Sheet1", i, 0);
            String roi = ExcelUtils.getCellData(filepath, "Sheet1", i, 1);
            String noOfMonth = ExcelUtils.getCellData(filepath, "Sheet1", i, 2);
            String  typeOfMonth = ExcelUtils.getCellData(filepath, "Sheet1", i, 3);
            String frequency = ExcelUtils.getCellData(filepath, "Sheet1", i, 4);
            String exp_value  = ExcelUtils.getCellData(filepath, "Sheet1", i, 5);
            log.info("Row " + i + ": Principal = " + principal + ", Rate = " + roi + ", Time  = " + noOfMonth + ", nameOfMonth = " + typeOfMonth + ", Frequency = " + frequency);

            // Perform actions on the web page using the data read from Excel
            driver.findElement(By.xpath("//input[@id='principal']")).sendKeys(principal);
            driver.findElement(By.xpath("//input[@id='interest']")).sendKeys(roi);
            driver.findElement(By.xpath("//input[@id='tenure']")).sendKeys(noOfMonth);
            Select typeOfMonths = new Select(driver.findElement(By.xpath("//select[@id='tenurePeriod']")));
            typeOfMonths.selectByVisibleText(typeOfMonth);

            Select frequencyDropdown = new Select(driver.findElement(By.xpath("//select[@id='frequency']")));
            frequencyDropdown.selectByVisibleText(frequency);

            driver.findElement(By.xpath("//div[@class=\"CTR PT15\"]/a[1]")).click(); //click on calculate button

            //validation
            String actual_value = driver.findElement(By.xpath("//span[@id='resp_matval']//strong")).getText();

            log.info("Expected Value: " + exp_value + ", Actual Value: " + actual_value);

            if(Double.parseDouble(exp_value)== Double.parseDouble(actual_value)) {
                log.info("Test Passed for row " + i);
                ExcelUtils.setCellData(filepath, "Sheet1", i, 7, "Pass");
                ExcelUtils.fillGreenColor(filepath, "Sheet1", i, 7);
            } else {
                log.error("Test Failed for row " + i + ". Expected: " + exp_value + ", Actual: " + actual_value);
                ExcelUtils.setCellData(filepath, "Sheet1", i, 7, "Fail");
                ExcelUtils.fillRedColor(filepath, "Sheet1", i, 7);
            }
            Thread.sleep(2000);// Wait for 2 seconds to see the result before clearing the input fields
            // Clear the input fields for the next iteration
            driver.findElement(By.xpath("//div[@class=\"CTR PT15\"]//a[2]")).click();
        }//end of for loop
        driver.quit();
    }
}
