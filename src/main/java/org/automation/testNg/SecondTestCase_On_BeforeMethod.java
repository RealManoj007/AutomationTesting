package org.automation.testNg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

/*

BeforeMethod will execute every time before each test method in the class.

Structure of the SecondEcomTestCase class:
1. login
2. add product to cart
3. logout
4. login
5. VerifyNoOfProductsInCart
6. logout
7. login
8. ClickOnCartIconToGoToCart
9. logout
10. login
11. RemoveProductFromCart
12. logout
13. login
14. VerifyCartIsEmpty
15. logout

* */
public class SecondTestCase_On_BeforeMethod {
    WebDriver driver;

    @BeforeMethod
    public void login() {
        driver= new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//input[@id=\"user-name\"]")).sendKeys("standard_user");
        driver.findElement(By.xpath("//input[@id=\"password\"]")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//input[@id=\"login-button\"]")).click();
    }

    @Test(testName = "Add Product to cart")
    public void AddProductToCart() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@id=\"add-to-cart-sauce-labs-backpack\"]")).click();
        Thread.sleep(2000);
    }

    @Test(testName = "Verify no of products in cart")
    public void VerifyNoOfProductsInCart() throws InterruptedException {
        Thread.sleep(2000);
        AddProductToCart();
        String cartCount = driver.findElement(By.xpath("//span[@class=\"shopping_cart_badge\"]")).getText();
        System.out.println("Number of products in cart: " + cartCount);
        Thread.sleep(2000);
    }

    @Test(testName = "verify product is in cart on cart page")
    public void ClickOnCartIconToGoToCart() throws InterruptedException {
        Thread.sleep(2000);
        AddProductToCart();
        driver.findElement(By.xpath("//a[@class=\"shopping_cart_link\"]")).click();
        Thread.sleep(2000);
    }

    @Test(testName = "remove product from cart")
    public void RemoveProductFromCart() throws InterruptedException {
        Thread.sleep(2000);
        AddProductToCart();
        driver.findElement(By.xpath("//button[@id=\"remove-sauce-labs-backpack\"]")).click();
        Thread.sleep(2000);
    }

    @Test(testName = "remove product from cart and verify cart is empty")
    public void VerifyCartIsEmpty() throws InterruptedException {
        ClickOnCartIconToGoToCart();
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

    @AfterMethod
    public void logout() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@id=\"react-burger-menu-btn\"]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@id=\"logout_sidebar_link\"]")).click();
        driver.close();
    }

}
