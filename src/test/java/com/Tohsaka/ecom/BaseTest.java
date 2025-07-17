package com.Tohsaka.ecom;

import com.Tohsaka.ecom.utils.DriverUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

public class BaseTest {

    @BeforeMethod
    @Parameters({"baseURL","username","password"})
    public void Setup(String baseURL, String username, String password) throws InterruptedException {
        WebDriver driver = DriverUtils.getDriver();
        driver.get(baseURL);
        WebElement InputUsername = driver.findElement(By.id("user-name"));
        InputUsername.sendKeys(username);

        Thread.sleep(1000);
        WebElement InputPassword = driver.findElement(By.id("password"));
        InputPassword.sendKeys(password);

        Thread.sleep(1000);
        WebElement ButtonLogin = driver.findElement(By.id("login-button"));
        ButtonLogin.click();
    }

    @AfterMethod
    public void Teardown() throws InterruptedException {
        Thread.sleep(1000);
        DriverUtils.quitDriver();
    }
}
