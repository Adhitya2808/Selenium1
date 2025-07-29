package com.Tohsaka.ecom.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginUtil {

    public  static void performLogin(WebDriver driver) throws InterruptedException {
        performLogin(driver,"standard_user","secret_sauce");
    }
    public static void performLogin(WebDriver driver, String username, String password) throws InterruptedException {
        WebElement InputUsername = driver.findElement(By.id("user-name"));
        InputUsername.sendKeys(username);

        Thread.sleep(1000);
        WebElement InputPassword = driver.findElement(By.id("password"));
        InputPassword.sendKeys(password);

        Thread.sleep(1000);
        WebElement ButtonLogin = driver.findElement(By.id("login-button"));
        ButtonLogin.click();
    }
}
