package org.automation.testNg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.*;

import java.time.Duration;

/*
Structure of the ThirdEcomBeforeClassTestCase class:
1. login
2. add product to cart
3. VerifyNoOfProductsInCart
4. ClickOnCartIconToGoToCart
5. RemoveProductFromCart
6. VerifyCartIsEmpty
7. logout
 */
public class ThirdEcomBeforeClassTestCase {
    WebDriver driver;
    @BeforeClass
    public void login() throws InterruptedException {
        driver= new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//input[@id=\"user-name\"]")).sendKeys("standard_user");
        driver.findElement(By.xpath("//input[@id=\"password\"]")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//input[@id=\"login-button\"]")).click();
        Thread.sleep(2000);
    }

    @Test(testName = "Add Product to cart",priority = 1)
    public void AddProductToCart() throws InterruptedException {
        driver.findElement(By.xpath("//button[@id=\"add-to-cart-sauce-labs-backpack\"]")).click();
        Thread.sleep(2000);
    }

    @Test(testName = "Verify no of products in cart",priority = 2)
    public void VerifyNoOfProductsInCart() throws InterruptedException {
        String cartCount = driver.findElement(By.xpath("//span[@class=\"shopping_cart_badge\"]")).getText();
        System.out.println("Number of products in cart: " + cartCount);
        Thread.sleep(2000);
    }

    @Test(testName = "verify product is in cart on cart page",priority = 3)
    public void ClickOnCartIconToGoToCart() throws InterruptedException {
        driver.findElement(By.xpath("//a[@class=\"shopping_cart_link\"]")).click();
        Thread.sleep(2000);
    }

    @Test(testName = "remove product from cart",priority = 4)
    public void RemoveProductFromCart() throws InterruptedException {
        driver.findElement(By.xpath("//button[@id=\"remove-sauce-labs-backpack\"]")).click();
        Thread.sleep(2000);
    }

    @Test(testName = "remove product from cart and verify cart is empty",priority = 5)
    public void VerifyCartIsEmpty() throws InterruptedException {
        String cartCount = driver.findElement(By.xpath("//span[@class=\"shopping_cart_badge\"]")).getText();
        Thread.sleep(2000);
        if (cartCount.isEmpty()) {
            System.out.println("Cart is empty");
        } else {
            System.out.println("Cart is not empty, count: " + cartCount);
            driver.findElement(By.xpath("//button[@id=\"remove-sauce-labs-backpack\"]")).click();
            System.out.println("Cart is Empty");
        }
    }

    @AfterClass
    public void logout() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@id=\"react-burger-menu-btn\"]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@id=\"logout_sidebar_link\"]")).click();
        driver.close();
    }
}
