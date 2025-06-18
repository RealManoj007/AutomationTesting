package org.automation.testNg;

/*
*   Automating with TestNG:
*   1) open app
*   2) Login
*   3) logout
*/

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class FirstTestCase {
    WebDriver driver;

    @Test
    public void openApp() {
        driver= new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//input[@id=\"user-name\"]")).sendKeys("standard_user");
        driver.findElement(By.xpath("//input[@id=\"password\"]")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//input[@id=\"login-button\"]")).click();
    }

    @Test(priority = 3)
    public void logout() {
        driver.findElement(By.xpath("//button[@id=\"react-burger-menu-btn\"]")).click();
        driver.findElement(By.xpath("//a[@id=\"logout_sidebar_link\"]")).click();
    }
}
